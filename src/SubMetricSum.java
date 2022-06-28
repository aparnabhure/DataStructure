/*
Problem Description
Given a matrix of integers A of size N x M and multiple queries Q, for each query, find and return the submatrix sum.

Inputs to queries are top left (b, c) and bottom right (d, e) indexes of submatrix whose sum is to find out.

NOTE:

Rows are numbered from top to bottom, and columns are numbered from left to right.
Sum may be large, so return the answer mod 109 + 7.


Problem Constraints
1 <= N, M <= 1000
-100000 <= A[i] <= 100000
1 <= Q <= 100000
1 <= B[i] <= D[i] <= N
1 <= C[i] <= E[i] <= M
 */
public class SubMetricSum {
    public static void main(String[] args) {
        int[][] A = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[] B = new int[]{1,2};
        int[] C = new int[]{1,2};
        int[] D = new int[]{2,3};
        int[] E = new int[]{2,3};
        int[] result = solve(A, B, C, D, E);
        print(result);
    }

    static void print(int[] result){
        for(int i:result){
            System.out.print(i+" ");
        }
    }
    static int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {

        //Prefix submatrix sum
        //Column wide sum first and then row wise sum
        int row = A.length;
        int col = A[0].length;

        int[][] pf = new int[row][col];
        int mod = 1000000007;
        for(int i=0; i<col; i++){
            pf[0][i] = A[0][i];
            for(int j=1; j<row; j++){
                int X = (pf[j-1][i] + A[j][i])%mod;
                if(X < 0) {
                    X = (X + mod) % mod;
                }

                pf[j][i] = X;
            }
        }

        for(int i=1; i<col; i++){
            for(int j=0; j<row; j++){
                int X = (pf[j][i] + pf[j][i-1])%mod;
                if(X < 0) {
                    X = (X + mod) % mod;
                }
                pf[j][i] = X;
            }
        }


        int q = B.length;

        int[] result = new int[q];

        for(int i=0; i<q; i++){
            int top = B[i]-1;
            int left = C[i]-1;
            int bottom = D[i]-1;
            int right = E[i]-1;

            int v1 = pf[bottom][right];
            int v2 = top==0?0:pf[top-1][right];
            int v3 = left==0?0:pf[bottom][left-1];
            int v4 = (left==0||top==0)?0:pf[top-1][left-1];
            int V = (v1-v2-v3+v4)%mod;
            if(V < 0) {
                V = (V+mod)%mod;
            }
            result[i] = V;
        }

        return result;

    }
}
