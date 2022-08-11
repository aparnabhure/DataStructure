import java.util.*;

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

/*
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 < index2.
Please note that your returned answers (both index1 and index2 ) are not zero-based.
Put both these numbers in order in an array and return the array from your function ( Looking at the function signature will make things clearer ).
Note that, if no pair exists, return empty list.

If multiple solutions exist, output the one where index2 is minimum.
If there are multiple solutions with the minimum index2, choose the one with minimum index1 out of them.
 */

public class TwoSum {
    public static void main(String[] args){
        System.out.println(solve(Arrays.asList(4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666), 9259332));
        System.out.println(solve(Arrays.asList(1, 1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9),2));
        System.out.println(solve(Arrays.asList(1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 9, 10), 5));
        int[] items = new int[] {2,7,11,15};
        int target = 9;
        int[] result = bruteForceMethod(items, target);
        print(result);

        result = hashMethod(items, target);
        print(result);

        result = usingSorting(items, target);
        print(result);

        //Expected ans
        //4 8
        items = new int[] {4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8};
        target = -3;
        result = bruteForceMethod(items, target);
        print(result);

        result = hashMethod(items, target);
        print(result);
        result = usingSorting(items, target);
        print(result);

    }

    static int solve(List<Integer> A, int B) {
        int n = A.size();
        if(n<=1) return 0;

        long count = 0;

        int i = 0;
        int j = n-1;
        while(i<j){
            int num1 = A.get(i);
            int num2 = A.get(j);
            int sum = num1+num2;
            if(sum == B){
                if(num1==num2){
                    int x = j-i;
                    count += (x*(x+1L))/2;
                    break;
                }
                //Check for duplicates
                int k=j;
                long jCounts= 0;
                while(k>=0 && A.get(j)== A.get(k)){
                    jCounts++;
                    k--;
                }
                j=k;

                int l= i;
                long iCounts=0;
                while(l<n && A.get(i)==A.get(l)){
                    iCounts++;
                    l++;
                }
                i=l;

                count+= (iCounts*jCounts);

            }else if(sum >B){
                j--;
            }else{
                i++;
            }
        }
        return (int)(count%1000000007);
    }

    static void print(int[] result){
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
            }else if(!numKeys.containsKey(nums[i])){
                numKeys.put(nums[i], i);
            }
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
