public class MaxSubSetSumNoAdjacent {
    public static void main(String[] args) {
        int[] nums = new int[]{7,10,12,7,9,14};
        //Ans : 7+12+14 = 33, as we cannot count adjacent indexes
        System.out.println(maxSum(nums));
        System.out.println(niceWayMaxSum(nums));

    }

    //Formula would be maxSum[i] = Max(maxSum[i-1], maxSum[i-2]+nums[i])
    // this will have O(N) | Space O(N)
    private static int maxSum(int[] nums){
        int sum = 0;
        if(nums.length <= 0){
            return sum;
        }
        if(nums.length == 1){
            return nums[0];
        }

        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        int[] maxSumArray = new int[nums.length];
        maxSumArray[0] = nums[0];
        maxSumArray[1] = Math.max(nums[0], nums[1]);

        for (int i=2; i<nums.length; i++){
            maxSumArray[i] = Math.max(maxSumArray[i-1], maxSumArray[i-2]+nums[i]);
        }

        return maxSumArray[maxSumArray.length-1];
    }

    //O(n) | space O(1)
    private static int niceWayMaxSum(int[] nums){
        if(nums.length <= 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }

        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        int second = nums[0];
        int first = Math.max(nums[0], nums[1]);

        for(int i=2; i<nums.length; i++){
           int current = Math.max(first, second+nums[i]);
           second = first;
           first = current;

        }
        return first;
    }

}
