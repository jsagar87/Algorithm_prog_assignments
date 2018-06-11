package sorting;


import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Our goal is to sort any type of data.
 */
public class Experiment {

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Double[]  a = new Double[N];
        for (int i = 0; i<N; i++)
        {
            a[i] = StdRandom.uniform();
        }

        // Sort
        Insertion.sort(a);
        for (int i = 0; i<N; i++)
        {
            StdOut.println(a[i]);
        }
    }
}
