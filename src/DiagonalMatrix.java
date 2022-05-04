public class DiagonalMatrix {
    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int n = 3;
        int[][] result = diagonal(mat);
        print(result);
    }

    static int[][] diagonal(int[][] A){
        int n = A.length;
        int[][] result = new int[2*n-1][n];

        int r=0;
        int c =0;

        int i=0;
        for(int j=0;j<n;j++){
            int row = i;
            int col = j;
            while(row<n && col>=0){
                result[r][c] = A[row][col];
                row++;
                col--;
                c++;
            }
            r++;
            c=0;
        }

        int j=n-1;
        for(i=1;i<n;i++){
            int row = i;
            int col = j;
            while(row<n && col>=0){
                result[r][c] = A[row][col];
                row++;
                col--;
                c++;
            }
            r++;
            c=0;
        }
        return result;
    }

    static void print(int[][] mat){
        for(int row=0;row<mat.length;row++){
            for(int col =0; col<mat[0].length; col++){
                System.out.print(mat[row][col] +" ");
            }
            System.out.println();
        }
    }
}
