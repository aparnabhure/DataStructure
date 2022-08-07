import java.util.Arrays;

public class LongestIdealSubString {
    public static void main(String[] args) {
        System.out.println(longestIdealString("acfgbd",2));
    }

    static int longestIdealString(String s, int k) {
        int[] dp = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            int a = s.charAt(i) - 'a', mx = 0;
            for (int b = Math.max(0, a - k); b <= Math.min(25, a + k); ++b)
                mx = Math.max(mx, dp[b]);
            dp[a] = 1 + mx;
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
