import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidSudoku {
    /*
    Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.



The input corresponding to the above configuration :

["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]
A partially filled sudoku which is valid.

Note:

A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
Return 0 / 1 ( 0 for false, 1 for true ) for this problem
     */

    public static void main(String[] args) {
        System.out.println(isValidSudoku(Arrays.asList("53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79")));
        System.out.println(isValidSudoku(Arrays.asList("53..3....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79")));
    }

    static int isValidSudoku(final List<String> A) {
        //Store row, column and 3x3 matrix box details in set
        Set<String> keys = new HashSet<>();
        //Matrix would be 9x9
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                char currentChar = A.get(i).charAt(j);
                if(currentChar != '.'){
                    if(!keys.add("row"+i+A.get(i).charAt(j)) || !keys.add("col"+j+A.get(i).charAt(j)) )
                        return 0;
                    if( !keys.add("box"+((i/3)*3+(j/3))+A.get(i).charAt(j)) )
                        return 0;
                }
            }
        }
        return 1;
    }
}
