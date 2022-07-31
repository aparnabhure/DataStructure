import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/contest/weekly-contest-304/problems/find-closest-node-to-given-two-nodes/
public class FindClosestNodetoGivenTwoNodes {
    public static void main(String[] args) {
        System.out.println(closestMeetingNode(new int[]{2,2,3,-1}, 0, 2));
    }

    static int closestMeetingNode(int[] edges, int node1, int node2) {
        Map<Integer, Integer> graph = new HashMap<>();
        int node = node1;
        int distance = 0;
        while(!graph.containsKey(node) && node >-1){
            graph.put(node, distance++);
            node = edges[node];
        }

        int ans = -1;
        node = node2;
        distance = 0;
        int min = Integer.MAX_VALUE;
        Set<Integer> visited = new HashSet<>();
        while(!visited.contains(node) && node>-1){
            if(graph.containsKey(node)){
                int curr = Math.max(distance, graph.get(node));
                if(ans == -1 || curr<=min){
                    ans = curr==min ? Math.min(ans, node) : node;
                    min = curr;
                }
            }
            distance++;
            visited.add(node);
            node = edges[node];
        }
        return ans;

    }
}
