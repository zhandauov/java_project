package ostalnoe;

public class Mark {

    private double first;

    private double second;

    private double finalPoint;

    public Mark (double first,double second,double finalPoint){
        this.first=first;
        this.second=second;
        this.finalPoint=finalPoint;
    }

    public double getFinalPoint() {
        return finalPoint;
    }

    public double getFirst() {
        return first;
    }

    public double getSecond() {
        return second;
    }

    public void setFinalPoint(double finalPoint) {
        this.finalPoint = finalPoint;
    }

    public void setFirst(double first) {
        this.first = first;
    }

    public void setSecond(double second) {
        this.second = second;
    }
}
