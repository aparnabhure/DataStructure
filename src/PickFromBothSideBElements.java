/*
You are given an integer array A of size N.

You have to pick B elements in total. Some (possibly 0) elements from left end of array A and some (possibly 0) from the right end of array A to get the maximum sum.

Find and return this maximum possible sum.

NOTE: Suppose B = 4, and array A contains 10 elements, then

You can pick the first four elements or can pick the last four elements, or can pick 1 from front and 3 from the back, etc. You need to return the maximum possible sum of elements you can pick.


Problem Constraints
1 <= N <= 105

1 <= B <= N

-103 <= A[i] <= 103



Input Format
First argument is an integer array A.

Second argument is an integer B.



Output Format
Return an integer denoting the maximum possible sum of elements you picked.



Example Input
Input 1:

 A = [5, -2, 3 , 1, 2]
 B = 3
Input 2:

 A = [1, 2]
 B = 1


Example Output
Output 1:

 8
Output 2:

 2


Example Explanation
Explanation 1:

 Pick element 5 from front and element (1, 2) from back so we get 5 + 1 + 2 = 8
Explanation 2:

 Pick element 2 from end as this is the maximum we can get

 https://www.scaler.com/academy/mentee-dashboard/class/24853/assignment/problems/9900?navref=cl_tt_nv
 */

import java.util.Arrays;
import java.util.List;

public class PickFromBothSideBElements {
    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(5,-2,3,1,2);
        System.out.println(slidingWindow(A, 3));
        System.out.println(prefixSum(A, 3));
        System.out.println(preAndSuffixSum(A, 3));
    }

    //O(N) SC: O(1)
    static int slidingWindow(List<Integer> A, int B){
        int n = A.size();

        int maxSum = 0;

        for(int i=0; i<B; i++){
            maxSum += A.get(i);
        }

        int i=B-1;
        int j= n-1;
        int sum = maxSum;
        while(i>=0){
            sum -= A.get(i);
            sum += A.get(j);
            i--;
            j--;
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    //TC O(n) sc :O(n)
    static int prefixSum(List<Integer> A, int B){
        int n = A.size();

        int[] prefixSum = new int[n];
        prefixSum[0] = A.get(0);
        for(int i=1; i<n; i++){
            prefixSum[i] = prefixSum[i-1]+A.get(i);
        }

        int maxSum = prefixSum[B-1];
        int i=B-2;
        int j=1;

        while(i>=-1){
            int sum = i<0?0:prefixSum[i] + prefixSum[n-1]-prefixSum[n-1-j];
            i--;
            j++;
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    //TC O(n) sc :O(n)
    static int preAndSuffixSum(List<Integer> A, int B){
        int n = A.size();

        int[] prefixSum = new int[n];
        prefixSum[0] = A.get(0);
        for(int i=1; i<n; i++){
            prefixSum[i] = prefixSum[i-1]+A.get(i);
        }

        int[] suffixSum = new int[n];
        suffixSum[n-1] = A.get(n-1);
        for(int i=n-2; i>=0; i--){
            suffixSum[i] = suffixSum[i+1]+A.get(i);
        }

        int maxSum = prefixSum[B-1];
        int i=B-2;
        int j=0;

        while(i>=-1){
            int sum = i<0?0:prefixSum[i] + suffixSum[n-1-j];
            i--;
            j++;
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
