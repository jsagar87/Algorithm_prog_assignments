package sorting;

public class HelperFunctions {
    public static boolean less(Comparable v,Comparable w)
    {
        return v.compareTo(w) < 0 ;
        /* Reasoing:
              if v is less then w then we swap.
              if we is greater its a right order.
              What if v and w same? Its same, so swap or not it won't
              male any difference. In fact not swapping and keeping it
              as is may reduce a machine step, hence preferable.
         */
    }
    public static void exch(Comparable[] a, int i,int j)
    {
        Comparable temp = a[i] ;
        a[i] = a[j] ;
        a[j] = temp;
    }

    /**
     * Test if an array is sorted.
     *
     * @return <b>true</b> if sorted<br/> <b>false</b> if it is not sorted.
     */
    public static boolean isSorted(Comparable[] a)
    {
        // To test this, go through the array from the
        // one to the length of the array and test if each item is less
        // one before it. If this passes, means if it has an item that is
        // less then one before it, then its not sorted.
        //
        // If it goes through the array without that happening
        for (int i=1; i<a.length; i++)
        {
            if (less(a[i],a[i-1])) return false;
        }
        return true;
    }
}
