package stack;

import java.util.Stack;

public class RedundantBrac {

    public static boolean checkRedundantBrackets(String input) {
        Stack<Character> s = new Stack<>();
        for (char c : input.toCharArray()) {
            if (c != ')') {
                s.add(c);
            } else {
                int count = 0;
                while (s.pop() != '(')
                    count++;
                if (count == 0)
                    return true;
            }
        }
        return false;
    }
}
