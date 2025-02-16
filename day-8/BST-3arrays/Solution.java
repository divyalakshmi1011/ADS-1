import java.util.Arrays;
/**
 * This class implements the array notation of BST.
 * keys are stored in one array
 * the left indices are stored in other array
 * the right indices are stored in another array
 * 
 * @author Divya
 */
class BinarySTA<Key extends Comparable<Key>, Value> {
        /**
         * keys array stores keys.
         */
        Key[] keys;
        /**
         * values array stores values.
         */
        Value[] values;
        /**
         * these arrays stores left and right links and sizes of arrays.
         */
		int[] leftLinks, rightLinks, size;
        /**
         * initialises the constructor with size limit.
         */
		BinarySTA(final int sizeLimit) {
			keys = (Key[]) new Comparable[sizeLimit];
			values = (Value[]) new Object[sizeLimit];
			leftLinks = new int[sizeLimit];
			rightLinks = new int[sizeLimit];
			size = new int[sizeLimit];

			for (int i = 0; i < sizeLimit; i++) {
				leftLinks[i] = -1;
				rightLinks[i] = -1;
			}
		}
        /**
         * This method returns the number of keys.
         */
		public int size() {
			return size(0);
		}

		private int size(int index) {
			if (index == -1) {
				return 0;
			}
				return size[index];
		}
        /**
         * This method inserts a element into the keys array.
         * and stores the left and right indices into the
         * corresponding arrays
         * @param key
         * @param value
         */
		public void put(Key key, Value value) {
				if (key == null || value == null) throw new IllegalArgumentException();
				if (size() == keys.length) {
					System.out.println("Size Limit Reached.");
				return;
				}
				put(0, key, value);
		}

		private int put(int index, Key key, Value value) {
			if (index == -1 || keys[index] == null) {
				int nextElementIndex = size();
				keys[nextElementIndex] = key;
				values[nextElementIndex] = value;
				size[nextElementIndex] = 1;

			return nextElementIndex;
		}

		int compare = key.compareTo(keys[index]);

		if (compare < 0) {
			leftLinks[index] = put(leftLinks[index], key, value);
		} else if (compare > 0) {
			rightLinks[index] = put(rightLinks[index], key, value);
		} else {
			values[index] = value;
		}

			size[index] = size(leftLinks[index]) + 1 + size(rightLinks[index]);
			return index;
		}

		public String toString() {
			return Arrays.toString(keys) + "\n" + Arrays.toString(leftLinks) + "\n" + Arrays.toString(rightLinks);
		}
        /**
         * This method returns the value which is paired with the key.
         * @param key
         */
		public Value get(Key key){
			return get(0,key);
		}


		public Value get(int index, Key key){
			if (key == null) throw new IllegalArgumentException("calls get() with a null key");
	        if (index == -1) return null;
	        int cmp = key.compareTo(keys[index]);
	        if      (cmp < 0) return get(leftLinks[index], key);
	        else if (cmp > 0) return get(rightLinks[index], key);
	        else              return values[index];
			}
}


public class Solution{
    /**
     * This is the main method and here 
     * testing of above function takes place
     */
	public static void main(String[] args) {
				BinarySTA<String, Integer> bsta = new BinarySTA<String, Integer>(11);
				bsta.put("S",0);
				bsta.put("E",1);
				bsta.put("A",2);
				bsta.put("R",3);
				bsta.put("C",4);
				bsta.put("H",0);
				bsta.put("E",0);
                bsta.put("X",1000000);
                System.out.println(bsta.get("C"));
                System.out.println(bsta.get("X"));
    }
}