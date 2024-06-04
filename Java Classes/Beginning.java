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

            for (Stage s : stageList){
                if (s.isStarve()){
                    s.execute();
                }
            }
        }
        if (!isEmpty()){

        }
        setWidget(new Widget(getName(), 0));
    }
}
