public class LongestPrefixSuffixString {
    /*
    LPS of a String
    abcab
    Not consider complete length
    prefix Suffix
    a       b
    ab      ab  == This is the Ans
    abc     cab
    abca    bcab
     */

    public static void main(String[] args) {
        System.out.println(lps("abcab"));
    }

    static String lps(String str){
        int n = str.length();
        int p1end = n-1;
        int p2start = 1;
        while(p1end>=0){
            String prefix = str.substring(0, p1end);
            String suffix = str.substring(p2start, n);
            if(prefix.equals(suffix)){
                return prefix;
            }
            p1end--;
            p2start++;
        }
        return null;
    }
}
