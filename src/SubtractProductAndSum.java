/**
 * https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 *
 * Given an integer number n, return the difference between the product of its digits and the sum of its digits.
 *
 *
 * Example 1:
 *
 * Input: n = 234
 * Output: 15
 * Explanation:
 * Product of digits = 2 * 3 * 4 = 24
 * Sum of digits = 2 + 3 + 4 = 9
 * Result = 24 - 9 = 15
 */
public class SubtractProductAndSum {
    public static void main(String[] args){
        System.out.println(subtractProductAndSum(234));
        System.out.println(subtractProductAndSum(4221));
    }

    private static int subtractProductAndSum(int n) {
        if(n < 10){
            return 0;
        }
        int sum = 0;
        int product = 1;
        while (n!=0){
            int reminder = n%10;
            n = n/10;
            sum += reminder;
            product *= reminder;
        }

        return (product - sum);
    }
}
