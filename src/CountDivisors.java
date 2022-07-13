import java.util.Vector;

public class CountDivisors {

    public static void main(String[] args) {
        int[] result = solve(new int[]{2,3,4,5});
        print(result);
        result = solveSqrtTC(new int[]{2,3,4,5});
        print(result);
        result = solveUsingPrimeFactorization(new int[]{2,3,4,5});
        print(result);
    }
    static void print(int[] result){
        for(int i:result){
            System.out.print(i+ " ");
        }
        System.out.println();
    }

    static int[] solveUsingPrimeFactorization(int[] A){
        int n = A.length;

        int max = Integer.MIN_VALUE;
        for(int i: A){
            max = Math.max(i, max);
        }

        //prepare smallest prime factors array
        int[] spf = new int[max+1];
        for(int i=2; i<=max; i++){
            spf[i]=i;
        }
        //Calculate smallest prime factors
        int sqrt = (int)Math.sqrt(max);
        for(int i=2; i<=sqrt; i++){
            if(spf[i] == i){
                for(int j=i*i; j<=max; j+=i){
                    if(spf[j] == j){
                        spf[j] = i;
                    }
                }
            }
        }

        for(int i=0; i<n; i++){
            //for each query
            int N = A[i];
            int total =1;
            while(N>1){
                int p= spf[N];
                int c = 0;
                while (N%p == 0){
                    c++;
                    N = N/p;
                }
                total *= (1+c);
            }
            A[i] = total;
        }
        return A;
    }
    static int[] solve(int[] A){
        int n =A.length;
        int max = 1000007;
        int[] v = new int[max];
        for(int i=1; i<max; i++){
            for(int j=1; j<max; j+=i){
                v[j]++;
            }
        }

        for(int i=0; i<n; i++){
            A[i] = v[A[i]+1];
        }

        return A;
    }


    static int[] solveSqrtTC(int[] A) {
        int n = A.length;

        for(int i = 0; i<n; i++){
            if(A[i] > 1){
                A[i] = findFactors(A[i]);
            }

        }

        return A;
    }

    static int findFactors(int n){
        int i=1;
        int count = 0;
        int sqrt = (int)Math.sqrt(n);
        while(i<=sqrt){
            if(n%i == 0){
                if(i == (n/i)){
                    count++;
                }else{
                    count+=2;
                }
            }

            i++;
        }
        return count;
    }
}
