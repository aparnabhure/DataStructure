/** Directions would always be right and down **/
public class MinCostMatrix {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,3,1},{1,5,1},{4,2,1}
        };
        System.out.println(minPathSum(grid));

        grid = new int[][]{ { 31, 100, 65, 12, 18 },
                { 10, 13, 47, 157, 6 },
                { 100, 113, 174, 11, 33 },
                { 88, 124, 41, 20, 140 },
                { 99, 32, 111, 41, 20 } };
        System.out.println(minPathSum(grid));
    }

    private static int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] costGrid = new int[rows][cols];

        for(int r=0; r<rows;r++){
            for(int c=0; c<cols; c++){
                if(r == 0){
                    if(c == 0){
                        costGrid[r][c] = grid[r][c];
                    }else{
                        costGrid[r][c] = costGrid[r][c-1] + grid[r][c];
                    }
                }else{
                    if(c == 0){
                        costGrid[r][c] =  costGrid[r-1][c] + grid[r][c];
                    }else{
                        costGrid[r][c] = Math.min(costGrid[r][c-1], costGrid[r-1][c]) + grid[r][c];
                    }
                }
            }

        }
        return costGrid[rows-1][cols-1];
    }
}
