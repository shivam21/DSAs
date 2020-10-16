package priorityqueues;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KLargestElement {

    public static ArrayList<Integer> kLargest(int input[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(input[i]);
        }
        for (int i = k; i < input.length; i++) {
            pq.poll();
            pq.add(input[k]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!pq.isEmpty())
            list.add(pq.poll());
        return list;
    }

}
