public class MultiplyMatrix {
    public static void main(String[] args) {
        int[][] A = new int[][]{
            {62, -37, -49, 18, -53, 14, 51},
            {62, -52, -11, -21, -62, -44, -95},
            {20, 78, -29, -49, -17, 21, 83},
            {-99, -69, -39, -47, 19, -50, -90},
            {91, -96, 63, -23, 5, 94, 49},
            {17, 1, 16, 63, -78, -13, -100},
            {-7, 72, 16, 86, -53, 94, 85},
            {-82, 78, 96, -45, -42, 38, 34},
            {-88, 37, 12, 31, -91, 51, 23}
        };

        int[][] B = new int[][]{
            {90, 68, 2, 54, -59},
            {78, -86, 8, -30, 24},
            {-92, 84, -62, 13, 2},
            {12, -73, -53, -91, -4},
            {74, 85, -51, -4, 37},
            {-30, -27, 10, -78, 29},
            {-96, 39, -42, 93, 78}
        };

        int[][] AB = solve(A, B);

        print(AB);


        A = new int[][]{
            {94, 91}
        };

        B = new int[][]{
            {35, -52, -12, 26, -93, -61},
            {29, -20, -36, -9, 66, 15}
        };

        AB = solve(A, B);

        print(AB);

    }

    static void print(int[][] AB){
        for(int i=0; i<AB.length; i++){
            for(int j=0; j<AB[0].length; j++){
                System.out.print(AB[i][j] +" , ");
            }
            System.out.println();
        }
        System.out.println("******************");
    }

    static int[][] solve(int[][] A, int[][] B) {
        int an = A.length;
        int bn= B.length;
        int bm = B[0].length;
        int[][] result = new int[an][bm];
        for(int i=0; i<an; i++){
            for(int j=0; j<bm; j++){
                int sum = 0;
                for(int k=0;k<bn;k++){
                    sum += A[i][k]*B[k][j];
                }
                result[i][j] = sum;
            }
        }

        return result;
    }
}
