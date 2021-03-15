package hashmap;

import linkedlists.Solution;

import java.util.HashMap;
import java.util.Scanner;

/*You are given with an array of integers and an integer K. Write a program to find and print all pairs which have difference K.
        Take difference as absolute.*/

public class PairsDifferenceK {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int input[] = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = s.nextInt();
        }
        int k = s.nextInt();
        findPairsDifferenceK(input, k);
    }

    public static void findPairsDifferenceK(int[] input, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : input) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        for (int i : input) {
            int key1 = k + i;
            int key2 = i - k;
            if (map.containsKey(key1) && map.get(key1) > 0) {
                int times = map.get(i) * map.get(key1);
                if (i == key1) {
                    times = map.get(i) * (map.get(i) - 1) / 2;
                }
                for (int j = 0; j < times; j++)
                    System.out.println(Math.min(i, key1) + " " + Math.max(i, key1));
            }
            if (map.containsKey(key2) && map.get(key2) > 0) {
                int times = map.get(i) * map.get(key2);
                if (i == key2) {
                    times = map.get(i) * (map.get(i) - 1) / 2;
                }
                for (int j = 0; j < times; j++)
                    System.out.println(Math.min(i, key2) + " " + Math.max(i, key2));
            }
            map.put(i, 0);
            map.put(key1, 0);
            map.put(key2, 0);
        }
    }
}
