import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class DijsktraGraphAlgo {
    public static void main(String[] args) {
        //Shortest distance from Source C to each node

        solve(6,new int[][]{{0, 4, 9},{3, 4, 6},{1, 2, 1},{2, 5, 1},{2, 4, 5},{0, 3, 7},{0, 1, 1},{4, 5, 7},{0, 5, 1},}, 4);
    }

    static class Pair{
        int node;
        int weight;
        public Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }

    static Map<Integer, List<Pair>> graph;
    static int[] solve(int A, int[][] B, int C) {

        int[] result = new int[A];

        graph = new HashMap<>();
        for(int[] g: B){
            int start = g[0];
            int end = g[1];
            int weight = g[2];
            List<Pair> pairs = graph.getOrDefault(start, new ArrayList<>());
            pairs.add(new Pair(end, weight));
            graph.put(start, pairs);

            pairs = graph.getOrDefault(end, new ArrayList<>());
            pairs.add(new Pair(start, weight));
            graph.put(end, pairs);
        }

        Arrays.fill(result, Integer.MAX_VALUE);
        result[C] = 0;
        PriorityQueue<Pair> queue= new PriorityQueue<>(Comparator.comparingInt(x -> x.weight));
        queue.add(new Pair(0,C));

        while(!queue.isEmpty()){
            int dist = queue.peek().node;
            int node = queue.peek().weight;
            queue.remove();
            List<Pair> pairs = graph.getOrDefault(node, new ArrayList<>());
            for(Pair p:pairs){
                int edgeweight = p.weight;
                int adjNode = p.node;
                if(dist+edgeweight<result[adjNode]){
                    result[adjNode]=dist+edgeweight;
                    queue.add(new Pair(result[adjNode],adjNode));
                }
            }
        }

        for (int i=0;i<A;i++){
            if(result[i]==Integer.MAX_VALUE){
                result[i]=-1;
            }
        }

        return result;
    }
}
