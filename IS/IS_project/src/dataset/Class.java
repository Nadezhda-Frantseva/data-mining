/*
 * This class provides a Structure for the Class i.e. the subject of a course to be assigned with teacher and room.
 * Information:
 * 1. id = Unique Class id
 * 2. course = Course to be placed in class
 * 3. subject = Subject to be taught
 * 4. hall = Hall Assigned
 * 5. classType = Lecture/Seminar/Practicum
 * 6. lecturer = Lecturer Assigned
 * 7. time = Time of Class
 */
package dataset;

public class Class {
    private String id;
    private Course course;
    private Subject subject;
    private Hall hall;

    public enum ClassType {
        lecture,
        seminar,
        practicum
    }
    private ClassType classType;
    private Lecturer lecturer;
    private TimeSlot time;

    public Class(String id,Course course,TimeSlot time){
        this.id = id;
        this.course = course;
        this.time = time;
    }

    public void setSubject(Subject subject){ this.subject = subject; }
    public void setRoom(Hall hall){ this.hall = hall; }
    public void setClassType(ClassType classType){this.classType = classType; }
    public void setTeacher(Lecturer lecturer){ this.lecturer = lecturer; }
    public void setNoClass(){
        subject = null;
        hall = null;
        lecturer = null;
    };

    public Subject getSubject(){ return subject; }

    @Override
    public String toString(){
        String message;
        if(subject == null){
            message = "["+time.toString()+","+course.getName()+",NULL, NULL, NULL]";
        }else{
            message = "["+time.toString()+","+course.getName()+","+subject.getName()+","+hall.getId()+","+lecturer.getName()+"]";
        }
        return message;
    }
    public String timeTableView(){
        String message;
        if(subject == null){
            message = "";
        }else{
            message = "" + lecturer.getId() + "\n" + subject.getId();
            if(classType.equals("seminar")){
                message += "\n (Sem.)";
            }else if(classType.equals("practicum")){
                message += "\n Prakt.";
            }
        }
        return message;
    }
}
