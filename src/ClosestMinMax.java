import java.util.Arrays;

public class ClosestMinMax {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{814, 761, 697, 483, 981}));
    }

    static int solve(int[] A){
        int  n = A.length;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int j : A) {
            min = Math.min(min, j);
            max = Math.max(max, j);
        }

        if(min == max){
            return 1;
        }

        int minIndex = -1;
        int maxIndex = -1;
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            if(A[i] == min){
                minIndex = i+1;
            }else if(A[i] == max){
                maxIndex = i+1;
            }

            if(maxIndex != -1 && minIndex != -1){
                ans = Math.min(ans, Math.abs(maxIndex-minIndex));
            }

        }

        return ans+1;
    }
}
