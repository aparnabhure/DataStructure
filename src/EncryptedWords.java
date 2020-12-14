/**
 * Encrypted Words
 * You've devised a simple encryption method for alphabetic strings that shuffles the characters in such a way that the resulting string is hard to quickly read, but is easy to convert back into the original string.
 * When you encrypt a string S, you start with an initially-empty resulting string R and append characters to it as follows:
 * Append the middle character of S (if S has even length, then we define the middle character as the left-most of the two central characters)
 * Append the encrypted version of the substring of S that's to the left of the middle character (if non-empty)
 * Append the encrypted version of the substring of S that's to the right of the middle character (if non-empty)
 * For example, to encrypt the string "abc", we first take "b", and then append the encrypted version of "a" (which is just "a") and the encrypted version of "c" (which is just "c") to get "bac".
 * If we encrypt "abcxcba" we'll get "xbacbca". That is, we take "x" and then append the encrypted version "abc" and then append the encrypted version of "cba".
 * Input
 * S contains only lower-case alphabetic characters
 * 1 <= |S| <= 10,000
 * Output
 * Return string R, the encrypted version of S.
 * Example 1
 * S = "abc"
 * R = "bac"
 * Example 2
 * S = "abcd"
 * R = "bacd"
 * Example 3
 * S = "abcxcba"
 * R = "xbacbca"
 * Example 4
 * S = "facebook"
 * R = "eafcobok"
 */
public class EncryptedWords {

    public static void main(String[] args) {
        System.out.println(encrypt("facebook"));
    }

    private static String encrypt(String str){
        StringBuilder sb = new StringBuilder();

        encryptRecursion(str, sb);

        return sb.toString();
    }

    private static void encryptRecursion(String str, StringBuilder sb){
        if(str == null || str.length() <=0){
            return;
        }
        int len = str.length();
        if(len == 1){
            sb.append(str);
            return;
        }
        int middleIndex = len/2;
        if(len%2 == 0){
            middleIndex -= 1;
        }
        sb.append(str.charAt(middleIndex));
        String leftStr = str.substring(0, middleIndex);
        String rightStr = str.substring(middleIndex+1);
        encryptRecursion(leftStr, sb);
        encryptRecursion(rightStr, sb);
    }
}
