import java.util.Arrays;

public class WaysToFormMaxHeap {
    public static void main(String[] args) {
        Arrays.fill(dp, -1);
        Arrays.fill(log, -1);
        for(long[] row:nCk)
            Arrays.fill(row,-1);

        long ans = numberOfWays(1);
        System.out.println((ans+MOD)%MOD);

        Arrays.fill(dp, -1);
        Arrays.fill(log, -1);
        for(long[] row:nCk)
            Arrays.fill(row,-1);
        ans = numberOfWays(20);
        System.out.println((ans+MOD)%MOD);



    }

    static final int MOD = 1000000007;
    static final int MAX = 100;
    static long[] dp = new long[MAX];
    static int[] log = new int[MAX];
    static long[][] nCk = new long[MAX][MAX];

    static long numberOfWays(int n){
        if(n==0) return 0;
        if(n==1 || n==2) return 1;
        if(dp[n] != -1) return dp[n];

        int height = log2(n);
        int nodes = (1<<height)-1;

        int left = ((nodes-1)/2) + Math.min(n-nodes, (nodes+1)/2);
        int right = n-left-1;
        dp[n] = (compute(n-1, left)%MOD * numberOfWays(left)%MOD * numberOfWays(right)%MOD)%MOD;
        return dp[n];
    }

    static long compute(int n, int k) {
        if (k > n) {
            return 0;
        }
        if (n <= 1 || k == 0) {
            return 1;
        }

        if (nCk[n][k] != -1) {
            return nCk[n][k];
        }

        long answer = (compute(n - 1, k - 1) + compute(n - 1, k))%MOD;
        nCk[n][k] = answer;
        return answer;
    }

    static int log2(int n)
    {
        if(log[n] != -1){
            return log[n];
        }
        // calculate log2 N indirectly
        // using log() method
        return  (int)(Math.log(n) / Math.log(2));
    }
}
