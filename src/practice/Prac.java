package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Prac {

    public static void main(String[] args) throws IOException {
        int[] arr = {5, 2, 3, 8, 6, 7, 1};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start >= end)
            return;
        int partition = (start + end) / 2;
        mergeSort(arr, start, partition);
        mergeSort(arr, partition + 1, end);
        mergeArr(arr, start, end, partition + 1);
    }

    private static void mergeArr(int[] arr, int start, int end, int partition) {
        int i = start;
        int j = partition;
        int[] tempArr = new int[end - start + 1];
        int k = 0;
        while (k < tempArr.length) {
            if (i < partition && (j >= (end+1) || arr[i] < arr[j])) {
                tempArr[k] = arr[i];
                i++;
            } else {
                tempArr[k] = arr[j];
                j++;
            }
            k++;
        }
        k = start;
        for (int value : tempArr) {
            arr[k] = value;
            k++;
        }
    }

    public static String removeConsecutiveDuplicates(String s) {
        // Write your code here

        if (s.isEmpty()) {
            return "";
        }

        if (s.charAt(0) == s.charAt(1)) {
            return removeConsecutiveDuplicates(s.substring(1));
        } else {
            return s.charAt(0) + removeConsecutiveDuplicates(s.substring(1));
        }
    }


}
