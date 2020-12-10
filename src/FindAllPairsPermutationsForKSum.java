import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

/**
 * example
 * [1,5,3,3,3] k = 6
 * output = 4  which is 1+5, 3+3 (2&3 index), 3+3(2&4index), 3+3(3&4 index)
 */

public class FindAllPairsPermutationsForKSum {
    public static void main(String[] args) {
        System.out.println(compute(new int[]{1,5,3,3,3}, 6));
        System.out.println(compute(new int[]{1,5,3,3,3,5,1}, 6));
        System.out.println(computeViaHashtable(new int[]{1,5,3,3,3}, 6));
        System.out.println(computeViaHashtable(new int[]{1,5,3,3,3,5,1}, 6));
        System.out.println(computeStoringSumDiff(new int[]{1,5,3,3,3}, 6));
        System.out.println(computeStoringSumDiff(new int[]{1,5,3,3,3,5,1}, 6));
    }

    /**
     * Approach 1 to execute 2D array
     * @param arr
     * @param k
     * @return
     */
    private static int compute(int[] arr, int k){
        int sum = 0;

        int[][] matrix = new int[arr.length][arr.length];
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                //O(1) array operations
                if((arr[i]+arr[j]) == k && (matrix[i][j] != 1 && matrix[j][i] != 1)){
                    matrix[i][j] = 1;
                    matrix[j][1] = 1;
                    sum++;
                }
            }
        }

        return sum;
    }

    /**
     * Approach 2 use HashMap
     * @param arr
     * @param k
     * @return
     */
    private static int computeViaHashtable(int[] arr, int k){
        int sum = 0;
        Set<String> pairs = new HashSet<>();
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if((arr[i]+arr[j]) == k){
                    String key1 = i+""+j;
                    String key2 = j+""+i;
                    if(!(pairs.contains(key1) && pairs.contains(key2))) {
                        pairs.add(key1);
                        pairs.add(key2);
                        sum++;
                    }
                }
            }
        }

        return sum;
    }

    private static int computeStoringSumDiff(int[] arr, int k){
        int sum = 0;
        Set<Integer> pairs = new HashSet<>();
        for (int a : arr) {
            int diff = k - a;
            if (pairs.contains(diff)) {
                sum++;
            }
            pairs.add(a);

        }

        return sum;
    }
}
