import java.util.Scanner;
 /**
  * This class finds the FarthestPair.
  in an array whose difference is maximum

  @author Divya
  */

public class FarthestPair {
    /**
     * Initialisation of constructor.
     */
    FarthestPair() {

    }
    /**
     * This method returns the minimum element in the array.
     * @param arr , contains the elements in arr.
     * @return the minimum element in the arr. If there are no elements, then
     */
    public static double min(final double[] arr) {
        double min = arr[0];
        for (int i = 0; i < arr.length; i++) {
           if (arr[i] < min) {
              min = arr[i];
            }
        }
      return min;
    }
    /**
     * This method returns the maximum element in the array.
     * @param arr , contains the elements in arr.
     * @return the maximum element in the arr. If there are no elements, then
     */
    public static double max(final double[] arr) {
        double max = 0.0;
        //int i;
      for (int i = 0; i < arr.length; i++) {
         if (arr[i] > max) {
            max = arr[i];
         }
      }
      return max;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] str = scan.nextLine().split(" ");
        double[] array = new double[str.length];
        int k = 0;
        for(String s : str)
            {
                array[k++] = Double.parseDouble(s);
            }
        System.out.println("Farthest Pair is" + " " + max(array) + " " + "and" + " " + min(array) );
    }
}