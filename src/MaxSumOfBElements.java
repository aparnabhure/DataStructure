public class MaxSumOfBElements {
    public static void main(String[] args) {
        int[] A = new int[]{5,-2,3,1,2};
        int B = 3;
        System.out.println(solve(A, B));

        A = new int[]{5,-2,1,3,2};
        B = 3;
        System.out.println(solve(A, B));

        A = new int[]{5,-2,1,3,2};
        B = 4;
        System.out.println(solve(A, B));
    }

    static int solve(int[] A, int B){
        int len = A.length;
        if(B <= 0 || len<=0){
            return 0;
        }

        int[] preSum = new int[len];
        int[] sufSum = new int[len];
        preSum[0] = A[0];
        sufSum[len-1] = A[len-1];
        for(int i=1, j=len-2; i<len;i++,j--){
            preSum[i] = A[i]+preSum[i-1];
            sufSum[j] = sufSum[j+1]+A[j];
        }

        if(len == B){
            return preSum[len-1];
        }

        int maxSum=Integer.MIN_VALUE;
        if(preSum[B-1]>maxSum)
        {
            maxSum=preSum[B-1];
        }
        if(sufSum[len-B]>maxSum)
        {
            maxSum=sufSum[len-B];
        }

        for(int i=B-2,k=1;i>=0;i--,k++)
        {
            int temp=preSum[i]+sufSum[len-k];
            if(temp>maxSum)
            {
                maxSum=temp;
            }
        }

        return maxSum;

    }
}
