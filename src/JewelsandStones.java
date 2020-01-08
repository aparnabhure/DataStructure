/**
 * https://leetcode.com/problems/jewels-and-stones/
 *
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 *
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
 * Example 1:
 *
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * Example 2:
 *
 * Input: J = "z", S = "ZZ"
 * Output: 0
 * Note:
 *
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 */
public class JewelsandStones {
    public static void main(String[] args){
        System.out.println(numJewelsInStones("aA", "aAAtds"));
    }

    private static int numJewelsInStones(String J, String S) {
        int sum = 0;
        if(J == null || S == null || J.isEmpty() || S.isEmpty()){
            return sum;
        }

        for(int i=0; i<J.length(); i++){
           char charAt = J.charAt(i);
           int jIndex = S.indexOf(charAt);
           if(jIndex != -1) {
               sum ++;
               for (int j = jIndex+1; j < S.length(); j++) {
                    char sChar = S.charAt(j);
                    if(sChar == charAt){
                        sum ++;
                    }
               }
           }
        }

        return sum;
    }
}
