package stack;

import java.util.Stack;

public class StockSpan {
    public static int[] stockSpan(int[] price) {
        // Write your code here
        Stack<Integer> s = new Stack<>();
        int[] result = new int[price.length];
        for (int i = 0; i < price.length; i++) {
            while (!s.isEmpty() && price[i] > price[s.peek()]) {
                s.pop();
            }
            int max = -1;
            if (!s.isEmpty())
                max = s.peek();
            result[i] = i - max;
            s.push(i);
        }
        return result;
    }
}
