package priorityqueues;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BuyTicket {

    public static int buyTicket(int input[], int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> queue = new LinkedList<>();
        for (int element : input)
            maxHeap.add(element);
        for (int i = 0; i < input.length; i++) queue.add(i);
        int time = 0;
        while (true) {
            if (input[queue.peek()]==(maxHeap.peek())) {
                time++;
                if (queue.poll() == k) {
                    break;
                }
                maxHeap.poll();
            } else {
                queue.add(queue.poll());
            }
        }
        return time;
    }

}
