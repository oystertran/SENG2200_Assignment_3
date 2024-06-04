public class Queue {
    private LinkedList<Widget> list;
    private int length;

    public Queue(int length){
        list = new LinkedList<Widget>();
        length = 0;
    }

    public void enqueue(Widget item){//add item to the tail of the queue
        list.prepend(item);
        length++;
    }

    public Widget dequeue(){
        Widget item = peek();
        list.removeHead();;
        length--;
        return item;
    }

    public Widget peek(){
        Widget item = list.getHead().getData();
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
