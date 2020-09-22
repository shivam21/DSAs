package practice;

import java.util.*;

public class A {

    A() {

    }

    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{1, 1, 1}));
    }

    public static boolean splitArray(int input[]) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int val : input) {
            if (map.containsKey(val)) {
                map.put(val, map.get(val) + 1);
            } else {
                map.put(val, 1);
            }
        }
        int sum1 = 0;
        int sum2 = 0;
        int restSum = 0;
        int count = 0;
        for (int val : input) {
            if (val % 5 == 0) {
                sum1 += val;
                map.put(val, map.get(val) - 1);
            } else {
                if (val % 3 == 0) {
                    sum2 += val;
                    map.put(val, map.get(val) - 1);
                } else {
                    restSum += val;
                    count++;
                }
            }
        }
        restSum -= Math.abs(sum2 - sum1);
        if (restSum % 2 == 0)
            restSum = restSum / 2;
        else
            return false;
        int[] newInput = new int[count];
        int l = 0;
        for (int val : input) {
            if (map.get(val) > 0) {
                newInput[l++] = val;
            }
        }
        return findSubsets(newInput, restSum, 0, 0);

    }

    private static boolean findSubsets(int input[], int k, int start, int sum) {
        if (start == input.length) {
            return sum == k;
        }
        if (sum == k)
            return true;
        findSubsets(input, k, start + 1, sum);
        findSubsets(input, k, start + 1, sum + input[start]);
        return false;
    }


}
