package hashmap;

import java.util.LinkedHashMap;

/*
You are given an array of integers that contain numbers in random order. Write a program to find and return the number which occurs the maximum times in the given input.
        If two or more elements contend for the maximum frequency, return the element which occurs in the array first.
*/

public class MaxFrequency {

    public static int maxFrequencyNumber(int[] arr) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        Integer maxElement = null;
        int maxFrequency = 0;
        for (int key : map.keySet()) {
            if (map.get(key) > maxFrequency) {
                maxFrequency = map.get(key);
                maxElement = key;
            }
        }
        return maxElement;
    }

}
