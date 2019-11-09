import java.util.Scanner;
/**
 * Class for solution.
 * 
 * @author Divya
 */
public final class ransome {
    /**
     * Constructs the object.
     */
    private ransome() {
    }
    /**
     * This is the main method where the execution starts.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        SeparateChainingHashST<String, Integer> hash
        = new SeparateChainingHashST();
        String[] magazine = scan.nextLine().split(" ");
        for (int i = 0; i < magazine.length; i++) {
            if (hash.contains(magazine[i])) {
                hash.put(magazine[i], hash.get(magazine[i]) + 1);
            } else {
                hash.put(magazine[i], 1);
            }
        }
        String[] tobe = scan.nextLine().split(" ");
        for (int i = 0; i < tobe.length; i++) {
            if (hash.contains(tobe[i])) {
                if (hash.get(tobe[i]) == 0) {
                    System.out.print("No");
                    return;
                } else {
                    hash.put(tobe[i], hash.get(tobe[i]) - 1);
                }
            } else {
                System.out.print("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
