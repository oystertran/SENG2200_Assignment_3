public class Node<T>{
    private Node<T> next;
    private Node<T> prev;
    private T data;

    public Node(){
        data = null;
        next = null;
        prev = null;
    }
    public Node(T data){
        this.data = data;
    }

    //getters and setters methods
    public Node<T> getNext(){
        return next;
    }
    public Node<T> getPrev(){
        return prev;
    }
    public T getData(){
        return data;
    }

    public void setNext(Node<T> next){
        this.next = next;
    }

    public void setPrev(Node<T> previous){
        this.prev = previous;
    }

    public void setData(T data){
        this.data = data;
    }
}