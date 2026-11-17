public class RoomAssignment implements Permission{
    private boolean status;

    public RoomAssignment(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

    public String getName() {
        return "Room Assignment";
    }  
}
