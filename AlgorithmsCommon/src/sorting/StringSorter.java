package sorting;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Insertion;

public class StringSorter {

    public static void main(String[] args) {
        String[] a = In.readStrings(args[0]);
        Insertion.sort(a);
        for (String s : a)
        {
            System.out.print(s + " ");
        }
    }
}
//C:\Users\sagar\algorithm-assignment\Algorithm_prog_assignments\AlgorithmsCommon\resource\sorting\words3.txt
//sorting/words3.txt