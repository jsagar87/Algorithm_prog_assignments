package sorting;

public class SelectionSort {

    // Algorithm scans from left to right i = 0 -> N
    // Invariants,
    //           entries to the left of present i is fixed in ascending order
    //           no entries to the right of i is smaller than any entry to the left
    // below code implements the invariants
    public static void sort(Comparable[] a) {
        for (int i = 0 ; i < a.length ; i++) {               // each position scan
            int min = i;
            for (int j = i+1; j < a.length; j++) {           // each time we have to scan through remaining entry
                if (HelperFunctions.less(a[j], a[min])) {
                    min = j ;
                }
                HelperFunctions.exch(a, i, min);
            }
        }
    }

    // Unit testing
    public static void main(String[] args) {
        Double[] unsorted = {7d,10d,5d,3d,8d,4d,2d,9d,6d};
        for(double d : unsorted)
            System.out.println(d);
        sort(unsorted);
        System.out.println("After sorting");
        for(double d : unsorted)
            System.out.println(d);
    }
}
