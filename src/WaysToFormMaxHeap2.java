import java.util.Arrays;
import java.util.List;

public class WaysToFormMaxHeap2 {
    /*
    Max heap is a special kind of complete binary tree in which, for every node, the value present in that node is greater than the value present in its children nodes.

Given an array A of size N consisting of N - 1 distinct elements. In other words, there is exactly one element that is repeated.
It is given that the element that would repeat would be either the maximum element or the minimum element.

Find the number of structurally different Max heaps possible using all the N elements of the array i.e., Max heap of size N.

As the final answer can be very large return your answer modulo 109 + 7.
     */

    public static void main(String[] args) {
        Arrays.fill(dp, -1);
        Arrays.fill(log, -1);
        for(long[] row:nCk)
            Arrays.fill(row,-1);

        int ans = solve(Arrays.asList(15, 15, 35, 48, 66));
        System.out.println(ans);

        Arrays.fill(dp, -1);
        Arrays.fill(log, -1);
        for(long[] row:nCk)
            Arrays.fill(row,-1);

        ans = solve(Arrays.asList(20, 20, 39, 58, 64));
        System.out.println(ans);

        Arrays.fill(dp, -1);
        Arrays.fill(log, -1);
        for(long[] row:nCk)
            Arrays.fill(row,-1);

        ans = solve(Arrays.asList(1,5,5));
        System.out.println(ans);

        Arrays.fill(dp, -1);
        Arrays.fill(log, -1);
        for(long[] row:nCk)
            Arrays.fill(row,-1);
        ans = solve(Arrays.asList(2,2,7));
        System.out.println(ans);



    }

    static int solve(List<Integer> list){
        int n = list.size();
        if(n==0) return 0;
        if(n==1 || n ==2) return 1;

        int[] x = new int[MAX];
        for(int i:list){
            x[i]++;
        }

        boolean maxRepeating = false;
        for(int i=x.length-1; i>=0; i--){
            if(x[i] != 0){
                if(x[i]>1) {
                    maxRepeating = true;
                }
                break;
            }
        }

        if(maxRepeating){
            return (int)((numberOfWays(list.size())+MOD)%MOD);
        }

        return (int)((numberOfWays2(list.size())+MOD)%MOD);

    }

    static long numberOfWays2(int n){
        if(n==0) return 0;
        if(n==1 || n==2) return 1;
        if(dp[n] != -1) return dp[n];
        int height = log2(n);
        int nodes = (1<<height)-1;

        int left = ((nodes-1)/2) + Math.min(n-nodes, (nodes+1)/2);
        int right = n-left-1;
        //If repeated min are in left subtree
        long ans = (compute(n-3, left-2)%MOD * numberOfWays2(left)%MOD * numberOfWays(right)%MOD)%MOD;
        //If repeated min are in right subtree
        ans = (ans%MOD) + (compute(n-3, right-2)%MOD * numberOfWays(left)%MOD * numberOfWays2(right)%MOD)%MOD;
        //If 1 is in left & other is in right subtree
        ans = (ans%MOD) + (compute(n-3, left-1)%MOD * numberOfWays(left)%MOD * numberOfWays(right)%MOD)%MOD;

        dp[n] = ans%MOD;

        return dp[n];

    }

    static final int MOD = 1000000007;
    static final int MAX = 1005;
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
        if (k<0 || k > n) {
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
