/*
 * This class provides a Structure for the Subjects with following data:
 * 1. id = Unique Subject Id
 * 2. name = Subject Name
 * 3. lecturer = Lecturer that will teach a subject
 * 4. lectureTime = Total time of Lecture (in hrs)
 * 5. seminarTime = Total time of Seminar (in hrs) (if any)
 * 6. practicumTime = Total time of Practicum (in hrs) (if any)
 */
package dataset;

public class Subject {
    private String id;
    private String name;
    private Lecturer lecturer;
    private Integer lectureTime;
    private Integer seminarTime;
    private Integer practicumTime;

    public Subject(String id, String name, Lecturer lecturer, Integer lectureTime, Integer seminarTime, Integer practicumTime){
        this.id = id;
        this.name = name;
        this.lecturer = lecturer;
        this.lectureTime = lectureTime;
        this.seminarTime = seminarTime;
        this.practicumTime = practicumTime;
    }

    public String getId(){ return id; }

    public String getName(){ return name; }
    public Lecturer getTeacher(){ return lecturer; }
    public Integer getLectureTime(){ return lectureTime; }
    public Integer getSeminarTime(){ return seminarTime; }
    public Integer getPracticalTime(){ return practicumTime; }
    public void decrementLectureTime(){ lectureTime -= 1;}
    public void decrementTutorialTime(){ seminarTime -= 1;}
    public void decrementPracticalTime(){ practicumTime -= 1;}

    @Override
    public String toString(){ return name; }

}
