package library;

public class DigitalAriticles implements Media{
    private String Title;
    private String Author;


    public DigitalAriticles(String title, String author){
        this.Title = title;
        this.Author = author;
    }

    public String getTitle(){
        return Title;
    }

    public boolean checkIn(){
        return false;
    }

    public boolean checkOut(){
        return true;
    }

    public String toString() {
        return Title + " by " + Author + " " + "[available]";
    }
}
