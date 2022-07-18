//https://leetcode.com/contest/leetcode-weekly-contest-3/problems/longest-substring-with-at-least-k-repeating-characters/
public class LongestSubstringWithAtLeastKRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(longestSubstring("ababacb",3));
        System.out.println(longestSubstring("ababbc", 2));
        System.out.println(longestSubstring("ababbcxxyzzzxy", 2));
        System.out.println(longestSubstring("aaabb", 3));
    }

    static int longestSubstring(String s, int k){
        int n = s.length();
        if(n<k) return 0;
        if(k==1) return n;


        int[] freq = new int[26];
        for(int i=0; i<n; i++){
            freq[s.charAt(i)-'a']++;
        }


        int i=0;
        while(i<n && freq[s.charAt(i)-'a']>=k) i++;
        if(i>=n-1){
            return i; //That is we found the string which has all chars >= k
        }

        //Left part
        int l1 = longestSubstring(s.substring(0,i), k);
        //right part
        int l2 = longestSubstring(s.substring(i+1), k);

        return Math.max(l1, l2);
    }
}
