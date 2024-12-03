
/**
 * * Class for constructing the doors.
 */

public class Door {

    // instance variables
    private String position;
    private boolean locked;
    private Room destination;

    // constructor initializing doors with position, whether door is locked, and destination
    public Door(String position, boolean locked, Room destination) {
        this.position = position;
        this.locked = locked;
        this.destination = destination;
    }

    // method to get the player's position
    public String getPosition() {
        return position;
    }

    public boolean isLocked() {
        return locked;
    }

    // method to retrieve the destination
    public Room getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return "Door{" +
                "position='" + position + '\'' +
                ", locked=" + locked +
                '}';
    }
}
