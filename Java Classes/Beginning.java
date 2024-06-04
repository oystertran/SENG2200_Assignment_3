public class Beginning extends Stage {
    private Storage storage;
    public Beginning(String name, Storage storage){
        setName(name);
        setWidget(new Widget(name));
        this.storage = storage;
    }

    public Beginning(){
        setT1(0.0);
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
