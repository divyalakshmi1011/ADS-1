import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * This is the Queue implementation.
 * 
 * @author Divya
 */
class CircularQueue<Item> implements Iterable<Item> {
    private Node<Item> last;     // end of queue
    private int n;               // number of elements on queue

    // helper linked list class
    private class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    /**
     * Initializes an empty queue.
     */
    CircularQueue() {

    }

    /**
     * Returns true if this queue is empty.
     *
     * @return {@code true} if this queue is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Returns the number of items in this queue.
     *
     * @return the number of items in this queue
     */
    public int size() {
        return n;
    }

    /**
     * Adds the item to this queue.
     *
     * @param  item the item to add
     */
    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        if(isEmpty()) {
            last.next = last;
        } else {
            last.next = oldlast.next;
            oldlast.next = last;
        }
        n++;
    }

    /**
     * Removes and returns the item on this queue that was least recently added.
     *
     * @return the item on this queue that was least recently added
     * @throws NoSuchElementException if this queue is empty
     */
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        if(last.next == last) {
            Item item = last.next.item;
            last = null;
            return item;
        } else {
           Item item = last.next.item;
           last.next = last.next.next;
           n--;
           return item;
        }
    }

    /**
     * Returns an iterator that iterates over the items in this queue in FIFO order.
     *
     * @return an iterator that iterates over the items in this queue in FIFO order
     */
    public Iterator<Item> iterator()  {
        return new ListIterator<Item>(last.next);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}

public class Test {
    /**
     * unit testing.
     * @param args
     */
    public static void main(String[] args) {
        CircularQueue<Integer> c = new CircularQueue<Integer>();
        c.enqueue(4);
        c.enqueue(10);
        c.enqueue(11);
        c.enqueue(12);
        c.enqueue(13);
        c.enqueue(14);
        System.out.println(c.size());
        System.out.println(c.dequeue());
        System.out.println(c.dequeue());
        System.out.println(c.dequeue());
        System.out.println(c.dequeue());
        System.out.println(c.dequeue());
        System.out.println(c.dequeue());
        System.out.println(c.dequeue());
    }
}