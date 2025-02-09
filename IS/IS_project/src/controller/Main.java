package controller;

import dataset.TimeTable;
import java.util.ArrayList;

public class Main {
    private Data data;
    private ArrayList<TimeTable> timetables;
    public static void main(String args[]){
        Main main = new Main();
        main.data = new Data();
        Schedule schedule = new Schedule(main.data);
        if(schedule.getSchedule()){
            main.timetables = schedule.getTimeTable();
        }else{
            System.out.println("No Schedule Possible");
        }
        main.printAvailableData();
    }

    private void printAvailableData(){
        System.out.println("Available Courses ==>");
        data.getCourses().forEach(course -> {System.out.println("Id: "+course.getId()+", Name: " + course.getName()+
                ", Maximum Students: "+course.getMaxNumOfStudents());});

        System.out.println("Availbale Rooms ==>");
        data.getHalls().forEach(room -> {System.out.println("Id: "+room.getId()+", Capacity: "+room.getCapacity());});

        System.out.println("Available Teachers ==>");
        data.getLecturers().forEach(teacher -> {System.out.println("Id: "+teacher.getId()+", Name: "+teacher.getName());});

        System.out.println("Available Subjects ==>");
        data.getSubjects().forEach(subject -> {System.out.println("Id: "+subject.getId()+", Name: "+subject.getName()+
                ", Teacher Code: "+subject.getTeacher().getId()+
                ", Duration (in hrs): "+subject.getLectureTime() +
                "|" + subject.getSeminarTime() + "|" +
                subject.getPracticalTime());});

        System.out.println("Time Table ==>");
        timetables.forEach(timetable -> {
            timetable.getClasses().forEach(temp -> {
                try {
                    if (temp.getSubject() != null) {
                        System.out.println(temp + "\n");
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        });
    }
}
