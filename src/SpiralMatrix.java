public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] result = generateMatrix(3);
        print(result);

        result = generateMatrix(2);
        print(result);

        result = generateMatrix(4);
        print(result);

        result = generateMatrix(20);
        print(result);
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

    static int[][] generateMatrix(int A) {
        int[][] result = new int[A][A];

        int count = 1;
        int max= A*A;
        int i=0;
        int j=0;
        int direction = 0; //0 = right, 1=down, 2=left; 3= up
        do{
            switch(direction){
                case 0:
                    result[i][j] = count;
                    j++;
                    if(j>=A){
                        j=A-1;
                        i++;
                        direction = 1;
                    }else if(result[i][j] != 0){
                        j--;
                        i++;
                        direction = 1;
                    }
                    break;
                case 1:
                    result[i][j] = count;
                    i++;
                    if(i>=A){
                        i=A-1;
                        j--;
                        direction = 2;
                    }else if(result[i][j] != 0){
                        i--;
                        j--;
                        direction = 2;
                    }
                    break;
                case 2:
                    result[i][j] = count;
                    j--;
                    if(j<0){
                        j=0;
                        i--;
                        direction = 3;
                    }else if(result[i][j] != 0){
                        j++;
                        i--;
                        direction = 3;
                    }
                    break;
                default:
                    result[i][j] = count;
                    i--;
                    if(i<0){
                        i = 0;
                        j++;
                        direction = 0;
                    }else if(result[i][j] != 0){
                        i++;
                        j++;
                        direction = 0;
                    }


            }

            count++;
        }while(count<=max);
        return result;
    }
}
