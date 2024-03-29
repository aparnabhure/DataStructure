/*
Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)]. It is allowed to swap any two elements (not necessarily consecutive).

Find the minimum number of swaps required to sort the array in ascending order.



Problem Constraints
1 <= N <= 100000
0 <= A[i] < N



Input Format
The only argument given is the integer array A.



Output Format
Return the minimum number of swaps.



Example Input
Input 1:

A = [1, 2, 3, 4, 0]
Input 2:

A = [2, 0, 1, 3]


Example Output
Output 1:

4
Output 2:

2
 */
public class MinimumSwap2 {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{2,0,1,3}));
        System.out.println(solve(new int[]{1,2,3,4,0}));
    }

    static int solve(int[] A) {
        int n = A.length;
        int i = 0;
        int count = 0;
        while(i<n){
            if(A[i] == i){
                i++;
            }else {
                int index = A[i];
                int temp = A[index];
                A[index] = A[i];
                A[i] = temp;
                count++;
            }
        }

        return count;

    }
}
