import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/atlantic-pacific-water-flow/?ref=gcse
public class WaterFlow {
    public static void main(String[] args) {
        int[][] A = new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        System.out.println(flowCordinates(A));
        A = new int[][]{{2,2},{2,2}};
        System.out.println(flowCordinates(A));
    }

    static class Cell{
        int x;
        int y;
        int value;
        Cell(int x, int y, int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
    static int flowCordinates(int[][] matrix){

        int n = matrix.length;
        int m = matrix[0].length;

        //Prepare Queues for blue lack move and other for red lack
        Queue<Cell> lack1Queue = new LinkedList<>();
        Queue<Cell> lack2Queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i==0 || j == 0){
                    lack1Queue.add(new Cell(i, j, matrix[i][j]));
                }
                if( i == n-1 || j == m-1){
                    lack2Queue.add(new Cell(i, j, matrix[i][j]));
                }
            }
        }

        //Direction matrix
        int[] dx = new int[]{-1,0,0,1};
        int[] dy = new int[]{0,-1,1,0};
        //Prepare visited array as well
        boolean[][] visitedLack1 = new boolean[n][m];
        boolean[][] visitedLack2 = new boolean[n][m];

        // apply BFS multi source - blue lake
        while (!lack1Queue.isEmpty()) {
            Cell cell = lack1Queue.poll();
            // mark visited
            visitedLack1[cell.x][cell.y] = true;

            for (int i = 0; i < dx.length; i++) {
                int x = cell.x + dx[i];
                int y = cell.y + dy[i];
                boolean isSafe = x >= 0 && y >= 0 && x < n && y < m;
                if (isSafe && cell.value <= matrix[x][y] && !visitedLack1[x][y]) {
                    lack1Queue.add(new Cell(x, y, matrix[x][y]));
                }
            }
        }

        // apply BFS multi source - red lake
        while (!lack2Queue.isEmpty()) {
            Cell cell = lack2Queue.poll();
            // mark visited
            visitedLack2[cell.x][cell.y] = true;

            for (int i = 0; i < dx.length; i++) {
                int x = cell.x + dx[i];
                int y = cell.y + dy[i];
                boolean isSafe = x >= 0 && y >= 0 && x < n && y < m;
                if (isSafe && cell.value <= matrix[x][y] && !visitedLack2[x][y]) {
                    lack2Queue.add(new Cell(x, y, matrix[x][y]));
                }
            }
        }

            // find the count of common elements from both visited arrays
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (visitedLack1[i][j] && visitedLack2[i][j]) {
                        count++;
                    }
                }
            }
            return count;
    }
}
