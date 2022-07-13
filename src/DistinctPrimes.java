import java.util.HashSet;
import java.util.Set;

/*
You have given an array A having N integers. Let say G is the product of all elements of A.

You have to find the number of distinct prime divisors of G.



Input Format

The first argument given is an Array A, having N integers.
Output Format

Return an Integer, i.e number of distinct prime divisors of G.
Constraints

1 <= N <= 1e5
1 <= A[i] <= 1e5
For Example

Input:
    A = [1, 2, 3, 4]
Output:
     2

Explanation:
    here G = 1 * 2 * 3 * 4 = 24
    and distinct prime divisors of G are [2, 3]
 */
public class DistinctPrimes {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{98,68,5,70}));
    }

    static int solve(int[] A) {
        int max = Integer.MIN_VALUE;
        for(int i:A){
            max = Math.max(max, i);
        }

        int[] spf = new int[max+1];
        for(int i=2; i<=max; i++){
            spf[i] =i;
        }

        int sqrt = (int)Math.sqrt(max);
        for(int i=2; i<=sqrt; i++){
            if(spf[i] == i){
                for(int j =i*i; j<=max; j+=i){
                    if(spf[j] == j){
                        spf[j] = i;
                    }
                }
            }
        }

        //Get prime factors of each element from array
        Set<Integer> primes =new HashSet<>();
        for(int N: A){
            while(N>1){
                int p = spf[N];
                while(N%p == 0){
                    primes.add(p);
                    N = N/p;
                }
            }
        }

        return primes.size();
    }
}
