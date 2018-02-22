import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 *
 * Corner cases.  Throw the specified exception for the following corner cases:
 *      Throw a java.lang.IllegalArgumentException if the client calls enqueue() with a null argument.
 *      Throw a java.util.NoSuchElementException if the client calls either sample() or dequeue() when the randomized queue is empty.
 *      Throw a java.util.NoSuchElementException if the client calls the next() method in the iterator when there are no more items to return.
 *      Throw a java.lang.UnsupportedOperationException if the client calls the remove() method in the iterator.
 *
 * Performance requirements.
 *    Your randomized headNode implementation must support each randomized headNode operation
 *    (besides creating an iterator) in constant amortized time. That is, any sequence of m randomized
 *    headNode operations (starting from an empty headNode) should take at most cm steps in the worst
 * case, for some constant c. A randomized headNode containing n items must use at
 * most 48n + 192 bytes of memory. Additionally, your iterator implementation
 * must support operations next() and hasNext() in constant worst-case time; and
 * construction in linear time; you may (and will need to) use a linear amount
 * of extra memory per iterator.
 *
 * @author
 * @version
*/
public class RandomizedQueue<Item> implements Iterable<Item> {


    private Item[] items;

    private int size;

    // construct an empty randomized queue
    public RandomizedQueue() {
        size = 0;
        items = (Item[])new Object[1];
    }

    /**
     * is the randomized queue empty?
     * @return true if
     */
    public boolean isEmpty() // is the headNode empty?
    {
        return size == 0;
    }

    /**
     * return the number of items on the headNode
     *
     * @return int size of current queue
     */
    public int size()
    {
        return size;
    }

    /**
     *  add the item
     *
     * @param item object to be added
     */
    public void enqueue(Item item)
    {
        if (null == item)
            throw new IllegalArgumentException ();
        if(size==items.length){
            resize();
        }

        items[size++] = item;

    }

    private void resize() {

        Item[] aux = (Item[]) new Object[2*items.length];

        int c = 0;
        // copy All the existing values to resized array
        for(Item i : items){
            aux[c++] = i;
        }

        // Pointing yo new resized array
        items = aux;
        // Scope of aux ends here, also original items array gets discarded
    }

    /**
     * remove and return a random item
     *
     * @return Item
     */
    public Item dequeue()
    {
        // When empty throw exception
        if(size==0)
            throw new NoSuchElementException();
        // Get the random number within the range of
        // linked list item
        int randomNumber = StdRandom.uniform(0,size);

        // Buffer before removing
        Item deportedItem = items[randomNumber];
        Item lastItem = items[size-1];

        // Shift last item in removed item space
        items[randomNumber] = lastItem ;

        size--;

        return deportedItem;
    }

    /**
     * return (but do not remove) a random item
     *
     * @return Item
     */
    public Item sample(){
        if(size==0)
            throw new NoSuchElementException();
        int randomNumber = StdRandom.uniform(0,size);

        Item sampleItem = items[randomNumber];

        return sampleItem;
    }

    public Iterator<Item> iterator() // return an independent iterator over
    // items in random order
    {
        return new Iterator<Item>() {
            private Item[] aux = items;
            private int cur = 0;
            private int q_size = size;
            @Override
            public boolean hasNext() {
                return cur < q_size;
            }

            @Override
            public Item next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                return aux[cur++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) // unit testing
    {
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        rq.sample();
        rq.enqueue("sagar");
        rq.enqueue("ajay");
        rq.enqueue("umesh");
        rq.enqueue("rupesh");
        rq.enqueue("surendra");
        rq.enqueue("subram");
        Iterator<String> myQueueIterator = rq.iterator();
        while(myQueueIterator.hasNext()){
            System.out.println(myQueueIterator.next());
        }

        rq.dequeue();
        rq.dequeue();

        System.out.println("===============");
        for(String s:rq)
            System.out.println(s);

        rq.enqueue(null);
    }
}
