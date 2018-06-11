package sorting;

import static sorting.HelperFunctions.less;
import static sorting.HelperFunctions.exch;


/*
 * Inversion is a keys that are partially sorted
 *
 * Array is partially sorted if the number of inversion is <= cN
 */
public class InsertionSort {

    public static void sort(Comparable[] a) {
        // i is index
        for (int i = 1; i < a.length; i++) {
            // Back propagation from current index to beginning
            // or the correct position
            for (int j = i ; j > 0 ; j--) {
                if (less(a[j],a[j-1])) {
                    exch(a,j,j-1);
                }
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