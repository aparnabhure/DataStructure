public class RotateArrayBy90Degree {

    /*
    [
      1 2 3
      4 5 6
      7 8 9
    ]

    ans
    [
      7 4 1
      8 5 2
      9 6 3
    ]

    steps could be make transpose first means columns become rows and rows become column
    [
      1 4 7
      2 5 8
      3 6 9
    ]

    now from center column rows are swapping and giving ans
     */
    public static void main(String[] args) {

        int[][] mat = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int n = 3;

        rotate(mat, n);
        print(mat,n);

        mat = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15, 16}
        };
        n = 4;

        rotate(mat, n);
        print(mat,n);

    }

    static void print(int[][] mat, int n){
        for(int row=0;row<n;row++){
            for(int col =0; col<n; col++){
                System.out.print(mat[row][col] +" ");
            }
            System.out.println();
        }
    }

    static void rotate(int[][] mat, int n){
        //Transpose
        for(int row=0;row<n;row++){
            for(int col=1+row;col<n;col++){
                int temp = mat[row][col];
                mat[row][col]=mat[col][row];
                mat[col][row] = temp;
            }
        }

        //Reverse or swap column from middle
        for(int row=0;row<n;row++){
            for(int col=0;col<n/2;col++){
                int temp = mat[row][col];
                mat[row][col]=mat[row][n-1-col];
                mat[row][n-1-col] = temp;
            }
        }
    }
}
