package library;
public class RareManuscripts implements Media{
    private String Title;
    private String Author;


    public RareManuscripts(String title, String author){
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
        return false;
    }

    public String toString() {
        return Title + " by " + Author + " " + "[available]";
    }
}