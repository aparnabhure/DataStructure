import java.util.Arrays;

/*
We define f(X, Y) as the number of different corresponding bits in the binary representation of X and Y.
For example, f(2, 7) = 2, since the binary representation of 2 and 7 are 010 and 111, respectively. The first and the third bit differ, so f(2, 7) = 2.

You are given an array of N positive integers, A1, A2,..., AN. Find sum of f(Ai, Aj) for all pairs (i, j) such that 1 ≤ i, j ≤ N. Return the answer modulo 109+7.



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 231 - 1



Input Format
The first and only argument of input contains a single integer array A.



Output Format
Return a single integer denoting the sum.



Example Input
Input 1:

 A = [1, 3, 5]
Input 2:

 A = [2, 3]


Example Output
Ouptut 1:

 8
Output 2:

 2


Example Explanation
Explanation 1:

 f(1, 1) + f(1, 3) + f(1, 5) + f(3, 1) + f(3, 3) + f(3, 5) + f(5, 1) + f(5, 3) + f(5, 5)
 = 0 + 1 + 1 + 1 + 0 + 2 + 1 + 2 + 0 = 8
Explanation 2:

 f(2, 2) + f(2, 3) + f(3, 2) + f(3, 3) = 0 + 1 + 1 + 0 = 2
 */
public class DifferntSumBits {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,3,4,5,6,7,7,7,8,9,10};
        int ans = Arrays.binarySearch(nums, 7);
        System.out.println(ans + " : "+ (ans<0?Math.abs(ans)-1:ans));
        ans= Arrays.binarySearch(nums, 11);
        System.out.println(ans + " : "+ (ans<0?Math.abs(ans)-1:ans));
        ans = Arrays.binarySearch(nums, 3);
        System.out.println(ans + " : "+ (ans<0?Math.abs(ans)-1:ans));
        ans = Arrays.binarySearch(nums, -1);
        System.out.println(ans + " : "+ (ans<0?Math.abs(ans)-1:ans));
        System.out.println(cntBits(new int[]{1, 3, 5}));
        System.out.println(cntBits(new int[]{3,5,6,8,2}));
    }

    //** Bits count table approach
    static int cntBits(int[] A) {

        int mod = 1000000007;
        int n = A.length;
        long total = 0;
        for (int i = 0; i < 32; i++) {
            int setBits = 0;
            for (int j = 0; j < A.length; j++) {
                if ((A[j] & (1 << i)) > 0) {
                    setBits++;
                }
            }
            total += 2 * (long)setBits * (n - (long)setBits);
            total = (total % mod);
        }
        return (int) (total);
    }
}
