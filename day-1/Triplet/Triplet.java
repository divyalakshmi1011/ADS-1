import java.util.Arrays;

class Myclass {
    /**
     * This method searches the required element by.
     * making the array length half of its original length
     * @param a
     * @param key
     * @return
     */
    public static int binarySearch(final int[] a, final int key) {
        int l = 0;
        int h = a.length - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (key < a[mid]) {
                h = mid - 1;
            } else if (key > a[mid]) {
                l = mid + 1;
            } else {
                return a[mid];
            }
        }
        return -1;
    }
    /**
     * This method prints number of triplets in a.
     * array whose sum is zero
     */
    public static void Triplet() {
        int c = 0;
        int z = 0;
        int[] arr = {-40, -20, -10, 0, 5, 10, 30};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                z = arr[i] + arr[j];
                if ((-z) == binarySearch(arr, (-z))) {
                    c++;
                }
            }
        }
        System.out.println(c);
    }
}

public class Triplet {
    /**This is the main method from.
     * where the execution starts
     * @param args
     */
    public static void main(final String[] args) {
        Myclass obj = new Myclass();
        obj.Triplet();
    }
}

