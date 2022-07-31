import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/contest/weekly-contest-304/problems/longest-cycle-in-a-graph/
public class LongestCycleInGraph {
    public static void main(String[] args) {
        System.out.println(longestCycle(new int[]{3,3,4,2,3}));
        System.out.println(longestCycle(new int[]{2,-1,3,1}));
        System.out.println(longestCycle(new int[]{6,2,3,4,6,0,5}));
        System.out.println(longestCycle(new int[]{1,2,3,4,6,0,5}));
    }

    static int longestCycle(int[] edges) {
        int maxPath = -1;

        Set<Integer> visited = new HashSet<>();
        int n = edges.length;
        for(int i=0; i<n; i++){
            if(!visited.contains(i)){
                int edgesCount = 0;
                Map<Integer, Integer> localVisited = new HashMap<>();
                int node = i;
                while(node != -1){
                    if(localVisited.containsKey(node)){
                        maxPath = Math.max(maxPath, edgesCount-localVisited.get(node));
                        break;
                    }
                    if(visited.contains(node)) break;
                    visited.add(node);
                    localVisited.put(node, edgesCount++);
                    node = edges[node];
                }
            }
        }
        return maxPath;
    }
}
