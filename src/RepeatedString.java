/**
 * Lilah has a string, , of lowercase English letters that she repeated infinitely many times.
 * Given an integer, , find and print the number of letter a's in the first  letters of Lilah's infinite string.
 * For example, if the string  and , the substring we consider is , the first  characters of her infinite string. There are  occurrences of a in the substring.
 * Function Description
 * Complete the repeatedString function in the editor below. It should return an integer representing the number of occurrences of a in the prefix of length  in the infinitely repeating string.
 * repeatedString has the following parameter(s):
 * s: a string to repeat
 * n: the number of characters to consider
 * Input Format
 * The first line contains a single string, .
 * The second line contains an integer, .
 * Constraints
 *
 *
 * For  of the test cases, .
 * Output Format
 * Print a single integer denoting the number of letter a's in the first  letters of the infinite string created by repeating  infinitely many times.
 * Sample Input 0
 * aba
 * 10
 * Sample Output 0
 * 7
 * Explanation 0
 * The first n=10 letters of the infinite string are abaabaabaa. Because there are  7 a's, we print 7 on a new line.
 * Sample Input 1
 * a
 * 1000000000000
 * Sample Output 1
 * 1000000000000
 * Explanation 1
 * Because all of the first n=1000000000000 letters of the infinite string are a, we print 1000000000000 on a new line.
 */
public class RepeatedString {

    public static void main(String[] args){
        System.out.println(repeatedString("kmretasscityylpdhuwjirnqimlkcgxubxmsxpypgzxtenweirknjtasxtvxemtwxuarabssvqdnktqadhyktagjxoanknhgilnm", 736778906400l));
    }

    /**
     * Need to find some other solutions because it is not performant
     * @param s
     * @param n
     * @return
     */
    private static long repeatedString(String s, long n) {

        long result = 0;

        if(!s.contains("a")){
            return result;
        }

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'a'){
                result++;
            }
        }

        if(result == s.length()){
            return n;
        }

        for(int i=s.length(), j=0; i<n; i++){
            if(s.charAt(j) == 'a'){
                result++;
            }
            j++;
            if(j >= s.length()){
                j=0;
            }
        }

        return result;
    }
}
