/*
Find the smallest prime factors from 2-N
Sieve Of Eratosthenes algorithm
 */
public class SmallestPrimeFactors {
    public static void main(String[] args) {
        print(smallestPrimeFactors(50));
    }

    static void print(int[] result){
        for(int i: result){
            System.out.print(i +" ");
        }
        System.out.println();
    }

    //TC: approx O(N) -> O(n * Log (Log (n) ))
    static int[] smallestPrimeFactors(int N){
        int[] spf = new int[N+1];
        for(int i=2; i<=N; i++){
            spf[i]=i;
        }
        int sqrt = (int)Math.sqrt(N);
        for(int i=2; i<=sqrt; i++){
            if(spf[i] == i){
                for(int j=i*i; j<=N; j+=i){
                    if(spf[j] == j){
                        spf[j] = i;
                    }
                }
            }
        }
        return spf;
    }
}
