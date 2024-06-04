public class Storage {
    private String name;//storage name
    private Queue storage;//
    private int size;//size of the storage (Qmax)
    public Storage(String name, int size) throws Exception{
        if (size > 1){
            storage = new Queue(size);
            this.name = name;
            this.size = size;
        }else{
            throw new Exception("Storage must not be empty");
        }
        
    }
    //getter methods
    public String getName(){
        return name;
    }
    public int getSize(){
        return size;
    }
}
