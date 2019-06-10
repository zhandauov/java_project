package ostalnoe;
import java.lang.*;

/**
 */
public class CourseFiles {
    /**
     */
    private String title;

    /**
     */
    private String text;

    public CourseFiles(String title, String text) {
        super();
        this.title = title;
        this.text = text;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((text == null) ? 0 : text.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CourseFiles other = (CourseFiles) obj;
        if (text == null) {
            if (other.text != null)
                return false;
        } else if (!text.equals(other.text))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        return true;
    }
    public void setTitle(String name) {
        this.title=name;
    }

    /**
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param text
     */
    public void setText(String text) {
        this.text=text;
    }

    /**
     * @return
     */
    public String getText() {
        return text;
    }
}