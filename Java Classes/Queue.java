public class Queue<T> {
    private LinkedList<T> list;
    private int length;

    public Queue(){
        list = new LinkedList<T>();
        length = 0;
    }

    public void enqueue(T item){//add item to the tail of the queue
        list.prepend(item);
        length++;
    }

    public T dequeue(){
        T item = peek();
        list.removeHead();;
        length--;
        return item;
    }

    public T peek(){
        T item = list.getHead().getData();
        return item;
    }

    public int size(){
        return length;
    }

    public boolean empty(){
        if(length == 0){
            return true;
        }
        return false;
    }
}
