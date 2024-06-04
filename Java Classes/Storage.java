public class Storage<T> {
    private String name;//storage name
    private Queue<T> storage;//
    private int size;//size of the storage (Qmax)
    public Storage(String name, int size){
        if (size > 1){
            storage = new Queue<T>();
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

    public void add(T item){
        storage.enqueue(item);
    }
}
