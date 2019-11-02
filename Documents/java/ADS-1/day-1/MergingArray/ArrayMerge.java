import java.util.Arrays;

public class ArrayMerge {
    /**
     * This methods merges two sorted arrays.
     * into a single sorted array and prints
     */
    public static void Merge() {
        int[] A1 = {1, 3, 5, 6, 7, 13};
        int[] A2 = {1, 2, 4, 6, 8, 9, 10, 11, 12};
        int a = A1.length;
        int b = A2.length;
        int[] arr = new int[a + b];
        int i = 0;
        int j = 0;
        int temp = 0;
        while (i < a && j < b) {
            if (A1[i] >= A2[j]) {
                arr[temp] = A2[j];
                temp++;
                j++;
            } else {
                arr[temp] = A1[i];
                temp++;
                i++;
            }
        }
                while (i < a) {
                    arr[temp] = A1[i];
                    temp++;
                    i++;
                }
                if (a == i) {
                    while (j < b) {
                        arr[temp] = A2[j];
                        temp++;
                        j++;
                    }
                }
       System.out.println(Arrays.toString(arr));
    }
    /**
     * This is the main method from where the.
     * execution starts
     * @param args
     */
    public static void main(final String[] args) {
        Merge();
    }
}
