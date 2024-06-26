public class Storage<T> {
    private String name;//storage name
    private Queue<T> storage;//
    private int size;
    private int max;//size of the storage (Qmax)
    public Storage(String name, int max){
        if (max > 1){
            storage = new Queue<T>();
            this.name = name;
            this.max = max;
        }else{
            System.out.println("Size has to be at least 1");
        }
        
    }

    public Storage(String name){
        storage = new Queue<T>();
        this.name = name;

    }
    //getter methods
    public String getName(){
        return name;
    }
    public int getSize(){
        size = storage.size();
        return size;
    }
    public int getMax(){
        return max;
    }
    public Queue<T> getStorage(){
        return storage;
    }
    public void add(T item){
        storage.enqueue(item);
    }
    public T poll(){
        T item = storage.poll();
        return item;
    }
}
