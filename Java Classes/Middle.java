import java.util.LinkedList;
public class Middle extends Stage{
    private Storage<Widget> prevStorage;//inter-stage storage
    private Storage<Widget> nextStorage;//inter-stage storage
    private LinkedList<Stage> capacity;//stage capacity
    public Middle(String name, Storage<Widget> prevStorage, Storage<Widget> nexStorage){

    }

    @Override
    public void execute(){
        if (this.isBlocked()){
            unBlock();
            incrBlock(0);
        }
        if (this.isStarve()){
            unStarve();
            incrBlock(0);
        }else{
            if(nextStorage.getSize() == nextStorage.getmax()){
                setBlock();
                setTime(0);
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
        }
        if(prevStorage.getSize()== 0){
            setStarve();
            setTime(0);
        }else{
            if(!isEmpty()){

            }
            setWidget(prevStorage.getStorage().dequeue());
            for (int i = 0; i < capacity.size(); i++){
                Stage current = capacity.get(i);
                if (current.isStarve()){
                    current.execute();
                    break;
                }
            }
        }
    }
}
