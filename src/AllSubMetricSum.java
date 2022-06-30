public class AllSubMetricSum {
    public static void main(String[] args) {
        int[][] A = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(sum(A));
    }

    static int sum(int[][] A){
        int n = A.length;

        int sum = 0;
        for(int r=0; r<n;r++){
            for(int c=0;c<n; c++){
                int contribution =  (r+1)*(c+1)*(n-r)*(n-c);
                sum += contribution*A[r][c];
            }
        }

        return sum;
    }
}
