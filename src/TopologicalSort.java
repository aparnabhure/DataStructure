import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/*
Given an directed acyclic graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].

Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.

Return the topological ordering of the graph and if it doesn't exist then return an empty array.

If there is a solution return the correct ordering. If there are multiple solutions print the lexographically smallest one.

Ordering (a, b, c) is said to be lexographically smaller than ordering (e, f, g) if a < e or if(a==e) then b < f and so on.

NOTE:

There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.


Problem Constraints
2 <= A <= 104

1 <= M <= min(100000,A*(A-1))

1 <= B[i][0], B[i][1] <= A



Input Format
The first argument given is an integer A representing the number of nodes in the graph.

The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].



Output Format
Return a one-dimensional array denoting the topological ordering of the graph and it it doesn't exist then return empty array.



Example Input
Input 1:

 A = 6
 B = [  [6, 3]
        [6, 1]
        [5, 1]
        [5, 2]
        [3, 4]
        [4, 2] ]
Input 2:

 A = 3
 B = [  [1, 2]
        [2, 3]
        [3, 1] ]


Example Output
Output 1:

 [5, 6, 1, 3, 4, 2]
Output 2:

 []
 */
public class TopologicalSort {
    public static void main(String[] args) {
        PrintUtil.print(solve(4, new int[][]{{1, 2},
            {2, 3},
            {2, 4},
            {3, 4},
            {4, 1}}));
        PrintUtil.print(solve(6, new int[][]{{6, 3},
            {6, 1},
            {5, 1},
            {5, 2},
            {3, 4},
            {4, 2}}));
    }

    static int[] solve(int A, int[][] B) {
        int[] indegree = new int[A+1];
        Map<Integer, List<Integer>>  graph = new HashMap<>();

        for(int[] i: B){
            int x=i[0];
            int y = i[1];
            List<Integer> set = graph.getOrDefault(x, new ArrayList<>());
            set.add(y);
            graph.put(x, set);
            indegree[y]++;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=1;i<=A; i++){
            if(indegree[i] == 0) queue.add(i);
        }

        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            int node = queue.poll();
            list.add(node);
            for(int child: graph.getOrDefault(node, new ArrayList<>())){
                indegree[child]--;
                if(indegree[child] == 0){
                    queue.add(child);
                }
            }
        }
        if(list.size()<A) return new int[]{};

        return list.stream().mapToInt(i->i).toArray();

    }
}
