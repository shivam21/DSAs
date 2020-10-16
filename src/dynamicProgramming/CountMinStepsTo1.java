package dynamicProgramming;

public class CountMinStepsTo1 {

    public static int countMinStepsToOne2(int n) {
        if (n == 1)
            return 0;
        if (n == 2 || n == 3)
            return 1;
        int count2 = Integer.MAX_VALUE;
        int count3 = Integer.MAX_VALUE;
        int count1 = 1 + countMinStepsToOne2(n - 1);
        if (n % 2 == 0)
            count2 = 1 + countMinStepsToOne2(n / 2);
        if (n % 3 == 0)
            count3 = 1 + countMinStepsToOne2(n / 3);
        return Math.min(count1, Math.min(count2, count3));
    }

    public static int countMinStepsToOne(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 0;
        arr[2] = 1;
        arr[3] = 1;
        for (int i = 4; i < arr.length; i++) {
            int count2 = Integer.MAX_VALUE;
            int count3 = Integer.MAX_VALUE;
            int count1 = 1 + arr[i - 1];
            if (n % 2 == 0)
                count2 = 1 + arr[n / 2];
            if (n % 3 == 0)
                count3 = 1 + arr[n / 3];
            arr[i] = Math.min(count1, Math.min(count2, count3));
        }
        return arr[n];
    }
}
