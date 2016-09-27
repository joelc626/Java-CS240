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

public class SetImplementation {
    public static void main(String[] args) {
        //Create list
        Set listA = new Set();
        Set listB = new Set();
        Set listD = new Set();

        //Make sure list are empty and get their size is 0
        System.out.println("List before anything added:");
        System.out.println("ListA: " + listA + " & size of " + listA.size());
        System.out.println("ListB: " + listB + " & size of " + listB.size());
        System.out.println("ListD: " + listD + " & size of " + listD.size());
        System.out.println();
        
        //Add elements
        listA.addElement(1);
        listA.addElement(3);
        listA.addElement(5);
        listA.addElement(7);
        listA.addElement(7);  //Try to add a duplicate

        listB.addElement(3);
        listB.addElement(4);
        listB.addElement(5);

        //Check if elements where added and have correct size
        System.out.println("List after adds:");
        System.out.println("ListA: " + listA + " & size of " + listA.size());
        System.out.println("ListB: " + listB + " & size of " + listB.size());
        System.out.println("ListD: " + listD + " & size of " + listD.size());
        System.out.println();

        //Check if remove method works correctly
        System.out.println("Did element 3 remove from ListA? " + listA.remove(3));
        System.out.println("ListA: " + listA + " & size of " + listA.size());
        System.out.println("Did element 9 remove from ListA? " + listA.remove(9));
        System.out.println("ListA: " + listA + " & size of " + listA.size());
        System.out.println();

        //Add element back
        System.out.println("Did element 3 add back to ListA? " + listA.addElement(3));
        System.out.println("ListA: " + listA + " & size of " + listA.size());
        System.out.println();
       
        //Check if elements 1-9 are contained in ListA
        System.out.println("Check if elements 1-9 are contained in ListA");
        for(int i = 1; i < 10; i++)
            System.out.println("ListA contains " + i + "? " + listA.contain(i));
        System.out.println();
        
        //Check to see if ListA is a subset of ListB
        System.out.println("With:");
        System.out.println("ListA: " + listA + " & size of " + listA.size());
        System.out.println("ListB: " + listB + " & size of " + listB.size());
        System.out.println("Is ListA a subset of ListB? " + listA.subsetOf(listB));
        System.out.println();
        
        //Check to see if ListB is a subset of ListA after removing elements
        listA.remove(7);
        listB.remove(4);
        System.out.println("But with:");
        System.out.println("ListA: " + listA + " & size of " + listA.size());
        System.out.println("ListB: " + listB + " & size of " + listB.size());
        System.out.println("Is ListB a subset of ListA? " + listB.subsetOf(listA));
        System.out.println();

        //Check the isEquals method
        System.out.println("With:");
        System.out.println("ListA: " + listA + " & size of " + listA.size());
        System.out.println("ListB: " + listB + " & size of " + listB.size());
        System.out.println("Is ListA is equal to ListB? " + listA.isEqual(listB));
        System.out.println();

        //Check the isEquals method after removing an element
        listA.remove(1);
        System.out.println("But with:");
        System.out.println("ListA: " + listA + " & size of " + listA.size());
        System.out.println("ListB: " + listB + " & size of " + listB.size());
        System.out.println("Is ListA is equal to ListB? " + listA.isEqual(listB));
        System.out.println();
        
        //Going back to the original sets
        listA.addElement(1);
        listA.addElement(7);

        listB.addElement(4);

        //Check the union method
        System.out.println("With:");
        System.out.println("ListA: " + listA + " & size of " + listA.size());
        System.out.println("ListB: " + listB + " & size of " + listB.size());
        System.out.println("ListA union ListB? " + listA.union(listB));
        System.out.println();

        //Check the intersection method
        System.out.println("With:");
        System.out.println("ListA: " + listA + " & size of " + listA.size());
        System.out.println("ListB: " + listB + " & size of " + listB.size());
        System.out.println("ListA intersection ListB? " + listA.intersection(listB));
        System.out.println();


        //Check the complement method
        System.out.println("With:");
        System.out.println("ListA: " + listA + " & size of " + listA.size());
        System.out.println("ListB: " + listB + " & size of " + listB.size());
        System.out.println("ListB complement ListA? " + listB.complement(listA));
        System.out.println("ListA complement ListB? " + listA.complement(listB));
        System.out.println();


        //Extra test cases with the empty ListD
        System.out.println("With:");
        System.out.println("ListA: " + listA + " & size of " + listA.size());
        System.out.println("ListB: " + listB + " & size of " + listB.size());
        System.out.println("ListD: " + listD + " & size of " + listD.size());
        System.out.println("Is ListD a subset of ListA? " + listD.subsetOf(listA));
        System.out.println("Is ListD a subset of ListB? " + listD.subsetOf(listB));
        System.out.println("Is ListD a subset of ListD? " + listD.subsetOf(listD));
    }
}
