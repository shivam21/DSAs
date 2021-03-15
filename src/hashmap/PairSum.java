package hashmap;

import java.util.HashMap;

/*
Given a random integer array A of size N. Find and print the pair of elements in the array which sum to 0.
        Array A can contain duplicate elements.
        While printing a pair, print the smaller element first.
        That is, if a valid pair is (6, -6) print "-6 6". There is no constraint that out of 5 pairs which have to be printed in 1st line. You can print pairs in any order, just be careful about the order of elements in a pair.
*/

public class PairSum {

    public static void PairSum(int[] input, int size) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : input) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        for (int i : input) {
            if (map.containsKey(-i) && map.get(-i) > 0) {
                map.put(i, map.get(i) - 1);
                map.put(-i, map.get(-i) - 1);
                System.out.println(Math.min(i, -i) + " " + Math.max(i, -i));
            }
        }
    }
}
