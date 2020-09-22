package codechef;


import java.util.*;

public class Codechef {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++)
                arr[i] = s.nextLong();
            HashSet<Long> set = new HashSet<>();
            for (long val : arr)
                set.add(val);
            System.out.println(set.size());


        }
    }


}
