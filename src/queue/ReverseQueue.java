package queue;

import java.util.Queue;

//1 2 3 4 5
public class ReverseQueue {
    public static void reverseQueue(Queue<Integer> q) {
        if (q.isEmpty())
            return;
        int first = q.poll();
        reverseQueue(q);
        q.add(first);
    }
}
