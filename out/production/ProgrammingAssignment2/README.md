**Fundamental data-types**

********************************************
*	**1.3 Bags, Queues, And Stacks**
********************************************

1. stacks
2. resizing arrays
3. queues
4. generics
5. iterators
6. applications

(Careful and closelook at  8-0 ;-\) )

**Introduction:**    
In many applications we have collection of objects that we wanna maintain
Operations are very simple. We wanna add something to the collection. May be remove something from the collection. And Iterate through the collection performing some action 

********************************************
*	**Stacks and queues**
********************************************
Fundamental data types
- Values: collection of objects
- Operations: insert, remove, iterate, test if empty
- Intent is clear when we insert
- Which item do we remove.

Stack : Examine the item most recently added. LIFO = "Last in first out"
 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ <---- push
|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|
							   -----> pop
							   
Queues : Examine the item least recently added. FIFO = "First in first out"
			    _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ 
enqueue	-----> |_|_|_|_|_|_|_|_|_|_|_|_|_|_|_| -----> dequeue
							   							   
														   
**********************************************************
*	**Client, Implemetation, Interface**
**********************************************************

Seperate interface and Implemetation
Ex: stack,queue,bag,priority queue,symbol table,union-find,...

Benefits,
1. Client can't know details of implementation =>
		client has many implementations from which to choose.
2. Implemetation can't know details of client's need =>
		many clients can reuse the same implementation.

Design: creates modular,reusable library.
Performance: use optimised implementation where it matters.

	Client: program using the operations defined in interface.
	Implemetation: actual code implementing the operations.
	Interface: description of data type, basic operations.
	
***********************************************************
* **Stack API**
***********************************************************

    public class StackOfStrings
    -------------------------------------------
    StackOfStrings()                // Create an empty stack
    
    
    
