package library;
public class Video implements Media{
    private String Title;
    private String Director;
    private int numCopies;
    private int currentNum;

    public Video(String title, String director, int numCopies, int currentNum){
        this.Title = title;
        this.Director = director;
        this.numCopies = numCopies;
        this.currentNum = currentNum;
    }

    public boolean checkOut() {
        if (currentNum >= 1){
            currentNum -= 1;
            return true;
        } else {
            return false;
        }
    }

    public boolean checkIn() {
        if (currentNum < numCopies){
            currentNum += 1;
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return Title + " by " + Director + " total: " + numCopies + " current: " + currentNum;
    }

    public String getTitle() {
        return Title;
    }

}
