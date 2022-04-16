public class FillInSpiralArray {
    //Print square matrix in spiral form
    /*
    [1]
    [1,2
     4,3]
     [1,2,3
      8,9,4
      7,6,5
      ]
     */
    public static void main(String[] args) {
        int A = 80;
        int[][] result = fillSpiralMatrix(A);
        for(int i=0; i<A;i++){
            for(int j=0; j<A;j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    enum DIRECTIONS{
        RIGHT,
        DOWN,
        LEFT,
        UP
    }

    static int[][] fillSpiralMatrix(int A){
        int counter = 0;
        int direction = DIRECTIONS.RIGHT.ordinal();
        int[][] result = new int[A][A];

        int left=0;
        int top=0;
        int right=A-1;
        int bottom = A-1;

        while (left<=right && top<=bottom){

            if(direction == DIRECTIONS.RIGHT.ordinal()){
                for(int i=left; i<=right;i++){
                    result[top][i] = ++counter;
                }
                direction = DIRECTIONS.DOWN.ordinal();
                top++;
            }else if(direction == DIRECTIONS.DOWN.ordinal()){
                for(int i=top; i<=bottom; i++){
                    result[i][right] = ++counter;
                }
                direction = DIRECTIONS.LEFT.ordinal();
                right--;
            }else if(direction == DIRECTIONS.LEFT.ordinal()){
                for(int i=right; i>=left; i--){
                    result[bottom][i] = ++counter;
                }
                direction = DIRECTIONS.UP.ordinal();
                bottom--;
            }else{
                for(int i= bottom; i>=top; i--){
                    result[i][left] = ++counter;
                }
                direction = DIRECTIONS.RIGHT.ordinal();
                left++;
            }
        }

        return result;
    }
}
