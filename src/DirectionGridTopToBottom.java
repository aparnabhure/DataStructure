/**
 * Given a grid, with each cell containing a direction (U, D, L, R) meaning they can only go to the cell above it or
 * below it to to it's left or to its right from the current cell.
 * Determine if it's possible to go from top left to bottom right
 */
public class DirectionGridTopToBottom {

    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'D', 'L', 'L', 'R'},
                {'D', 'L', 'U', 'D'},
                {'R', 'R', 'D', 'R'}
        };
        System.out.println(traverseGrid(matrix));

        matrix = new char[][]{
                {'D', 'L', 'L', 'R'},
                {'D', 'L', 'U', 'D'},
                {'R', 'R', 'R', 'R'}
        };
        System.out.println(traverseGrid(matrix));

        matrix = new char[][]{
                {'D', 'L', 'L', 'R'},
                {'L', 'L', 'U', 'D'},
                {'R', 'R', 'R', 'R'}
        };
        System.out.println(traverseGrid(matrix));

        matrix = new char[][]{
                {'R', 'L', 'L', 'R'},
                {'L', 'L', 'U', 'D'},
                {'R', 'R', 'R', 'R'}
        };
        System.out.println(traverseGrid(matrix));
    }

    private static boolean traverseGrid(char[][] matrix){
        boolean isPossible = true;
        int row = matrix.length;
        int col = matrix[0].length;
        //Fill matrix with not visited matrix
        int[][] visitedMatrix = new int[row][col];
        int r=0;
        int c=0;
        while (true) {
            visitedMatrix[r][c] = 1;
            char c1 = matrix[r][c];
            if(c1 == 'D'){
                r++;
            }else if(c1 == 'U'){
                r--;
            }else if(c1 == 'L'){
                c--;
            }else if(c1 == 'R'){
                c++;
            }
            if(r == row-1 && c == col-1){
                break;
            }

            if(r <0 || r >=row || c <0 || c >=col || visitedMatrix[r][c] == 1){
                isPossible = false;
                break;
            }

        }

        return isPossible;
    }

}


