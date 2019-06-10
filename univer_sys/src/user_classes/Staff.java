package user_classes;

public class Staff extends User{
    private double salary;
    private int job_experience;
    public Staff(String log, String pas, String id, String fn, String ln) {
        super(log,pas,id,fn,ln);
    }
}
