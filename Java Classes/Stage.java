public abstract class Stage{
    private String name;//name of the stage
    private Widget widget;//widget store in stage
    private Storage storage;//inter-stage storage
    private double time;
    private double starveTime;
    private double blockedTime;
    private double productionTime;
    private boolean blocked;//starved or not 
    private boolean starved;//blocked or not

    public abstract void execute();
    public abstract void setNext(Stage s);
    public abstract void setPrev(Stage s);

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
}