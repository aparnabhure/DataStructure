//https://leetcode.com/contest/weekly-contest-305/problems/check-if-there-is-a-valid-partition-for-the-array/
public class ValidPartition {
    public static void main(String[] args) {
        System.out.println(validPartition(new int[]{1,1,1,2}));
        System.out.println(validPartition(new int[]{4,4,4,5,6}));
    }

    static boolean validPartition(int[] nums) {
        boolean[] dp = new boolean[nums.length+1];
        dp[0]=true;
        for (int i = 2; i <= nums.length; i++){
            dp[i]|=nums[i-1]==nums[i-2] && dp[i-2]; // cond 1
            dp[i]|= i>2 && nums[i-1] == nums[i-2] && nums[i-2] == nums[i-3] && dp[i-3]; // cond 2
            dp[i]|= i>2 && nums[i-1]-nums[i-2]==1 && nums[i-2]-nums[i-3]==1 && dp[i-3]; // cond 3
        }
        return dp[nums.length];

    }
}
