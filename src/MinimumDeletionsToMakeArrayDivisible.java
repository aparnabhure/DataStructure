import java.util.Arrays;

//https://leetcode.com/contest/weekly-contest-302/problems/minimum-deletions-to-make-array-divisible/
/*
You are given two positive integer arrays nums and numsDivide. You can delete any number of elements from nums.

Return the minimum number of deletions such that the smallest element in nums divides all the elements of numsDivide. If this is not possible, return -1.

Note that an integer x divides y if y % x == 0.



Example 1:

Input: nums = [2,3,2,4,3], numsDivide = [9,6,9,3,15]
Output: 2
Explanation:
The smallest element in [2,3,2,4,3] is 2, which does not divide all the elements of numsDivide.
We use 2 deletions to delete the elements in nums that are equal to 2 which makes nums = [3,4,3].
The smallest element in [3,4,3] is 3, which divides all the elements of numsDivide.
It can be shown that 2 is the minimum number of deletions needed.
Example 2:

Input: nums = [4,3,6], numsDivide = [8,2,6,10]
Output: -1
Explanation:
We want the smallest element in nums to divide all the elements of numsDivide.
There is no way to delete elements from nums to allow this.


Constraints:

1 <= nums.length, numsDivide.length <= 105
1 <= nums[i], numsDivide[i] <= 109
 */
public class MinimumDeletionsToMakeArrayDivisible {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{3,2,6,2,35,5,35,2,5,8,7,3,4}, new int[]{105,70,70,175,105,105,105}));
        System.out.println(minOperations(new int[]{2,3,2,4,3}, new int[]{9,6,9,3,15}));
        System.out.println(minOperations(new int[]{4,3,6}, new int[]{8,2,6,10}));
    }

    static int minOperations(int[] nums, int[] numsDivide) {
        int g = numsDivide[0];
        for(int num:numsDivide){
            g = gcd(num, g);
        }
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(g%nums[i] == 0){
                return i;
            }
        }
        return -1;
    }

    static int gcd(int A, int B){
        if(B==0)
            return A;
        return gcd(B, A%B);
    }
}
