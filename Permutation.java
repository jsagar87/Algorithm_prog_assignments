import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author Bhishma Jariwala
 */
public class Permutation {

    public static void main(String[] args) {

        String numberString = args[0];

        Integer number = Integer.parseInt(numberString);

        RandomizedQueue<String> q = new RandomizedQueue<>();

        while(!StdIn.isEmpty()) {
            String inputStr = StdIn.readString();
            q.enqueue(inputStr);
        }

        int cnt = 0;
        while(cnt<number) {
//            if(cnt<q.size())
            StdOut.println(q.dequeue());
            cnt++;
        }
    }

}