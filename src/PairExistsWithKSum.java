import java.util.HashMap;
import java.util.Map;

public class PairExistsWithKSum {
    /*
    Given an array find if a pair exists in the array with sum as K
    ie a[i]+a[j]=k where i!=j
     */
    public static void main(String[] args) {
        int[] A = new int[]{2,7,11,15,7};
        System.out.println(pairExists(A, 14));
        System.out.println(pairExists(A, 4));
        System.out.println(pairExists(A, 18));
    }

    //O(n)
    static boolean pairExists(int[] A, int k){
        int n = A.length;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int i:A){
            int f = freqMap.getOrDefault(i, 0);
            freqMap.put(i, ++f);
        }

        for(int i:A){
            int diff = k-i;
            if(freqMap.containsKey(diff)){
                if(diff == i){
                    int freq = freqMap.get(diff);
                    if(freq >= 2){
                        return true;
                    }
                }else {
                    return true;
                }
            }
        }

        return false;
    }
}
