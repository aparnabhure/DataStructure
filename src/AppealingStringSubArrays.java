//https://leetcode.com/contest/weekly-contest-291
public class AppealingStringSubArrays {
    public static void main(String[] args) {
        System.out.println(appealSum("abbca"));
    }

    static long appealSum(String s){
        long result = 0;
        long current = 0;
        long[] prev = new long[26];
        for(int i=0; i<s.length(); i++){
            current += i+1 -prev[s.charAt(i)-'a'];
            prev[s.charAt(i)-'a'] = i+1;
            result += current;
        }
        return result;
    }
}
