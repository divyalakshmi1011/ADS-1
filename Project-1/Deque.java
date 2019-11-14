import java.util.Iterator;

/**
 * This class is Deque.
 * @param <Item>
 *
 *@author Divya
 */

public class Deque<Item> implements Iterable<Item> {
    /**
     * first node.
     */
    private Node first;
    /**
     * last node.
     */
    private Node last;
    /**
     * number of items in queue.
     */
    private int numberOfItems;

    private class Node {
        /**
         * item.
         */
        private Item item;
        /**
         * reference to next item.
         */
        private Node next;
        /**
         * reference to previous item.
         */
        private Node prev;

    }
    private class ListIterator implements Iterator<Item> {
        /**
         * present node.
         */
        private Node current;
        /**
         * initialisation of constructor.
         * @param initialNode node
         */
        ListIterator(final Node initialNode) {
            current = initialNode;
        }
        /**
         * sees if there is nextt item.
         * @return true or false
         */
        public boolean hasNext() {
            return current != null;
        }
        /**
         * @return next item.
         */
        public Item next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
        /**
         * removes the item.
         */
        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }
    /**
     * is the deque empty?
     * @return true or false.
     */
    public boolean isEmpty() {
        return first == null;
    }
    /**
     * return the number of items on the deque.
     * @return size.
     */
    public int size() {
        return numberOfItems;
    }
    /**
     * add the item.
     * @param item item
     */
    public void addFirst(final Item item) {
        if (item == null) {
            throw new java.lang.IllegalArgumentException();
        }
        if (numberOfItems == 0) {
            first = new Node();
            first.item = item;
            last = first;
        } else {
            Node oldFirst = first;
            first = new Node();
            first.item = item;
            first.next = oldFirst;
            oldFirst.prev = first;
        }
        numberOfItems++;
    }
    /**
     * add the item at the end.
     * @param item add
     */
    public void addLast(final Item item) {
        if (item == null) {
            throw new java.lang.IllegalArgumentException();
        }
        Node newNode = new Node();
        newNode.item = item;
        if (last != null) {
            newNode.prev = last;
            last.next = newNode;
        }
        last = newNode;
        if (first == null) {
            first = last;
        }
        numberOfItems++;
    }
    /**
     * removes first.
     * @return item
     */
    public Item removeFirst() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        Item item = first.item;
        if (numberOfItems == 1) {
            last = null;
            first = null;
        } else {
            first.next.prev = null;
            first = first.next;
        }
        numberOfItems--;
        return item;
    }
    /**
     * removes the last item.
     * @return item
     */
    public Item removeLast() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        Item item = last.item;
        if (last.prev == null) {
            last = null;
            first = null;
        } else {
            last.prev.next = null;
            last = last.prev;
        }
        numberOfItems--;
        return item;
    }
    /**
     * iterator.
     * @return iterator
     */
    public Iterator<Item> iterator() {
        // return an iterator over items in order from front to end
        return new ListIterator(first);
    }
    /**
     * unit testing.
     * @param args arguments
     */
    public static void main(final String[] args) {
        Deque<String> d = new Deque<String>();
        d.addFirst("Divya");
        d.addFirst("Pallavi");
        d.addFirst("Sree");
        d.addLast("Msit");
        d.removeFirst();
        d.removeLast();
        for (String string : d) {
            System.out.println(string);
        }
        System.out.println(d.size());
    }
}
