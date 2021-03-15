package stack;

import java.util.Stack;

/*
Given a binary tree, check if its balanced i.e. depth of left and right subtrees of every node differ by at max 1. Return true if given binary tree is balanced, false otherwise.
        Input format :

        Elements in level order form (separated by space). If any node does not have left or right child, take -1 in its place.

*/


public class CheckBalanced {

    public static void main(String[] args) {
        System.out.println(checkBalanced("[ a * ( b+ (c + d)) ]\n"));
    }

    public static boolean checkBalanced(String exp) {
        // Write your code here
        Stack<Character> stack = new Stack<>();
        for (char c : exp.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            if (c == ')') {
                char element = stack.pop();
                if (element != '(')
                    return false;
            }
            if (c == '}') {
                char element = stack.pop();
                if (element != '{')
                    return false;
            }
            if (c == ']') {
                char element = stack.pop();
                if (element != '[')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
