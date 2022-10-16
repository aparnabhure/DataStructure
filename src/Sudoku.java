public class Sudoku {
    public static void main(String[] args) {
        char[][] A = new char[][]{
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6', '.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        solveSudoku(A);
        print(A);
    }

    static void print(char[][] A){
        for(int i=0; i<9; i++){
            for(int j =0; j<9; j++){
                System.out.print(A[i][j]);
            }
            System.out.println();
        }
        System.out.println("*******");
    }

    static void solveSudoku(char[][] A) {
        solve(A);
    }

    static boolean solve(char[][] A) {
        int n = 9;
        for(int row=0; row<n; row++){
            for(int col=0; col<n; col++){
                if(A[row][col] == '.'){
                    for(char num = '1'; num <= '9'; num++){
                        if(canFill(A, row, col, num)){
                            A[row][col] = num;
                            if(solve(A)) return true;
                            A[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    static boolean canFill(char[][] A, int row, int col, char charToFill){
        for(int i=0;i<9;i++){
            if(A[i][col] != '.' && A[i][col] == charToFill) return false;
            if(A[row][i] != '.' && A[row][i] == charToFill) return false;
            if(A[3*(row / 3) + i / 3][ 3*(col / 3) + i % 3] != '.' &&
            A[3 *(row / 3) + i / 3][3*(col / 3) + i % 3] == charToFill) return false;
        }
        return true;
    }
}
