import java.util.Queue;

/**
 * This class implements sequential search symbol table.
 * for self organising search
 * @author Divya
 * 
 * 
 * @param <Key>
 * @param <Value>
 */
public class SequentialSearchST<Key extends Comparable<Key>, Value> {

    private int n;           // number of key-value pairs.
    private Node head;      // the linked list of key-value pairs.

    // a helper linked list data type.
    private class Node {
        private Key key;
        private Value value;
        private Node next;

        public Node(Key key, Value value)  {
            this.key   = key;
            this.value = value;
        }
    }

    // return number of key-value pairs
    public int size() {
        return n;
    }
    /**
     * inserts the key value pair into Sequential search.
     * Symbol table at the end
     * @param key
     * @param value
     */
    public void put(Key key, Value value) {
        Node node = new Node(key, value);
        if(head == null) {
            head = node;
        }
        Node current = head;
        while(current != null) {
            if(current.key.compareTo(key) == 0) {
                current.value = value;
                return;
            }
            current = current.next;
        }
        Node oldhead = head;
        head = new Node(key, value);
        head.next = oldhead;
    }
    private Value exchange(Node current) {
        Node temp = current.next;
        Value value = temp.value;
        current.next = current.next.next;
        Node node = head;
        while(node.next != null) {
            node = node.next;
        }
        node.next = temp;
        temp.next = null;
        return value;
    }

    /**
     * This method checks for the given key.
     * and its values 
     * @param key
     * @return key value pair
     */
    public Value get(Key key) {
        if(key == null) {
            return null;
        }
        if(head.key.compareTo(key) == 0) {
            return exchange(head);
        }
        Node current = head;
        while(current != null) {
            if(current.next.key.compareTo(key) == 0) {
                return exchange(current);
            }
            current = current.next;
        }
        return null;
    }
    /**
     * This method enqueues all the elements of.
     * Symbol table to a queue
     * @return queue consisting of symbol table elements
     */
    public QueueLinkedList<Key > key() {
        QueueLinkedList<Key> obj = new QueueLinkedList<Key>();
        Node current = head;
        while(current != null) {
            obj.enqueue(current.key);
            current = current.next;
        }
        return obj;
    }
    /**
     * This method is used to convert queue to string.
     * @return String of inserted elements
     */
    public String keys() {
        String str = "";
        Node current = head;
        while(current != null) {
            str = str + current.key + " ";
            current = current.next;
        }
        return str;
    }
}