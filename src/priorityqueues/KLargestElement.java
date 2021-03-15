package priorityqueues;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*You are given with an integer k and an array of integers that contain numbers in random order. Write a program to find k largest numbers from given array. You need to save them in an array and return it.
        Time complexity should be O(nlogk) and space complexity should be not more than O(k).*/

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
