
public class MergeSort {

    /**
     * Basic plan for merge sort is
     * 1. Divide array into two halves
     * 2. Recursively sort each half.
     * 3. Merge two halves
     */

//    private String[] a;

    private  MergeSort() {}

    public static void sort(Comparable[] a){

    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

        assert isSorted(a, lo, mid);
        assert isSorted(a, mid + 1, hi);

        int i = lo, j = mid + 1;
        // Copy
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];

        // Merge
        for (int k = lo; k <= hi; k++)

            if (less(a[i], a[j])) aux[k] = a[i++];
            else aux[k] = a[j++];


    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {

        int i = lo, j = lo + 1;
        while (j <= hi) {
            if (!less(a[i], a[j]))
                return false;
            i++;
            j++;
        }
        return true;
    }

    private static boolean less(Comparable a, Comparable b) {
        return (a.compareTo(b) < 0);
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args) {

        MergeSort.sort(new String[]{"p","q","t","s"});

    }
}
