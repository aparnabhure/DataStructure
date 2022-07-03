/*
The division algorithm is divided into two steps:

Shift the upper bits of the dividend (the number we are dividing into) into the remainder.

Subtract the divisor from the value in the remainder. The high order bit of the result become a bit of the quotient (division result).
 */
/*
Divide two integers without using multiplication, division and mod operator.

Return the floor of the result of the division.

Also, consider if there can be overflow cases i.e output is greater than INT_MAX, return INT_MAX.

NOTE: INT_MAX = 2^31 - 1



Problem Constraints
-231 <= A, B <= 231-1

B != 0



Input Format
The first argument is an integer A denoting the dividend.
The second argument is an integer B denoting the divisor.



Output Format
Return an integer denoting the floor value of the division.



Example Input
Input 1:

 A = 5
 B = 2
Input 2:

 A = 7
 B = 1


Example Output
Output 1:

 2
Output 2:

 7

 */
public class BinaryDivision {

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -2));
        System.out.println(divide(-3, -1));
        System.out.println(divide(-2147483648, -1)); //Ans should be MAX_VALUE
        System.out.println(divide(-2147483648, 1));
        System.out.println(divide(-1, -1));
        System.out.println(divide(-1, 1));
        System.out.println(divide(2147483647, 1));
    }

    static boolean isInRange(int A){
        if(A >= Integer.MIN_VALUE && A <= Integer.MAX_VALUE){
            return true;
        }
        return false;
    }

    static int divide(int A, int B) {
        //Approach is for each bit of A check if it is <= A ie 2^x * B <=A then subract it from A and keep adding 2^x in sum
        //System.out.println(Integer.MIN_VALUE +" "+Integer.MAX_VALUE);

//        if(A == Integer.MIN_VALUE){
//            return Integer.MAX_VALUE;
//        }

        long x = Math.abs(A*1L);
        long y = Math.abs(B*1L);

        int signed = 0;
        if(A<0){
            signed ^= 1;
        }
        if(B<0){
            signed ^= 1;
        }

        long ans = 0;
        for(int i=31; i>=0; i--){
            long z = (y <<i);
            if(z <= x){
                x -= z;
                ans += (1L<<i);
                if(ans >= Integer.MAX_VALUE) return (signed ==1 ? Integer.MIN_VALUE : Integer.MAX_VALUE);
            }
        }

        return (int)(signed==1 ? ans*-1 : ans);

//        if(signed == 1){
//            ans = -ans;
//        }
//
//        if(ans > Integer.MAX_VALUE){
//            return Integer.MAX_VALUE;
//        }
//
//        return (int)ans;
    }
}
