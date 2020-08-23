import java.util.*;
import java.util.stream.Collectors;
// https://leetcode.com/problems/most-visited-sector-in-a-circular-track/
public class MostVisitedSectorInCircle {
    public static void main(String[] args) {
        // n=4 rounds = {1,3,1,2} ans: {1,2}
        // 1->3 contains 1->2->3 ,3->1 contains 3->4->1, 1->2 contains 1->2 where 1&2 visited most
        List<Integer> mostVistedSectors = mostVisitedSectors(new int[]{1,3,1,2}, 4);
        for(int i:mostVistedSectors) {
            System.out.println(i);
        }
        mostVistedSectors = mostVisitedSectors(new int[]{1,3,5,7}, 7);
        for(int i:mostVistedSectors) {
            System.out.println(i);
        }
        mostVistedSectors = mostVisitedSectors(new int[]{2,1,2,1,2,1,2,1,2}, 2);
        for(int i:mostVistedSectors) {
            System.out.println(i);
        }
    }

    private static List<Integer> mostVisitedSectors(int[] rounds, int n){
        int[] sectors = new int[n];
        //Fill the all available sectors
        for(int i=0;i<n;i++){
            sectors[i] = i+1;
        }
        Map<Integer, Integer> sectorsCountMap =new HashMap<>();
        //Insert very first start lap
        sectorsCountMap.put(rounds[0], 1);
        //Traverse the sectors
        for(int i=0;i<rounds.length-1;i++){
            int start = rounds[i];
            int end = rounds[i+1];

            int j=start;
            while(true){
                if(j>sectors.length-1){
                    j=0;
                }
                int count = 1;
                if(sectorsCountMap.containsKey(sectors[j])){
                    count += sectorsCountMap.get(sectors[j]);
                }
                sectorsCountMap.put(sectors[j], count);
                if (sectors[j] == end){
                    break;
                }
                j++;
            }
        }

        int maxValue =Integer.MIN_VALUE;
        Map<Integer, Set<Integer>> results = new HashMap<>();

        for (Map.Entry<Integer, Integer> entry : sectorsCountMap.entrySet()){
            int value = entry.getValue();
            if(value >= maxValue){
                maxValue = value;
                int key = entry.getKey();
                if(results.containsKey(value)){
                    results.get(value).add(key);
                }else{
                    results.clear();
                    Set<Integer> keys = new TreeSet<>();
                    keys.add(key);
                    results.put(value, keys);
                }
            }
        }
        return new ArrayList<>(results.get(maxValue));

    }
}
