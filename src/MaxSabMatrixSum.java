public class MaxSabMatrixSum {
    public static void main(String[] args) {
        System.out.println(solve(new int[][]{
            {1, 1, 1, 1, 1},
        {2, 2, 2, 2, 2},
            {3, 8, 6, 7, 3},
                {4, 4, 4, 4, 4},
                    {5, 5, 5, 5, 5}
        }, 3));
    }

    static int solve(int[][] A, int B){
        int row = A.length;
        int col = A[0].length;

        int[][] pf = new int[row+1][col+1];
        int pfRow = pf.length;
        int pfCol = pf[0].length;
        for(int i=1; i<pfRow; i++){
            for(int j=1; j<pfCol; j++){
                pf[i][j] = A[i-1][j-1]+pf[i-1][j]+pf[i][j-1]-pf[i-1][j-1];
            }
        }

        int maxSum = Integer.MIN_VALUE;

        for(int i=1; i<=pfRow-B; i++){
            for(int j=1; j<=pfCol-B; j++){
                int top = i;
                int left = j;
                int bottom = i+B-1;
                int right = j+B-1;
                int v1 = pf[bottom][right];
                int v2 = pf[top-1][right];
                int v3 = pf[bottom][left-1];
                int v4 = pf[top-1][left-1];
                int V = (v1-v2-v3+v4);
                maxSum = Math.max(maxSum, V);
            }
        }

        return maxSum;



    }
}
