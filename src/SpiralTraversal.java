public class SpiralTraversal {
    /**
     * Traverse 2D array in spiral order
     *
     */
    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1,2,3,4},
                {12,13,14,5},
                {11,16,15,6},
                {10,9,8,7}
        };
        int[] newArray = spiralTraversal(array);
        for (int i:newArray){
            System.out.println(" "+i);
        }

        int[] newSpriralArray = spiralTraverseRecursive(array, new int[array.length*array[0].length], 0,0, array.length-1, 0, array[0].length-1);
        for (int i:newSpriralArray){
            System.out.println(" "+i);
        }
    }

    //O(n) time | O(n) space as storing n values in resulting array
    private static int[] spiralTraversal(int[][] array){
        int[] newArray = new int[array.length*array[0].length];
        int startingRow= 0;
        int startColumn = 0;
        int endRow = array.length-1;
        int endColumn = array[0].length-1;
        int index = 0;
        while (startingRow <= endRow && startColumn<=endColumn){
            //Top Row
            for(int i=startColumn; i<=endColumn; i++){
                newArray[index] = array[startingRow][i];
                index++;
            }
            //right column
            for(int i=startingRow+1; i<=endRow; i++){
                newArray[index] = array[i][endColumn];
                index++;
            }

            //bottom row
            for(int i=endColumn-1; i>=startColumn; i--){
                newArray[index] = array[endRow][i];
                index++;
            }

            //Left column
            for (int i=endRow-1; i>startingRow; i--){
                newArray[index] = array[i][startColumn];
                index++;
            }

            startingRow++;
            startColumn++;
            endRow--;
            endColumn--;
        }

        return newArray;
    }

    //O(n) | O(n) space because of stack recursion
    private static int[] spiralTraverseRecursive(int[][] array, int[] newArray, int index, int startRow, int endRow, int startColumn, int endColumn){
        if((startRow > endRow || startColumn > endColumn)){
            return newArray;
        }

        //Top Row
        for(int i=startColumn; i<=endColumn; i++){
            newArray[index] = array[startRow][i];
            index++;
        }
        //right column
        for(int i=startRow+1; i<=endRow; i++){
            newArray[index] = array[i][endColumn];
            index++;
        }

        //bottom row
        for(int i=endColumn-1; i>=startColumn; i--){
            newArray[index] = array[endRow][i];
            index++;
        }

        //Left column
        for (int i=endRow-1; i>startRow; i--){
            newArray[index] = array[i][startColumn];
            index++;
        }

        return spiralTraverseRecursive(array, newArray, index, startRow+1, endRow-1, startColumn+1, endColumn-1);
    }
}
