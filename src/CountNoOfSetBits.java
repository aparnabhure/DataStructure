/*
Given a positive integer A, the task is to count the total number of set bits in the binary representation of all the numbers from 1 to A.

Return the count modulo 109 + 7.



Problem Constraints

1 <= A <= 109


Input Format

First and only argument is an integer A.


Output Format

Return an integer denoting the ( Total number of set bits in the binary representation of all the numbers from 1 to A )modulo 109 + 7.


Example Input

Input 1:

 A = 3

Input 2:

 A = 1



Example Output

Output 1:

 4

Output 2:

 1



Example Explanation

Explanation 1:

 DECIMAL    BINARY  SET BIT COUNT
    1          01        1
    2          10        1
    3          11        2
 1 + 1 + 2 = 4
 Answer = 4 % 1000000007 = 4

Explanation 2:

 A = 1
  DECIMAL    BINARY  SET BIT COUNT
    1          01        1
 Answer = 1 % 1000000007 = 1

 */
public class CountNoOfSetBits {

    public static void main(String[] args) {
        System.out.println(solve(1000000000));
        System.out.println(solve(4));
        System.out.println(solve(3));
    }

    //Obervations from https://www.geeksforgeeks.org/count-total-set-bits-in-all-numbers-from-1-to-n/
    //For each bit position 0 &1 are getting repeated with alternative 2's power
    //0th position are alternative 1 diff, 1position by 2*1, 3rd by 2*4, 4th by 2*8and so on
    /*
    0000
    0001
    0010
    0011
    0100
    0101
    0110
    0111
    1000
     */

    static int solve(int A) {
        if(A <= 0){
            return 0;
        }
        if(A == 1){
            return 1;
        }
        if(A == 2){
            return 2;
        }

        int largest2PowSmallerThanN = largest2PowLessThanA(A);

        long setBitsCountFromXMinus1 = largest2PowSmallerThanN * (1L<<(largest2PowSmallerThanN-1));
        long msbBitCountsFromX = A - (1L<<largest2PowSmallerThanN) +1;
        int restBits = A - (1<<largest2PowSmallerThanN);
        int mod = 1000000007;
        long sum = setBitsCountFromXMinus1%mod + msbBitCountsFromX%mod + solve(restBits) %mod;
        return (int)sum%mod;
    }


    static int largest2PowLessThanA(int A){
        int x = 0;
        while((1<<x) <= A){
            x++;
        }

        return x-1;
    }
}
