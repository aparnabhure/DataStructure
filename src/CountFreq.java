//https://leetcode.com/contest/biweekly-contest-79/problems/check-if-number-has-equal-digit-count-and-digit-value/
public class CountFreq {

    /*
    you are given a 0-indexed string num of length n consisting of digits.

Return true if for every index i in the range 0 <= i < n, the digit i occurs num[i] times in num, otherwise return false.
Input: num = "1210"
Output: true
Explanation:
num[0] = '1'. The digit 0 occurs once in num.
num[1] = '2'. The digit 1 occurs twice in num.
num[2] = '1'. The digit 2 occurs once in num.
num[3] = '0'. The digit 3 occurs zero times in num.
The condition holds true for every index in "1210", so return true.

     */
    public static void main(String[] args) {
        System.out.println(digitCount("1210"));
        System.out.println(digitCount("030"));
    }

    static boolean digitCount(String num) {
        int[] nfreq = new int[10];
        int n = num.length();
        for(int i=0; i<n; i++){
            nfreq[num.charAt(i)-'0']++;
        }

        for(int i=0; i<n; i++){
            if(nfreq[i] != (num.charAt(i)-'0')){
                return false;
            }
        }

        return true;

    }
}
