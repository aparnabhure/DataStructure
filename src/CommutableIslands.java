import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
There are A islands and there are M bridges connecting them. Each bridge has some cost attached to it.

We need to find bridges with minimal cost such that all islands are connected.

It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.



Problem Constraints
1 <= A, M <= 6*104

1 <= B[i][0], B[i][1] <= A

1 <= B[i][2] <= 103



Input Format
The first argument contains an integer, A, representing the number of islands.

The second argument contains an 2-d integer matrix, B, of size M x 3 where Island B[i][0] and B[i][1] are connected using a bridge of cost B[i][2].



Output Format
Return an integer representing the minimal cost required.



Example Input
Input 1:

 A = 4
 B = [  [1, 2, 1]
        [2, 3, 4]
        [1, 4, 3]
        [4, 3, 2]
        [1, 3, 10]  ]
Input 2:

 A = 4
 B = [  [1, 2, 1]
        [2, 3, 2]
        [3, 4, 4]
        [1, 4, 3]   ]


Example Output
Output 1:

 6
Output 2:

 6
 */
public class CommutableIslands {
    //Kruskal's Algo
    public static void main(String[] args) {
        System.out.println(solve(4, new int[][]{{1, 2, 1},
            {2, 3, 4},
            {1, 4, 3},
            {4, 3, 2},
            {1, 3, 10}}));
        System.out.println(solve(4, new int[][]{{1, 2, 1},
            {2, 3, 2},
            {3, 4, 4},
            {1, 4, 3}}));
    }

    static class Node{
        int x;
        int y;
        int cost;
        public Node(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    static int findParent(int node, int[] parents){
        if(node == parents[node]) return node;
        parents[node] = findParent(parents[node], parents);
        return parents[node];
    }

    static int solve(int A, int[][] B) {

        List<Node> list = new ArrayList<>();
        for(int[] i:B){
            list.add(new Node(i[0], i[1], i[2]));
        }
        list.sort(Comparator.comparingInt(o -> o.cost));

        int[] parents = new int[A+1];
        for(int i=1; i<=A; i++){
            parents[i] = i;
        }

        /*loop through sorted adjacency list and extract vertices x, y and cost. Find the parent of x and y,
        if they belong to diff parent consider taking that edge (Union) and replace the parent of higher node
        with smaller node's parent.*/

        int minCost = 0;
        for(Node node: list){
            int parentX = findParent(node.x, parents);
            int parentY = findParent(node.y, parents);
            if(parentX != parentY){
                parents[Math.max(parentX, parentY)] = parents[Math.min(parentX, parentY)];
                minCost += node.cost;
            }
        }

        return minCost;

    }
}
