package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Prac2 {

    public static void main(String[] args) throws IOException {
        // Write your code here
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        String[] line = s.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        long k = Long.parseLong(line[1]);
        long[] arr = new long[n];
        String[] tempArr = s.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(tempArr[i]);
        }
        Arrays.sort(arr);
        long numVariation = 0;
        for (int i = 0; i < arr.length-1; i++) {
            int index = Arrays.binarySearch(arr, i + 1, arr.length , arr[i] + k);
            if (index < 0) {
                numVariation += arr.length + index + 1;
            } else {
                numVariation += arr.length - index;
            }
        }
        System.out.println(numVariation);

    }


}
