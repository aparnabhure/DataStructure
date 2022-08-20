public class MakeStringPalindrome {
    /*
    Given a string A of size N consisting only of lowercase alphabets. The only operation allowed is to insert characters in the beginning of the string.

Find and return how many minimum characters are needed to be inserted to make the string a palindrome string.
     */

    public static void main(String[] args) {
        System.out.println(solve("abc"));
        System.out.println(solve("aaaaa"));
    }

    static int solve(String A) {

        StringBuilder sb = new StringBuilder(A);
        String S = A+"#"+sb.reverse();
        int n = S.length();
        int[] lps = lpsArray(S, n);
        return A.length()-lps[n-1];

    }

    static int[] lpsArray(String A, int n){
        int[] lps = new int[n];

        int x = 0;
        int i=1;
        while(i<n){
            if(A.charAt(x) == A.charAt(i)){
                x++;
                lps[i]=x;
                i++;
            }else{
                if(x!=0){
                    x = lps[x-1];
                }else{
                    lps[i]= 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
