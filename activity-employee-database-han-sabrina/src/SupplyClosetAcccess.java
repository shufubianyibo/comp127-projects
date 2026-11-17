public class SupplyClosetAcccess implements Permission{
    private boolean status;

    public SupplyClosetAcccess(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

    public String getName() {
        return "Supply Closet Acccess";
    }
    
}
