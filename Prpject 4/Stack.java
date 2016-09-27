/* Author: Joel Castro
 * Class: CS 240-01: Data Structures and Algorithms I
 * Assignment: Stack Application
 *
 * Driver: StackApplication.java
 * Purpose: Take a user's equation and send it to
 * postfix and prefix functions for printing using my own Stack.
 */

public interface Stack<E> {
    /*
     * Return the number of elements in the stack.
    * @return number of elements in the stack.
    */
    public int size();
    
    /*
    * Return whether the stack is empty.
    * @return true if the stack is empty, false otherwise.
    */
    public boolean isEmpty();
    
    /*
    * Inspect the element at the top of the stack.
    * @return top element in the stack.
    */
    public E top();
    
    /*
    * Insert an element at the top of the stack.
    * @param element to be inserted.
    */
    public void push (E element);
    
    /*
    * Remove the top element from the stack.
    * @return element removed.
    */
    public E pop();
}
