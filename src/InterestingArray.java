/**
 * Problem Description
 * You have an array A with N elements. We have two types of operation available on this array :
 * We can split an element B into two elements, C and D, such that B = C + D.
 * We can merge two elements, P and Q, to one element, R, such that R = P ^ Q i.e., XOR of P and Q.
 * You have to determine whether it is possible to convert array A to size 1, containing a single element equal to 0 after several splits and/or merge?
 */
public class InterestingArray {
    public static void main(String[] args) {
        int[] A = new int[]{2,3,6,2,8,9};
        System.out.println(solve(A));
        A = new int[]{1};
        System.out.println(solve(A));
        A = new int[]{0};
        System.out.println(solve(A));
        A = new int[]{2,3,6,2,8,9,1};
        System.out.println(solve(A));
    }

    static String solve(int[] A){

        int ans = 0;
        for(int i:A){
            ans ^= i;
        }

        if((ans^1) == ans+1){
            //Number is EVEN
            return "YES";
        }else{
            return "NO";
        }
    }
}
