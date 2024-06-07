import java.util.LinkedList;
import java.util.PriorityQueue;

public class Stage{
    private String name;//name of the stage
    private Widget widget;//widget store in stage
    private double time;
    private double P;
    private double starveTime = 0.0;
    private double blockedTime = 0.0;
    private boolean blocked;//starved or not 
    private boolean starved;//blocked or not
    private Storage<Widget> nextStorage;
    private Storage<Widget> prevStorage;
    private LinkedList<Stage> nextStage = new LinkedList<>();
    private LinkedList<Stage> prevStage = new LinkedList<>();

    public Stage(String name, Storage<Widget> storage){
        this.name = name;
        if(name.equals("s0a") || name.equals("s0b")){
            nextStorage = storage;
        }else{
            prevStorage = storage;
        }
    }
    public Stage(String name, Storage<Widget> nextStorage, Storage<Widget> prevStorage){
        this.name = name;
        this.nextStorage = nextStorage;
        this.prevStorage = prevStorage;
    }
    //getter methods
    public String getName(){
        return name;
    }
    public Widget getWidget(){
        Widget temp = widget;
        widget = null;
        return temp;
    }
    public double getTime(){
        return time;
    }
    public Storage<Widget> getNextStorage(){
        return nextStorage;
    }
    public Storage<Widget> getPrevStorage(){
        return prevStorage;
    }
    public LinkedList<Stage> getNextStage(){
        return nextStage;
    }
    public LinkedList<Stage> getPrevStage(){
        return prevStage;
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
        Job job = new Job(this);
        this.widget = widget;
    }
    public void setTime(double time){
        this.time = time;
    }
    public void setNextStorage(Storage<Widget> nexStorage){
        this.nextStorage = nexStorage;
    }
    public void setPrevStorage(Storage<Widget> prevStorage){
        this.prevStorage = prevStorage;
    }
    public void setNext(Stage next){
        if (!this.getName().equals("s6")){
            nextStage.add(next);
        }
    }
    public void setPrev(Stage prev){
        if (!this.getName().equals("s0a") && (!this.getName().equals("s0b"))){
            prevStage.add(prev);
        }
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
    public void incrP(double time){
        P += time;
    }

}