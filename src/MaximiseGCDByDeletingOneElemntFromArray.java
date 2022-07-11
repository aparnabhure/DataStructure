public class MaximiseGCDByDeletingOneElemntFromArray {
    public static void main(String[] args) {
        System.out.println(maximizedGCD(new int[]{4,8,3,12,16}));
        System.out.println(maximizedGCD(new int[]{12,15,18}));
    }

    static int maximizedGCD(int[] A){
        int n= A.length;
        //Prepare prefix GCD and suffix GCD array and then get GCD of elements prior and next from the deleted element
        //Where the GCD is maximum that element need to be deleted

        int[] pfgcd =new int[n];
        int[] sfgcd =new int[n];
        pfgcd[0] = A[0];
        sfgcd[n-1] = A[n-1];
        for(int i=1, j=n-2; i<n && j>=0; i++,j--){
            pfgcd[i]= gcd(A[i], pfgcd[i-1]);
            sfgcd[j] = gcd(A[j], sfgcd[j+1]);
        }
        int max = Integer.MIN_VALUE;
        int value = -1;
        for(int i=0; i<n; i++){
            int gcd = gcd(i==0?0:pfgcd[i-1], i==(n-1)?0:sfgcd[i+1]);
            if(gcd>max){
                max= gcd;
                value = A[i];
            }
        }
        return value;
    }

    static int gcd(int A, int B){
        if(B==0) return A;
        return gcd(B, A%B);
    }
}
