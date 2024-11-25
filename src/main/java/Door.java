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

    public boolean isLocked() {
        return locked;
    }

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
