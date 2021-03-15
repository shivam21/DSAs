package priorityqueues;

import java.util.PriorityQueue;

/*Given an array A of random integers and an integer k, find and return the kth largest element in the array.
        Try to do this question in less than O(nlogn) time.*/

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
