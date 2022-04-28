public class RangeSum {
    public static void main(String[] args) {
        int[] A = new int[]{7, 3, 1, 5, 5, 5, 1, 2, 4, 5};
        int[][] B = new int[][]{{7, 10}, {3, 10}, {3, 5}, {1, 10}};
        long[] result = rangeSum(A, B);
        for(long i:result){
            System.out.print(i+" ");
        }
    }

    static long[] rangeSum(int[] A, int[][] B){
        //Prepare prefix sum array
        long[] prefixSum = new long[A.length];
        prefixSum[0] = A[0];
        for(int i=1; i<A.length;i++){
            prefixSum[i] = A[i]+prefixSum[i-1];
        }

        long[] result = new long[B.length];
        //Range formula [i, j] = pf[j]-pf[i]
        for(int i=0; i<B.length; i++){
            int start = B[i][0]-1;
            int end = B[i][1]-1;
            if(start == 0){
                result[i] = prefixSum[end];
            }else {
                result[i] = prefixSum[end] - prefixSum[start - 1];
            }
        }

        return result;

    }
}
