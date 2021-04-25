//https://leetcode.com/problems/longest-substring-of-all-vowels-in-order
public class LongestBeautifulSubString {
    public static void main(String[] args) {
        System.out.println(longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu"));
        System.out.println(longestBeautifulSubstring("aeeeiiiioooauuuaeiou"));
    }

    private static int longestBeautifulSubstring(String word) {
        if(word == null || word.length() < 5){
            return 0;
        }

        int a = 0;
        int e = 0;
        int i = 0;
        int o = 0;
        int u = 0;
        int maxLen = 0;

        StringBuilder sb = new StringBuilder();
        char c = word.charAt(0);
        sb.append(c);
        a += (c == 'a')?1:0;
        e += (c == 'e')?1:0;
        i += (c == 'i')?1:0;
        o += (c == 'o')?1:0;
        u += (c == 'u')?1:0;

        for(int x=1; x<word.length();x++){

            char ch = word.charAt(x);
            if(ch >= c){
                //Valid
                a += (ch == 'a')?1:0;
                e += (ch == 'e')?1:0;
                i += (ch == 'i')?1:0;
                o += (ch == 'o')?1:0;
                u += (ch == 'u')?1:0;
                sb.append(ch);
            }else{
                //Reset
                if(sb.length() > 0 && a>0 && e > 0 && i> 0 && o>0 && u>0){
                    maxLen = Math.max(maxLen, sb.length());
                }
                sb = new StringBuilder();
                a = (ch == 'a')?1:0;
                e = (ch == 'e')?1:0;
                i = (ch == 'i')?1:0;
                o = (ch == 'o')?1:0;
                u = (ch == 'u')?1:0;
                sb.append(ch);
            }

            c = ch;
        }

        if(sb.length() > 0 && a>0 && e > 0 && i> 0 && o>0 && u>0){
            maxLen = Math.max(maxLen, sb.length());
        }

        return maxLen;
    }
}
