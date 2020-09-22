package stack;

import java.util.Stack;

public class StackUse {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(12);
        stack.push(14);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.size());
        for (int i = 0; i < 100; i++) {
            stack.push(i);
        }
        System.out.println(stack.size());
        while (!stack.isEmpty())
            System.out.println(stack.pop());
    }
}
