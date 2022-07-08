import java.util.Vector;

public class CountDivisors {

    public static void main(String[] args) {
        int[] result = solve(new int[]{2,3,4,5});
        print(result);
        result = solveSqrtTC(new int[]{2,3,4,5});
        print(result);
    }

    static void print(int[] result){
        for(int i:result){
            System.out.print(i+ " ");
        }
        System.out.println();
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
