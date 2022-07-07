//https://leetcode.com/contest/weekly-contest-300/problems/number-of-increasing-paths-in-a-grid/
public class StrictlyIncreasingPathInMatrix {
    public static void main(String[] args) {
        //DP & DFS approach :: for each cell check if how many neighbour (left,right,top,left) are contributing to the cell to become increasing cell ie cell[i][j] is > than neighbours
        System.out.println(countPaths(new int[][]{{1,1},{3,4}}));
    }

    static int mod = 1000000007;
    static int countPaths(int[][] grid) {

        long ans = 0;
        int rows = grid.length;
        int col = grid[0].length;
        long[][] dp =new long[rows][col];
        for(int i=0; i<rows; i++){
            for(int j=0; j<col; j++){
                ans = (ans + dfs(dp, grid, i, j, 0))%mod;
            }
        }
        return (int)ans;

    }

    static long dfs(long[][] dp, int[][] grid, int i, int j, int preVal){
        int rows = grid.length;;
        int col = grid[0].length;
        if(i<0 || i>=rows || j <0 || j>=col) return 0;
        if(grid[i][j]<=preVal) return 0;
        if(dp[i][j]>0) return dp[i][j];
        dp[i][j] = 1;
        long left = dfs(dp,grid, i, j-1, grid[i][j]);
        long right = dfs(dp, grid, i, j+1, grid[i][j]);
        long top = dfs(dp,grid, i-1, j, grid[i][j]);
        long bottom = dfs(dp,grid, i+1, j, grid[i][j]);

        dp[i][j] = (dp[i][j] +left+right+top+bottom)%mod;

        return dp[i][j];
    }
}
