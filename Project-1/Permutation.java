import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    /**
     * This is the main method.
     * @param args
     */
   public static void main(final String[] args) {
      RandomizedQueue<String> rq = new RandomizedQueue<String>();
      while (!StdIn.isEmpty()) {
          rq.enqueue(StdIn.readString());
      }
      int number = Integer.parseInt(args[0]);
      for (int i = 0; i < number; i++) {
        StdOut.println(rq.dequeue());
      }
    }
}