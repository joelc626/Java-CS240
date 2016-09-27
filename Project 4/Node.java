/* Author: Joel Castro
 * Class: CS 240-01: Data Structures and Algorithms I
 * Assignment: Stack Application
 *
 * Driver: StackApplication.java
 * Purpose: Take a user's equation and send it to
 * postfix and prefix functions for printing using my own Stack.
 */

import java.io.*;
import java.util.*;

public class Node<E> {
    private E element;
    private Node<E> next;
    
    //Creates a node with null references to its element and next node
    public Node() {
        this(null, null);
    }
    
    //Creates a node with the given element and next node
    public Node(E e, Node<E> n) {
        element = e;
        next = n;
    }

    //Returns the element of this node
    public E getElement() {
        return element;
    }

    //Returns the next node of this node
    public Node<E> getNext() {
        return next;
    }

    //Sets the element of this node
    public void setElement(E newElem) {
        element = newElem;
    }

    //Sets the next node of this node
    public void setNext(Node<E> newNext) {
        next = newNext;
    }
}
