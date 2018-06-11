import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BruteCollinearPoints {

    Point[] point;
    LineSegment[] segments;
    int size;

    public BruteCollinearPoints(Point[] point) {
        if (null == point)
            throw new java.lang.IllegalArgumentException();
        this.point = point ;
        this.size = 10 ;
        this.segments = new LineSegment[this.size] ;
        // finds all line segments containing 4 point
        collinearSegments();
    }

    // (1,2), (3,3), (4,4), (7,7), (9,7)
    private void collinearSegments() {
        for (int p = 0 ; p < this.point.length ; p++) {
            for (int q = 0 ; q < this.point.length ; q++) {
                for (int r = 0 ; r < this.point.length ; r++) {
                    for (int s = 0 ; s < this.point.length ; s++) {

                        if (isAnyTwoPointsSame(p,q,r,s))
                        {continue;}

//                        if (isLineSegmentAlreadyExist())
//                        {continue;}

                        if (!isCollinear(this.point[p],this.point[q],this.point[r],this.point[s]))
                        {continue;}

                        Point minp = min(this.point[p],this.point[q],this.point[r],this.point[s]);
                        Point maxp = max(this.point[p],this.point[q],this.point[r],this.point[s]);
                        addLineSegment(minp,maxp);
                    }
                }
            }
        }
    }

    private Point min(final Point point,final Point point1,final Point point2,final Point point3) {
        return Collections.min(Arrays.asList(point,point1,point2,point3));
    }

    private Point max(Point point, Point point1, Point point2, Point point3) {
        return Collections.max(Arrays.asList(point,point1,point2,point3));
    }

    private boolean isAnyTwoPointsSame(int p, int q, int r, int s) {
        return ( p == q || p == r || p == s ||
                    q == r || q == s ||
                        r == s ) ;
    }

    int x = 0;
    private void addLineSegment(Point start, Point stop) {
        if (x<size)
            segments[x++] = new LineSegment(start,stop);
    }

    private boolean isCollinear(Point p, Point q, Point r, Point s) {
        double slope1 = p.slopeTo(q);
        double slope2 = p.slopeTo(r);
        double slope3 = p.slopeTo(r) ;
        double slope4 = p.slopeTo(s);
        boolean comp1 = slope1 == slope2;
        boolean comp2 = slope3 == slope4;
        return comp1 && comp2 ;
    }

    // the number of line segments
    public int numberOfSegments() {
        return segments.length;
    }

    // the line segments
    public LineSegment[] segments() {
        return segments;
    }

}