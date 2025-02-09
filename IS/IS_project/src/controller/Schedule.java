package controller;

import dataset.Course;
import dataset.Subject;
import dataset.TimeTable;
import dataset.Class;
import dataset.Hall;
import dataset.Lecturer;
import dataset.TimeSlot;
import java.util.ArrayList;
import java.util.Collections;

public class Schedule {
    private ArrayList<Class> classes;
    private ArrayList<TimeTable> timetable;
    private Data data;

    public Schedule(Data data){
        this.data = data;
        timetable = new ArrayList<>();
        classes = new ArrayList<>();
        for(int i = 0;i < data.getNumberOfCourse();i++){
            TimeTable temp = new TimeTable("" + i, data.getCourses().get(i));
            timetable.add(temp);
        }
    }

    private Subject availableSubject;
    private Hall availableRoom;
    private void constraintSatisfaction(){
        data.getTimeSlots().forEach(time -> {
            halls = (ArrayList<Hall>) data.getHalls().clone();
            lecturers = (ArrayList<Lecturer>) data.getLecturers().clone();
            for(int course_index = 0;course_index < data.getCourses().size();course_index++){
                Course course = data.getCourses().get(course_index);
                Class assignedClass = new Class(course.getId()+";"+time.getId(),course,time);
                availableSubject = subjectAvailablity(course,time);
                availableRoom = hallAvailability(course);
                if(availableRoom != null && availableSubject != null){
                    //Remove Elements for Availability
                    halls.remove(availableRoom);
                    switch (type) {
                        case 2:
                            availableSubject.decrementPracticalTime();
                            assignedClass.setClassType(Class.ClassType.practicum);
                            break;
                        case 1:
                            availableSubject.decrementTutorialTime();
                            assignedClass.setClassType(Class.ClassType.seminar);
                            break;
                        default:
                            availableSubject.decrementLectureTime();
                            assignedClass.setClassType(Class.ClassType.lecture);
                            break;
                    }
                    lecturers.remove(availableSubject.getTeacher());
                    //Assign Class in the Time Table
                    assignedClass.setRoom(availableRoom);
                    assignedClass.setSubject(availableSubject);
                    assignedClass.setTeacher(availableSubject.getTeacher());
                }else{ assignedClass.setNoClass(); }
                classes.add(assignedClass);
                //System.out.println(assignedClass.toString());
                timetable.get(course_index).addClass(assignedClass);
            }
        });
    }

    private ArrayList<Hall> halls;
    private Hall hallAvailability(Course course){
        Hall available = null;
            for(int i = 0;i < halls.size();i++){
                if(type == 2){
                    //Assigning Lab for Lab Subjects
                    if(halls.get(i).getHallType().equals("ordinary")){
                        available = halls.get(i);
                        break;
                    }
                }else{
                    //Assigning Room for Lectures
                    if(halls.get(i).getCapacity() >= course.getMaxNumOfStudents()){
                        available = halls.get(i);
                        break;
                    }
                }
            }
        return available;
    }

    private int type;
    private Subject subjectAvailablity(Course course,TimeSlot time){
        Subject available = null;
        Collections.shuffle(course.getSubjects());
        outer:
        for(int i = 0;i < course.getSubjects().size();i++){
            boolean loop_condition = true;
            type = 0;
            //Considers any of the possible Lecture/Tutorial/Lab at given time slot
            while(loop_condition){
                switch(type){
                    case 0: if(course.getSubjects().get(i).getLectureTime() > 0){
                        //Finding Lecture for Room
                        if(!teacherAvailability(course.getSubjects().get(i),time)){ continue outer; }
                        if(hallAvailability(course) == null){ type = 2; continue; }
                        available = course.getSubjects().get(i);
                        loop_condition = false;
                    }else{ type = 1; }
                        break;
                    case 1: if(course.getSubjects().get(i).getSeminarTime() > 0){
                        //Finding Lecture for Tutorial
                        if(!teacherAvailability(course.getSubjects().get(i),time)){ continue outer; }
                        if(hallAvailability(course) == null){ type = 2;continue; }
                        available = course.getSubjects().get(i);
                        loop_condition = false;
                    }else{ type = 2; }
                        break;
                    case 2: if(course.getSubjects().get(i).getPracticalTime() > 0){
                        //Finding Lecture for Practical
                        if(!teacherAvailability(course.getSubjects().get(i),time)){ continue outer; }
                        if(hallAvailability(course) == null){ type = -1; continue; }
                        available = course.getSubjects().get(i);
                        loop_condition = false;
                    }else{ type = -1; }
                        break;
                    default:
                        continue outer;
                }
            }
            if(!loop_condition)
                break;
        }
        return available;
    }

    private ArrayList<Lecturer> lecturers;
    private boolean teacherAvailability(Subject subject,TimeSlot time){
        Lecturer lecturer = subject.getTeacher();
        boolean condition = lecturers.contains(lecturer);
        //Checking Time Slot Availability
        if(condition){
            // if not(Time Slot is within Teacher Availability) condition = false;
            if(!(lecturer.getAvailableFrom() <= time.getSlotFrom() && lecturer.getAvailableTo() >= time.getSlotTo())){
                condition = false;
            }
        }
        return condition;
    }

    private int total_time = 0;
    public boolean getSchedule(){
        boolean condition = true;
        data.getSubjects().forEach(subject -> {
            total_time += subject.getLectureTime();
        });
        if(total_time > 40*data.getHalls().size())
            condition = false;
        if(condition)
            constraintSatisfaction();
        return condition;
    }

    public ArrayList<TimeTable> getTimeTable(){ return timetable; }

}