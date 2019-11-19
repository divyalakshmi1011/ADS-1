import java.util.ArrayList;
import java.util.Arrays;
/**
 * This class determines the Line segments which contains.
 * 4 line segments only
 * 
 * @author Divya
 */
public class BruteCollinearPoints {

    private final ArrayList<LineSegment> segmentLists = new ArrayList<LineSegment>();

    /**
     * Finds all line segments containing 4 points.
     * @param arguments pointarray
     */
    public BruteCollinearPoints(Point[] arguments) {
        if (arguments == null) throw new IllegalArgumentException();
        int n = arguments.length;
        for (int i = 0; i < n; i++) {
            if (arguments[i] == null) throw new IllegalArgumentException();
        }
        Point[] pointsArray = Arrays.copyOf(arguments, n);
        Arrays.sort(pointsArray);
        for (int i = 1; i < n; i++) {
            if (pointsArray[i].compareTo(pointsArray[i - 1]) == 0) throw new IllegalArgumentException();
        }
        for (int i = 0; i < n; i++) {
            Point p = pointsArray[i];
            for (int j = i + 1; j < n; j++) {
                Point p1 = pointsArray[j];
                for (int k = j + 1; k < n; k++) {
                    Point p2 = pointsArray[k];
                    for (int m = k + 1; m < n; m++) {
                        Point p3 = pointsArray[m];
                        if ((p.slopeTo(p1) == p.slopeTo(p3)) && (p.slopeTo(p1) == p.slopeTo(p2))){
                           segmentLists.add(new LineSegment(p, p3));
                        }
                    }
                }
            }
        }
    }

    /**
     * The number of line segments.
     * @return number of segments
     */
    public int numberOfSegments() {
        return segmentLists.size();
    }

    /**
     * The line segments.
     * @return line segments
     */
    public LineSegment[] segments() {
        LineSegment[] segmentsArray = new LineSegment[segmentLists.size()];
        return segmentLists.toArray(segmentsArray);
    }
}