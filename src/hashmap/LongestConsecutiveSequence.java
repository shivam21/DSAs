package hashmap;

import java.util.ArrayList;
import java.util.HashMap;

/*You are given an array of unique integers that contain numbers in random order. Write a program to find the longest possible sequence of consecutive numbers using the numbers from given array.
        You need to return the output array which contains consecutive elements. Order of elements in the output is not important.
        Best solution takes O(n) time.
        If two sequences are of equal length then return the sequence starting with the number whose occurrence is earlier in the array.*/

public class LongestConsecutiveSequence {
    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        ArrayList<Integer> maxList = new ArrayList<>();
        for (int i : arr)
            map.put(i, true);
        for (int i : arr) {
            if (!map.containsKey(i - 1)&&!map.get(i-1)) {
                ArrayList<Integer> newList = getMax(i, map);
                if (maxList.size() < newList.size()) {
                    maxList = newList;
                }
            }
        }
        return maxList;
    }

    private static ArrayList<Integer> getMax(int i, HashMap<Integer, Boolean> map) {
        int current = i;
        ArrayList<Integer> list = new ArrayList<>();
        while (map.containsKey(current) && map.get(current)) {
            list.add(current);
            map.put(current, false);
            current--;
        }
        current = i + 1;
        while (map.containsKey(current) && map.get(current)) {
            list.add(current);
            map.put(current, false);
            current++;
        }
        return list;
    }

}
