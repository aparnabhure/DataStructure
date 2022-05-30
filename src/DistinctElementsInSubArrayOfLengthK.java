import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistinctElementsInSubArrayOfLengthK {
    /*
    Given an array find distinct elements in every subarray of size K
    example: (sliding window approach)
    1 1 2 3 2
    k = 3
    ans 2 3 2
     */
    public static void main(String[] args) {
        int[] A = new int[]{1,1,2,3,2};
        int[] result = findSubArray(A, 3);
        print(result);

        A = new int[]{6,3,7,3,8,6,7};
        result = findSubArray(A, 3);
        print(result);
    }

    static void print(int[] A){
        for(int i:A){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    static int[] findSubArray(int[] A, int k){

        int n = A.length;
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> freqMap =new HashMap<>();
        //prepare first window
        for(int i=0; i<k; i++){
            int count = freqMap.getOrDefault(A[i], 0);
            freqMap.put(A[i], ++count);
        }

        result.add(freqMap.size());

        for(int i=1; i<=n-k; i++){
            int removal = A[i-1];
            int addition = A[i+k-1];
            if(freqMap.containsKey(removal)){
                int freq = freqMap.get(removal);
                if(freq == 1){
                    freqMap.remove(removal);
                }else{
                    freqMap.put(removal, --freq);
                }
            }

            int freq = freqMap.getOrDefault(addition, 0);
            freqMap.put(addition, ++freq);

            result.add(freqMap.size());
        }

        return result.stream().mapToInt(i->i).toArray();
    }
}
