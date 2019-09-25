/**
 *
 * https://leetcode.com
 * Given a 32-bit signed integer, reverse digits of an integer.
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer
 * range: [−2^31,  2^31 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger {
    public static void main(String[] args){
        System.out.println(reverse(1534236469));
    }
    private static int reverse(int x) {
        long reverse = 0;

        while (x != 0){
            int y = x%10;
            x = x/10;
            reverse = reverse * 10 + y;

            if(isOverflow(reverse)){
                return 0;
            }
        }

        return (int)reverse;
    }

    private static boolean isOverflow(long x){
        if(x <= Integer.MAX_VALUE && x>= Integer.MIN_VALUE)
            return false;

       return true;
    }
}
