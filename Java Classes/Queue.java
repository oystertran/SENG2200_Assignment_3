import java.util.ArrayList;
public class Queue {
    private Widget widget;
    private ArrayList<Widget> list;
    private int length;

    public Queue(int length){
        list = new ArrayList<Widget>();
        length = 0;
    }

    public void enqueue(Widget item){//add item to the tail of the queue
        list.add(item);
        length++;
    }

    public Widget dequeue(){
        Widget item = list.get(0);
        list.remove(item);
        length--;
        return item;
    }

    public Widget peek(){
        Widget item = list.get(0);
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
