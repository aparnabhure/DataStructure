import java.util.*;

/**
 * Problem:: Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 *
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 *
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */

public class FourSum {
    public static void main(String[] args){
        //Sample 1 : [1, 0, -1, 0, -2, 2]
        //Sample 2 : [-3,-2,-1,0,0,1,2,3]
        int[] items = new int[] {-3,-2,-1,0,0,1,2,3};
        int target = 0;

        long startTime = System.currentTimeMillis();
//        List<List<Integer>> result = brouteForce(items, target);
        List<List<Integer>> result = fourSum(items, target);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken " + ((endTime - startTime)));
        if(result != null){
            System.out.println(result.size());
            for(List<Integer> item:result){
                System.out.println();
                for(Integer i: item){
                    System.out.print(i + ": ");
                }
            }
        }else {
            System.out.println("Set not found");
        }

    }

    private static List<List<Integer>> brouteForce(int[] nums, int target){
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int k=j+1; k<nums.length; k++){
                    for(int l=k+1; l<nums.length; l++){
                        int sum = nums[i]+nums[j]+nums[k]+nums[l];
                        if(sum == target) {
                            //Issue with this is it has duplicate and not optimal solution
                            result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        }
                    }
                }
            }
        }

        //this will reduce the duplicate
        LinkedHashSet<List<Integer>> hashSet = new LinkedHashSet<>(result);
        List<List<Integer>> ans = new ArrayList<>(hashSet);
        return ans;
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new ArrayList<>();

        Arrays.sort(nums);
        List<List<Integer>> ansList = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int twoSum = target - nums[i] - nums[j];
                int minSum = nums[j+1] + nums[j+2];
                int maxSum = nums[nums.length - 1] + nums[nums.length - 2];
                if (twoSum < minSum || twoSum > maxSum) continue;
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int tmpSum = nums[left] + nums[right];
                    if (tmpSum == twoSum) {
                        List<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        ansList.add(list);
                        left++;
                        right--;
                    }else if (tmpSum < twoSum) {
                        left++;
                    }else if (tmpSum > twoSum) {
                        right--;
                    }
                }
            }
        }
        //remove duplicate
        HashSet<List<Integer>> hashSet = new HashSet<>(ansList);
        ansList = new ArrayList<>(hashSet);

        return ansList;
    }
}
