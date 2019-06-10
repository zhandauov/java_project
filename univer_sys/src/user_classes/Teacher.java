package user_classes;

import enums.*;

public class Teacher extends User{
    private double salary;
    private int job_experience;
    public Faculty faculty;
    public Subject subject;
    public double rating;
    Position position;
    public Teacher(String log, String pas, String id, String fn, String ln, Position pos) {
        super(log,pas,id,fn,ln);
        position = pos;
    }
}
