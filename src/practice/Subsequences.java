package practice;

import java.util.Arrays;

public class Subsequences {

    public static void main(String[] args) {
        int s = 23;
        keypad(s);
    }

    // Return a string array that contains all the possible strings
    public static void keypad(int n) {
        getSubsequences(n, "");
    }

    private static void getSubsequences(int s, String output) {
        if (s == 0) {
            System.out.println(output);
            return;
        }

        int ld = s % 10;
        if (ld == 2) {
            getSubsequences(s / 10, "a" + output);
            getSubsequences(s / 10, "b" + output);
            getSubsequences(s / 10, "c" + output);
        }
        if (ld == 3) {
            getSubsequences(s / 10, "d" + output);
            getSubsequences(s / 10, "e" + output);
            getSubsequences(s / 10, "f" + output);
        }
        if (ld == 4) {
            getSubsequences(s / 10, "g" + output);
            getSubsequences(s / 10, "h" + output);
            getSubsequences(s / 10, "i" + output);
        }
        if (ld == 5) {
            getSubsequences(s / 10, "j" + output);
            getSubsequences(s / 10, "k" + output);
            getSubsequences(s / 10, "l" + output);
        }
        if (ld == 6) {
            getSubsequences(s / 10, "m" + output);
            getSubsequences(s / 10, "n" + output);
            getSubsequences(s / 10, "o" + output);
        }
        if (ld == 7) {
            getSubsequences(s / 10, "p" + output);
            getSubsequences(s / 10, "q" + output);
            getSubsequences(s / 10, "r" + output);
            getSubsequences(s / 10, "s" + output);
        }
        if (ld == 8) {
            getSubsequences(s / 10, "t" + output);
            getSubsequences(s / 10, "u" + output);
            getSubsequences(s / 10, "v" + output);
        }
        if (ld == 9) {
            getSubsequences(s / 10, "w" + output);
            getSubsequences(s / 10, "x" + output);
            getSubsequences(s / 10, "y" + output);
            getSubsequences(s / 10, "z" + output);
        }
    }

}
