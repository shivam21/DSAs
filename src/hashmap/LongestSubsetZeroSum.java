package hashmap;

import java.util.ArrayList;
import java.util.HashMap;

public class LongestSubsetZeroSum {

    public static int lengthOfLongestSubsetWithZeroSum(ArrayList<Integer> arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            }
            map.put(sum, i);
        }

        return maxLength;
    }

}
