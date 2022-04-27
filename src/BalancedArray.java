public class BalancedArray {
    public static void main(String[] args) {
        int[] A = new int[]{2,1,6,4};
        System.out.println(solve(A));
    }

    static int solve(int[] A) {
        int len = A.length;
        if(len == 1){
            return 1;
        }

        int[] prefixEven = new int[len];
        int[] prefixOdd = new int[len];
        // Even Sum = pfeven[i-1] + (pfodd(n-1)-pfodd(i))
        // Even odd = pfodd(i-1) + (pfeven(n-1)-pfeven(i))
        prefixEven[0] = A[0];
        prefixOdd[0] = 0;
        for(int i=1; i<len; i++){
            if(i%2 == 0){
                //Even Prefix
                prefixEven[i] = A[i]+prefixEven[i-1];
                prefixOdd[i] = prefixOdd[i-1];
            }else{
                //Odd prefix
                prefixEven[i] = prefixEven[i-1];
                prefixOdd[i] = A[i]+prefixOdd[i-1];
            }
        }

        int count = 0;

        for(int i=0; i<len; i++){
            int evenSum = (i==0?0:prefixEven[i-1])+prefixOdd[len-1]-prefixOdd[i];
            int oddSum = (i==0?0:prefixOdd[i-1])+prefixEven[len-1]-prefixEven[i];
            if(evenSum == oddSum){
                count++;
            }
        }

        return count;

    }
}
