package dynamicProgramming;

import java.util.Arrays;

public class MaxMoneyLooted {

    public static int maxMoneyLooted2(int[] houses) {
        int[] storage = new int[houses.length + 1];
        Arrays.fill(storage, -1);
        return maxMoneyLootedM(houses, 0, storage);
    }

    private static int maxMoneyLootedRecursive(int[] houses, int i) {
        if (i >= houses.length)
            return 0;
        int opt1 = houses[i] + maxMoneyLootedRecursive(houses, i + 2);
        int op2 = maxMoneyLootedRecursive(houses, i + 1);
        return Math.max(opt1, op2);
    }

    private static int maxMoneyLootedM(int[] houses, int i, int[] storage) {
        if (i >= houses.length)
            return 0;
        if (storage[i] != -1) {
            return storage[i];
        }
        int opt1 = houses[i] + maxMoneyLootedM(houses, i + 2, storage);
        int op2 = maxMoneyLootedM(houses, i + 1, storage);
        storage[i] = Math.max(opt1, op2);
        return storage[i];
    }

    public static int maxMoneyLooted(int[] houses) {
        int[] storage = new int[houses.length + 2];
        storage[houses.length + 1] = 0;
        storage[houses.length] = 0;
        for (int i = houses.length - 1; i >= 0; i--) {
            int opt1 = houses[i] + storage[i + 2];
            int op2 = storage[i + 1];
            storage[i] = Math.max(opt1, op2);
        }
        return storage[0];
    }


}
