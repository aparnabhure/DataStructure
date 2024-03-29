import java.util.*;
import java.util.stream.Collectors;

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

        ArrayList<Integer> pair = twoSum(Arrays.stream(A).boxed().collect(Collectors.toList()), 14);
        System.out.print(pair.isEmpty()?"[]":"["+pair.get(0)+", "+pair.get(1)+"]");
    }

    static ArrayList<Integer> twoSum(final List<Integer> A, int B) {

        ArrayList<Integer> result = new ArrayList<>();
        int n = A.size();

        Map<Integer, List<Integer>> freqMap = new HashMap<>();
        for(int i=0; i<n; i++){
            List<Integer> indexes = freqMap.getOrDefault(A.get(i), new ArrayList<>());
            indexes.add(i);
            freqMap.put(A.get(i), indexes);
        }

        for(int i =0;i<n; i++){
            int diff = B-A.get(i);
            if(freqMap.containsKey(diff)){
                List<Integer> indexes = freqMap.get(diff);
                if(diff == A.get(i)){
                    if(indexes.size()>=2){
                        result.add(i+1);
                        result.add(indexes.get(1)+1);
                        break;
                    }
                }else{
                    result.add(i+1);
                    result.add(indexes.get(0)+1);
                    break;
                }
            }
        }
        return result;

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
