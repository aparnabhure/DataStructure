/**
 * https://leetcode.com/problems/to-lower-case/
 *
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 *
 *
 *
 * Example 1:
 *
 * Input: "Hello"
 * Output: "hello"
 * Example 2:
 *
 * Input: "here"
 * Output: "here"
 * Example 3:
 *
 * Input: "LOVELY"
 * Output: "lovely"
 */
public class ToLowerCase {

    public static void main(String[] args){
        System.out.println(toLowerCase("ZAPaRNa"));
        System.out.println(toLower("shjSDJEOW CsdADAD 32sdfSDF"));
    }

    private static String toLowerCase(String str) {
        if(str == null || str.isEmpty()){
            return str;
        }

        StringBuffer lower = new StringBuffer();
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c >= 65 && c <= 90){
                c = (char)(c+32);
            }
            lower.append(c);
        }

        return lower.toString();
    }

    private static String toLower(String str){
        if(str == null || str.isEmpty()){
            return str;
        }

        StringBuffer lower = new StringBuffer();
        char[] chars = str.toCharArray();
        for(char c:chars){
            if(Character.isUpperCase(c)){
                c += 32;
            }
            lower.append(c);
        }

        return lower.toString();
    }
}
