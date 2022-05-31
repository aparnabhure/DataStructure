import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsDictionary {
    /*
    Surprisingly, in an alien language, they also use English lowercase letters, but possibly in a different order.
    The order of the alphabet is some permutation of lowercase letters.

Given an array of words A of size N written in the alien language, and the order of the alphabet denoted by string B of size 26,
return 1 if and only if the given words are sorted lexicographically in this alien language else, return 0.

A = ["hello", "scaler", "interviewbit"]
 B = "adhbcfegskjlponmirqtxwuvzy"
explanation: The order shown in string B is: h < s < i for the given words. So return 1.
 Ans: 1

  A = ["fine", "none", "no"]
 B = "qwertyuiopasdfghjklzxcvbnm"
 explanation: "none" should be present after "no". Return 0.
 ans: 0
     */
    public static void main(String[] args) {
        System.out.println(solve(Arrays.asList("hello", "scaler", "interviewbit"), "adhbcfegskjlponmirqtxwuvzy"));
        System.out.println(solve(Arrays.asList("fine", "none", "no"), "qwertyuiopasdfghjklzxcvbnm"));
    }

    static int solve(List<String> A, String B) {
        int aLen = A.size();
        if(aLen <=1){
            return 1;
        }

        Map<Character, Integer> bMap = new HashMap<>();
        int bLen = B.length();
        for(int i=0; i<bLen; i++){
            bMap.put(B.charAt(i), i);
        }

        for(int i=0; i<aLen-1;i++){
            String s1 = A.get(i);
            String s2 = A.get(i+1);
            int n1 = s1.length();
            int n2 = s2.length();
            //if smaller length string is next then return false
            if(n1>n2){
                return 0;
            }
            char x = s1.charAt(0);
            char y = s2.charAt(0);
            if(bMap.get(x) <= bMap.get(y)){
                continue;
            }
            return 0;
        }

        return 1;
    }
}
