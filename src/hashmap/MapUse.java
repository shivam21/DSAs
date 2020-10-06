package hashmap;

public class MapUse {
    public static void main(String[] args) {
        MyMap<String, Integer> map = new MyMap<>();
        for (int i = 0; i < 20; i++) {
            map.insert("abc" + i, i + 1);
            System.out.println("i:" + i + " loadFactor:" + map.loadFactor());
        }

        map.remove("abc4");
        map.remove("abc7");
        for (int i = 0; i < 20; i++) {
            System.out.println(map.get("abc" + i));
        }
    }
}
