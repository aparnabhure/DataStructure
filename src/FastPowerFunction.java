public class FastPowerFunction {
    public static void main(String[] args) {
        int mod = (int)1e9+7;
        System.out.println(fastPower(10,5,mod));
        System.out.println(fastPower(5,3,mod));
    }

    static int fastPower(int A, int pow, int mod){
        if(pow == 0)return 1;

        int p = fastPower(A, pow/2, mod) %mod;
        p = (int)((p*(long)p)%mod);
        if(pow%2 == 0){
            return p;
        }

        return ((int)(A*(long)p)%mod);
    }
}
