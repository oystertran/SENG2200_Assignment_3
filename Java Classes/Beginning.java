public class Beginning extends Stage {
    private Storage<Widget> storage;//inter-stage storage
    private LinkedList<Stage> stageList;//stage capacity
    public Beginning(String name, Storage<Widget> storage){
        setName(name);
        setWidget(new Widget(name, 0.0));
        stageList = new LinkedList<>();
        this.storage = storage;
    }

    public Beginning(){
        setT1(getWidget().getTime());
    }
    
    @Override
    public void execute(){
        if (this.isBlocked()){
            unBlock();
            incrBlock(0);
        }

        if (storage.getSize() == 0){
            setBlock();
            setTime(0.0);
            return;
        }else{
            storage.add(getWidget());
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
        if (!isEmpty()){

        }
        setWidget(new Widget(getName(), 0));
    }
}
