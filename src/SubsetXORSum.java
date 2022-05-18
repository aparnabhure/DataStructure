//https://leetcode.com/problems/sum-of-all-subset-xor-totals/
public class SubsetXORSum {
    public static void main(String[] args) {
        int[] nums = new int[]{5,1,6};
        System.out.println(subsetXORSum(nums,0,0));
        nums = new int[]{3,4,5,6,7,8};
        System.out.println(subsetXORSum(nums,0,0));
        nums = new int[]{1,3};
        System.out.println(subsetXORSum(nums,0,0));

    }
    static int subsetXORSum(int[] nums, int current, int xor) {
        if(current == nums.length){
            return xor;
        }

        int x = subsetXORSum(nums, current+1, nums[current]^xor);
        int y =subsetXORSum(nums, current+1, xor);
        return x+y;

    }
}
