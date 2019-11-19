import java.io.*; 
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Point p1 = new Point(10000, 0);
        Point p2 = new Point(0, 10000);
        Point p3 = new Point(3000, 7000);
        Point p4 = new Point(7000, 3000);
        Point p5 = new Point(20000, 21000);
        Point p6 = new Point(3000,  4000);
        Point p7 = new Point(14000, 15000);
        Point p8 = new Point(6000,  7000);
        Point[] array = new Point[8];
        array[0] = p1;
        array[1] = p2;
        array[2] = p3;
        array[3] = p4;
        array[4] = p5;
        array[5] = p6;
        array[6] = p7;
        array[7] = p8;
        System.out.println(array[5]);
        BruteCollinearPoints b = new BruteCollinearPoints(array);
        System.out.println(b.numberOfSegments());
        LineSegment[] a = b.segments();
        System.out.println(Arrays.toString(a));
        System.out.println("---------------------------------------------------------------------------------------------");
        FastCollinearPoints c = new FastCollinearPoints(array);
        System.out.println(c.numberOfSegments());
        LineSegment[] d = c.segments();
        System.out.println(Arrays.toString(d));
    }
}