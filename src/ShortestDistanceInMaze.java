import java.util.*;

/*
Given a matrix of integers A of size N x M describing a maze. The maze consists of empty locations and walls.

1 represents a wall in a matrix and 0 represents an empty location in a wall.

There is a ball trapped in a maze. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall (maze boundary is also considered as a wall). When the ball stops, it could choose the next direction.

Given two array of integers of size B and C of size 2 denoting the starting and destination position of the ball.

Find the shortest distance for the ball to stop at the destination. The distance is defined by the number of empty spaces traveled by the ball from the starting position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.



Problem Constraints

2 <= N, M <= 100

0 <= A[i] <= 1

0 <= B[i][0], C[i][0] < N

0 <= B[i][1], C[i][1] < M



Input Format

The first argument given is the integer matrix A.

The second argument given is an array of integer B.

The third argument if an array of integer C.



Output Format

Return a single integer, the minimum distance required to reach destination



Example Input

Input 1:

A = [ [0, 0], [0, 0] ]
B = [0, 0]
C = [0, 1]

Input 2:

A = [ [0, 0], [0, 1] ]
B = [0, 0]
C = [0, 1]



Example Output

Output 1:

 1

Output 2:

 1



 */
public class ShortestDistanceInMaze {
    public static void main(String[] args) {
        System.out.println(solve(new int[][]{{1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1},
                {0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1},
                {0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0},
                {0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1},
                {1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0},
                {0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0},
                {0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1},
                {1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1},
                {0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1},
                {1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        }, new int[]{16, 10}, new int[]{17, 13}));
        System.out.println(solve(new int[][]{{1, 1, 0, 1}, {0, 0, 0, 1}, {1, 0, 0, 1}, {0, 0, 1, 0}}, new int[]{1, 1}, new int[]{2, 1}));
        System.out.println(solve(new int[][]{{0, 0}, {0, 0}}, new int[]{0,0},new int[]{0,1}));
    }

    enum Direction{
        UP(-1, 0),
        DOWN(1,0),
        LEFT(0,-1),
        RIGHT(0,1);
        final int x;
        final int y;
        Direction(int x, int y){
            this.x =x;
            this.y = y;
        }
    }

    static class Node{
        int x, y, count;
        Direction direction;
        public Node(int x, int y, Direction direction, int count){
            this.x = x; this.y =y; this.direction = direction; this.count = count;
        }
    }

    static class VisitedDirection{
        Map<Direction, Boolean> dir;
        public VisitedDirection(){
            dir = new HashMap<>();
            for(Direction direction: Direction.values()){
                dir.put(direction, false);
            }
        }
    }

    static boolean isValid(int[][] A, int u, int v, Direction dir) {
        if(dir == Direction.LEFT && (v - 1 == -1 || A[u][v - 1] == 1)) return true;
        if(dir == Direction.RIGHT && (v + 1 == A[0].length || A[u][v + 1] == 1)) return true;
        if(dir == Direction.UP && (u - 1 == -1 || A[u-1][v] == 1)) return true;
        if(dir == Direction.DOWN && (u + 1 == A.length || A[u+1][v] == 1)) return true;
        return false;
    }

    static int solve(int[][] A, int[] B, int[] C) {
        int n = A.length;
        int m = A[0].length;

        VisitedDirection[][] visitedDirections = new VisitedDirection[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                visitedDirections[i][j] = new VisitedDirection();
            }
        }

        int ans = Integer.MAX_VALUE;
        Queue<Node> queue = new LinkedList<>();
        for(Direction direction:Direction.values()){
            int u = B[0] + direction.x;
            int v = B[1] + direction.y;
            if(u >= 0 && u < n && v >= 0 && v < m && A[u][v] == 0) {
                queue.add(new Node(u, v, direction, 1));
            }
        }

        while (!queue.isEmpty()){
            Node node = queue.poll();
            if(node.x == C[0]&& node.y == C[1] && isValid(A, node.x, node.y, node.direction)){
                ans = Math.min(ans, node.count);
                continue;
            }
            //Mark direction as visited
            Direction direction = node.direction;
            visitedDirections[node.x][node.y].dir.put(direction, true);

            int x = node.x+ direction.x;
            int y = node.y+ direction.y;

            if(x >= 0 && x < n && y >= 0 && y < m && A[x][y] == 0 && !visitedDirections[x][y].dir.get(direction)) {
                queue.add(new Node(x, y, direction, node.count + 1));
            }else{
                for(Direction dir: Direction.values()){
                    if(dir != direction){
                        int x1 = node.x + dir.x;
                        int y1 = node.y + dir.y;
                        if(x1 >= 0 && x1 < n && y1 >= 0 && y1 < m && A[x1][y1] == 0 && !visitedDirections[x1][y1].dir.get(dir)) {
                            queue.add(new Node(x1, y1, dir, node.count + 1));
                        }
                    }
                }
            }
        }

        return ans==Integer.MAX_VALUE?-1:ans;


    }

}
