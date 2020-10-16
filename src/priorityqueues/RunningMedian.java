package priorityqueues;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RunningMedian {

    public static void findMedian(int arr[]) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < arr.length; j++) {
            int i = arr[j];
            if (maxHeap.isEmpty() || i < maxHeap.peek()) {
                maxHeap.add(i);
            } else {
                minHeap.add(i);
            }
            while (Math.abs(maxHeap.size() - minHeap.size()) > 1) {
                if (maxHeap.size() > minHeap.size()) {
                    minHeap.add(maxHeap.poll());
                } else {
                    maxHeap.add(minHeap.poll());
                }
            }
            if (j % 2 == 0) {
                if (maxHeap.size() > minHeap.size())
                    stringBuilder.append(maxHeap.peek()).append("\n");
                else
                    stringBuilder.append(minHeap.peek()).append("\n");
            } else {
                int sum = 0;
                if (maxHeap.peek() != null)
                    sum = maxHeap.peek();
                if (minHeap.peek() != null)
                    sum += minHeap.peek();
                stringBuilder.append(sum / 2).append("\n");
            }
        }
        System.out.println(stringBuilder.toString().trim());
    }
}
