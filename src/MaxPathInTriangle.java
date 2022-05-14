//https://www.geeksforgeeks.org/maximum-path-sum-triangle/
public class MaxPathInTriangle {
    public static void main(String[] args) {
        int[][] A = new int[][]{  {1, 0, 0},
                {4, 8, 0},
                {1, 5, 3} };
        System.out.println(findPathSum(A, 0, 0, 3, 3));
        System.out.println(findSum(A, 3, 3));

        A = new int[][]{  {3, 0, 0, 0},
                {7, 4, 0, 0},
                {2, 4, 6, 0},
                {8, 5, 9, 3} };
        System.out.println(findPathSum(A, 0, 0, 4, 4));
        System.out.println(findSum(A, 4, 4));

        A = new int[][]{{38, 0, 0, 0},
                {4, 4, 0, 0},
                {2, 2, 6, 0},
                {1, 1, 1, 1} };
        System.out.println(findPathSum(A, 0, 0, 4, 4));
        System.out.println(findSum(A, 4, 4));
    }

    //Brute force way
    static int findPathSum(int[][] A, int i, int j, int rows, int cols){
        if(j == cols){
            return 0;
        }

        if(i==rows-1){
            return A[i][j];
        }

        return A[i][j] + Math.max(findPathSum(A, i+1, j, rows, cols), findPathSum(A, i+1, j+1, rows, cols));
    }

    //O(M*N) other approach with saving max sum
    static int findSum(int[][] A, int rows, int cols){
        //Bottom up approach
        for(int i = rows-2; i>=0; i--){
            for(int j=0; j<=i; j++){
                if(A[i+1][j] > A[i+1][j+1]){
                    A[i][j] += A[i+1][j];
                }else{
                    A[i][j] += A[i+1][j+1];
                }
            }
        }
        return A[0][0];
    }
}
