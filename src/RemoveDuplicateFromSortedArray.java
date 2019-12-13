import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 *
 * Given nums = [1,1,2],
 *
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 *
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 *
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 *
 * It doesn't matter what values are set beyond the returned length.
 */
public class RemoveDuplicateFromSortedArray {
    public static void main(String[] args){
        int[] nums = new int[]{0,0,1,1,1,1,2,2,3,3,3,4};
        System.out.println(removeDuplicatesNoUpdateInArray(nums));
        System.out.println(removeDuplicates(nums));
    }

    private static int removeDuplicatesNoUpdateInArray(int[] nums) {
        if(nums == null){
            return 0;
        }

        if(nums.length <= 1){
            return nums.length;
        }

        Set<Integer> newNums = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            newNums.add(nums[i]);
        }

        return newNums.size();
    }

    private static int removeDuplicates(int[] nums) {
        if(nums == null){
            return 0;
        }

        if(nums.length <= 1){
            return nums.length;
        }

        int i=0, j=1;
        for(; j<nums.length; j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }

        return i;
    }
}
