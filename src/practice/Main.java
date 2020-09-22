package practice;

import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        // Write your code here
        Scanner s = new Scanner(System.in);
       
        int n = s.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            long numPeople = s.nextLong();
            int extraRounds = 0;
            if ((numPeople % n) > i)
                extraRounds = 1;
            long numRounds = (numPeople / n) + extraRounds;
            arr[i] = numRounds;
        }
        int minIndex = 0;
        long minValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
                minIndex = i;
            }
        }
        System.out.println((minIndex + 1));

    }


}
