package dynamicProgramming;

/*
Gary has two string S and V. Now Gary wants to know the length shortest subsequence in S such that it is not a subsequence in V.
*/

public class ShortestSequence {

    public int solve(String S, String V) {
        int[][] storage = new int[S.length() + 1][V.length() + 1];
        return solveHelper(S, V, storage);
    }

    private int solveHelper(String S, String V, int[][] storage) {
        if (V.isEmpty())
            return 1;
        if (S.isEmpty())
            return 1000;

        if (storage[S.length()][V.length()] != 0) {
            return storage[S.length()][V.length()];
        }
        String rest = S.substring(1);
        int opt1 = solveHelper(rest, V, storage);
        char c = S.charAt(0);
        int index = -1;
        for (int i = 0; i < V.length(); i++) {
            if (c == V.charAt(i)) {
                index = i;
                break;
            }
        }
        int result;
        if (index == -1) {
            result = 1;
        } else {
            int opt2 = 1 + solveHelper(rest, V.substring(index + 1), storage);
            result = Math.min(opt1, opt2);
        }
        storage[S.length()][V.length()] = result;
        return result;
    }
}
