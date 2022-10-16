public class VerticalHorizontalSumBacktracking {
/*
Given a matrix B, of size N x M, you are allowed to do at most A special operations on this grid such that there is no vertical or horizontal contiguous subarray that has a sum greater than C.

A special operation involves multiplying any element by -1 i.e. changing its sign.

Return 1 if it is possible to achieve the answer, otherwise 0.



Problem Constraints

1 <= N, M <= 10

0 <= A <= 5

-105 <= B[i][j], C <= 105



Input Format

The first argument is an integer A, representing the number of special operations allowed.
The second argument has the N x M integer matrix, B.
The third argument is an integer C, as described in the problem statement.



Output Format

Return 1 if it is possible to achieve the answer, otherwise 0.



Example Input

Input 1:

 A = 3
 B = [
        [1, 1, 1]
        [1, 1, 1]
        [1, 1, 1]
     ]
 C = 2
Input 2:

 A = 1
 B = [
        [1, 1, 1]
        [1, 1, 1]
        [1, 1, 1]
     ]
 C = 2


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explanation 1:

 The given matrix does not satisfy the conditions, but if we apply the special operation to B[0][0], B[1][1], B[2][2],
 then the matrix would satisfy the given conditions i.e. no row or column has a sum greater than 2.
Explanation 2:

 It is not possible to apply the special operation to 1 element to satisfy the conditions.
 */

    public static void main(String[] args) {
        System.out.println(solve(5, new int[][]{{-7, -3, -6}, {-2, -10, -3},{ 5, -4, -6}, {-4, 7, -4}} , 7));
    }

    static int solve(int A, int[][] B, int C) {
        int rows = B.length;
        int cols = B[0].length;
        return check(B, 0, 0, A, 0, rows, cols, C, new int[cols])?1:0;
    }


    static boolean check(int[][] B, int r, int c, int op_left, int rsum, int rows, int cols, int C, int[] permutations) {
        if (rsum > C) return false;
        if (rsum < 0) rsum = 0;
        if (c == cols) {
            c = 0;
            r++;
            rsum = 0;
        }
        if (r == rows) {
            for (int x: permutations) {
                if (x > C) return false;
            }
            return true;
        }
        if (permutations[c] > C) return false;
        int old = permutations[c];
        permutations[c] = Math.max(permutations[c] + B[r][c], 0);
        if (check(B, r, c + 1, op_left, rsum + B[r][c], rows, cols, C, permutations))
            return true;
        permutations[c] = old;
        if (op_left > 0) {
            permutations[c] = Math.max(permutations[c] - B[r][c], 0);
            if (check(B, r, c + 1, op_left - 1, rsum - B[r][c], rows, cols, C, permutations)) return true;
            permutations[c] = old;
        }
        return false;
    }
}
