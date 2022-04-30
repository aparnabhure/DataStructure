import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class AmazingSubArray {
    public static void main(String[] args) {
        System.out.println(solve("ABIC"));
    }

    static int solve(String A){
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        int len = A.length();
        int ans = 0;
        for(int i=0; i<len; i++){
            if(vowels.contains(A.charAt(i))){
                ans += len-1-i+1;
            }
        }

        return ans%10003;
    }
}
