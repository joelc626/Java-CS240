/* Author: Joel Castro
 * Class: CS 240-01: Data Structures and Algorithms I
 * Assignment: Random Name Selector
 *
 * Purpose: Your professor wants to have a program that can help him/her call
 * a random name to answer questions during class. You will be given a list of
 * names in a file called "name.txt".
 */

import java.util.*;
import java.io.*;

public class RandomNameSelector {
    public static void main(String[] args) {
        int size = 0;;      //How many students on the list.
        String comm = "n";  //Command initialized to n so a name must be generated.
        int gen = 0;        //Count how many names have been generated.
        int rep = 0;        //Counts the repetitions of the names.
        String curName;     //The name generated after displayed.
        String tempRem;     //Temporarily removes the name from the list.
        String[] nameArr = new String[size];
        int[] nameCount = new int[size];
        LinkedList<String> list = new LinkedList<String>();
        Random rand = new Random();
        Scanner kb = new Scanner(System.in);
        
        //Attempt to open the file name.txt and read the names.
        try {
            File nameFile = new File("name.txt");
            Scanner names = new Scanner(nameFile);

            //Reads the file and gets the correct number of students.
            while (names.hasNextLine()) {
                String temp = names.nextLine(); //This is so the loop will stop.
                size++;
            }
            names.close();
        
            //Reset the file by creating a new Scanner
            names = new Scanner(nameFile);
            
            //Now the correct size is set.
            nameArr = new String[size];
            nameCount = new int[size];
            
            //Stores the names into the array.
            for (int i = 0; i < size; i++) {
                nameArr[i] = names.nextLine();
                nameCount[i] = 0;
            }
            names.close();
        }

        //If the file doesn't exist and end the program.
        catch (FileNotFoundException e) {
            System.out.println("The file was not found.");
            return;
        }

        //Displays the number of student in this class
        System.out.println("\nNumber of students in class: " + size);
        
        do {
            if (comm.equals("n")) {
                //Randomly choose a name, display it, count it, and add it to the list.
                curName = nameArr[rand.nextInt(size)];
                System.out.println("\n" + curName + "\n");
                gen++;
                list.add(curName);

                //Counts how many times each name was called.
                for (int i = 0; i < size; i++)
                    if (curName.equals(nameArr[i]))
                        nameCount[i]++;

                //Counts how many times a name is repeted.
                if (gen > 1) {
                    tempRem = list.removeLast();
                    if (list.contains(curName))
                        rep += 1;
                    list.add(tempRem);
                }
            }

            //Ask the user for a command.
            System.out.print("Command? ");
            comm = kb.nextLine();
           
            //Displays the list of names and how many times they where each called.
            if (comm.equals("list")) {
                int num = 1;
                System.out.println();
                for (int i = 0; i < size; i++) {
                    System.out.println(num + ". " + nameArr[i] + " (" + nameCount[i] + ")");
                    num++;
                }
                System.out.println();
            }

            //Displays the options of what the user can command the prgram to do.
            if (comm.equals("help")) {
                System.out.println("\n n\t Next random name");
                System.out.println(" exit\t Exit the program");
                System.out.println(" list\t List all the unique names "
                            + "that have been called as well as the number of times");
                System.out.println(" help\t Display this message\n");
            }
        }
        while(!comm.equals("exit"));

        //Finishes the program with correct counts of names and repetitions.
        System.out.println("\nThe program has generated " + gen
                            + " name(s) with " + rep + " repetition(s)\n");
    }
}
