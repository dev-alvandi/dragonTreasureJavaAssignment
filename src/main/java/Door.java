import java.util.HashMap;
import java.util.Map;

public class Door {

    private String position;
    private boolean locked;
    private Room destination;

    public Door(String position, boolean locked, Room destination) {
        this.position = position;
        this.locked = locked;
        this.destination = destination;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public Room getDestination() {
        return destination;
    }

    public void setDestination(Room destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Door{" +
                "position='" + position + '\'' +
                ", locked=" + locked +
                '}';
    }
}
