public class SubArrayOR {
    public static void main(String[] args) {
        /*
        Problem Description
You are given an array of integers A of size N.

The value of a subarray is defined as BITWISE OR of all elements in it.

Return the sum of value of all subarrays of A % 109 + 7.



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 108



Input Format
The first argument given is the integer array A.



Output Format
Return the sum of Value of all subarrays of A % 109 + 7.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:

 A = [7, 8, 9, 10]


Example Output
Output 1:

 71
Output 2:

 110


Example Explanation
Explanation 1:

 Value([1]) = 1
 Value([1, 2]) = 3
 Value([1, 2, 3]) = 3
 Value([1, 2, 3, 4]) = 7
 Value([1, 2, 3, 4, 5]) = 7
 Value([2]) = 2
 Value([2, 3]) = 3
 Value([2, 3, 4]) = 7
 Value([2, 3, 4, 5]) = 7
 Value([3]) = 3
 Value([3, 4]) = 7
 Value([3, 4, 5]) = 7
 Value([4]) = 4
 Value([4, 5]) = 5
 Value([5]) = 5
 Sum of all these values = 71
         */

        System.out.println(sum(new int[]{1,2,3,4,5}));
    }

    static int sum(int[] A){
        int n=A.length;
        long ans=0;
        int n2 = 1<<n;
        for(int i=0;i<n2;i++){
            int index=n;
            for(int j=n-1;j>=0;j--){
                if(((A[j]>>i)&1) == 1)index=j;
                ans=(ans+(n-index)*(1<<i));
                ans%=1000000007;
            }
        }
        return (int)ans%1000000007;
    }
}
