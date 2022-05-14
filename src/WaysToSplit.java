//https://leetcode.com/contest/biweekly-contest-78/problems/number-of-ways-to-split-array/
public class WaysToSplit {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,0};
        System.out.println(waysToSplitArray(nums));
        nums = new int[]{10,4,-8,7};
        System.out.println(waysToSplitArray(nums));
    }

    static int waysToSplitArray(int[] nums) {
        int len = nums.length;
        long startSum = nums[0];
        long endSum = 0;
        for(int i=1; i<len; i++){
            endSum += nums[i];
        }

        int valid = 0;

        for(int i=1; i<len; i++){
            if(startSum>=endSum){
                valid++;
            }
            startSum += nums[i];
            endSum -= nums[i];
        }

        return valid;

    }

//    static int waysToSplitArray(int[] nums) {
//        int len = nums.length;
//        int[] prefixSum = new int[len];
//        int[] suffixSum = new int[len];
//        prefixSum[0] = nums[0];
//        for(int i=1; i<len; i++){
//            prefixSum[i] = nums[i]+prefixSum[i-1];
//        }
//
//        suffixSum[len-1] = nums[len-1];
//        for(int i=len-2; i>=0; i--){
//            suffixSum[i] = nums[i] + suffixSum[i+1];
//        }
//
//        int valid = 0;
//
//        for(int i=0; i<len-1; i++){
//            if(prefixSum[i]>=suffixSum[i+1]){
//                valid++;
//            }
//        }
//
//        return valid;
//
//    }
}
