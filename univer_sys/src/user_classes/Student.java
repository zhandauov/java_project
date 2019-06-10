package user_classes;
import enums.*;

public class Student extends User{
private double gpa;
public Degree degree;
public Faculty faculty;
    public Student(String log, String pas, String id, String fn, String ln) {
        super(log,pas,id,fn,ln);
    }
    public String getFullname()
    {
        return firstname + ' ' + lastname;
    }
}
