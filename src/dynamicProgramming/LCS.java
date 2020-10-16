package dynamicProgramming;

public class LCS {

    public static void main(String[] args) {
        System.out.println(findLcs("adegaagagagsdshsdhaasassasasa", "deafagaggagagagsaassuhsasasasassa"));
        System.out.println(findLcsRecursively("adegaagagagsdshsdhaasassasasa", "deafagaggagagagsaassuhsasasasassa"));
    }

    private static int findLcsRecursively(String s, String t) {
        if (s.isEmpty() || t.isEmpty())
            return 0;
        if (s.charAt(0) == t.charAt(0))
            return 1 + findLcsRecursively(s.substring(1), t.substring(1));
        int opt1 = findLcsRecursively(s.substring(1), t);
        int opt2 = findLcsRecursively(s, t.substring(1));
        return Math.max(opt1, opt2);
    }

    private static int findLcs(String s, String t) {
        int[][] arr = new int[s.length() + 1][t.length() + 1];
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (s.charAt(s.length() - i) == t.charAt(t.length() - j))
                    arr[i][j] = 1 + arr[i - 1][j - 1];
                else
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
            }
        }
        return arr[s.length()][t.length()];
    }
}
