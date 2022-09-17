//https://leetcode.com/problems/minimum-money-required-before-transactions/discuss/2588034/JavaC%2B%2BPython-Easy-and-Coincise
public class MinimumMoneyRequired {
    public static void main(String[] args) {
        System.out.println(minimumMoney(new int[][]{{2,1},{5,0},{4,2}}));
    }

    static long minimumMoney(int[][] A) {
        long res = 0; int v = 0;
        for (int[] a : A) {
            v = Math.max(v, Math.min(a[0], a[1]));
            res += Math.max(a[0] - a[1], 0);
        }
        return res + v;
    }
}
