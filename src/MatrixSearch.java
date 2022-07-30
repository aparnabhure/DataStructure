public class MatrixSearch {

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{22, 32, 67}}, 93));
    }

    static int searchMatrix(int[][] A, int B) {
        //Find lower bound on last column
        int lowerBoundCol = lowerBound(A, B);

        int low= 0;
        int high = A[0].length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            int num = A[lowerBoundCol][mid];
            if(num == B ) return 1;
            if(num>B) high = mid-1;
            else low = mid+1;
        }

        return 0;

    }
    static int lowerBound(int[][] A, int K){
        int n = A.length;
        int col = A[0].length;

        int low = 0;
        int high = n;

        while(low<high){
            int mid = low+(high-low)/2;

            if(A[mid][col-1] == K) return mid;
            if(A[mid][col-1]>K) high = mid;
            else low = mid+1;
        }

        if(low<n && A[low][col-1]<K){
            low++;
        }

        return low>=n?low-1:low;
    }
}
