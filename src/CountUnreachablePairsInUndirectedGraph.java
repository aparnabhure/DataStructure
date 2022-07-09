import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/contest/biweekly-contest-81/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/
public class CountUnreachablePairsInUndirectedGraph {
    public static void main(String[] args) {
        System.out.println(totalCounts(5, new int[][]{{1,0},{3,1},{2,1},{0,4}}));
        System.out.println(totalCounts(7, new int[][]{{0,2},{0,5},{2,4},{1,6},{5,4}}));
    }

    static long totalCounts(int n, int[][] edges){
        Map<Integer, Set<Integer>> emap = new HashMap<>();
        for(int[] e:edges){
            int x = e[0];
            int y = e[1];
            Set<Integer> pairs = emap.getOrDefault(x, new HashSet<>());
            pairs.add(y);
            emap.put(x, pairs);

            pairs = emap.getOrDefault(y, new HashSet<>());
            pairs.add(x);
            emap.put(y, pairs);
        }

        long totalPairs = ((long)n*(n-1))/2;
        Set<Integer> visited = new HashSet<>();
        for(int i=0; i<n; i++){
            if(!visited.contains(i)){
                long counts = dfs(emap, visited, i);
                long pairs = ((counts*(counts-1))/2);
                totalPairs -= pairs;
            }
        }

        return totalPairs;

    }

    static long dfs(Map<Integer, Set<Integer>> emap, Set<Integer> visited, int parent){
        visited.add(parent);
        long count = 1;
        Set<Integer> child = emap.getOrDefault(parent, new HashSet<>());
        for(Integer c:child){
            if(!visited.contains(c)){
                count += dfs(emap, visited, c);
            }
        }
        return count;
    }
}
