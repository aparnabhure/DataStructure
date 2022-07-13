import java.util.Arrays;

/*
Find all prime numbers between 1-N
Sieve Of Eratosthenes algorithm
 */
public class FindAllPrimeNumbers {

    public static void main(String[] args) {
        printPrimes(50);
    }

    //TC: approx O(N) -> O(n * Log (Log (n) ))
    static void printPrimes(int N){
        boolean[] primes = new boolean[N+1];
        Arrays.fill(primes, true); //TC: O(n)

        primes[0] = primes[1] = false; //0 &1 are not prime numbers
        int sqrt = (int)Math.sqrt(N);
        for(int i=2; i<=sqrt; i++){
            if(primes[i]){
                //mark multiple of i as false
                for(int j=i*i; j<=N; j+=i){
                    primes[j] = false;
                }
            }
        }

        for(int i=2; i<=N; i++){
            if(primes[i]) System.out.print(i +", ");
        }
        System.out.println();
    }
}
