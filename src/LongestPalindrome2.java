/*
Given a string A of size N, find and return the longest palindromic substring in A.

Substring of string A is A[i...j] where 0 <= i <= j < len(A)

Palindrome string:
A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.

Incase of conflict, return the substring which occurs first ( with the least starting index).
 */
public class LongestPalindrome2 {
    public static void main(String[] args) {
        String str = "aaababa";
        System.out.println(longestPalindrome(str));
        str = "abcbcdxyz";
        System.out.println(longestPalindrome(str));
    }

    static String longestPalindrome(String str){
        int n = str.length();
        if(n == 1){
            return str;
        }

        String longestPal =str.substring(0,1);
        int maxLen=1;
        for(int i=1; i<n; i++){
            //Even length pal
            String pal = expandedPal(str, n, i-1, i+1);
            int len = pal.length();
            if(len > maxLen){
                longestPal = pal;
                maxLen = len;
            }
            //Odd length pal
            pal = expandedPal(str, n, i-1, i);
            len = pal.length();
            if(len>maxLen){
                longestPal = pal;
                maxLen = len;
            }
        }
        return longestPal;
    }

    static String expandedPal(String str, int n, int start, int end){
        while(start>=0 && end<n){
            if(str.charAt(start) != str.charAt(end)){
                break;
            }
            start--;
            end++;
        }

        int len = end-start-1;
        if(len<1){
            len = 1;
        }

        int x = start+1;
        int y = x+len;
        return str.substring(x, y);
    }
}
