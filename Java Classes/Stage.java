
public abstract class Stage{
    private String name;//name of the stage
    private Widget widget;//widget store in stage
    private double time;
    private double starveTime = 0.0;
    private double blockedTime = 0.0;
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
    public double getTime(){
        return time;
    }
    public double getStarveTime(){
        return starveTime;
    }
    public double getBlockedTime(){
        return blockedTime;
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
    public void setStarveTime(double starveTime){
        this.starveTime = starveTime;
    }
    public void setBlockedTime(double blockedTime){
        this.blockedTime = blockedTime;
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

    public void incrBlock(double time){
        blockedTime += time;
    }
    public void incrStarve(double time){
        starveTime += time;
    }

}