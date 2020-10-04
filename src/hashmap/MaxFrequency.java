package hashmap;

import java.util.LinkedHashMap;

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
