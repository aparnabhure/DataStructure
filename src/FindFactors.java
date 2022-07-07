public class FindFactors {
    public static void main(String[] args) {
        int[] result = solve(new int[]{2,3,4,5});
        print(result);
        result = solve(new int[]{8,9,10});
        print(result);
    }

    static void print(int[] result){
        for(int i:result){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    static int[] solve(int[] A) {
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
