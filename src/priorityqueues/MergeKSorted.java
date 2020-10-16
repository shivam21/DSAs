package priorityqueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MergeKSorted {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();
        ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
        while (k > 0) {
            int n = s.nextInt();
            ArrayList<Integer> current = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                current.add(s.nextInt());
            }
            input.add(current);
            k--;
        }
        ArrayList<Integer> output = mergeKSortedArrays(input);
        for (int i : output) {
            System.out.print(i + " ");
        }
    }

    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> input) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] arr = new int[input.size()];
        Arrays.fill(arr, 0);
        for (int i = 0; i < input.size(); i++) {
            ArrayList<Integer> list = input.get(i);
            pq.add(list.get(arr[i]));
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            int element = pq.poll();
            int minIndex = -1;
            for (int i = 0; i < input.size(); i++) {
                if (arr[i] < input.get(i).size() && input.get(i).get(arr[i]) == element) {
                    minIndex = i;
                    break;
                }
            }
            if (minIndex == -1)
                break;
            arr[minIndex]++;
            if (arr[minIndex] < input.get(minIndex).size())
                pq.add(input.get(minIndex).get(arr[minIndex]));
            result.add(element);
        }
        if (!pq.isEmpty())
            result.add(pq.poll());
        return result;
    }
}
