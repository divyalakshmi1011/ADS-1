// import java.util.Comparator;
// import java.util.Iterator;

/**
 * class maximum priority queue.
 * @param <Key> type
 * @author Divya
 */
public class MaxPQ<Key extends Comparable<Key>> {
    /**
     *this will be an array of key type.
     * @param pq represents the priorty queue
     */
    private Key[] pq;

    /**
     * @param n size of the array.
     */
    private int n;

    /**
     * this method gives a max value.
     * @param capacity size.
     */
    public MaxPQ(final int capacity) {
        pq = (Key[]) new Comparable[capacity + 1];
    }

    /**
     * checks whether empty or not.
     * @return true or false
     */
    public boolean isEmpty() {
        if (n == 0) {
            return true;
        } else {
            return false;
        }
        // return true;
    }

    /**
     * puts the elements into the priority queue.
     * @param key value
     */
    public void insert(final Key key) {
        pq[++n] = key;
        swim(n);
    }

    /**
     * returns maximum.
     * @return the maximum value
     */
    public Key max() {
        return pq[1];
    }

    /**
     * delete the maximum value.
     * @return maximum value.
     */
    public Key delMax() {
        Key max = pq[1];
        exch(1, n--);
        sink(1);
        pq[n + 1] = null;
        return max;
    }

    /**
     * sends the element to the top in the hash table.
     * @param k element
     */
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    /**
     * gives the size.
     * @return integer.
     */
    public int size() {
        return n;
    }

    /**
     * sinks the element.
     * @param k the value.
     */
    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    /**
     * compares.
     * @param i 1 element
     * @param j 2 element
     * @return true or false.
     */
    private boolean less(final int i, final int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    /**
     * swaps the values.
     * @param i 1 element
     * @param j 2 element
     */
    private void exch(final int i, final int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
}