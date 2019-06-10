package ostalnoe;
import java.lang.*;
import java.util.*;
import user_classes.*;

public class News {
    private String title;
    private String text;
    private String  date;
    private Manager author;

    public News(String title,String text,String date,Manager author){
        this.text=text;
        this.title=title;
        this.date=date;
        this.author=author;
    }

    public Manager getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }
}