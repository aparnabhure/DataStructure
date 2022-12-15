import java.util.*;

/*https://leetcode.com/contest/weekly-contest-322/problems/minimum-score-of-a-path-between-two-cities/*/
public class MinScoreInPath {
    public static void main(String[] args) {
        System.out.println(minScore(4, new int[][]{{1,2,9},{2,3,6},{2,4,5},{1,4,7}}));
        System.out.println(minScore(4, new int[][]{{1,2,2},{1,3,4},{3,4,7}}));
    }
    static class Node{
        int start;
        int end;
        int distance;
        Node(int start, int end, int distance){
            this.start = start;
            this.end = end;
            this.distance = distance;
        }

    }

    static Map<Integer, List<Node>> graph;
    static int ans;
    static int minScore(int n, int[][] roads) {
        graph =new HashMap<>();
        ans = Integer.MAX_VALUE;
        for(int[] road:roads){
            int x = road[0];
            int y = road[1];
            int d = road[2];
            List<Node> list = graph.getOrDefault(x, new ArrayList<>());
            list.add(new Node(x,y,d));
            graph.put(x, list);
            list = graph.getOrDefault(y, new ArrayList<>());
            list.add(new Node(y,x,d));
            graph.put(y, list);
        }
        Set<Integer> visited = new HashSet<>();
        minDistance(1, n, visited);
        return ans;

    }

    static void minDistance(int parent, int destination, Set<Integer> visited){
        if(visited.contains(parent)) return;

        visited.add(parent);
        for(Node node: graph.getOrDefault(parent, new ArrayList<>())){
            ans = Math.min(ans, node.distance);
            minDistance(node.end, destination, visited);
        }
    }
}
