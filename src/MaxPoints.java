import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

/*https://leetcode.com/contest/weekly-contest-323/problems/maximum-number-of-points-from-grid-queries/

 */
public class MaxPoints {
    public static void main(String[] args) {
        PrintUtil.print(maxPoints(new int[][]{{1,2,3},{2,5,7},{3,5,1}}, new int[]{5,6,2}));
    }
    static class Cell{
        int i;
        int j;
        int val;
        public Cell(int i, int j, int val){
            this.i = i; this.j = j; this.val=val;
        }
    }
    static int[][] dx = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
    static int[] maxPoints(int[][] grid, int[] queries) {

        int n = grid.length;
        int m = grid[0].length;
        TreeMap<Integer, Integer> points = new TreeMap<>();
        PriorityQueue<Cell> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        queue.add(new Cell(0,0, grid[0][0]));
        int p = 0;
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;

        while(!queue.isEmpty()){
            int query = queue.peek().val+1;

            while(!queue.isEmpty() && queue.peek().val <query){
                Cell cl = queue.poll();
                int row = cl.i;
                int col = cl.j;
                p++;
                for(int[] d:dx){
                    int r = row+d[0];
                    int c = col+d[1];
                    if(r>=0 && r<n && c>=0 && c<m && !visited[r][c]){
                        visited[r][c]=true;
                        queue.add(new Cell(r,c,grid[r][c]));
                    }
                }

            }

            points.put(query, p);

        }


        int q = queries.length;
        int[] ans = new int[q];

        for(int i=0; i<q; i++){
            Integer key = points.floorKey(queries[i]);
            if (key != null) {
                ans[i] = points.get(key);
            } else {
                ans[i] = 0;
            }
        }

        return ans;

    }
}
