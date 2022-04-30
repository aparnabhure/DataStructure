public class UnguardedCells {
    public static void main(String[] args) {
        int[][] guards = new int[][]{{0,0},{1,1},{2,3}};
        int[][] walls = new int[][]{{0,1},{2,2}, {1,4}};
        int m = 4;
        int n=6;
        System.out.println(countUnguardedCells(m, n, guards, walls));

        guards = new int[][]{{1,1}};
        walls = new int[][]{{0,1},{1,0}, {2,1},{1,2}};
        m = 3;
        n=3;
        System.out.println(countUnguardedCells(m, n, guards, walls));

        m=3;
        n=4;
        guards = new int[][]{{0,1},{1,2},{2,0}, {2,1}};
        walls = new int[][]{{1,3},{0,3}, {1,0},{2,2},{0,2}};

        System.out.println(countUnguardedCells(m, n, guards, walls));
    }

    static int countUnguardedCells(int m, int n, int[][] guards, int[][] walls){
        int[][] matrix = new int[m][n];

        int count = 0;
        for(int i =0; i<guards.length; i++){
            int r = guards[i][0];
            int c = guards[i][1];
            matrix[r][c] = 1;
            count++;
        }

        for(int i =0; i<walls.length; i++){
            int r = walls[i][0];
            int c = walls[i][1];
            matrix[r][c] = 1;
            count++;
        }

        for(int i=0; i<guards.length; i++){
            int r = guards[i][0];
            int c = guards[i][1];
            //Move left/right/up & down directions
            //For right
            for(int j = c+1; j<n; j++){
                if(matrix[r][j] == 1){
                    break;
                }
                if(matrix[r][j] != 3){
                    matrix[r][j] = 3;
                    count++;
                }
            }
            //For left
            for(int j=c-1; j>=0; j--){
                if(matrix[r][j] == 1){
                    break;
                }

                if(matrix[r][j] != 3) {
                    matrix[r][j] = 3;
                    count++;
                }
            }

            //For up
            for(int j=r-1; j>=0; j--){
                if(matrix[j][c] == 1){
                    break;
                }
                if(matrix[j][c] != 3) {
                    matrix[j][c] = 3;
                    count++;
                }
            }

            //for down
            for(int j=r+1; j<m; j++){
                if(matrix[j][c] == 1){
                    break;
                }
                if(matrix[j][c] != 3) {
                    matrix[j][c] = 3;
                    count++;
                }
            }
        }


        return (m*n - count);
    }
}
