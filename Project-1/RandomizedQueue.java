import java.util.Iterator;
import java.util.Random;

/**
 * This class implements the Randomozed Queue.
 * which differs in dequeuing an item from normal
 * queue
 *
 * This class also includes Iterator class which enables
 * to iterate over the randomized queue and return all the
 * items in the queue
 * @param <Item>
 *
 * @author Divya
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    /**
     * This is the iterator class.
     * @param <Item>
     */
    private class RandomizedIterator<Item> implements Iterator<Item> {
        /**
         * tandomizedQueue of item type.
         */
        private Item[] randomizedQueue;
        /**
         * current is the present number of items in.
         * randomizesQueue
         */
        private int current;

         RandomizedIterator(final Item[] randomizedQueue) {
            int sizeOfQueue = size();
            this.randomizedQueue = (Item[]) new Object[sizeOfQueue];
            for (int i = 0; i < sizeOfQueue; i++) {
                this.randomizedQueue[i] = randomizedQueue[i];
            }
            shuffle(this.randomizedQueue);
        }
        private Item[] shuffle(final Item[] randomizedQueues) {
            Random rnd = new Random();
            for (int i = randomizedQueues.length - 1; i > 0; i--) {
                int index = rnd.nextInt(i + 1);
                Item a = randomizedQueues[index];
                randomizedQueues[index] = randomizedQueues[i];
                randomizedQueues[i] = a;
            }
            return randomizedQueues;
        }
        /**
         * Returns true if the iteration has more elements.
         * @return number
         */
        public boolean hasNext() {
            return current != randomizedQueue.length;
        }
        /**
         * Returns the next element in the iteration.
         * It throws NoSuchElementException if no more
         * element present
         * @return item
         */
        public Item next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            return randomizedQueue[current++];
        }
        /**
         * Remove the next element in the iteration.
         */
        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }
    /**
     * randomized queue array of item type.
     */
    private Item[] randomizedQueue;
    /**
     * iterator.
     */
    private RandomizedIterator<Item> iterator;
    /**
     * number of items in the randomized queue.
     */
    private int numberOfItems;
    /**
     * Initialization of constructor with capacity 10.
     */
    public RandomizedQueue() {
        randomizedQueue = (Item[]) (new Object[10]);
        numberOfItems = 0;
    }

    /**
     * is the randomized queue empty?.
     * @return true if empty else returns false.
     */
    public boolean isEmpty() {
        return numberOfItems == 0;
    }

    /**
     * return the number of items on the randomized queue.
     * @return number
     */
    public int size() {
        return numberOfItems;
    }

    /**
     * add the item into randomized Queue.
     * @param item item
     */
    public void enqueue(final Item item) {
        if (item == null) {
            throw new java.lang.IllegalArgumentException();
        }
        if (numberOfItems == randomizedQueue.length) {
            resize(randomizedQueue.length * 2);
        }
        randomizedQueue[numberOfItems] = item;
        numberOfItems = numberOfItems + 1;
    }

    /**
     * remove and return a random item.
     * @return item
     */
    public Item dequeue() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        Random random = new Random();
        int num = random.nextInt(size());
        Item item = randomizedQueue[num];
        randomizedQueue[num] = randomizedQueue[numberOfItems - 1];
        numberOfItems--;
        randomizedQueue[numberOfItems] = null;
        if (!isEmpty() && size() == randomizedQueue.length / 4) {
            resize(randomizedQueue.length / 2);
        }
        return item;
    }

    /**
     * return a random item (but do not remove it).
     * @return item
     */
    public Item sample() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        Random random = new Random();
        int num = random.nextInt(size());
        return randomizedQueue[num];
    }

    /**
     * return an independent iterator over items in random order.
     * @return iterator
     */
    public Iterator<Item> iterator() {
        iterator = new RandomizedIterator<Item>(randomizedQueue);
        return iterator;
    }

    /**
     * Helper Function for resizing of randomized queue.
     * if required
     * @param resizingLength resizes
     */
    private void resize(final int resizingLength) {
        Item[] tempQueue = (Item[]) (new Object[resizingLength]);
        int sizeOfQueue = size();
        for (int i = 0; i < sizeOfQueue; i++) {
            tempQueue[i] = randomizedQueue[i];
        }
        randomizedQueue = tempQueue;
    }
    /**
     * unit testing.
     * @param args arguments.
     */
    public static void main(final String[] args) {
        RandomizedQueue<Integer> randomQueue = new RandomizedQueue<>();
        randomQueue.enqueue(1);
        randomQueue.enqueue(10);
        randomQueue.enqueue(2);
        randomQueue.enqueue(34);
        randomQueue.enqueue(3);
        randomQueue.enqueue(90);
        randomQueue.enqueue(91);
        randomQueue.enqueue(92);
        randomQueue.enqueue(93);
        randomQueue.enqueue(94);
        randomQueue.enqueue(95);
        randomQueue.enqueue(100);
        System.out.println("Sample" + randomQueue.sample());
        System.out.println("Deque" + randomQueue.dequeue());
        System.out.println("Deque" + randomQueue.dequeue());
        System.out.println("Deque" + randomQueue.dequeue());
        for (Integer number : randomQueue) {
            System.out.println(number);
        }
        System.out.println("Size" + randomQueue.size());
    }
}
