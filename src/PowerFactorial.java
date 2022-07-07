public class PowerFactorial {
    public static void main(String[] args) {
        System.out.println(solve(2, 3));
        System.out.println(solve(2, 6));
    }

    static int fast_power(long A, long B, long mod) {
        long ans = 1;
        while(B > 0) {
            if((B & 1) == 1) {
                ans = (ans * A) % mod;
            }
            A = (A % mod * A % mod) % mod;
            B = B >> 1;
        }
        return (int)(ans % mod);
    }

    static int solve(int A, int B) {
        long fact = 1;
        long mod = (long)(1e9 + 7);
        // calculating factorial of B
        for(long i = 2; i <= B; i += 1) {
            fact = (fact * i) % (mod - 1);      // (mod-1) is used according to Fermat Little theorem.
        }
        return fast_power(A, fact, mod);     // calculating power by divide and conquer
    }
}
