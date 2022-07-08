public class CalculateGCD {
    public static void main(String[] args) {
        System.out.println(gcd(36, 46));
        System.out.println(gcd(35, 46));
        System.out.println(gcd(2, 3));
        System.out.println(gcd(45, 15));
    }

    static int gcd(int A, int B){
        if(A == 0){
            return B;
        }

        return gcd(B%A, A);
    }
}
