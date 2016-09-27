/* Author: Joel Castro
 * Class: CS 240-01: Data Structures and Algorithms I
 * Assignment: Stack Application
 *
 * Driver: StackApplication.java
 * Purpose: Take a user's equation and send it to
 * postfix and prefix functions for printing using my own Stack.
 */

import java.util.*;
import java.io.*;

public class NodeStack<E> implements Stack<E> {
    protected Node<E> top; // reference to the head node
    protected int size; // number of elements in the stack
          
    public NodeStack() { // constructs an empty stack
        top = null; //no dummy head
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (top == null)
            return true;
        return false;
    }

    public void push(E elem) {
        top = new Node<E> (elem, top);
        size++;
    }

    public E top() { 
        //top is the head
        if (isEmpty()) {
            System.out.println("Something is wrong. Please check your expression.");
            System.exit(0);
        }
        return top.getElement();
    }
    
    public E pop() {
        if (isEmpty()) {
            System.out.println("Something is wrong. Please check your expression.");
            System.exit(0);
        }
        E tmp = top.getElement();
        top = top.getNext();
        size--;
        return tmp;
    }
}
