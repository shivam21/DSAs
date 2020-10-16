package priorityqueues;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static int kthLargest(int arr[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            pq.add(arr[i]);
            pq.poll();
        }
        return pq.poll();
    }
}
