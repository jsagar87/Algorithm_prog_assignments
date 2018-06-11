package sorting;

import static sorting.HelperFunctions.*;

public class QuickSort {

    public static void sort(Comparable[] a){

    }

    private static int partition(Comparable[] a, int lo, int hi)
    {
        int i = lo,j=hi+1;

        while (true) {
            while(less(a[++i],a[lo]))      // Find item on left to swap
                if ( i==hi)  break;

            while(less(a[--j],a[i]))      // Find item on right to swap
                if ( j==lo ) break;

            if (i>=j) break;
            exch(a,i,j);
        }
        exch(a,i,j);
        return j;
    }
}
