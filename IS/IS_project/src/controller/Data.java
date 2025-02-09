/*
 * Provides complete information necessary for Time Table Scheduling
 * 1. Halls
 * 2. Courses
 * 3. Lecturers
 * 4. Subject
 * 5. Time Slot
 */
package controller;

import dataset.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Data {
    private ArrayList<Hall> halls;
    private ArrayList<Subject> subjects;
    private ArrayList<Lecturer> lecturers;
    private ArrayList<Course> courses;
    private ArrayList<TimeSlot> time_slots;
    private int numberOfCourse = 0;

    public Data(){ initialize(); }

    private Data initialize(){

        //Initializing Rooms

        Hall room130 = new Hall("FHF130", Hall.HallType.auditorium,260,  Hall.Building.FHF);
        Hall roomFHF210 = new Hall("FHF210", Hall.HallType.auditorium,260,  Hall.Building.FHF);
        Hall room01 = new Hall("FMI01", Hall.HallType.auditorium,80,  Hall.Building.FMI);
        Hall room02 = new Hall("FMI02", Hall.HallType.auditorium,60,  Hall.Building.FMI);
        Hall room101 = new Hall("FMI101", Hall.HallType.auditorium,112,  Hall.Building.FMI);
        Hall room200 = new Hall("FMI200", Hall.HallType.auditorium,154,  Hall.Building.FMI);
        Hall room229 = new Hall("FMI229", Hall.HallType.auditorium,80,  Hall.Building.FMI);
        Hall room325 = new Hall("FMI325", Hall.HallType.auditorium,68,  Hall.Building.FMI);
        Hall room500 = new Hall("FMI500", Hall.HallType.auditorium,56,  Hall.Building.FMI);
        Hall room603 = new Hall("FHF603", Hall.HallType.auditorium,40,  Hall.Building.FHF);
        Hall room604 = new Hall("FHF604", Hall.HallType.auditorium,78,  Hall.Building.FHF);
        Hall roomA207 = new Hall("FZFA207", Hall.HallType.auditorium,140,  Hall.Building.FZF);
        Hall roomA = new Hall("BANA", Hall.HallType.auditorium,40,  Hall.Building.BAN);
        Hall roomB = new Hall("BANB", Hall.HallType.auditorium,40,  Hall.Building.BAN);

        Hall room013k = new Hall("FMI013k", Hall.HallType.computer,14,  Hall.Building.FMI);
        Hall room014k = new Hall("FMI014k", Hall.HallType.computer,14,  Hall.Building.FMI);
        Hall room018k = new Hall("FMI018k", Hall.HallType.computer,12,  Hall.Building.FMI);
        Hall room019k = new Hall("FMI019k", Hall.HallType.computer,15,  Hall.Building.FMI);
        Hall room020k = new Hall("FMI020k", Hall.HallType.computer,15,  Hall.Building.FMI);
        Hall room107k = new Hall("FMI107k", Hall.HallType.computer,24,  Hall.Building.FMI);
        Hall room120k = new Hall("FMI120k", Hall.HallType.computer,24,  Hall.Building.FMI);
        Hall room122k = new Hall("FMI122k", Hall.HallType.computer,11,  Hall.Building.FMI);
        Hall room217k = new Hall("FMI217k", Hall.HallType.computer,15,  Hall.Building.FMI);
        Hall room222k = new Hall("FMI222k", Hall.HallType.computer,19,  Hall.Building.FMI);
        Hall room306k = new Hall("FMI306k", Hall.HallType.computer,20,  Hall.Building.FMI);
        Hall room309k = new Hall("FMI309k", Hall.HallType.computer,18,  Hall.Building.FMI);
        Hall room313k = new Hall("FMI313k", Hall.HallType.computer,10,  Hall.Building.FMI);
        Hall room314k = new Hall("FMI314k", Hall.HallType.computer,18,  Hall.Building.FMI);
        Hall room320k = new Hall("FMI320k", Hall.HallType.computer,20,  Hall.Building.FMI);
        Hall room321k = new Hall("FMI321k", Hall.HallType.computer,18,  Hall.Building.FMI);
        Hall room323k = new Hall("FMI323k", Hall.HallType.computer,15,  Hall.Building.FMI);
        Hall roomBAN303 = new Hall("BAN303", Hall.HallType.computer,18,  Hall.Building.BAN);
        Hall room306 = new Hall("BAN306", Hall.HallType.computer,18,  Hall.Building.BAN);

        Hall room03 = new Hall("FMI03", Hall.HallType.ordinary,18,  Hall.Building.FMI);
        Hall room04 = new Hall("FMI04", Hall.HallType.ordinary,24,  Hall.Building.FMI);
        Hall roomFMI210 = new Hall("FMI210", Hall.HallType.ordinary,26,  Hall.Building.FMI);
        Hall room211 = new Hall("FMI212", Hall.HallType.ordinary,20,  Hall.Building.FMI);
        Hall room216 = new Hall("FMI216", Hall.HallType.ordinary,22,  Hall.Building.FMI);
        Hall room302 = new Hall("FMI302", Hall.HallType.ordinary,18,  Hall.Building.FMI);
        Hall roomFMI303 = new Hall("FMI303", Hall.HallType.ordinary,18,  Hall.Building.FMI);
        Hall room304 = new Hall("FMI304", Hall.HallType.ordinary,18,  Hall.Building.FMI);
        Hall room305 = new Hall("FMI305", Hall.HallType.ordinary,18,  Hall.Building.FMI);
        Hall room307 = new Hall("FMI307", Hall.HallType.ordinary,30,  Hall.Building.FMI);
        Hall room308 = new Hall("FMI308", Hall.HallType.ordinary,30,  Hall.Building.FMI);
        Hall room310 = new Hall("FMI310", Hall.HallType.ordinary,30,  Hall.Building.FMI);
        Hall room311 = new Hall("FMI311", Hall.HallType.ordinary,30,  Hall.Building.FMI);
        Hall room401 = new Hall("FMI401", Hall.HallType.ordinary,30,  Hall.Building.FMI);
        Hall room404 = new Hall("FMI404", Hall.HallType.ordinary,24,  Hall.Building.FMI);
        Hall room405 = new Hall("FMI405", Hall.HallType.ordinary,30,  Hall.Building.FMI);
        Hall room501 = new Hall("FMI501", Hall.HallType.ordinary,15,  Hall.Building.FMI);
        Hall room514 = new Hall("FMI514", Hall.HallType.ordinary,18,  Hall.Building.FMI);
        Hall room526 = new Hall("FMI526", Hall.HallType.ordinary,24,  Hall.Building.FMI);
        Hall room234A = new Hall("FZH234A", Hall.HallType.ordinary,30,  Hall.Building.FZF);
        Hall roomA305 = new Hall("FZFA305", Hall.HallType.ordinary,12,  Hall.Building.FZF);
        Hall roomC = new Hall("BANC", Hall.HallType.ordinary,27,  Hall.Building.BAN);
        Hall room601 = new Hall("FHF601", Hall.HallType.ordinary,12,  Hall.Building.FHF);

        halls = new ArrayList<>(Arrays.asList(room130, roomFHF210, room01, room02, room101, room200, room229, room325, room500, room603, room604, roomA207, roomA,
                roomB, room013k, room014k, room018k, room019k, room020k, room107k, room120k, room122k, room217k, room222k, room306k, room309k, room313k, room314k,
                room320k, room321k, room323k, roomBAN303, room306, room03, room04, roomFMI210, room211, room216, room302, roomFMI303, room304, room305, room307, room308,
                room310, room311, room401, room404, room405, room501, room514, room526, room234A, roomA305, roomC, room601));


        //Initializing Teachers

        Lecturer teacher1 = new Lecturer("MS","Prof. Dr. Maya Stoyanova", Lecturer.LecturerType.professor,9,17);
        Lecturer teacher2 = new Lecturer("VB","Prof. Dr. Vladimir Babev",Lecturer.LecturerType.professor,9,17);
        Lecturer teacher3 = new Lecturer("AD","Prof. Angel Dichev",Lecturer.LecturerType.professor,9,17);
        Lecturer teacher4 = new Lecturer("JB-B","Dr. Julgena Benbasat-Bankova",Lecturer.LecturerType.professor,9,17);
        Lecturer teacher5 = new Lecturer("DK","Dr. Alexander Dimov",Lecturer.LecturerType.professor,9,17);

        Lecturer teacher6 = new Lecturer("IK","Prof. Dr. Ivan Koichev",Lecturer.LecturerType.professor,9,17);
        Lecturer teacher7 = new Lecturer("ST","Prof. Dr. Simeon Tsvetanov",Lecturer.LecturerType.professor,9,17);
        Lecturer teacher8 = new Lecturer("DP","Assoc. Dr. Donka Petrova",Lecturer.LecturerType.professor,9,17);

        Lecturer teacher9 = new Lecturer("BB","Prof. Dr. Boyan Bonchev",Lecturer.LecturerType.professor,9,17);
        Lecturer teacher10 = new Lecturer("KG","Dr. Kalina Georgieva ",Lecturer.LecturerType.professor,9,17);
        Lecturer teacher11 = new Lecturer("MS","Prof. Mladen Savov",Lecturer.LecturerType.professor,9,17);
        Lecturer teacher12 = new Lecturer("SI","Prof. Dr. Silvia Ilieva",Lecturer.LecturerType.professor,9,17);

        Lecturer teacher13 = new Lecturer("DP-A","Prof. Dr. Desislava Petrova-Antonova",Lecturer.LecturerType.professor,9,17);
        Lecturer teacher14 = new Lecturer("EG","Prof. Dr. Elisaveta Gurova",Lecturer.LecturerType.professor,9,17);

        Lecturer teacher15 = new Lecturer("TT","Dr. Trifon Trifonov",Lecturer.LecturerType.professor,9,17);

        lecturers = new ArrayList<>(Arrays.asList(teacher1,teacher2,teacher3,teacher4,teacher5,teacher6,
                teacher7,teacher8,teacher9,teacher10,teacher11,teacher12,
                teacher13));


        // Initializing Subjects

        // 1 year -> 1 sem
        Subject subject1 = new Subject("A","Algebra", teacher1,3,3,0);
        Subject subject2 = new Subject("DIS1","Differential & integral equals 1", teacher2,4,4,0);
        Subject subject3 = new Subject("DStr1","Discrete Structures 1", teacher3,3,3,0);
        Subject subject4 = new Subject("UP","Introduction in programming", teacher5,3,2,0);
        Subject subject5 = new Subject("En","English language", teacher4,0,2,0);

        // SE: 2 year -> 1 sem
        Subject subject6 = new Subject("DSA","Data Structures & Algorithms", teacher6,3,2,0);
        Subject subject7 = new Subject("CompArch","Computer Architecture", teacher7,4,0,0);
        Subject subject8 = new Subject("CommTech","Communication techniques", teacher8,1,0,1);
        Subject subject9 = new Subject("USI","Introduction to Software Engineering", teacher5,3,1,1);

        // SE: 3 year -> 1 sem
        Subject subject10 = new Subject("XML","XML for semantic Web", teacher9,3,0,2);
        Subject subject11 = new Subject("SPASI","Social-legal aspects of software engineering", teacher10,2,0,0);
        Subject subject12 = new Subject("St","Statistics and methods", teacher11,2,2,2);
        Subject subject13 = new Subject("UK","Quality management", teacher12,3,0,2);

        // SE: 4 year -> 1 sem
        Subject subject14 = new Subject("IS","Data Mining", teacher6,2,0,2);
        Subject subject15 = new Subject("PISS","Design and integration of software systems", teacher13,2,0,3);
        Subject subject16 = new Subject("UP","Projects management", teacher14,3,0,1);

        // CS: 2 year -> 1 sem
        Subject subject17 = new Subject("CE","Computer English", teacher4,0,2,0);
        Subject subject18 = new Subject("BCG","Basics of computer graphics", teacher9,2,0,2);
        Subject subject19 = new Subject("FP","Functional programming", teacher15,2,0,2);

        subjects = new ArrayList<>(Arrays.asList(subject1, subject2, subject3, subject4, subject5,subject6,subject7,subject8,subject9,subject10,subject11,subject12,
                subject13, subject14, subject15, subject16, subject17,subject18,subject19));

        //Initializing Course

        // SE
        Course course1SE = new Course("SE-1","SE 1st Year",
                new ArrayList<>(Arrays.asList(subject1,subject2,subject3,subject4,subject5)),
                160);
        Course course2SE = new Course("SE-2","SE 2nd Year",
                new ArrayList<>(Arrays.asList(subject6,subject7,subject8,subject9)),
                140);
        Course course3SE = new Course("SE-3","SE 3rd Year",
                new ArrayList<>(Arrays.asList(subject10,subject11,subject12,subject13)),
                120);
        Course course4SE = new Course("SE-4","SE 4th Year",
                new ArrayList<>(Arrays.asList(subject14,subject15,subject16)),
                100);

        // CS
        Course course1CS = new Course("CS-1","CS 1st Year",
                new ArrayList<>(Arrays.asList(subject1,subject2,subject3,subject4)),
                100);
        Course course2CS = new Course("CS-2","CS 2nd Year",
                new ArrayList<>(Arrays.asList(subject17,subject7,subject18,subject6,subject19)),
                100);

        courses = new ArrayList<>(Arrays.asList(course1SE,course2SE,course3SE,course4SE,course1CS));

        TimeSlot time1 = new TimeSlot("Mo1",9,10,"Monday");
        TimeSlot time2 = new TimeSlot("Tu1",9,10,"Tuesday");
        TimeSlot time3 = new TimeSlot("We1",9,10,"Wednesday");
        TimeSlot time4 = new TimeSlot("Th1",9,10,"Thrusday");
        TimeSlot time5 = new TimeSlot("Fr1",9,10,"Friday");
        time_slots = new ArrayList<>(Arrays.asList(time1,time2,time3,time4,time5));
        time1 = new TimeSlot("Mo2",10,11,"Monday");
        time2 = new TimeSlot("Tu2",10,11,"Tuesday");
        time3 = new TimeSlot("We2",10,11,"Wednesday");
        time4 = new TimeSlot("Th2",10,11,"Thrusday");
        time5 = new TimeSlot("Fr2",10,11,"Friday");
        time_slots.addAll(Arrays.asList(time1,time2,time3,time4,time5));
        time1 = new TimeSlot("Mo3",11,12,"Monday");
        time2 = new TimeSlot("Tu3",11,12,"Tuesday");
        time3 = new TimeSlot("We3",11,12,"Wednesday");
        time4 = new TimeSlot("Th3",11,12,"Thrusday");
        time5 = new TimeSlot("Fr3",11,12,"Friday");
        time_slots.addAll(Arrays.asList(time1,time2,time3,time4,time5));
        time1 = new TimeSlot("Mo4",12,13,"Monday");
        time2 = new TimeSlot("Tu4",12,13,"Tuesday");
        time3 = new TimeSlot("We4",12,13,"Wednesday");
        time4 = new TimeSlot("Th4",12,13,"Thrusday");
        time5 = new TimeSlot("Fr4",12,13,"Friday");
        time_slots.addAll(Arrays.asList(time1,time2,time3,time4,time5));
        time1 = new TimeSlot("Mo5",13,14,"Monday");
        time2 = new TimeSlot("Tu5",13,14,"Tuesday");
        time3 = new TimeSlot("We5",13,14,"Wednesday");
        time4 = new TimeSlot("Th5",13,14,"Thrusday");
        time5 = new TimeSlot("Fr5",13,14,"Friday");
        time_slots.addAll(Arrays.asList(time1,time2,time3,time4,time5));
        time1 = new TimeSlot("Mo6",14,15,"Monday");
        time2 = new TimeSlot("Tu6",14,15,"Tuesday");
        time3 = new TimeSlot("We6",14,15,"Wednesday");
        time4 = new TimeSlot("Th6",14,15,"Thrusday");
        time5 = new TimeSlot("Fr6",14,15,"Friday");
        time_slots.addAll(Arrays.asList(time1,time2,time3,time4,time5));
        time1 = new TimeSlot("Mo7",15,16,"Monday");
        time2 = new TimeSlot("Tu7",15,16,"Tuesday");
        time3 = new TimeSlot("We7",15,16,"Wednesday");
        time4 = new TimeSlot("Th7",15,16,"Thrusday");
        time5 = new TimeSlot("Fr7",15,16,"Friday");
        time_slots.addAll(Arrays.asList(time1,time2,time3,time4,time5));
        time1 = new TimeSlot("Mo8",16,17,"Monday");
        time2 = new TimeSlot("Tu8",16,17,"Tuesday");
        time3 = new TimeSlot("We8",16,17,"Wednesday");
        time4 = new TimeSlot("Th8",16,17,"Thrusday");
        time5 = new TimeSlot("Fr8",16,17,"Friday");
        time_slots.addAll(Arrays.asList(time1,time2,time3,time4,time5));

        numberOfCourse = courses.size();

        return this;
    }

    public ArrayList<Hall> getHalls(){ return halls; }
    public ArrayList<Subject> getSubjects(){ return subjects; }
    public ArrayList<Lecturer> getLecturers(){ return lecturers; }
    public ArrayList<Course> getCourses(){ return courses; }
    public ArrayList<TimeSlot> getTimeSlots(){ return time_slots; }
    public int getNumberOfCourse(){ return numberOfCourse; }

}
