/* Author: Joel Castro
 * Class: CS 240-01: Data Structures and Algorithms I
 * Assignment: Set Implementation
 *
 * Driver: SetImplementation.java
 * Purpose: You are to implement a Set ADT using a singly linked list.
 * Create and test various methods like adding, removeing elements and
 * checking sets with one another about their elements.
 */

import java.io.*;
import java.util.*;

public class Node {
    private Object element;
    private Node next;
    
    //Creates a node with the given element and next node
    public Node(Object o, Node n) {
        element = o;
        next = n;
    }

    //Returns the element of this node
    public Object getElement() {
        return element;
    }

    //Returns the next node of this node
    public Node getNext() {
        return next;
    }

    //Sets the element of this node
    public void setElement(Object newElem) {
        element = newElem;
    }

    //Sets the next node of this node
    public void setNext(Node newNext) {
        next = newNext;
    }
}