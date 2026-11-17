import java.util.List;
public class LabTech extends Employee {

    public LabTech(String name, int id) {
        super(name, id);
        updatePermission(List.of(new LabAccess(true), new RoomAssignment(false), new SupplyClosetAcccess(true)));
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
        return "< ID: " + this.getID() + "; Name: " + this.getName() + "; Lab Technician >\n" 
        + permissionString;


    }
    
}
