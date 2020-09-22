package queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueUse {
    public static void main(String[] args) {
        Queue<Integer> queueArray = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            queueArray.add(i);
        }
        while (!queueArray.isEmpty()) {
            queueArray.poll();
        }
        for (int i = 0; i < 100; i++) {
            queueArray.add(i);
        }
        while (!queueArray.isEmpty()) {
            System.out.println(queueArray.poll());
        }
        for (int i = 0; i < 100; i++) {
            queueArray.add(i);
        }
    }
}
