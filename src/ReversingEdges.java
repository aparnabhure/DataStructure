import java.util.*;

/*
Given a directed graph with A nodes and M edges.
Find the minimum number of edges that needs to be reversed in order to reach node A from node 1.


Problem Constraints

1 <= A, M <= 10 5
1 <= B[i][0], B[i][1] <= A
There can be multiple edges or self loops (B[i][0] = B[i][1])


Input Format

The first argument is an integer A, denoting the number of nodes in the graph.
The second argument is a 2D integer array B, denoting the directed edges in the graph.


Output Format

Return a single integer denoting the minimum number of edges to be reversed.


Example Input

Input 1:

A = 5
B = [[1, 2],
     [2, 3],
     [4, 3],
     [4, 5]]

Input 2:

A = 5
B = [[1, 2],
     [2, 3],
     [3, 4],
     [4, 5]]



Example Output

Output 1:

1

Output 2:

0

 */
public class ReversingEdges {
    public static void main(String[] args) {
        ArrayList<List<Integer>> B = new ArrayList<>();
        B.add(Arrays.asList(1,2));
        B.add(Arrays.asList(2, 3));
        B.add(Arrays.asList(4, 3));
        B.add(Arrays.asList(4, 5));
        System.out.println(reverseEdges(5, B));
    }

    static class Pair{
        int node;
        int weight;
        public Pair(int node,int weight){
            this.node = node;
            this.weight =weight;
        }
    }
    static Map<Integer, Set<Pair>> graph;
    static int reverseEdges(int A, ArrayList<List<Integer>> B) {
        graph = new HashMap<>();
        for(List<Integer> i:B){
            int x= i.get(0);
            int y = i.get(1);
            Set<Pair> pairs = graph.getOrDefault(x, new HashSet<>());
            pairs.add(new Pair(y, 0));
            graph.put(x,pairs);
            //Add opposite with 1 weight
            pairs = graph.getOrDefault(y, new HashSet<>());
            pairs.add(new Pair(x, 1));
            graph.put(y, pairs);
        }

        int[] ans = new int[A+1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(x->x.weight));
        pq.add(new Pair(1, 0));

        while (!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.node;
            int distance = p.weight;
            if(ans[node] == Integer.MAX_VALUE) {
                ans[node] = distance;
                for (Pair child : graph.getOrDefault(node, new HashSet<>())) {
                    if (ans[child.node] == Integer.MAX_VALUE) {
                        pq.add(new Pair(child.node, child.weight+distance));
                    }
                }
            }
        }

        return ans[A]==Integer.MAX_VALUE?-1:ans[A];

    }
}
