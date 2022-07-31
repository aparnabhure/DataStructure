public class MatrixMedian {

    public static void main(String[] args) {
        System.out.println(findMedian(new int[][]{{1}}));
        System.out.println(findMedian2(new int[][]{{1}}));
        System.out.println(findMedian(new int[][]{{1, 3, 5},{2, 6, 9},{3, 6, 9}}));
        System.out.println(findMedian2(new int[][]{{1, 3, 5},{2, 6, 9},{3, 6, 9}}));
        System.out.println(findMedian(new int[][]{{5, 17, 100}}));
    }


    static int findMedian2(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        int median = 0;

        for (int i = 0; i < rows; i++) {
            if (A[i][0] < minValue)
                minValue = A[i][0];
            if (A[i][cols - 1] > maxValue)
                maxValue = A[i][cols - 1];
        }

        int desiredCount = (rows * cols) / 2 + 1; // median will be >= half of total elements + 1
        while (minValue <= maxValue) {
            int midValue = minValue + (maxValue - minValue) / 2;
            int countOfElementsLessOrEqltoMid = 0;
            for (int i = 0; i < rows; i++) {
                countOfElementsLessOrEqltoMid += countElementsLessOrEqualToTarget(A, i, 0, cols - 1, midValue);
            }
            if (countOfElementsLessOrEqltoMid < desiredCount)
                minValue = midValue + 1;
            else {
                median = midValue;
                maxValue = midValue - 1;
            }
        }
        return median;
    }

    static int countElementsLessOrEqualToTarget(int[][] A, int rowIndex, int startIndex, int endIndex,
                                                 int targetValue) {
        int count = 0;
        while (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;
            if (A[rowIndex][mid] <= targetValue) {
                count = mid + 1; // mid index converted to count
                startIndex = mid + 1;
            } else
                endIndex = mid - 1;
        }
        return count;
    }


    static int findMedian(int[][] matrix){
        //Find max/high in column
        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = 0;
        int high = 0;
        for (int[] row : matrix) {
            low = Math.min(low, row[0]);
            high = Math.max(high, row[cols - 1]);
        }

        int ans = -1;
        int requiredCounts = ((rows*cols)/2) + 1;
        while(low<=high){

            int mid = low + (high-low)/2;
            int count = 0;
            for(int i=0;i<rows;i++){
                count += upperBound(matrix[i], mid);
            }

            if(count >= requiredCounts){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }

        }

        return ans;
    }

    static int upperBound(int[] A, int K){
        int n = A.length;
        int low = 0;
        int high = n-1;

        int ans = 0;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(A[mid]>K){
                high = mid-1;
            }else{
                ans = mid+1;
                low = mid+1;
            }
        }
        return ans;
    }
}
