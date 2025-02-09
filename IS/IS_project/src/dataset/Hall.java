/*
 * This class provides a Structure for the Halls with following data:
 * 1. id = Unique Hall Id
 * 2. hallType = type of the Hall (one of auditorium, ordinary, computer)
 * 3. capacity = Hall Capacity
 * 4. building = building, in which the hall is
 */
package dataset;

public class Hall {
    public enum HallType {
        auditorium,
        ordinary,
        computer
    }
    public enum Building {
        FMI,
        FHF,
        FZF,
        BAN
    }

    private String id;
    private HallType hallType;
    private int capacity;
    private Building building;


    public Hall(String id,HallType hallType,int capacity,Building building){
        this.id = id;
        this.hallType = hallType;
        this.capacity = capacity;
        this.building = building;
    }

    public String getId(){ return id; }
    public HallType getHallType(){ return hallType; }
    public int getCapacity(){ return capacity; }

    @Override
    public String toString(){ return hallType.toString(); }
}
