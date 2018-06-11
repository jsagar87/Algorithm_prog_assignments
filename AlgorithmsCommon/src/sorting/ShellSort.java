package sorting;

import static sorting.HelperFunctions.exch;
import static sorting.HelperFunctions.less;

/**
 *  Looks elementary type of sorting algorithm in face. But its not.
 *  Idea.
 *      Idea behind shell sort is Move entries more than one position at a time
 *      by h-sorting the array.
 *
 *      An h sorted array is h interleaved sorted subsequences.
 *
 *  Shellsort. h-sort array for decreasing sequence of values of h.
 *  Initially starting with h = 13. then h=4,1..
 *
 *  How to h-sort an array? Insertion sort, with stride length h.
 *
 *  Invented by Shell in 1959
 */
public class ShellSort {
    public static void sort(Comparable[] a) {
        // Big increment => small sub array.
        // Small increments => nearly in order
        int h =3;
        // i is index
        for (int i = 1; i < a.length; i++) {
            // Back propagation from current index to beginning
            // or the correct position
            for (int j = i ; j > 0 ; j=j-h) {
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

        String[] unsortedString = {"M","O","L","E","X","A","S","P","R","T"};

        for(String s : unsortedString)
            System.out.println(s);
        sort(unsortedString);
        System.out.println("After sorting string");
        for(String s : unsortedString)
            System.out.println(s);
    }
}
