package priorityQueues;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Transaction;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TopM {

    public static void main(String[] args) throws FileNotFoundException {

        // Print the top M lines in the input stream - M being user input
        int M = Integer.parseInt(args[0]);
        MinPQ<Transaction> pq = new MinPQ<Transaction>(M+1);
        if(args.length > 1)
            System.setIn(new FileInputStream("C:\\Users\\sagar\\algorithm-assignment\\Algorithm_prog_assignments\\AlgorithmsCommon\\resource\\priorityQueues\\"+args[2]));

        System.out.println(String.format("Top %s records will be printed",M));

        while (StdIn.hasNextLine()) {
            pq.insert(new Transaction(StdIn.readLine()));
            if (pq.size()>M)
                pq.delMin();
        }
        Stack<Transaction> stack = new Stack<Transaction>();
        while (!pq.isEmpty()) stack.push(pq.delMin());
        for (Transaction t : stack) StdOut.println(t);

    }
}
