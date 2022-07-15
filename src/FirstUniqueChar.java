//https://leetcode.com/contest/warm-up-contest/problems/first-unique-character-in-a-string/
public class FirstUniqueChar {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
        System.out.println(firstUniqChar("aabb"));
    }

    static int firstUniqChar(String s) {
        int[] chars = new int[26];
        int n = s.length();
        for(int i=0; i<n; i++){
            chars[s.charAt(i)-'a']++;
        }

        for(int i=0; i<n; i++){
            if(chars[s.charAt(i)-'a'] == 1){
                return i;
            }
        }

        return -1;

    }
}
