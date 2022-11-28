/*
As it is Tushar's Birthday on March 1st, he decided to throw a party to all his friends at TGI Fridays in Pune. Given are the eating capacity of each friend, filling capacity of each dish and cost of each dish. A friend is satisfied if the sum of the filling capacity of dishes he ate is equal to his capacity. Find the minimum cost such that all of Tushar's friends are satisfied (reached their eating capacity).

NOTE:

Each dish is supposed to be eaten by only one person. Sharing is not allowed.

Each friend can take any dish unlimited number of times.

There always exists a dish with filling capacity 1 so that a solution always exists.



Problem Constraints

|A| <= 1000

|B| <= 1000

|C| <= 1000



Input Format

First Argument is vector A, denoting eating capacities

Second Argument is vector B, denoting filling capacities

Third Argument is vector C, denoting cost
 */
public class Party {
    public static void main(String[] args) {

        System.out.println(solve(new int[]{2,4,6}, new int[]{2,1,3}, new int[]{2,5,3}));

    }

    static int solve(final int[] A, final int[] B, final int[] C) {
        int totalCost = 0;
        for(int i: C){
            totalCost+=i;
        }

        int maxCapacity=0;
        for(int i:A){
            maxCapacity = Math.max(i, maxCapacity);
        }

        int[][] dp = new int[maxCapacity+1][B.length];

        int minCost = 0;
        for(int i:A){
            minCost += minCost(i, 0, i*totalCost, B, C, dp);
        }

        return minCost;

    }

    static int minCost(int capacity, int i, int maxCapacity, int[] B, int[] C, int[][] dp){
        if(capacity == 0) return 0;
        if(i==B.length) return Integer.MAX_VALUE;
        if(dp[capacity][i] != 0) return dp[capacity][i];
        int ans = maxCapacity;
        if(capacity>=B[i]){
            ans = C[i]+minCost(capacity-B[i], i, maxCapacity, B, C, dp);
        }

        ans = Math.min(ans, minCost(capacity, i+1, maxCapacity, B, C, dp));
        dp[capacity][i] = ans;
        return ans;
    }
}
