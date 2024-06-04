public class Beginning extends Stage {
    private Storage storage;//inter-stage storage
    private Queue stageQueue;//stage capacity
    public Beginning(String name, Storage storage){
        setName(name);
        setWidget(new Widget(name, 0.0));
        stageQueue = new Queue<>();
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
            storage.add(storage);
        }
    }
}
