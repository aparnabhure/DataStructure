import java.util.Arrays;

/*
Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to the given number.

If there is more than one solution possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then
[a, b] < [c, d], If a < c OR a==c AND b < d.
NOTE: A solution will always exist. Read Goldbach's conjecture.



Problem Constraints

4 <= A <= 2*107



Input Format

First and only argument of input is an even number A.



Output Format

Return a integer array of size 2 containing primes whose sum will be equal to given number.



Example Input

 4


Example Output

 [2, 2]


Example Explanation

 There is only 1 solution for A = 4.
 */
public class PrimeSum {
    public static void main(String[] args) {
        int[] result = primesum(4);
        print(result);
        result = primesum(10);
        print(result);
        result = primesum(8763678);
        print(result);
    }

    static void print(int[] result){
        for(int i:result){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    static int[] primesum(int A) {
        boolean[] p = new boolean[A + 1];
        Arrays.fill(p, true);
        p[0] = p[1] = false;

        int sqrt = (int) Math.sqrt(A);
        for (int i = 2; i <= sqrt; i++) {
            if (p[i]) {
                for (int j = i * i; j <= A; j += i) {
                    p[j] = false;
                }
            }
        }

        int[] result = new int[2];
        int y = 0;
        int x = 0;
        for (int i = 2; i <=A; i++) {
            if (p[i]) {
                x = i;
                y = A - x;
                if(p[y]){
                    break;
                }else{
                    x=0; y=0;
                }
            }
        }
        result[0] = x;
        result[1] = y;
        return result;
    }
}
