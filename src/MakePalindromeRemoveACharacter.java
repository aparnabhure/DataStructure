//https://www.geeksforgeeks.org/remove-character-string-make-palindrome/
public class MakePalindromeRemoveACharacter {
    public static void main(String[] args) {
        System.out.println(makePalindrome("abcba"));
        System.out.println(makePalindrome("abccba"));
        System.out.println(makePalindrome("abecea"));
        System.out.println(makePalindrome("abcbea"));
        System.out.println(makePalindrome("abcca"));
        System.out.println(makePalindrome("abcbca"));
        System.out.println(makePalindrome("abceba"));
        System.out.println(makePalindrome("abecbea"));
    }

    private static boolean makePalindrome(String str){
        boolean makePalindrome = true;
        int start = 0;
        int end = str.length()-1;
        boolean isCharDeleted = false;
        char[] chars = str.toCharArray();

        while (start<end){
            if(chars[start] == chars[end]){
                start++;
                end--;
            }else{
                if(isCharDeleted){
                    makePalindrome = false;
                    break;
                }
                if(chars[start] == chars[end-1]){
                    isCharDeleted = true;
                    end--;
                }else if(chars[start+1] == chars[end]){
                    isCharDeleted = true;
                    start++;
                }
            }
        }

        return makePalindrome;
    }
}
