public class ClosestPalindrome {
    /*
    Given a string A of size N consisting of lowercase alphabets, he wants to know if it is possible to make the given string a palindrome by changing exactly one of its character.
     */

    public static void main(String[] args) {

        System.out.println(solve("adaddb"));

        System.out.println(solve("abba"));

        System.out.println(solve("aaaaaaaaaabaaaaaaaaa"));

    }

    static String solve(String A) {
        int n = A.length();

        int left = 0;
        int right = n-1;
        boolean charChanged = false;
        while(left<right){
            if(A.charAt(left) != A.charAt(right)){
                if(charChanged) return "NO";
                charChanged = true;
            }
            left++;
            right--;
        }

        if(n%2 == 0 && !charChanged){
            return "NO";
        }

        return "YES";
    }
}
