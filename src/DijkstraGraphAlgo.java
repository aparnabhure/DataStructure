import java.util.*;

/*
Given a weighted undirected graph having A nodes and M weighted edges, and a source node C.

You have to find an integer array D of size A such that:

=> D[i] : Shortest distance form the C node to node i.

=> If node i is not reachable from C then -1.

Note:

There are no self-loops in the graph.

No multiple edges between two pair of vertices.

The graph may or may not be connected.

Nodes are numbered from 0 to A-1.

Your solution will run on multiple testcases. If you are using global variables make sure to clear them.



Problem Constraints

1 <= A <= 1e5

0 <= B[i][0],B[i][1] < A

0 <= B[i][2] <= 1e3

0 <= C < A



Input Format

The first argument given is an integer A, representing the number of nodes.

The second argument given is the matrix B of size M x 3, where nodes B[i][0] and B[i][1] are connected with an edge of weight B[i][2].

The third argument given is an integer C.



Output Format

Return the integer array D.



Example Input

Input 1:

A = 6
B = [   [0, 4, 9]
        [3, 4, 6]
        [1, 2, 1]
        [2, 5, 1]
        [2, 4, 5]
        [0, 3, 7]
        [0, 1, 1]
        [4, 5, 7]
        [0, 5, 1] ]
C = 4

Input 2:

A = 5
B = [   [0, 3, 4]
        [2, 3, 3]
        [0, 1, 9]
        [3, 4, 10]
        [1, 3, 8]  ]
C = 4



Example Output

Output 1:

D = [7, 6, 5, 6, 0, 6]

Output 2:

D = [14, 18, 13, 10, 0]

 */
public class DijkstraGraphAlgo {
    public static void main(String[] args) {
        PrintUtil.print(solve(7, new int[][]{{2, 4, 10}, {3, 4, 1}, {3, 6, 1}, {1, 2, 4}, {4, 5, 6}},2));
        PrintUtil.print(solve(6,new int[][]{{0, 4, 9}, {3, 4, 6}, {1, 2, 1}, {2, 5, 1}, {2, 4, 5}, {0, 3, 7}, {0, 1, 1},{4, 5, 7}, {0, 5, 1}},4));
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
    static int[] ans;
    static int[] solve(int A, int[][] B, int C) {
        graph =new HashMap<>();
        for(int[] i:B){
            int x=i[0];
            int y=i[1];
            int w = i[2];
            Set<Pair> pairs = graph.getOrDefault(x, new HashSet<>());
            pairs.add(new Pair(y, w));
            graph.put(x, pairs);

            pairs = graph.getOrDefault(y, new HashSet<>());
            pairs.add(new Pair(x, w));
            graph.put(y, pairs);
        }

        ans = new int[A];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[C]=0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(x->x.weight));
        pq.add(new Pair(C, 0));
        Set<Integer> visited =new HashSet<>();

        while (!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.node;
            if(visited.contains(node)) continue;
            visited.add(node);

            int distance = p.weight;
            for(Pair child: graph.getOrDefault(node, new HashSet<>())){
                if(distance+ child.weight < ans[child.node]){
                    ans[child.node] = distance+ child.weight;
                    pq.add(new Pair(child.node, ans[child.node]));
                }
            }
        }
        for(int i=0; i<A; i++){
            if(ans[i]== Integer.MAX_VALUE) ans[i]=-1;
        }

        return ans;
    }
}
