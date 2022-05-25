//https://leetcode.com/contest/weekly-contest-294/problems/percentage-of-letter-in-string/
public class PercentageLetters {
    public static void main(String[] args) {
        System.out.println(percentageLetter("foobar", 'o'));
    }

    static int percentageLetter(String s, char letter) {
        int len = s.length();
        if(len == 1){
            if(s.charAt(0) == letter){
                return 100;
            }else{
                return 0;
            }
        }
        int[] chars = new int[26];

        for(int i=0; i<len; i++){
            chars[s.charAt(i)-'a']++;
        }

        int counts = chars[letter-'a'];
        if(counts <= 0){
            return 0;
        }

        return counts*100/len;

    }
}
