/* Author: Joel Castro
 * Class: CS 240-01: Data Structures and Algorithms I
 * Assignment: Hashing
 *
 * Driver:Hashing.java
 * Purpose: Develop my own hash table and hash functions.
 * The program will process score files, it has a name and a score on it.
 * The name can be multiple words with any amount of white space between them. 
 */

import java.util.*;
import java.io.*;

class Node {
    private String name; //key
    private Node next; //a node pointing to the next
    private float sum;
    private int count;
    private int hash;
    
    //One Constructor
    public Node() {}

    //This constuctor creates a node with the given name and next node
    public Node(int h, String name, Node n, float s) {
        next = n;
        this.name = name;
        hash = h;
        sum = s;
    }

    //Sets the name of this node
    public void setName(String newName) {
        name = newName;
    }

    //Sets the next node of this node
    public void setNext(Node newNext) {
        next = newNext;
    }

    //Sets the hash value of this node
    public void setNext(int hv) {
        hash = hv;
    }

    //Sets the sum value of this node
    public void setSum(float s) {
        sum = s;
    }

    //Returns the element of this node
    public String getName() {
        return name;
    }

    //Returns the next node of this node
    public Node getNext() {
        return next;
    }

    //Returns the hash value of this node
    public int getHash() {
        return hash;
    }

    //Returns the hash value of this node
    public float getSum() {
        return sum;
    }
}
