public class Middle extends Stage{
    private Storage<Widget> prevStorage;//inter-stage storage
    private Storage<Widget> nextStorage;//inter-stage storage
    private LinkedList<Stage> stageList;//stage capacity
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
            if(nextStorage.getSize() == 0){
                setBlock();
                setTime(0);
                return;
            }else{
                nextStorage.add(getWidget());
                for (int i = 0; i < stageList.size; i++){
                    Node<Stage> node = stageList.getHead();
                    Stage s = node.getData();
                    if (s.isStarve()){
                        s.execute();
                        break;
                    }
                    node = node.getNext();
                }
            }
        }
        if(prevStorage.getSize()== 0){
            setStarve();
            setTime(0);
        }else{
            if(!isEmpty()){

            }
            setWidget(prevStorage.pop());
            for (int i = 0; i < stageList.size; i++){
                Node<Stage> node = stageList.getHead();
                Stage s = node.getData();
                if (s.isStarve()){
                    s.execute();
                    break;
                }
                node = node.getNext();
            }
        }
    }
}
