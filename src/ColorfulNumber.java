import java.util.HashSet;
import java.util.Set;

public class ColorfulNumber {
    /*
    Given a number A, find if it is COLORFUL number or not.

If number A is a COLORFUL number return 1 else, return 0.

What is a COLORFUL Number:

A number can be broken into different contiguous sub-subsequence parts.
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different.
     */
    public static void main(String[] args) {
        System.out.println(colorful(23));
        System.out.println(colorful(236));
        System.out.println(colorful(231));
        System.out.println(colorful(432));
    }

    static int colorful(int A) {

        Set<Long> productSet = new HashSet<>();
        long prev = -1;

        while(A>0){
            long digit = A%10;
            A = A / 10;

            if(productSet.contains(digit) || productSet.contains(digit*prev))
                return 0;

            productSet.add(digit);
            if (!productSet.add(digit*prev)) {
                return 0;
            }
            prev = digit ;

        }
        return 1;
    }
}
