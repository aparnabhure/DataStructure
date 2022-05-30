import java.util.HashMap;
import java.util.Map;

public class AllPairsWithSumAsK {
    /*
    Given an array find list of all pairs having sum as K
    a[i]+a[j]=K where i != j

    2,7,11,15,7, 6, 8 ,8, 7
    K = 14
    pairs are
    7,7
    7,7
    7,7
    6,8
    6,8


     */
    public static void main(String[] args) {
        int[] A = new int[]{2,7,11,15,7,6,8,8,7};
        System.out.println(pairCounts(A, 14));
    }

    static int pairCounts(int[] A, int K){

        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int i:A){
            int freq = freqMap.getOrDefault(i, 0);
            freqMap.put(i, ++freq);
        }

        int count = 0;

        for(int i:A){
            int diff = K-i;
            if(freqMap.containsKey(diff)){
                if(diff == i){
                    int freq = freqMap.get(diff);
                    if(freq>=2){
                        //Sum of N+ve numbers
                        count += (freq*(freq-1))/2;
                        freqMap.remove(diff);
                    }
                }else{
                    count += (freqMap.get(i)*freqMap.get(diff));
                    freqMap.remove(i);
                    freqMap.remove(diff);
                }
            }
        }
        return count;
    }
}
