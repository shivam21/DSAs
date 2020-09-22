package stack;

import java.util.Stack;

public class MinBracRev {
    //{{{{}}
    public static int countBracketReversals(String input) {
        if (input.length() % 2 != 0)
            return -1;
        Stack<Character> s = new Stack<>();
        int count = 0;
        for (char c : input.toCharArray()) {
            if (c == '{') {
                s.push('{');
            } else {
                if (s.isEmpty()) {
                    s.push('{');
                    count++;
                } else {
                    s.pop();
                }
            }
        }
        return count + s.size() / 2;
    }
}
