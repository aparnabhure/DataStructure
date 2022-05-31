import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubarrayWithGivenSum {
    /*
    Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.

If the answer does not exist return an array with a single element "-1".

First sub-array means the sub-array for which starting index in minimum.

Constaints:
1 <= length of the array <= 100000
1 <= A[i] <= 109
1 <= B <= 109

USE LONG for prefix sum
     */

    public static void main(String[] args) {
        ArrayList<Integer> result = solve(Arrays.asList(1,2,3,4,5), 5);
        print(result);
        result = solve(Arrays.asList(1,2,3,4,5), 6);
        print(result);
        result = solve(Arrays.asList(1,20,10,10,5), 25);
        print(result);
        result = solve(Arrays.asList(42, 9, 38, 36, 48, 33, 36, 50, 38, 8, 13, 37, 33, 38, 17, 25, 50, 50, 41, 29, 34, 18, 16, 6, 49, 16, 21, 29, 41, 7, 37, 14, 5, 30, 35, 26, 38, 35, 9, 36, 34, 39, 9, 4, 41, 40, 3, 50, 27, 17, 14, 5, 31, 42, 5, 39, 38, 38, 47, 24, 41, 5, 50, 9, 29, 14, 19, 27, 6, 23, 17, 1, 22, 38, 35, 6, 35, 41, 34, 21, 30, 45, 48, 45, 37), 100);
        print(result);
        result = solve(Arrays.asList(5, 10, 20, 100, 105), 110);
        print(result);
    }

    static void print(ArrayList<Integer> result){
        for(int i:result){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    static ArrayList<Integer> solve(List<Integer> A, int B) {

        int n = A.size();
        long[] prefixSum = new long[n];
        Map<Long, Integer> indexMap = new HashMap<>();
        prefixSum[0] = A.get(0);
        indexMap.put((long)A.get(0), 0);
        for(int i=1; i<n; i++){
            prefixSum[i] = prefixSum[i-1]+A.get(i);
            indexMap.put(prefixSum[i], i);
        }



        int startIndex = 0;
        int endIndex = -1;
        for(int i=0; i<n; i++){
            if(prefixSum[i] == B){
                endIndex = i;
                break;
            }else if(prefixSum[i] > B){
                long diff = prefixSum[i]-B;
                if(indexMap.containsKey(diff)){
                    startIndex = indexMap.get(diff)+1;
                    endIndex = i;
                    break;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while(startIndex <=endIndex){
            result.add(A.get(startIndex));
            startIndex++;
        }

        if(result.isEmpty()){
            result.add(-1);
        }
        return result;
    }
}
