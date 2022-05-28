import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinDistance {
    /*
    Shaggy has an array A consisting of N elements. We call a pair of distinct indices in that array a special if elements at those indices in the array are equal.

Shaggy wants you to find a special pair such that the distance between that pair is minimum. Distance between two indices is defined as |i-j|. If there is no special pair in the array, then return -1.
     */
    public static void main(String[] args) {
        System.out.println(solve(Arrays.asList(7, 1, 3, 4, 1, 7)));
    }

    static  int solve(List<Integer> A) {
        int n = A.size();
        //item and min distance
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<n; i++){
            int a = A.get(i);
            List<Integer> indexes = new ArrayList<>();
            if(map.containsKey(a)){
                indexes = map.get(a);
            }
            indexes.add(i);
            map.put(a, indexes);
        }

        int minDistance = Integer.MAX_VALUE;
        for(Map.Entry<Integer, List<Integer>> entry:map.entrySet()){
            List<Integer> list = entry.getValue();
            n = list.size();
            for(int i =0; i<n-1; i++){
                int distance = list.get(i+1)-list.get(i);
                minDistance = Math.min(minDistance, distance);
            }
        }
        return minDistance==Integer.MAX_VALUE?-1:minDistance;
    }
}
