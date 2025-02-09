/*
 * 24 Hour Format
 * This class provides a Structure for the Lecturer with following data:
 * 1. id = Unique Lecturer Id
 * 2. name = Lecturer Name
 * 3. availableFrom = Lecturer's Time of Availability From
 * 4. availableTo = Lecturer's Time of Availability To
 */
package dataset;

public class Lecturer {
    private String id;
    private String name;

    public enum LecturerType {
        professor,
        assistant,
    }
    private LecturerType lecturerType;
    private int availableFrom;
    private int availableTo;

    public Lecturer(String id,String name,LecturerType lecturerType,int availableFrom,int availableTo){
        this.id = id;
        this.name = name;
        this.lecturerType = lecturerType;
        this.availableFrom = availableFrom;
        this.availableTo = availableTo;
    }
    public String getId(){ return id; }
    public String getName(){ return name; }
    public LecturerType getLecturerType(){ return lecturerType; }
    public int getAvailableFrom(){ return availableFrom; }
    public int getAvailableTo(){ return availableTo; }
    @Override
    public String toString(){ return name; }
}
