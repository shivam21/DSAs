package priorityqueues;

import java.util.Scanner;

public class checkMaxHeep {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        System.out.println(checkMaxHeap(arr));
    }

    public static boolean checkMaxHeap(int arr[]) {
        return checkMaxHeapHelper(arr, 0);
    }

    private static boolean checkMaxHeapHelper(int[] arr, int rootIndex) {
        if (rootIndex >= arr.length)
            return true;
        int leftChildIndex = 2 * rootIndex + 1;
        if (leftChildIndex >= arr.length)
            return true;
        int rightChildIndex = 2 * rootIndex + 2;
        int maxIndex = rootIndex;
        if (arr[leftChildIndex] > arr[maxIndex])
            maxIndex = leftChildIndex;
        if (rightChildIndex < arr.length && arr[rightChildIndex] > arr[maxIndex])
            maxIndex = rootIndex;
        return maxIndex == rootIndex && checkMaxHeapHelper(arr, leftChildIndex) && checkMaxHeapHelper(arr, rightChildIndex);
    }
}
