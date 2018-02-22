import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

/**
 * Corner cases.
 *      1. Throw a java.lang.IllegalArgumentException  if the client attempts to add a null item;
 *      2. Throw a java.util.NoSuchElementException if the client
 *      attempts to remove an item from an empty deque;
 *      3. Throw a java.lang.UnsupportedOperationException if the client calls the remove()
 *       method in the iterator;
 *      4. Throw a java.util.NoSuchElementException if the client calls
 *       the next() method in the iterator and there are no more items to return.
 *
 * Performance requirements.
 *              Your deque implementation must support each deque operation
 *              (including construction) in constant worst-case time. A deque
 *              containing n items must use at most 48n + 192 bytes of memory and use space
 *              proportional to the number of items currently in the deque. Additionally,
 *              your iterator implementation must support each operation (including construction)
 *              in constant worst-case time.
 *
 * @author Bhishma Jariwala
 * @version
 */
public class Deque<Item> implements Iterable<Item> {

    /*
     * ---------------------------------------
     * Instance Inner classes
     * ---------------------------------------
     */
    private class Node {
        Item item;
        Node next;
        Node prev;
    }
    private class DequeIterator implements Iterator<Item>{

        Node first;
        DequeIterator(){
            first = head;
        }

        @Override
        public boolean hasNext() {
            return first != null ;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item x = first.item;
            first = first.next;
            return x;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

	/*
	 * ---------------------------------------
	 * Instance variable(s)
	 * ---------------------------------------
	 */
    private Node head;
    private Node tail;
    private int  size;

	/*
	 * ---------------------------------------
	 * Constructor(s)
	 * ---------------------------------------
	 */

    // construct an empty deque
    public Deque() {
        head =  tail = null;
        size = 0;
    }

	/*
	 * ---------------------------------------
	 * Operation(s) of Deque
	 * ---------------------------------------
	 */

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item)
    {
        if (null == item)
            throw new IllegalArgumentException ();

        // Create a new node
        Node newNode = new Node();
        newNode.item = item;

        // Handle first node scenario for
        // head and tail
        if ( null == head && null == tail){
            // You're here because you are here for the first time.
            tail  = newNode;
        }
        else
        {
//            Node oldHead = head;
            head.prev = newNode;

            newNode.next = head;
            newNode.prev = null;
        }

        // Reset head to the top i.e. new node to head
        head = newNode;

        // Increment the size
        size++;
    }

    /**
     * add the item to the end
     *
     * @param item
     */
    public void addLast(Item item)
    {
        if (null == item)
            throw new IllegalArgumentException ();

        // Create a new node
        Node newNode = new Node();
        newNode.item = item;

        // Handle first node scenario for
        // head and tail
        if ( null == head && null == tail){
            // You're here because you are here for the first time.
            head  = newNode;
        }
        else
        {
//            Node oldTail = tail;
            tail.next = newNode;

            newNode.prev = tail;
            newNode.next = null;
        }

        // Reset head to the top i.e. new node to head
        tail = newNode;

        // Increment the size
        size++;
    }

    /**
     * remove and return the item from the front
     *
     * @return first item from the headNode
     */
    public Item removeFirst()
    {
        if (isEmpty())
            throw new NoSuchElementException();
        Item itemBuffer = head.item;
        head = head.next;
        if (head!=null)
            head.prev = null;   // Cleaning is required
        size--;
        return itemBuffer;
    }

    /**
     *  remove and return the item from the end
     *
     * @return the item from the end
     */
    public Item removeLast()
    {
        if (isEmpty())
            throw new NoSuchElementException();
        Item itemBuffer = tail.item;
        tail = tail.prev;
        if(tail!=null)
            tail.next = null;   // Cleaning is required after popping out item
        size--;
        return itemBuffer;

    }

    /**
     * return an iterator over items in order from front to end
     *
     * @return a new copy of iterator
     */
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }


    public static void main(String[] args) // unit testing (optional)
    {
//        Deque<String> myDeque = new Deque<>();
//
//        // Lets print 1st item
//        // StdOut.println(myDeque.removeFirst());
//
//        // Initial size of stack must be 0, hence following line
//        // must return true
//        StdOut.println(myDeque.isEmpty());
//
//        // And this line should return size 0
//        StdOut.println(myDeque.size());
//
//        // Lets add some item to test size increses properly or not
//        myDeque.addFirst("Hello");
//        myDeque.addFirst(",");
//        myDeque.addFirst("World !");
//        myDeque.addLast("Woooo hoo !");
//
//        // At this point size must be 4
//        StdOut.println(myDeque.size());
//
//        // Lets print 1st item,it should print "World !"
//        StdOut.println(myDeque.removeFirst());
//
//        // Lets print the last item,it should print "Woooo hoo !"
//        StdOut.println(myDeque.removeLast());
//
//        Iterator<String> stringIterator = myDeque.iterator();
//        StdOut.println(stringIterator.hasNext());
//        while(stringIterator.hasNext()){
//            StdOut.println(stringIterator.next());
//        }
//
//        Iterator<String> stringReverseIterator = myDeque.iterator();
//        StdOut.println(stringReverseIterator.hasNext());
//        while(stringReverseIterator.hasNext()){
//            StdOut.println(stringReverseIterator.next());
//        }
        Deque<Integer> deque = new Deque<Integer>();
        deque.addFirst(0);
        System.out.println(deque.removeFirst());
    }
}