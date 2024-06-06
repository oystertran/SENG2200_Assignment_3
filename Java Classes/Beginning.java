import java.util.LinkedList;
public class Beginning extends Stage {
    private Storage<Widget> nextStorage;//inter-stage storage connecting this stage with next stage
    private LinkedList<Stage> capacity;//stage capacity
    
    public Beginning(String name, Storage<Widget> nextStorage){
        setName(name);//a stage has a name
        setWidget(new Widget(name));// Beginning stage has widgets

        this.nextStorage = nextStorage;
    }
    
    @Override
    public void execute(){
        if (this.isBlocked()){
            unBlock();
            incrBlock(0);
        }

        if (nextStorage.getSize() == nextStorage.getmax()){
            setBlock();
            setTime(0.0);
            return;
        }else{
            nextStorage.add(getWidget());
            for (int i = 0; i < capacity.size(); i++){
                Stage current = capacity.get(i);
                if (current.isStarve()){
                    current.execute();
                    break;
                }
            }
        }
        if (!isEmpty()){

        }
        setWidget(new Widget(getName()));
    }
}
