package stack;

import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BalancedParenthesis {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        String expression = br.readLine().trim();
        System.out.println(isBalanced(expression));
    }

    public static boolean isBalanced(String expression) {
        if (expression.length() % 2 != 0)
            return false;
        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}
