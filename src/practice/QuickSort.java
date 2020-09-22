package practice;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr ={5, 2, 3, 6, 7, 1,3};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end)
            return;
        int partition = getPartition(arr, start, end);
        quickSort(arr, start, partition - 1);
        quickSort(arr, partition + 1, end);
    }

    private static int getPartition(int[] arr, int start, int end) {
        int temp = arr[start];
        int numSmall = 0;
        for (int val = start+1; val <= end; val++) {
            if (arr[val] <= temp) {
                numSmall++;
            }
        }
        int partition = start + numSmall;
        swap(arr, start, partition);
        int i = start;
        int j = end;
        while (i < partition && j > partition) {
            while (i < partition && arr[i] <= arr[partition])
                i++;
            while (j > partition && arr[j] > arr[partition])
                j--;
            swap(arr, i, j);
        }
        return partition;
    }

    public static void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }
}
