public class FastPowerFunction {
    public static void main(String[] args) {
        System.out.println(fastPower(71045970, 41535484,64735492));
        System.out.println(fastPower(-1, 1, 20));

        int mod = (int)1e9+7;
        System.out.println(fastPower(10,5,mod));
        System.out.println(fastPower(5,3,mod));


    }

    static int fastPower(int A, int pow, int mod){
        if(A == 0) return 0;
        if(pow == 0) return 1;

        long p = (long)fastPower(A, pow/2, mod) %mod;
        p = ((p%mod)*(p%mod))%mod;
        if(pow%2 == 0){
            return p<0?(int)(p+mod):(int)p;
        }

        p = ((A%mod) *(p%mod))%mod;
        return p<0?(int)(p+mod):(int)p;
    }
}
