import java.util.Arrays;

//https://www.geeksforgeeks.org/chocolate-distribution-problem
public class ChocolateDistributionProblem {
    public static void main(String[] args) {
        int arr[] = {12, 4, 7, 9, 2, 23, 25, 41,
                30, 40, 28, 42, 30, 44, 48,
                43, 50};
        System.out.println(distribute(arr, 7));
    }

    static int distribute(int[] A, int students){
        int len = A.length;
        if(students == 0 || len == 0){
            return 0;
        }

        if(students>len){
            return -1;
        }

        Arrays.sort(A);
        int min = Integer.MAX_VALUE;
        for(int i=0; i<=len-students; i++){
            min = Math.min(min, A[i+students-1]-A[i]);
        }

        return min;
    }
}
