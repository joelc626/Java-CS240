/* Author: Joel Castro
 * Class: CS 240-01: Data Structures and Algorithms I
 * Assignment: Hashing
 *
 * Driver:Hashing.java
 * Purpose: Develop my own hash table and hash functions.
 * The program will process score files, it has a name and a score on it.
 * The name can be multiple words with any amount of white space between them.
 */

import java.io.*;
import java.util.*;

class Hashing {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("Error: Directory name is missing");
            System.out.println("Usage: java scoreProcess directory_name");
            return;
        }
        File directory = new File(args[0]); // args[0] contains the directory name
        File[] files = directory.listFiles(); // get the list of files from that directory

        File file;
        Scanner input;
        int tableSize = 0;
        List<String> list = new ArrayList<String>();

        for (int i = 0; i < files.length; i++) {
            input = new Scanner(files[i]);

            String key;
            float value;

            while (input.hasNext()) {
                key = "";
                while (!input.hasNextFloat()) {
                    key += input.next() + " ";
                }

                //Delete the space char at the end of the keys
                key = key.substring(0, key.length() - 1);

                //Still need to catch the value but dont do nothing with it
                value = new Float(input.next());

                //Store all the different names in a list if they are not added already
                //Doing this to get the number of entries
                if(!list.contains(key)) {
                    list.add(key);
                    tableSize++;
                }
            }
            input.close();
        }

        //Pass the size
        HashChain hc = new HashChain(tableSize);

        //Reopen the directory
        directory = new File(args[0]); // args[0] contains the directory name
        files = directory.listFiles(); // get the list of files from that directory

        //process the arguments stores in args
        for (int i = 0; i < files.length; i++) {
            input = new Scanner(files[i]);
                              
            String key;
            float value;
            while (input.hasNext()) {
                key = "";
                while (!input.hasNextFloat()) {
                    key += input.next() + " ";
                }
                //Delete the space char at the end of the keys
                key = key.substring(0, key.length() - 1);

                value = new Float(input.next());

                //Add the key with its value
                hc.addEntry(key, value);
            }
        }
        String name;
        Scanner kb = new Scanner(System.in);
        
        System.out.println("# of collisions:     " + hc.getNumOfColl());
        System.out.println("Size of table:       " + tableSize);
        System.out.println("Load Factor:         "
                        + (double)(hc.getNumOfEntries() / (tableSize)));
        System.out.println("\n# of Names:          " + hc.getNumOfEntries());
        hc.setCurMinAndMax();
        System.out.println("Minimum average:     " + hc.getCurMin());
        hc.printCurMinList(hc.getCurMin());
        System.out.println("Maximum average:     " + hc.getCurMax());
        hc.printCurMinList(hc.getCurMax());
        System.out.println();

        //Add user for a name to look up
        do {
            System.out.print("Enter name : ");
            name = kb.nextLine();
            
            if (name.equals("exit"))
                return;

            //Make sure the name is a valid name before getting averages
            if (hc.checkValidation(name) == false)
                System.out.println("  " + name + " not found");
            else
                System.out.println("  " + name + ": Avg: " + hc.getAvg(name) 
                    + "\t# Scores: " + hc.getScores(name));
        }
        while (!name.equals("exit"));
    }
}
