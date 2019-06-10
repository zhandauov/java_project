package ostalnoe;

public class Time {
    private int day;
    private int hour;
    public Time (int x,int y){
        day=x;
        hour=y;
    }

    public String getDay() {
        String s="";
        if(day==1)s="Monday";
        else if(day==2)s="Tuesday";
        else if(day==3)s="Wednesday";
        else if(day==4)s="Thursday";
        else if(day==5)s="Friday";
        else if(day==6)s="Saturday";
        return s;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setDay(int day) {
        this.day = day;
    }
}