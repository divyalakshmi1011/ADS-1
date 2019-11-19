import java.util.ArrayList;
import java.util.Arrays;
/**
 * This class checks the slope equalities and.
 * returns the line segments containing 4 or more
 * points whode slopes are equal.
 * 
 * @author Divya
 */
public class FastCollinearPoints {

    private final ArrayList<LineSegment> segmentsList = new ArrayList<>();

     /**
      * Finds all line segments containing 4 or more points.
      * @param arguments
      */
    public FastCollinearPoints(Point[] arguments) {

        if (arguments == null) throw new IllegalArgumentException();
        
        int n = arguments.length;

        for (int i = 0; i < n; i++) {
            if (arguments[i] == null) throw new IllegalArgumentException();
        }

        Point[] pointsArray = Arrays.copyOf(arguments, n);
        for (int i = 0; i < n; i++) {
            Point p = arguments[i];
            Arrays.sort(pointsArray);
            Arrays.sort(pointsArray, p.slopeOrder());
            int minimum = 0;
            while (minimum < n && p.slopeTo(pointsArray[minimum]) == Double.NEGATIVE_INFINITY) minimum++;
            // Check duplicate points
            System.out.println(minimum);
            if (minimum != 1) throw new IllegalArgumentException();
            System.out.println(minimum);
            int maximum = minimum;
            System.out.println(minimum);
            System.out.println("Max :" + maximum + "Min :" + minimum);
            while (minimum < n) {
                System.out.println("Max :" + maximum + "Min :" + minimum);
                while (maximum < n && p.slopeTo(pointsArray[maximum]) == p.slopeTo(pointsArray[minimum])) maximum++;
                System.out.println("Max :" + maximum + "Min :" + minimum);
                if (maximum - minimum >= 3) {
                    Point pMin = pointsArray[minimum];
                    if (!(pointsArray[minimum].compareTo(p) < 0)) pMin = p;
                    if (p == pMin)
                    segmentsList.add(new LineSegment(pMin, pointsArray[maximum - 1]));
                    System.out.println("Max :" + maximum + "Min :" + minimum);
                }
                minimum = maximum;
            }
        }
    }

    /**
     * The number of line segments.
     * @return number of linesegments
     */
    public int numberOfSegments() {
        return segmentsList.size();
    }

    /**
     * The line segments which contains points of equal slope.
     * @return Line segments
     */
    public LineSegment[] segments() {
        LineSegment[] segmentsArray = new LineSegment[segmentsList.size()];
        return segmentsList.toArray(segmentsArray);
    }
}