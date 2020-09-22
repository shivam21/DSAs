package stack;

import java.util.Stack;

public class ReverseStack {

    public static void reverseStack(Stack<Integer> s1, Stack<Integer> s2) {
        if (s1.isEmpty())
            return;
        int first = s1.pop();
        while (!s1.isEmpty())
            s2.push(s1.pop());
        reverseStack(s2, s1);
        s1.push(first);
        while (!s2.isEmpty())
            s1.push(s2.pop());

    }
}
