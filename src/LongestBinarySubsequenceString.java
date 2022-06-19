/*
https://leetcode.com/contest/weekly-contest-298/problems/longest-binary-subsequence-less-than-or-equal-to-k/

You are given a binary string s and a positive integer k.

Return the length of the longest subsequence of s that makes up a binary number less than or equal to k.

Note:

The subsequence can contain leading zeroes.
The empty string is considered to be equal to 0.
A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.


Example 1:

Input: s = "1001010", k = 5
Output: 5
Explanation: The longest subsequence of s that makes up a binary number less than or equal to 5 is "00010", as this number is equal to 2 in decimal.
Note that "00100" and "00101" are also possible, which are equal to 4 and 5 in decimal, respectively.
The length of this subsequence is 5, so 5 is returned.
Example 2:

Input: s = "00101001", k = 1
Output: 6
Explanation: "000001" is the longest subsequence of s that makes up a binary number less than or equal to 1, as this number is equal to 1 in decimal.
The length of this subsequence is 6, so 6 is returned.


Constraints:

1 <= s.length <= 1000
s[i] is either '0' or '1'.
1 <= k <= 109
 */
public class LongestBinarySubsequenceString {
    public static void main(String[] args) {
        System.out.println(longestSubsequence("1001010", 5));
    }

    static int longestSubsequence(String s, int k) {

        int n = s.length();

        long sum = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=n-1,j=0; i>=0; i--,j++){
            char c = s.charAt(i);
            if(c == '0'){
                sb.insert(0, c);
            }else if(s.charAt(i) == '1' && sum < k){
                sum += (1L<<j);
                if(sum <= k){
                    sb.insert(0,c);
                }
            }
        }

        return sb.length();


    }
}
