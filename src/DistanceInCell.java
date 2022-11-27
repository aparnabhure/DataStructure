import java.util.LinkedList;
import java.util.Queue;

/*
Given a matrix of integers A of size N x M consisting of 0 or 1.

For each cell of the matrix find the distance of nearest 1 in the matrix.

Distance between two cells (x1, y1) and (x2, y2) is defined as |x1 - x2| + |y1 - y2|.

Find and return a matrix B of size N x M which defines for each cell in A distance of nearest 1 in the matrix A.

NOTE: There is atleast one 1 is present in the matrix.



Problem Constraints

1 <= N, M <= 1000

0 <= A[i][j] <= 1



Input Format

The first argument given is the integer matrix A.



Output Format

Return the matrix B.



Example Input

Input 1:

 A = [
       [0, 0, 0, 1]
       [0, 0, 1, 1]
       [0, 1, 1, 0]
     ]

Input 2:

 A = [
       [1, 0, 0]
       [0, 0, 0]
       [0, 0, 0]
     ]



Example Output

Output 1:

 [
   [3, 2, 1, 0]
   [2, 1, 0, 0]
   [1, 0, 0, 1]
 ]

Output 2:

 [
   [0, 1, 2]
   [1, 2, 3]
   [2, 3, 4]
 ]



Example Explanation

Explanation 1:

 A[0][0], A[0][1], A[0][2] will be nearest to A[0][3].
 A[1][0], A[1][1] will be nearest to A[1][2].
 A[2][0] will be nearest to A[2][1] and A[2][3] will be nearest to A[2][2].

Explanation 2:

 There is only a single 1. Fill the distance from that 1.
 */
public class DistanceInCell {
    public static void main(String[] args) {
        PrintUtil.print(solve(new int[][]{{0, 0, 0, 1}, {0, 0, 1, 1}, {0, 1, 1, 0}}));
    }

    static int[][] ans;
    static int[][] solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        ans = new int[n][m];
        //bfs
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j =0; j<m; j++){
                if(A[i][j] == 1)
                    queue.add(new int[]{i,j});
            }
        }

        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int i = cell[0];
            int j = cell[1];
            updateDistance(i,j,n, m, A, queue);
        }

        return ans;
    }
    static void updateDistance(int i, int j, int n, int m, int[][] A,  Queue<int[]> queue){
        //up
        if(i>0 && A[i-1][j]==0 && ans[i-1][j] == 0){
            ans[i-1][j] = ans[i][j]+1;
            queue.add(new int[]{i-1, j});
        }

        //down
        if(i<n-1 && A[i+1][j] == 0 && ans[i+1][j]==0){
            ans[i+1][j]=ans[i][j]+1;
            queue.add(new int[]{i+1, j});
        }

        //left
        if(j>0 && A[i][j-1] == 0 && ans[i][j-1]==0){
            ans[i][j-1] =ans[i][j]+1;
            queue.add(new int[]{i, j-1});
        }

        //right
        if(j<m-1 && A[i][j+1] == 0 && ans[i][j+1]==0){
            ans[i][j+1]= ans[i][j]+1;
            queue.add(new int[]{i, j+1});
        }
    }
}
