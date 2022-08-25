import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        /*
        Given a string A, find the length of the longest substring without repeating characters.
         */
        System.out.println(lengthOfLongestSubstring("dadbc"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    static int lengthOfLongestSubstring(String A) {
        int n = A.length();
        Set<Character> set = new HashSet<>();
        int max=0;
        int start = 0;
        int end = 0;
        while(end<n){
            char c = A.charAt(end);
            if(!set.contains(c)){
                set.add(c);
            }else{
                max = Math.max(max, set.size());
                while(true){
                    char x = A.charAt(start);
                    set.remove(x);
                    start++;
                    if(x == c) break;
                }
                set.add(c);
            }
            end++;
        }
        return Math.max(max, set.size());

    }
}
