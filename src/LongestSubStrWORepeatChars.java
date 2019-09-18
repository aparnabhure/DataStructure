import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 *
 */
public class LongestSubStrWORepeatChars {

    public static void main(String[] args){

        //Best
        System.out.print(lengthOfLongestSubstringUsingHash("abcabcbb"));
        System.out.print(lengthOfLongestSubstringUsingHash("bbbbb"));
        System.out.print(lengthOfLongestSubstringUsingHash("pwwkew"));
        System.out.print(lengthOfLongestSubstringUsingHash(" "));
        System.out.print(lengthOfLongestSubstringUsingHash("dvdf"));

        //Average
        System.out.print(lengthOfLongestSubstringUsingSet("abcabcbb"));
        System.out.print(lengthOfLongestSubstringUsingSet("bbbbb"));
        System.out.print(lengthOfLongestSubstringUsingSet("pwwkew"));
        System.out.print(lengthOfLongestSubstringUsingSet(" "));
        System.out.print(lengthOfLongestSubstringUsingSet("dvdf"));

        //Worst
        System.out.print(lengthOfLongestSubstring("abcabcbb"));
        System.out.print(lengthOfLongestSubstring("bbbbb"));
        System.out.print(lengthOfLongestSubstring("pwwkew"));
        System.out.print(lengthOfLongestSubstring(" "));
        System.out.print(lengthOfLongestSubstring("dvdf"));

    }

    /**Runtime 77ms
 * Memory 38.9MB
     * */
    private static int lengthOfLongestSubstring(String input) {

        if(input == null || input.isEmpty()){
            return 0;
        }
        StringBuilder subStr = new StringBuilder();
        int maxLength = 0;
        String maxLengthSubStr = "";
        for (int i=0; i<input.length(); i++){
            char charAt = input.charAt(i);
            if(subStr.indexOf((Character.toString(charAt))) != -1){
                if(subStr.length() > maxLength){
                    maxLength = subStr.length();
                    maxLengthSubStr = subStr.toString();
                }
                subStr.setLength(0);
                int lastIndex = input.lastIndexOf(charAt, i-1);
                i = lastIndex;
                continue;

            }
            subStr.append(Character.toString(charAt));
        }

        if(subStr.length() >0 && maxLength<subStr.length()){
            maxLength = subStr.length();
            maxLengthSubStr = subStr.toString();
        }

        System.out.print(maxLengthSubStr+" ");
        return maxLength;
    }

    //Hash approach Best approach
    //Time 8ms
    //Memory 36 MB
    private static int lengthOfLongestSubstringUsingHash(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    private static int lengthOfLongestSubstringUsingSet(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
