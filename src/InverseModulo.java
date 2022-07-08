public class InverseModulo {
    //Calculate A^-1 MOD B where B is prime number and GCD(a, b) = 1
    public static void main(String[] args) {
        System.out.println(solve(3, 5));
    }

    static int solve(int A, int B){
        if(gcd(A, B) != 1){
            return 0;
        }

        //https://en.wikipedia.org/wiki/Fermat%27s_little_theorem
        /*
        Fermat's little theorem states that if p is a prime number, then for any integer a, the number ap − a is an integer multiple of p. In the notation of modular arithmetic, this is expressed as

    a p ≡ a ( mod p ) . {\displaystyle a^{p}\equiv a{\pmod {p}}.} a^p \equiv a \pmod p.

For example, if a = 2 and p = 7, then 27 = 128, and 128 − 2 = 126 = 7 × 18 is an integer multiple of 7.

If a is not divisible by p, Fermat's little theorem is equivalent to the statement that ap − 1 − 1 is an integer multiple of p, or in symbols:[1][2]

    a p − 1 ≡ 1 ( mod p ) . {\displaystyle a^{p-1}\equiv 1{\pmod {p}}.} a^{p-1} \equiv 1 \pmod p.

For example, if a = 2 and p = 7, then 26 = 64, and 64 − 1 = 63 = 7 × 9 is thus a multiple of 7.
         */

        return power(A, B-2, B); //formula A^-1 = A^M-2 (mod M);
    }

    static int power(int A, int pow, int mod){
        if(pow == 0) return 1;

        int p = power(A, pow/2, mod) %mod;
        p = (int)((p * (long)p) % mod);
        if(pow %2 == 0){
            return p;
        }

        return (int)((A * (long)p) % mod);
    }

    static int gcd(int a, int b){
        if(a==0){
            return b;
        }
        return gcd(b%a, a);
    }
}
