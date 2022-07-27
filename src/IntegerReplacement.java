//https://leetcode.com/contest/leetcode-weekly-contest-4/problems/integer-replacement/
public class IntegerReplacement {
    public static void main(String[] args) {
        System.out.println(integerReplacement(2147483647));
        System.out.println(integerReplacement(4));
        System.out.println(integerReplacement(5));
        System.out.println(integerReplacement(6));
        System.out.println(integerReplacement(7));
        System.out.println(integerReplacement(8));
        System.out.println(integerReplacement(55));
        System.out.println(integerReplacement(35));
    }

    static int integerReplacement(int n) {

        if(n == Integer.MAX_VALUE){
            n--;
        }
        int count = 0;
        while(n>1){
            if((n&1) == 0){
                n = n>>1;
            }else{
                if((n&3) != 3 || n==3)
                    n--;
                else
                    n++;
            }
            count++;
        }
        return count;
    }
}
