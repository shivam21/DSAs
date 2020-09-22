package stack;

import java.util.Stack;

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
