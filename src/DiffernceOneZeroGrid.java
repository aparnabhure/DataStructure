/*https://leetcode.com/contest/biweekly-contest-92/problems/difference-between-ones-and-zeros-in-row-and-column/*/
public class DiffernceOneZeroGrid {
    public static void main(String[] args) {
        PrintUtil.print(onesMinusZeros(new int[][]{{0,1,1},{1,0,1},{0,0,1}}));
    }

    static int[][] onesMinusZeros(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[] rone = new int[r];
        int[] cone = new int[c];
        int[] rzero = new int[r];
        int[] czero = new int[c];

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j] == 0){
                    rzero[i]++;
                }else{
                    rone[i]++;
                }
            }
        }

        for(int i=0; i<c; i++){
            for(int j=0; j<r; j++){
                if(grid[j][i] == 0){
                    czero[i]++;
                }else{
                    cone[i]++;
                }
            }
        }

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                grid[i][j] = rone[i]+cone[j]-rzero[i]-czero[j];
            }
        }

        return grid;
    }
}
