public class SubsequenceWithGCD1 {
    public static void main(String[] args) {
        System.out.println(subsequenceExists(new int[]{4,6,3,8}));
        System.out.println(subsequenceExists(new int[]{4,6}));
    }

    //TC:n*Log2 MAX(arr[i])
    static boolean subsequenceExists(int[]A){
        //If we take GCD of all elements and if get gcd as 1 then return true
        int a = A[0];
        int n = A.length;
        for(int i=1; i<n; i++){
            int b = A[i];
            a = gcd(b, a%b);
        }

        return a==1;
    }

    static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}
