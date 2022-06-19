import java.util.Arrays;
import java.util.List;
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

public class SubArrayOR {
    public static void main(String[] args) {


        //expected 398980269
        System.out.println(solveWithBitsArrays(Arrays.asList(1,2,3,4,5)));
        System.out.println(solveByBits(Arrays.asList(1,2,3,4,5)));
        System.out.println(solve(Arrays.asList(1,2,3,4,5)));
    }

    //Working solution
    static int solveWithBitsArrays(List<Integer> A){
        long sum = 0;
        int[] prev = new int[32]; //Creating array of 32 Bits which will be fill filled with 1 and not 0
        int mod=1000000007;

        for(int i = 1; i <= A.size(); i++) {
            int sum2 = A.get(i - 1);
            for(int j = 0; j < 32; j++){
                long pow = (1 << j);//Left shifting 1, j times
                if((sum2 & pow) != 0) {//if sum2 & pow != 0 than we add we add i in the array
                    sum = (sum + (pow * i) % mod) % mod; //calculating sum using mod
                    prev[j] = i; //add i in the array
                } else if(prev[j] != 0) {
                    sum = (sum + (pow * prev[j]) % mod) % mod;//if prev[j] != 0 than we calculate sum again.
                }
            }
        }

        return (int) (sum % mod);  //taking mod for all subarray sum
    }

    //TC O(n) using bits contribution approach
    //Incorrect result for some other large set testcase
    static int solveByBits(List<Integer> A){
        int n=A.size();
        if(n == 1) return A.get(0);

        long sum = 0;
        int mod = 1000000007;
        //Consider 32 bits Computer
        for(int i=0; i<32; i++){
            //Find the index of an element which is having ith bit set
            //Reverse traversal is because we can carry forward the previous contribution
            int index = n;
            for(int j=n-1; j>=0; j--){
                int element = A.get(j);
                if(((element>>i)&1) == 1){
                    index=j;
                }
                int onesContribution = (n-index)*(1<<i);
                sum = sum%mod + onesContribution%mod;
            }
        }

        return (int)sum%mod;
    }

    //TC O(n^2) not work with large input
    static int solve(List<Integer> A) {
        int n=A.size();
        if(n == 1) return A.get(0);

        long sum = 0;
        int mod = 1000000007;

        for(int i=0; i<n; i++){
            long or = 0;
            for(int j=i; j<n; j++){
                or |= A.get(j);
                sum = sum%mod + or%mod;
            }
        }

        return (int)sum%mod;
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
