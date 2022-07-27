//https://leetcode.com/contest/leetcode-weekly-contest-4/problems/rotate-function/
public class RotateFunction {
    public static void main(String[] args) {
        System.out.println(maxRotateFunction(new int[]{4,3,2,6}));
        System.out.println(maxRotateFunction(new int[]{10,5,6,8,2,3,6,7,9,12}));
    }

    static int maxRotateFunction(int[] nums) {
        int n = nums.length;
        if(n<=1) return 0;

        int totalSum = 0;
        int firstRoundSum = 0;
        for(int i=0; i<n; i++){
            totalSum += nums[i];
            firstRoundSum += i*nums[i];
        }

        int ans = firstRoundSum;
        for(int i=1; i<n; i++){
            firstRoundSum = firstRoundSum+(n*nums[i-1])-totalSum;
            ans = Math.max(ans, firstRoundSum);
        }

        return ans;
    }
}
