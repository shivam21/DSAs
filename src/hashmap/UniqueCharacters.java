package hashmap;

import java.util.HashMap;

/*
Given a string, you need to remove all the duplicates. That means, the output string should contain each character only once. The respective order of characters should remain same.
*/

public class UniqueCharacters {

    public static String uniqueChar(String str) {
        HashMap<Character, Boolean> map = new HashMap<>();
        StringBuilder s = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (!map.containsKey(c)) {
                s.append(c);
                map.put(c, true);
            }
        }
        return s.toString();
    }

}
