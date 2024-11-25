import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Room {

    public static Map<String, String> letterToDirection = new HashMap<>();

    static {
        letterToDirection.put("n", "norrut");
        letterToDirection.put("s", "söderut");
        letterToDirection.put("ö", "österut");
        letterToDirection.put("v", "västerut");
    }

    private String roomDesc;
    private List<RoomProperty> roomProperties;
    private List<Door> doors;

    public Room(String roomDesc, List<RoomProperty> roomProperties) {
        this.roomDesc = roomDesc;
        this.roomProperties = roomProperties;
    }

    public String getRoomDesc() {
        return roomDesc;
    }

    public void setRoomDesc(String roomDesc) {
        this.roomDesc = roomDesc;
    }

    public List<RoomProperty> getRoomProperties() {
        return roomProperties;
    }

    public void setRoomProperties(List<RoomProperty> roomProperties) {
        this.roomProperties = roomProperties;
    }

    public List<Door> getDoors() {
        return doors;
    }

    public void setDoors(List<Door> doors) {
        this.doors = doors;
    }

    public void doNarrative() {
        for (Door door : doors) {
            if (door.isLocked()) {
                System.out.printf("Du ser en låst dörr i %s [%s]%n", letterToDirection.get(door.getPosition()), door.getPosition());
            } else if (door.getDestination().getRoomProperties() != null && door.getDestination().getRoomProperties().contains(RoomProperty.END) && door.getPosition().equals("ö")) {
                System.out.println("Du ser en utgång österut [ö]");
            } else {
                System.out.printf("Du kan gå %s [%s]%n", letterToDirection.get(door.getPosition()), door.getPosition());
            }
        }
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomDesc='" + roomDesc + '\'' +
                ", roomProperties=" + roomProperties +
                ", doors=" + doors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;
        return Objects.equals(getRoomDesc(), room.getRoomDesc()) && Objects.equals(getRoomProperties(), room.getRoomProperties()) && Objects.equals(getDoors(), room.getDoors());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getRoomDesc());
        result = 31 * result + Objects.hashCode(getRoomProperties());
        result = 31 * result + Objects.hashCode(getDoors());
        return result;
    }
}

