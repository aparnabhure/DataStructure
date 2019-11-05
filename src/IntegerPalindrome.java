/**
 *
 * https://leetcode.com
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true

Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

Follow up:

Could you solve it without converting the integer to a string?

*/
public class IntegerPalindrome {
    public static void main(String[] args){
        System.out.println(isPalindrome(3));
        System.out.println(isPalindromeWithHalfTraverse(12321));
    }
    //Approach one O(N)
    private static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        
        if(x >= 0 && x < 10){
            return true;
        }
        int tempNumber = x;
        int newNumber = 0;
        
        while(x != 0){
            int reminder = x% 10;
            x = x/10;
            newNumber = newNumber*10 + reminder;
        }
        
        if(newNumber == tempNumber){
            return true;
        }
        
        return false;
    }

  //Approach two Log(n)
    private static boolean isPalindromeWithHalfTraverse(int x) {
        if(x < 0){
            return false;
        }
        
        if(x >= 0 && x < 10){
            return true;
        }
        int tempNumber = x;
        int newNumber = 0;
        
        while(x > newNumber){
            int reminder = x% 10;
            x = x/10;
            newNumber = newNumber*10 + reminder;
        }
        
        if(newNumber == tempNumber || tempNumber == (newNumber %10)){
            return true;
        }
        
        return false;
    }
}
