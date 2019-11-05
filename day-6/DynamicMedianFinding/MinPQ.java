import java.util.Comparator;
// import java.util.Iterator;

/**
 * class minimum priority queue.
 * @param <Key> type.
 * @author Divya
 */
public class MinPQ<Key extends Comparable<Key>> {
    /**
     *it is an array of type key.
     * pq represents the priority queue.
     */
    private Key[] pq;

    /**
     * n represents the size of the array.
     */
    private int n;

    /**
     * comparator.
     */
    private Comparator<Key> comparator;

    /**
     * to find the min pq.
     * @param capacity size.
     */
    public MinPQ(final int capacity) {
        pq = (Key[]) new Comparable[capacity + 1];
    }

    /**
     * isempty or not.
     * @return true or false.
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
     * represents the size.
     * @return size.
     */
    public int size() {
        return n;
    }

    /**
     * inserts the elements.
     * @param key element
     */
    public void insert(final Key key) {
        pq[++n] = key;
        swim(n);
    }

    /**
     * deletes the maximum element.
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
     * gives the maximum value.
     * @return max value
     */
    public Key min() {
        return pq[1];
    }

    /**
     * sends the element to the top.
     * @param k index.
     */
    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    /**
     * drops the elements.
     * @param k index
     */
    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && greater(j, j + 1)) {
                j++;
            }
            if (!greater(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    /**
     * checks whether greater or not.
     * @param i element1
     * @param j element2
     * @return true or false.
     */
    private boolean greater(final int i, final int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
        } else {
            return comparator.compare(pq[i], pq[j]) > 0;
        }
    }

    /**
     * swaps the element.
     * @param i 1 element
     * @param j 2 element
     */
    private void exch(final int i, final int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
}