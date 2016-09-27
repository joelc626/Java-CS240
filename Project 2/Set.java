/* Author: Joel Castro
 * Class: CS 240-01: Data Structures and Algorithms I
 * Assignment: Set Implementation
 *
 * Driver: SetImplementation.java
 * Purpose: You are to implement a Set ADT using a singly linked list.
 * Create and test various methods like adding, removeing elements and
 * checking sets with one another about their elements.
 */

import java.util.*;
import java.io.*;

//Singly linked list
public class Set {
    protected Node head;
    protected int size;

    //Default constructor that creates an empty list with a dummy head
    public Set() {
        head = new Node(null, null);
        size = 0;
    }

    //Returns true if the given object is contained in the set and false otherwise
    boolean contain(Object object) {
        for(Node cur = head.getNext(); cur != null; cur = cur.getNext())
            if (cur.getElement().equals(object))
                return true;
        return false;
    }

    //Returns true if the node containing the object is removed from the set and
    //false otherwise
    boolean remove(Object object) {
        //Check to see if the list is empty
        if (head.getNext() == null) {
            System.out.println("List is empty");
            return false;
        }
        for(Node cur = head; cur.getNext() != null; cur = cur.getNext())
            if (cur.getNext().getElement().equals(object)) {
                cur.setNext(cur.getNext().getNext());
                size--;
                return true;
            }
        return false;
    }

    //Returns false if element not added because it is already in the set and 
    //true if the element is added
    boolean addElement(Object object) {
        for(Node cur = head.getNext(); cur != null; cur = cur.getNext())
            if(cur.getElement() == object)
                return false;
        Node n = new Node(object, head.getNext());
        head.setNext(n);
        size++;
        return true;
    }

    //returns an integer equal to the number of distinct objects are in the Set
    int size() {
        return size;
    }

    //A.subsetOf(B). Returns true if every element in set A is in set B and
    //false otherwise
    boolean subsetOf(Set set) {
        for(Node cur = head.getNext(); cur != null; cur = cur.getNext())
            if(set.contain(cur.getElement()) == false)
                return false;
        return true;
    }

    //Returns true if both sets contain the same elements where order in
    //either set does not count
    boolean isEqual(Set set) {
        //Check if the sizes equal
        if(set.size() != size)
            return false;
        for(Node cur = head.getNext(); cur != null; cur = cur.getNext())
            if(set.contain(cur.getElement()) == false)
                return false;
        return true;
    }

    //C = A.union(B). Union returns a Set that contains all the elements
    //in set A and B, but only list duplicates once
    Set union(Set set) {
        Set setC = new Set();
        //Add elements from A
        for(Node cur = head.getNext(); cur != null; cur = cur.getNext())
                setC.addElement(cur.getElement());
        //Add elements from B that are not added already
        for(Node cur = set.head.getNext(); cur != null; cur = cur.getNext())
                setC.addElement(cur.getElement());
        return setC;
    }

    //C = A.intersection(B) and returns a set containing only elements
    //that are common to both A and B, but no duplicates
    Set intersection(Set set) {
        Set setC = new Set();
        for(Node cur = head.getNext(); cur != null; cur = cur.getNext())
            if(set.contain(cur.getElement()))
                setC.addElement(cur.getElement());
        return setC;
    }
    
    //C = A.complement(B) and returns a set containing only elements that
    //are in A but not in B
    Set complement(Set set) {
        Set setC = new Set();
        for(Node cur = head.getNext(); cur != null; cur = cur.getNext())
            if(set.contain(cur.getElement()) == false)
                setC.addElement(cur.getElement());
        return setC;
    }

    //Displays a message that indicates an object's state.
    //An object's state is the data that is stored in the object's fields
    //at any giving moment
    public String toString() {
        String str = "{";
        for(Node cur = head.getNext(); cur != null; cur = cur.getNext()) {
            str += cur.getElement();
            if (cur.getNext() != null)
                str += ", ";
        }
        return str += "}";
    }
}