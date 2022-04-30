public class ProductArray {
    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,4,5};
        int[] result = solve(A);
        for(int i:result){
            System.out.print(i+ " ");
        }

        A = new int[]{5};
        result = solve(A);
        for(int i:result){
            System.out.print(i+ " ");
        }
    }

    static int[] solve(int[] A){
        int len = A.length;
//        if(len <= 1){
//            return 1;
//        }

        long[] productSum = new long[A.length];
        productSum[0] = A[0];
        for(int i=1; i<len;i++){
            productSum[i] = A[i]*productSum[i-1];
        }

        int[] result = new int[len];
        for(int i=0; i<len;i++){
            if(i==0){
                result[i] = (int) (productSum[len-1]/productSum[i]);
            }else{
                result[i] = (int) (productSum[i-1]*(productSum[len-1]/productSum[i]));
            }
        }

        return result;
    }
}
