package hashmap;

import java.util.Arrays;
import java.util.HashMap;

/*
You have been given two integer arrays/list(ARR1 and ARR2) of size N and M, respectively. You need to print their intersection; An intersection for this problem can be defined when both the arrays/lists contain a particular value or to put it in other words, when there is a common value that exists in both the arrays/lists.
*/

public class PrintIntersection {

    public static void intersection(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : arr1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        for (int i : arr2) {
            if (map.containsKey(i) && map.get(i) > 0) {
                System.out.println(i);
                map.put(i, map.get(i) - 1);
            }
        }
    }
}
