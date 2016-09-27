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

class StackApplication {
    public static void main(String[] args) {
        String infix;
        Scanner kb = new Scanner(System.in);

        while (true) {
            System.out.print("Enter an input expression: ");
            infix = kb.nextLine();

            //end when user hits ENTER
            if(infix.equals(""))
                break;

            infixToPostfix(infix);
            infixToPrefix(infix);
        }
    }

    static void infixToPostfix(String infix) {
        NodeStack<Character> myStack = new NodeStack<Character>();
        char curChar;
        String pfx = "";

        for (int i = 0; i < infix.length(); i++) {
            curChar = infix.charAt(i);
            
            //if curChar == *, -, /, +, %
            if (isOperator(curChar)) {
                //while curChar operator <= top of the stack, pop and add
                while (!myStack.isEmpty() && prec(myStack.top()) >= prec(curChar))
                    pfx += myStack.pop();
                //add curChar
                myStack.push(curChar);
            }
            
            //left parentheses are always pushed onto a stack
            else if (curChar == '(')
                myStack.push(curChar);
            
            //the symbol on the top of the stack is popped off
            else if (curChar == ')') {
                while(!myStack.top().equals('('))
                    pfx += myStack.pop();
                //pop the '('
                myStack.pop();
            }

            //variables are directly copied to output
            else
                pfx += curChar;
        }

        //remaining chars
        while (!myStack.isEmpty()){
            //Check for unmatched parentheses
            if (myStack.top().equals('(')) {
                System.out.println("Error! Unmatched parentheses");
                System.exit(0);
            }
            pfx += myStack.pop();
        }

        System.out.println("\nThe postfix expression is: " + pfx + "");
    }
    
    static void infixToPrefix(String infix) {
        NodeStack<Character> torsStack = new NodeStack<Character>();
        NodeStack<String> randsStack = new NodeStack<String>();
        char curChar;
        String right = "";
        String left = "";
        String op = "";
        String opRL= "";
        String pfx = "";

        for (int i = 0; i < infix.length(); i++) {
            curChar = infix.charAt(i);
            //left parentheses are always pushed onto the operand stack
            if (curChar == '(')
                torsStack.push(curChar);
            //if curChar == *, -, /, +
            else if (curChar == ')') {
                while(!torsStack.top().equals('(')) {
                    op = "" + torsStack.pop();
                    //Check for unmatched parentheses
                    if (op.equals("(") || op.equals(")")) {
                        System.out.println("Error! Unmatched parentheses");
                        System.exit(0);
                    }
                    right = randsStack.pop();
                    left = randsStack.pop();
                    opRL = op + left + right;
                    randsStack.push(opRL);
                }
                //pop the '('
                torsStack.pop();
            }
            else if (isOperator(curChar)) {
                //if no parentheses || ..., push into operators stack
                if (torsStack.isEmpty() || (prec(curChar) > prec(torsStack.top())))
                    torsStack.push(curChar);
                else {
                    //if 
                    while (!torsStack.isEmpty() && prec(curChar) <= prec(torsStack.top())) {
                        op = "" +  torsStack.pop();
                        //Check for unmatched parentheses
                        if (op.equals("(") || op.equals(")")) {
                            System.out.println("Error! Unmatched parentheses");
                            System.exit(0);
                        }
                        right = randsStack.pop();
                        left = randsStack.pop();
                        opRL = op + left + right;
                        randsStack.push(opRL);
                        //System.out.println("*" + opRL + "*");
                    }
                    torsStack.push(curChar);
                }
            }
            //variables (operands) are pushed onto the operand stack 
            else {
                String temp = "" + curChar;
                randsStack.push(temp);
            }
        }

        while (!torsStack.isEmpty()) {
            op = "" +  torsStack.pop();
            //Check for unmatched parentheses
            if (op.equals("(") || op.equals(")")) {
                System.out.println("Error! Unmatched parentheses");
                System.exit(0);
            }
            right = randsStack.pop();
            left = randsStack.pop();
            opRL = op + left + right;
            randsStack.push(opRL);
        }
        pfx = randsStack.pop();

        System.out.println("The prefix expression is: " + pfx + "");
        System.out.println("-----------------------------------");
    }

    static boolean isOperator(char e) {
        if(e == '*' || e == '-' || e == '/' || e == '+' || e == '%')
            return true;
        return false;
    }
    
    //Find the precedence of operations
    public static int prec(char operator) {
        if(operator == '+' || operator =='-')
            return 1;
        if(operator == '*' || operator == '/' || operator == '%')
            return 2;
        //for para.
        return 0;
    }
}

