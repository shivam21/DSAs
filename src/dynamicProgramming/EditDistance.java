package dynamicProgramming;

import java.util.Scanner;

public class EditDistance {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner s = new Scanner(System.in);

        String str1 = s.next();
        String str2 = s.next();
        System.out.println(editDistanceRecursive(str1, str2));
    }


    public static int editDistanceRecursive(String s1, String s2) {
        if (s1.isEmpty() || s2.isEmpty())
            return Math.max(s1.length(), s2.length());

        if (s1.charAt(0) == s2.charAt(0))
            return editDistanceRecursive(s1.substring(1), s2.substring(1));
        //INSERT
        int opt1 = editDistanceRecursive(s1, s2.substring(1));
        //DELETE
        int opt2 = editDistanceRecursive(s1.substring(1), s2);
        //REPLACE
        int opt3 = editDistanceRecursive(s1.substring(1), s2.substring(1));
        return 1 + Math.min(opt1, Math.min(opt2, opt3));
    }

    public static int editDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] arr = new int[m + 1][n + 1];
        for (int i = 0; i < s1.length(); i++) {
            arr[i][0] = i;
        }
        for (int i = 0; i < s2.length(); i++) {
            arr[0][i] = i;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                if (s1.charAt(m - i) == s2.charAt(n - j)) {
                    arr[i][j] = arr[i - 1][j - 1];
                } else {
                    arr[i][j] = 1 + Math.min(arr[i - 1][j], Math.min(arr[i - 1][j - 1], arr[i][j - 1]));
                }
            }
        }
        return arr[m][n];

    }
}
