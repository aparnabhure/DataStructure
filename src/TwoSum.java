import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem:: Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */

public class TwoSum {
    public static void main(String[] args){
        int[] items = new int[] {2,7,11,15};
        int target = 9;
        int[] result = bruteForceMethod(items, target);
        if(result == null){
            System.out.println("Set not found");
        }else{
            System.out.println(" {" +result[0] + ", "+ result[1]+"}");
        }

        result = hashMethod(items, target);
        if(result == null){
            System.out.println("Set not found");
        }else{
            System.out.println(" {" +result[0] + ", "+ result[1]+"}");
        }

        result = usingSorting(items, target);
        if(result == null){
            System.out.println("Set not found");
        }else{
            System.out.println(" {" +result[0] + ", "+ result[1]+"}");
        }
    }

    /**
     * O(n^2)
     * @param nums
     * @param target
     * @return
     */
    private static int[] bruteForceMethod(int[] nums, int target){
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                int x = target - nums[i];
                if(x == nums[j]){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * O(n) space O(1)
     * @param nums
     * @param target
     * @return
     */
    private static int[] hashMethod(int[] nums, int target){
        Map<Integer, Integer> numKeys = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int x = target - nums[i];
            if(numKeys.containsKey(x)){
                return new int[]{numKeys.get(x), i};
            }
            numKeys.put(nums[i], i);
        }
        return null;
    }

    /**
     * O(nLog(n) which is better than O(n2)
     * @param num
     * @param target
     * @return
     */
    private static int[] usingSorting(int[] num, int target){
        //If using quick sort then time complexity would be log(n)
        Arrays.sort(num);
        for(int left=0,right = num.length-1; left<right;){
            int sum = num[left] + num[right];
            if(sum == target){
                return new int[]{left, right};
            }else if(sum < target){
                left++;
            }else{
                right--;
            }
        }

        return null;
    }
}
