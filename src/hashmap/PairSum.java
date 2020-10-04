package hashmap;

import java.util.HashMap;

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
