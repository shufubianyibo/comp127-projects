import java.util.List;
public class MiddleManager extends Employee {

    public MiddleManager(String name, int id) {
        super(name, id);
        updatePermission(List.of(new LabAccess(false), new RoomAssignment(true), new SupplyClosetAcccess(true)));
    }

    @Override
    public String description() {
        String permissionString = new String();
        for (Permission p : this.getPermissions()){
            permissionString += p.getName();
            permissionString += " ";
            permissionString += p.getStatus();
            permissionString += "; ";
        }
        return "< ID: " + this.getID() + "; Name: " + this.getName() + "; Middle Manager >\n" 
        + permissionString;
    }
}
