import java.util.Random;
import java.util.random.*;
public abstract class Stage{
    private String name;//name of the stage
    private Widget widget;//widget store in stage
    private int Qmax; //capacity
    private double M; //average processing time
    private double N; //range of processing time
    private double P; //procesisng time
    private double T1; //starting time
    private double T2; //completion time
    private double d; //random number [0, 1]
    private Storage storage;//inter-stage storage
    private double time;
    private double starveTime;
    private double blockedTime;
    private double productionTime;
    private boolean blocked;//starved or not 
    private boolean starved;//blocked or not

    public abstract void execute();
    //getter methods
    public String getName(){
        return name;
    }
    public Widget getWidget(){
        return widget;
    }

    //setter methods
    public void setName(String name){
        this.name = name;
    }
    public void setWidget(Widget widget){
        this.widget = widget;
    }
    public void setTime(double time){
        this.time = time;
    }
    public void setT1(double T1){
        this.T1 = T1;
    }

    //stage managing methods
    public void setStarve(){
        starved = true;
    }
    public void unStarve(){
        starved = false;
    }
    public void setBlock(){
        blocked = true;
    }
    public void unBlock(){
        blocked = false;
    }

    //stage condition checker
    public boolean isStarve(){
        if (starved){
            return true;
        }
        return false;
    }
    public boolean isBlocked(){
        if (blocked){
            return true;
        }
        return false;
    }
    public boolean isEmpty(){
        if (widget == null){
            return true;
        }
        return false;
    }

    //calculation methods
    public void calcP(){
        Random r = new Random();
        d = r.nextDouble();
        switch (name){
            case "s0a":
                P = 2*M + 2*N * (d - 0.5);
            case "s3a":
                P = 2*M + 2*N * (d - 0.5);
            case "s3b":
                P = 2*M + 2*N * (d - 0.5);
            case "s5a":
                P = 2*M + 2*N * (d - 0.5);
            case "s5b":
                P = 2*M + 2*N * (d - 0.5);
            default:
                P = M + N * (d - 0.5);
        }
    }

    public void calcT2(){
        T2 = time + P;
    }
}