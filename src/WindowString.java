import java.util.HashMap;
import java.util.Map;

public class WindowString {
    /*
    Given a string A and a string B, find the window with minimum length in A, which will contain all the characters in B in linear time complexity.
Note that when the count of a character c in B is x, then the count of c in the minimum window in A should be at least x.

Note:

If there is no such window in A that covers all characters in B, return the empty string.
If there are multiple such windows, return the first occurring minimum window ( with minimum start index and length )
     */
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    static String minWindow(String A, String B) {

        int n = B.length();
        Map<Character, Integer> chars = new HashMap<>();
        for(int i=0; i<n; i++){
            char c = B.charAt(i);
            int count = chars.getOrDefault(c, 0);
            chars.put(c, ++count);
        }

        String ans = "";

        int count = 0;
        int start = 0;
        int end = 0;
        int x = A.length();
        while(end<x){
            char c = A.charAt(end);
            if(!chars.containsKey(c)){
                end++;
            }else {
                int cnt = chars.get(c);
                if (cnt > 0) count++;
                chars.put(c, --cnt);

                if (count == n) {
                    //Optimize start
                    while (true) {
                        c = A.charAt(start);
                        if(!chars.containsKey(c)){
                            start++;
                        }else if ( chars.get(c) < 0) {
                            cnt = chars.get(c);
                            chars.put(c, ++cnt);
                            start++;
                        } else {
                            cnt = chars.get(c);
                            chars.put(c, ++cnt);
                            count--;
                            break;
                        }
                    }
                    //Compute length
                    String s = A.substring(start, end+1);
                    if (ans.length() == 0 || s.length() < ans.length()) {
                        ans = s;
                    }
                    start++;
                }
                end++;
            }

        }
        return ans;

    }
}
