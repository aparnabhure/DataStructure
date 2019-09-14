import java.util.*;

/**
 * Problem:: Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
 *
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 *
 * Example:
 *
 * Input:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * Output:
 * 2
 *
 * Explanation:
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 *
 */

public class FourSumII {
    public static void main(String[] args){
        /**
         * Sample 1: *
         * A = [ 1, 2]
         *  * B = [-2,-1]
         *  * C = [-1, 2]
         *  * D = [ 0, 2]
         */

        int[] A = new int[] {1,2};
        int[] B = new int[] {-2, -1};
        int[] C = new int[] {-1,2};
        int[] D = new int[] {0,2};

        long startTime = System.currentTimeMillis();
        int count = fourSumII(A, B, C, D);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken " + ((endTime - startTime)));

        System.out.println("Count " + count);

    }


    private static int fourSumII(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer>hm = new HashMap<>();
        HashMap<Integer, Integer>hk = new HashMap<>();
        int count = 0;

        for(int i=0; i<A.length; i++){
            for(int j =0; j<A.length; j++){
                int ab = A[i] + B[j];

                if(hm.containsKey(ab)){
                    hm.put(ab, hm.get(ab)+1);
                }else{
                    hm.put(ab, 1);
                }

                int cd = C[i] + D[j];

                if(hk.containsKey(cd)){
                    hk.put(cd, hk.get(cd)+1);
                }else{
                    hk.put(cd, 1);
                }
            }
        }

        for(Map.Entry<Integer, Integer> data:hm.entrySet()){
            int abKey = data.getKey();
            int abValue = data.getValue();

            int v = abKey * -1;
            if(hk.containsKey(v)){
                count += hk.get(v) * abValue;

            }
        }

        return count;
    }
}
