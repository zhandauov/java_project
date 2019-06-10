package user_classes;
import enums.*;
import ostalnoe.Order;

public class Manager extends User{
    private double salary;
    private int job_experience;
    private Faculty faculty;
    public Manager(String log, String pas, String id, String fn, String ln) {
        super(log,pas,id,fn,ln);
    }

}
