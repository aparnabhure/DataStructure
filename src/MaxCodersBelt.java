import java.util.ArrayList;
import java.util.List;

/**
 * Find max coders linked cities
 * They can be connected horizontally/ vertically and/or diagonally
 * Need to find Belt with max connected coders
 * examples
 *                  {{0,0,0,0},
 *                 {0,0,1,0},
 *                 {0,0,1,0},
 *                 {1,1,0,0}};
 *                 Ans 4 as all 1s are directly + indirectly connected
 *
 *                 {{1,1,1},
 *                 {0, 0, 1},
 *                 {1,0,0}}
 *                 Ans 4 Here 2 belts with top2 rows and one with single 1 at the bottom.. Max are 4
 *
 *                 {{1,1,1,0,0},
 *                 {0,1,1,0,0},
 *                 {0,0,0,0,1},
 *                 {1,0,0,1,1},
 *                 {1,1,0,0,1}}
 *                 Ans 5 Here 3 belts with 5 coders in first 2 rows.. 4 in 3rd, 4th & 5th row right side and
 *                 3 in last 2 rows left side, but max coders belt is C1 with 5 coders.
 */
public class MaxCodersBelt {
    public static void main(String[] args) {
        int [][] matrix =
                {{0,0,0,0},
                        {0,0,1,0},
                        {0,0,1,0},
                        {1,1,0,0}};
        System.out.println(maxCoders(4,4,matrix));

        matrix = new int[][] {{1,1,1},
                {0, 0, 1},
                {1,0,0}};
        System.out.println(maxCoders(3,3,matrix));

        matrix = new int[][] {{1,1,1,0,0},
                {0,1,1,0,0},
                {0,0,0,0,1},
                {1,0,0,1,1},
                {1,1,0,0,1}};
        System.out.println(maxCoders(5,5,matrix));
    }

    static class VObject{
        int x;
        int y;
        boolean isVisited;
        int totalOnce;
        List<String> onesPairs = new ArrayList<>();
    }

    private static int maxCoders(int rows, int cols, int[][] matrix){
        VObject[][] pairsMatrix = fillPairMatrix(rows, cols, matrix);
        int result = traverse(rows, cols ,matrix, pairsMatrix);
        return result;
    }

    private static VObject[][] fillPairMatrix(int rows, int cols, int[][] matrix){
        VObject[][] visitedPairsMatrix = new VObject[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0; j<cols;j++){
                if(matrix[i][j] == 0){
                    continue;
                }

                visitedPairsMatrix[i][j] = countDirectOnce(i, j, rows, cols, matrix);
            }
        }

        return visitedPairsMatrix;
    }

    private static VObject countDirectOnce(int r, int c, int rows, int cols, int[][] matrix){
        VObject vObject = new VObject();
        vObject.x = r;
        vObject.y = c;

        List<String> pairs = new ArrayList<>();

        int count = 0;
        for(int i=r-1; i<=r+1; i++){
            if(i <0 || i >=rows){
                continue;
            }
            for(int j=c-1; j<=c+1; j++){
                if(j <0 || j>=cols){
                    continue;
                }
                if(matrix[i][j] == 1) {
                    count++;
                    if(i == r && j == c) {
                        //Do nothing
                    }else{
                        pairs.add(i + ":" + j);
                    }
                }
            }
        }

        vObject.onesPairs = pairs;
        vObject.totalOnce = count;
        return vObject;
    }

    private static int traverse(int rows, int cols, int[][] matrix, VObject[][] visitedMatrix){
        int result = -1;
        for(int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                if(matrix[i][j] == 0){
                    continue;
                }

                result = Math.max(result, findBelts(i, j, visitedMatrix, 0));
            }
        }
        return result;
    }

    private static int findBelts(int r, int c, VObject[][] visitedMatrix, int sum){
        if(visitedMatrix[r][c] == null || (visitedMatrix[r][c].isVisited) ){
            return sum;
        }

        visitedMatrix[r][c].isVisited = true;
        sum++;
        List<String> pairs = visitedMatrix[r][c].onesPairs;
        for (String s:pairs){
            String[] coordinates = s.split(":");
            sum = findBelts(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]), visitedMatrix, sum);
        }
        return sum;

    }
}
