package com.bridgelabz.LinkedList;

import java.util.Scanner;
import java.util.Stack;

/**
 * Balanced Parentheses class to check expression is balanced or not
 * imports Stack class for pop and push methods
 */
public class BalancedParentheses {
    /**
     * checks whether the expression is balanced parentheses or not
     * @param s is string input given by user
     * @return boolean true if balanced else false
     */
    public static boolean balancedParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[' || ch == '(' || ch == '{') {
                stack.push(ch);
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (ch == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the expression");
        String str = sc.nextLine();
        if(balancedParentheses(str)) System.out.println("Balanced");
        else System.out.println("Not Balanced");
    }
}