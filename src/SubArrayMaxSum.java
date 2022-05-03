public class SubArrayMaxSum {
    public static void main(String[] args) {
        int[] C = new int[]{2, 1, 3, 4, 5};
        int B = 12;
        int A = 5;
        System.out.println(maxSubarray(A, B, C));

        C = new int[]{2,2,2};
        B = 1;
        A = 3;
        System.out.println(maxSubarray(A, B, C));
    }
    static int maxSubarray(int A, int B, int[] C) {
        if(A == 0){
            return 0;
        }

        if(A == 1){
            return C[0]<=B?C[0]:0;
        }

        //Kadane algorithm
        int max = 0;
        int currentSum = 0;
        int lastIndex = 0;
        for(int i=0; i<C.length; i++){
            currentSum += C[i];

            if(currentSum > B){
                while(currentSum>B ){
                    currentSum -= C[lastIndex];
                    lastIndex++;
                }
            }

            if(currentSum == B){
                return currentSum;
            }else {
                max = Math.max(max, currentSum);
            }
        }

        return max;
    }
}
