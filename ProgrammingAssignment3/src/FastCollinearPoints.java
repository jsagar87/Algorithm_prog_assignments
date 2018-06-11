public class FastCollinearPoints {
    Point[] point;
    LineSegment[] segments;

    public FastCollinearPoints(Point[] point) {
        if (null == point)
            throw new java.lang.IllegalArgumentException();
        this.point = point ;
        // finds all line segments containing 4 point
        collinearSegments();
    }

    private void collinearSegments() {
        for (int p = 0 ; p < this.point.length ; p++) {
            for (int q = 0 ; q < this.point.length ; q++) {
                for (int r = 0 ; r < this.point.length ; r++) {
                    for (int s = 0 ; s < this.point.length ; s++) {
                        if (isAnyTwoPointsSame(p,q,r,s)){continue;}
                        if (isCollinear(this.point[p],this.point[q],this.point[r],this.point[s]))
                        {
                            addLineSegment(p,s);
                        }
                    }
                }
            }
        }
    }

    private boolean isAnyTwoPointsSame(int p, int q, int r, int s) {
        return ( p == q || p == r || p == s ||
                q == r || q == s ||
                r == s ) ;
    }

    int x = 0;
    private void addLineSegment(int p, int s) {
        segments[x++] = new LineSegment(point[p],point[s]);
    }

    private boolean isCollinear(Point p, Point q, Point r, Point s){
        return (p.slopeTo(q) ==  p.slopeTo(r)) && p.slopeTo(r) == p.slopeTo(s) ;
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
