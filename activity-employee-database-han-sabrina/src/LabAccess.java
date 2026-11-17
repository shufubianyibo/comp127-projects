public class LabAccess implements Permission {
    private boolean status;

    public LabAccess(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

    public String getName() {
        return "Laboratory Access";
    }
}
