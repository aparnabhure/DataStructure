import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class WaysToFormMaxHeap2 {
    /*
    Max heap is a special kind of complete binary tree in which, for every node, the value present in that node is greater than the value present in its children nodes.

Given an array A of size N consisting of N - 1 distinct elements. In other words, there is exactly one element that is repeated.
It is given that the element that would repeat would be either the maximum element or the minimum element.

Find the number of structurally different Max heaps possible using all the N elements of the array i.e., Max heap of size N.

As the final answer can be very large return your answer modulo 109 + 7.
     */

    static final int MOD = 1000000007;
    static final int MAX = 1005;
    static long[] dp = new long[MAX];
    static long[] dp2 = new long[MAX];
    static int[] log = new int[MAX];
    static long[][] nCk = new long[MAX][MAX];

    public static void main(String[] args) {
        for(int i=4; i<=20; i++){
            int[] list = new int[i];
            list[0]=1;
            list[1]=1;
            for(int j=2; j<=(i-1); j++){
                list[j]=j;
            }
            Solution solution = new Solution();
            int ans = solution.solve(list);
            System.out.println("TestCase "+list.length+" : ans : " +ans);
        }

        //All working
        for(int i=4; i<=20; i++){
            Arrays.fill(dp, -1);
            Arrays.fill(dp2, -1);
            Arrays.fill(log, -1);
            for(long[] row:nCk)
                Arrays.fill(row,-1);
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(1);
            for(int j=2; j<=(i-1); j++){
                list.add(j);
            }
            int ans = solve(list);
            System.out.println("TestCase "+list.size()+" : ans : " +ans);
        }

//        Arrays.fill(dp, -1);
//        Arrays.fill(dp2, -1);
//        Arrays.fill(log, -1);
//        for(long[] row:nCk)
//            Arrays.fill(row,-1);
//
//        //expected : 509585165 (FAILED)
//        int ans = solve(Arrays.asList(1,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28));
//        System.out.println(ans);

        /********* PASSED Cases **********/

//        Arrays.fill(dp, -1);
//        Arrays.fill(dp2, -1);
//        Arrays.fill(log, -1);
//        for(long[] row:nCk)
//            Arrays.fill(row,-1);
//
//        ans = solve(Arrays.asList(1,1,2));
//        System.out.println(ans);
//
//        Arrays.fill(dp, -1);
//        Arrays.fill(dp2, -1);
//        Arrays.fill(log, -1);
//        for(long[] row:nCk)
//            Arrays.fill(row,-1);
//
//        ans = solve(Arrays.asList(1,1,2,3));
//        System.out.println(ans);
//
//        Arrays.fill(dp, -1);
//        Arrays.fill(dp2, -1);
//        Arrays.fill(log, -1);
//        for(long[] row:nCk)
//            Arrays.fill(row,-1);
//
//        ans = solve(Arrays.asList(1,1,2,3,4));
//        System.out.println(ans);
//
//        Arrays.fill(dp, -1);
//        Arrays.fill(dp2, -1);
//        Arrays.fill(log, -1);
//        for(long[] row:nCk)
//            Arrays.fill(row,-1);
//
//        ans = solve(Arrays.asList(1,1,2,3,4,5));
//        System.out.println(ans);
//
//        Arrays.fill(dp, -1);
//        Arrays.fill(dp2, -1);
//        Arrays.fill(log, -1);
//        for(long[] row:nCk)
//            Arrays.fill(row,-1);
//
//        ans = solve(Arrays.asList(1,1,2,3,4,5,6));
//        System.out.println(ans);
//
//        Arrays.fill(dp, -1);
//        Arrays.fill(dp2, -1);
//        Arrays.fill(log, -1);
//        for(long[] row:nCk)
//            Arrays.fill(row,-1);
//
//        ans = solve(Arrays.asList(15, 15, 35, 48, 49, 66));
//        System.out.println(ans);
//
//        Arrays.fill(dp, -1);
//        Arrays.fill(dp2, -1);
//        Arrays.fill(log, -1);
//        for(long[] row:nCk)
//            Arrays.fill(row,-1);
//
//        ans = solve(Arrays.asList(20, 20, 39, 58, 64));
//        System.out.println(ans);
//
//        Arrays.fill(dp, -1);
//        Arrays.fill(dp2, -1);
//        Arrays.fill(log, -1);
//        for(long[] row:nCk)
//            Arrays.fill(row,-1);
//
//        ans = solve(Arrays.asList(5,1, 5));
//        System.out.println(ans);
//
//        Arrays.fill(dp, -1);
//        Arrays.fill(dp2, -1);
//        Arrays.fill(log, -1);
//        for(long[] row:nCk)
//            Arrays.fill(row,-1);
//        ans = solve(Arrays.asList(2,2,7));
//        System.out.println(ans);
    }

    static int solve(List<Integer> list){
        int n = list.size();
        if(n==0) return 0;
        if(n<=3) return 1;

        Collections.sort(list);
        boolean minRepeating = Objects.equals(list.get(0), list.get(1));

        if(minRepeating){
            return (int)((numberOfWays2(list.size())+MOD)%MOD);
        }

        return (int)((numberOfWays(list.size())+MOD)%MOD);

    }

    static long numberOfWays2(int n){
        if(n==0) return 0;
        if(n<=3) return 1;
        if(dp2[n] != -1) return dp2[n];
        int height = log2(n);
        int nodes = (1<<height)-1;

        int left = ((nodes-1)/2) + Math.min(n-nodes, (nodes+1)/2);
        int right = n-left-1;
        //If repeated min are in left subtree
        long ans = (compute(n-3, left-2) * (numberOfWays2(left) * numberOfWays(right))%MOD)%MOD;
        //System.out.println(n + "::left::" + ans);
        //If repeated min are in right subtree
        ans = (ans%MOD) + (compute(n-3, right-2) * (numberOfWays(left) * numberOfWays2(right))%MOD)%MOD;
        //System.out.println(n + "::right::" + ans);
        //If 1 is in left & other is in right subtree
        ans = (ans%MOD) + (compute(n-3, left-1) * (numberOfWays(left) * numberOfWays(right))%MOD)%MOD;
        //System.out.println(n + "::both::" + ans);

        dp2[n] = ans;

        return dp2[n];
        //return ans;

    }

    static long numberOfWays(int n){
        if(n==0) return 0;
        if(n==1 || n==2) return 1;
        if(dp[n] != -1) return dp[n];

        int height = log2(n);
        int nodes = (1<<height)-1;

        int left = ((nodes-1)/2) + Math.min(n-nodes, (nodes+1)/2);
        int right = n-left-1;
        dp[n] = (compute(n-1, left) * (numberOfWays(left) * numberOfWays(right))%MOD)%MOD;
        //System.out.println(n + "::normal::" + dp[n]);
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

        long answer = (compute(n - 1, k - 1)%MOD + compute(n - 1, k)%MOD)%MOD;
        nCk[n][k] = answer;
        return answer;
    }

    static int log2(int n)
    {
        if(log[n] != -1){
            return log[n];
        }
       return (int) (Math.log(n) / Math.log(2) + 1e-10);
//        // calculate log2 N indirectly
//        // using log() method
//        return  (int)(Math.log(n) / Math.log(2));
    }


    static class Solution {
        final int MOD = 1000000007;
        final int MAX = 1005;
        long[] dp = new long[MAX];
        long[] dp2 = new long[MAX];
        int[] log = new int[MAX];
        long[][] nCk = new long[MAX][MAX];

        public int solve(int[] A) {

            Arrays.fill(dp2, -1);
            Arrays.fill(dp, -1);
            Arrays.fill(log, -1);
            for(long[] row:nCk)
                Arrays.fill(row,-1);

            int n = A.length;
            if(n==0) return 0;
            if(n==1 || n ==2) return 1;

            Arrays.sort(A);
            boolean minRepeating = Objects.equals(A[0], A[1]);

            if(minRepeating){
                return (int)((numberOfWays2(n)+MOD)%MOD);
            }

            return (int)((numberOfWays(n)+MOD)%MOD);
        }

        long numberOfWays2(int n){
            if(n==0) return 0;
            if(n<=3) return 1;
            if(dp2[n] != -1) return dp2[n];
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

            dp2[n] = ans;

            return dp2[n];

        }

        long numberOfWays(int n){
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


        long compute(int n, int k) {
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

        int log2(int n)
        {
            if(log[n] != -1){
                return log[n];
            }
            return (int) (Math.log(n) / Math.log(2) + 1e-10);
        }
    }
}
