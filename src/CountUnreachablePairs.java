import java.util.*;

//https://leetcode.com/contest/biweekly-contest-81/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/
public class CountUnreachablePairs {
    public static void main(String[] args) {
        System.out.println(countPairs(5, new int[][]{{1,0},{3,1},{0,4},{2,1}}));//ans = 0
        System.out.println(countPairs(7, new int[][]{{0,2},{0,5},{2,4},{1,6},{5,4}}));
        System.out.println(countPairs(3, new int[][]{{0,1},{0,2},{1,2}}));
    }

    static long countPairs(int n, int[][] edges) {
        Map<Integer, Set<Integer>> edgeMap = new HashMap<>();
        for (int[] e : edges) {
            int x = e[0];
            int y = e[1];
            Set<Integer> list = edgeMap.getOrDefault(x, new HashSet<>());
            list.add(y);
            edgeMap.put(x, list);

            list = edgeMap.getOrDefault(y, new HashSet<>());
            list.add(x);
            edgeMap.put(y, list);
        }


        Set<Integer> visited = new HashSet<>();
        int totalCounts =0;
        for(int i=0; i<n; i++) {
            if(!visited.contains(i)) {
                long ans = dfs(visited, edgeMap, i);
                totalCounts += ans * (n-ans); // total connecton * total non connected nodes
            }
        }

        return totalCounts/2; //Remove the j,i pair as i,j == j,i
    }

    static long dfs(Set<Integer> visited, Map<Integer, Set<Integer>> map, int parent){
        visited.add(parent);
        Set<Integer> childSet = map.getOrDefault(parent, new HashSet<>());
        for(Integer child:childSet){
            if(!visited.contains(child)){
                return 1L+ dfs(visited, map, child);
            }
        }

        return 1L;
    }
}
