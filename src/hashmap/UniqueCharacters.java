package hashmap;

import java.util.HashMap;

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
