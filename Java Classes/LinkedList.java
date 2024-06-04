
public class LinkedList<T>{//Linked List only allow object of type T to ge inserted
    protected Node<T> sentinel;
    protected Node<T> head;
    protected int size;

    //A new Linked List has a default sentinel node
    public LinkedList(){
        sentinel = new Node<T>();
        sentinel.setNext(sentinel);
        sentinel.setPrev(sentinel);
        size = 0;
    }


    /*
     * Method to add a new node to the start of the list 
     * Pre-condition: None
     * Post-condition: add a node to the sart of the list if the list has more than one node,
     * or create a head node if the list is empty
     */
    public void append(T data){
        Node<T> nodeItem = new Node<T>(data);
        if (size == 0){//if the list only has the sentinel node, add it before the sentinel node and do nothing else
            nodeItem.setNext(sentinel);
            nodeItem.setPrev(sentinel);
            sentinel.setPrev(nodeItem);
            sentinel.setNext(nodeItem);
            size++;
            head = sentinel.getNext();
        }else{//if the list has more than one node, add it before the sentinel node and update the link
            //new node is between the last node and sentinel node
            insertBefore(data, sentinel);
            head = sentinel.getNext();
        }
    }

    /*
     * Method to add node to the end of the list
     * Pre-condition: None
     * Post-condition: Add new node to the end of the list, make it the sentinel node
     * if the list has more than one node, or add a head node if the list is empty
     */
    public void prepend(T data){
        Node<T> nodeItem = new Node<T>(data);
        if (size == 0){//if the list is empty, add new node after the sentinel node and do nothing else
            //there's only 1 node so it cannot go anywhere
            nodeItem.setNext(sentinel);
            nodeItem.setPrev(sentinel);
            sentinel.setPrev(nodeItem);
            sentinel.setNext(nodeItem);
            //current node is the new node
            head = nodeItem;
            size++;
            return;
        }else{//if there are one or more node in the list
            //new node is between the first node and the sentinel node
            insertBefore(data, head);
            head = nodeItem;
        }
    }

    /*
     * Method the add a node before a desired node in the linkedlist
     * Pre-conditin: None
     * Post-condition: Add a node before a desire node in the list
     */
    public void insertBefore(T data, Node<T> nodeDesired){
        Node<T> nodeInsert = new Node<T>(data);
        Node<T> prevNode = nodeDesired.getPrev();
        nodeInsert.setPrev(prevNode);
        nodeInsert.setNext(nodeDesired);
        prevNode.setNext(nodeInsert); // Link prevNode's next to newNode
        nodeDesired.setPrev(nodeInsert); // Link tempNode's prev to newNode
        size++;
    }

    /*
     * Method to return the head of the list
     * Pre-condition: None
     * Post-condition: return the head of the list 
     */
    public Node<T> getHead(){
        return head;
    }

    /*
     * Method to return the sentinel node of the list
     * Pre-condition: None
     * Post-condition: return the sentinel node of the list 
     */
    public Node<T> getSentinel(){
        return sentinel;
    }

    public void removeHead(){
        Node<T> temp = sentinel.getNext();
        head = temp.getNext();
        head.setPrev(sentinel);
    }

    /*
     * Method to insert data to the list by calling the append method
     * Pre-condition: None
     * Post-condition: append data to the list
     */
    public void insert(T data){
        append(data);
    }

    /*
     * next() and reset() method is rewritten to throw UnsupportedOperationException
     */
    public void next() throws UnsupportedOperationException{
        
    }
    public void reset() throws UnsupportedOperationException{
        
    }
}