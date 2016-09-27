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

class HashChain {
    private Node hashTable[]; //node array call it hashtable
    private int numOfEntries = 0;
    private int numOfColl = 0;
    private float curMin = 0;
    private float curMax = 0;
    private List<String> curMinList = new ArrayList<String>();
    private List<String> curMaxList = new ArrayList<String>();
   
    //Constructor with size
    public HashChain(int size) {
        numOfEntries = size;
        hashTable = new Node[numOfEntries];
        for (int i = 0; i < numOfEntries; i++)
            hashTable[i] = new Node();
    }
    
    //Add to the nodes with information
    public void addEntry(String name, float s) {
        int hv = hashFunc(name);
        Node n = new Node (hv, name, hashTable[hv].getNext(), s);

        //If collision happens then connect nodes
        if (hashTable[hv].getName() == null)
            hashTable[hv] = n;
        else
            hashTable[hv].setNext(n);
    }
    
    //Validate if the name is in the program
    public boolean checkValidation(String name) {
        int hashVal = hashFunc(name);
        Node cur = hashTable[hashVal];
        if (cur.getName() == null)
            return false;
        for (; cur != null; cur = cur.getNext()) 
            if (cur.getName().equals(name)) 
                return true;
        return false;
    }

    //Hash the name and use it as an index
    public int hashFunc(String name) {
        int hashVal = 0;
        int length = name.length();

        for (int i = 0; i < length; i++)
            hashVal = 41 * hashVal + name.charAt(i);
        hashVal %= numOfEntries;
        if (hashVal < 0)
            hashVal += numOfEntries;
        return hashVal;
    }
    
    //Get the number of times a name comes up in the directory
    public int getScores(String name) {
        int count = 0;
        int hashVal = hashFunc(name);
        for (Node cur = hashTable[hashVal]; cur != null; cur = cur.getNext())
            if (cur.getName().equals(name))
                count++;
        return count;
    }

    public void setCurMinAndMax() {
        for (int i = 0; i < numOfEntries; i++) {
            for (Node cur = hashTable[i]; cur != null; cur = cur.getNext()) {
                
                //Initialize the first name as the curMin
                if (curMin == 0)
                    curMin = getAvg(cur.getName());
                
                //If node is empty, continue with the for loop
                if (cur.getName() == null)
                    break;

                //Set curMin and curMax
                if (curMin >= getAvg(cur.getName()))
                    curMin = getAvg(cur.getName());
                if (curMax <= getAvg(cur.getName()))
                    curMax = getAvg(cur.getName());
            }
        }
    }

    public float getCurMin() {
        return curMin;
    }

    public float getCurMax() {
        return curMax;
    }

    public int getNumOfEntries() {
        return numOfEntries;
    }

    //Prints the names that match curMin
    public void printCurMinList(float min) {
        for (int i = 0; i < numOfEntries; i++)
            for (Node cur = hashTable[i]; cur != null; cur = cur.getNext()) {
                if (cur.getName() == null)
                    break;
                if (getAvg(cur.getName()) == min)
                    if (!curMinList.contains(cur.getName())) {
                        curMinList.add(cur.getName());
                        System.out.println("  " + cur.getName());
                    }
            }
    }

    //Prints the names that match curMax
    public void printCurMaxList(float max) {
        for (int i = 0; i < numOfEntries; i++)
            for (Node cur = hashTable[i]; cur != null; cur = cur.getNext()) {
                if (cur.getName() == null)
                    break;
                if (getAvg(cur.getName()) == max)
                    if (!curMaxList.contains(cur.getName())) {
                        curMaxList.add(cur.getName());
                        System.out.println("  " + cur.getName());
                    }
            }
    }

    //Get the average of the name passed
    public float getAvg(String name) {
        int hashVal = hashFunc(name);
        float temp = 0;
        for (Node cur = hashTable[hashVal]; cur != null; cur = cur.getNext())
            if (cur.getName().equals(name))
                temp += cur.getSum();
        return (temp / getScores(name));
    }

    //Get the number of collisions
    public int getNumOfColl() {
        for (int i = 0; i < numOfEntries; i++) {
            Node cur = hashTable[i];
            Node temp = cur.getNext();
            while (temp != null) {
                if (!cur.getName().equals(temp.getName()))
                    numOfColl++;
                else
                    break;
                temp = temp.getNext();
            }
        }
        return numOfColl; 
    }
}
