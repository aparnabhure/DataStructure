import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class NQueens {
    /*
    The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer A, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
The final list should be generated in such a way that the indices of the queens in each list should be in reverse lexicographical order.


Problem Constraints
1 <= A <= 10



Input Format
First argument is an integer n denoting the size of chessboard



Output Format
Return an array consisting of all distinct solutions in which each element is a 2d char array representing a unique solution.



Example Input
Input 1:

A = 4
Input 2:

A = 1


Example Output
Output 1:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Output 1:

[
 [Q]
]


Example Explanation
Explanation 1:

There exist only two distinct solutions to the 4-queens puzzle:
Explanation 1:

There exist only one distinct solutions to the 1-queens puzzle:
     */

    public static void main(String[] args) {
        print(solveNQueensForOrder(4));
        print(solveNQueens(4));
        System.out.println(solve(4));
    }

    static void print(ArrayList<ArrayList<String>> result){
        for(ArrayList<String> r: result){
            System.out.println();
            for(String i:r){
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    static Set<Integer> rowSet = new HashSet<>();
    static Set<Integer> diagonalAttackLeftSide = new HashSet<>();
    static Set<Integer> diagonalAttackUpperSide = new HashSet<>();
    static ArrayList<ArrayList<String>> ans = new ArrayList<>();
    static int[][] board;

    static ArrayList<ArrayList<String>> solveNQueensForOrder(int A) {

        rowSet = new HashSet<>();
        diagonalAttackLeftSide = new HashSet<>();
        diagonalAttackUpperSide = new HashSet<>();
        ans = new ArrayList<>();
        board = new int[A][A];
        find(A, 0);
        return ans;
    }

    static void find(int A, int row){
        if(row == A){
            //add in the ans
            ArrayList<String> currList = new ArrayList<>();
            for(int i=0; i<A; i++) {
                char[] chars = new char[A];
                Arrays.fill(chars, '.');
                for(int j=0; j<A; j++) {
                    if(board[i][j] == 1) {
                        chars[j] = 'Q';
                    }
                }
                currList.add(new String(chars));
            }
            ans.add(currList);
            return;
        }

        for(int col=0; col<A; col++){
            if(rowSet.contains(col) || diagonalAttackLeftSide.contains(col+row)|| diagonalAttackUpperSide.contains(col-row)) continue;
            board[row][col] = 1;
            rowSet.add(col);
            diagonalAttackLeftSide.add(col+row);
            diagonalAttackUpperSide.add(col-row);

            find(A, row+1);

            board[row][col] = 0;
            rowSet.remove(col);
            diagonalAttackLeftSide.remove(col+row);
            diagonalAttackUpperSide.remove(col-row);

        }
    }

    static void solve(int A, int col, ArrayList<Integer> colsPermutations){
        if(col == A){
            count++;
            ArrayList<String> temp = new ArrayList<>();
            for(int c: colsPermutations){
                char[] chars = new char[A];
                Arrays.fill(chars, '.');
                chars[c] = 'Q';
                temp.add(new String(chars));
            }
            Collections.sort(temp);
            ans.add(temp);
            return;
        }

        for(int i=0; i<A; i++){
            if(rowSet.contains(i) || diagonalAttackLeftSide.contains(i+col)|| diagonalAttackUpperSide.contains(i-col)) continue;

            colsPermutations.add(col);
            rowSet.add(i);
            diagonalAttackLeftSide.add(i+col);
            diagonalAttackUpperSide.add(i-col);

            countPositions(A, col+1, colsPermutations);

            colsPermutations.remove(colsPermutations.size()-1);
            rowSet.remove(i);
            diagonalAttackLeftSide.remove(i+col);
            diagonalAttackUpperSide.remove(i-col);
        }
    }

    static ArrayList<ArrayList<String>> solveNQueens(int A) {

        rowSet = new HashSet<>();
        diagonalAttackLeftSide = new HashSet<>();
        diagonalAttackUpperSide = new HashSet<>();
        ans = new ArrayList<>();
        countPositions(A, 0, new ArrayList<>());
        return ans;

    }
    static int solve(int A){
        countPositions(A, 0, new ArrayList<>());
        return count;
    }

    static int count = 0;
    static void countPositions(int A, int col, ArrayList<Integer> colsPermutations){
        if(col == A){
            count++;
            ArrayList<String> temp = new ArrayList<>();
            for(int c: colsPermutations){
                char[] chars = new char[A];
                Arrays.fill(chars, '.');
                chars[c] = 'Q';
                temp.add(new String(chars));
            }
            Collections.sort(temp);
            ans.add(temp);
            return;
        }

        for(int i=0; i<A; i++){
            if(rowSet.contains(i) || diagonalAttackLeftSide.contains(i+col)|| diagonalAttackUpperSide.contains(i-col)) continue;

            colsPermutations.add(col);
            rowSet.add(i);
            diagonalAttackLeftSide.add(i+col);
            diagonalAttackUpperSide.add(i-col);

            countPositions(A, col+1, colsPermutations);

            colsPermutations.remove(colsPermutations.size()-1);
            rowSet.remove(i);
            diagonalAttackLeftSide.remove(i+col);
            diagonalAttackUpperSide.remove(i-col);
        }
    }
}
