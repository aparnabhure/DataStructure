//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/submissions/
public class LongestIncreasingPath {
    public static void main(String[] args) {
        System.out.println(longestIncreasingPath(new int[][]{{9,9,4},{6,6,8},{2,1,1}}));
    }
    static int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];

        int longestPath = 0;

        for(int i =0; i<rows;i++){
            for(int j=0; j<cols; j++){
                longestPath = Math.max(longestPath, dfs(dp, matrix, i, j, rows, cols));
            }
        }

        return longestPath;

    }

    static int dfs(int[][] dp, int[][] matrix, int i, int j, int rows, int cols){
        //Check boundaries
        if(i<0 || i>=rows || j<0 || j>=cols) return 0;

        if(dp[i][j] >0) return dp[i][j];

        int currentLength = 1;
        int length = 0;
        //Left
        if(isInBoundaries(rows, cols, i, j-1)){
            if(matrix[i][j] < matrix[i][j-1]){
                length = (1+dfs(dp, matrix, i, j-1, rows, cols));
            }
        }
        currentLength = Math.max(currentLength, length);

        //right
        if(isInBoundaries(rows, cols, i, j+1)){
            if(matrix[i][j] < matrix[i][j+1]){
                length = (1+dfs(dp, matrix, i, j+1, rows, cols));
            }
        }
        currentLength = Math.max(currentLength, length);

        //top
        if(isInBoundaries(rows, cols, i-1, j)){
            if(matrix[i][j] < matrix[i-1][j]){
                length = (1+dfs(dp, matrix, i-1, j, rows, cols));
            }
        }
        currentLength = Math.max(currentLength, length);

        //bottom
        if(isInBoundaries(rows, cols, i+1, j)){
            if(matrix[i][j] < matrix[i+1][j]){
                length = (1+dfs(dp, matrix, i+1, j, rows, cols));
            }
        }
        currentLength = Math.max(currentLength, length);

        dp[i][j] = currentLength;

        return currentLength;
    }

    static boolean isInBoundaries(int rows, int cols, int i, int j){
        return !(i<0 || i>=rows || j<0 || j>=cols);
    }
}
