public class Storage {
    private String name;//storage name
    private Queue storage;//
    private int size;//size of the storage (Qmax)
    public Storage(String name, int size){
        if (size > 1){
            storage = new Queue(size);
            this.name = name;
            this.size = size;
        }else{
            System.out.println("Size has to be at least 1");
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
