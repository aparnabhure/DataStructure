import java.util.*;

/*
https://leetcode.com/contest/biweekly-contest-93/problems/maximum-star-sum-of-a-graph/
 */
public class MaxStarSumGraph {
    public static void main(String[] args) {
        System.out.println(maxStarSum(new int[]{1,2,3,4,10,-10,-20}, new int[][]{{0,1},{1,2},{1,3},{3,4},{3,5},{3,6}}, 2));
    }

    static Map<Integer, List<Integer>> graph;
    static int maxStarSum(int[] vals, int[][] edges, int k) {
        graph = new HashMap<>();
        for(int[] edge: edges){
            int x = edge[0];
            int y = edge[1];
            List<Integer> nodes = graph.getOrDefault(x, new ArrayList<>());
            nodes.add(y);
            graph.put(x, nodes);

            nodes = graph.getOrDefault(y, new ArrayList<>());
            nodes.add(x);
            graph.put(y, nodes);
        }

        int max = Integer.MIN_VALUE;

        for(int i=0; i<vals.length; i++){
            int m = vals[i];
            int sum = vals[i];
            List<Integer> neb = graph.getOrDefault(i, new ArrayList<>());
            neb.sort((a, b) -> vals[b]-vals[a]);
            for(int j = 0; j < k && j < neb.size(); j++){
                sum += vals[neb.get(j)];
                m = Math.max(m, sum);
            }
            max = Math.max(max, m);

        }

        return max;
    }
}
