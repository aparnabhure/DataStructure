/*
Given an integer A, find and return the total number of digit 1 appearing in all non-negative integers less than or equal to A.



Problem Constraints
0 <= A <= 109



Input Format
The only argument given is the integer A.



Output Format
Return the total number of digit 1 appearing in all non-negative integers less than or equal to A.



Example Input
Input 1:

 A = 10
Input 2:

 A = 11


Example Output
Output 1:

 2
Output 2:

 4

 */
public class CountNumberOfOnes {
    public static void main(String[] args) {
        System.out.println(solve(923));
    }

    static int solve(int A) {
        if(A == 0) return 0;
        if(A <= 9) return 1;
        if(A == 10) return 2;
        if(A == 11) return 4;

        //Logic is to calculate 1's in each unit place
        int i = 1;
        int sum = 0;
        while((A/i) > 0){
            int counts = ((A/(i*10))*i) + Math.min(Math.max(((A%(i*10))-(i-1)),0),i);
            sum += counts;
            i *= 10;
        }

        return sum;
    }
}
