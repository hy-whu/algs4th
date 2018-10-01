package three_sum_in_quadratic_time;

import edu.princeton.cs.algs4.StdOut;

public class three_sum {
    public static int threeSumProblem(int[] a) {
        int cnt = 0;
        for (int i = 0; i < a.length - 2; i++) {
            int j = i + 1;
            int k = a.length - 1;
            while (j < k) {
                int sum = a[i] + a[j] + a[k];
                if (sum == 0) {
                    cnt++;
                }
                if (sum >= 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        int[] a = {-40, -30, -20, -10, 0, 5, 10, 40};
        int cnt = threeSumProblem(a);
        System.out.println(cnt);
    }
}
