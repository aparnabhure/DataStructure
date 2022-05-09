import java.util.Arrays;

// https://leetcode.com/discuss/interview-question/364618/
public class MinStepMakePilesEqualHeight {
    public static void main(String[] args) {
        int[] A = new int[]{2,3,5,1,2,4,6,6,8,1,2,4,3,3,8,8,9,6};
        System.out.println(minSteps(A));

        A = new int[]{5,2,1};
        System.out.println(minSteps(A));

        A = new int[]{1, 1, 2, 2, 2, 3, 3, 3, 4, 4};
        System.out.println(minSteps(A));
    }

    static int minSteps(int[] A){
        int len = A.length;
        if(len <= 1){
            return 0;
        }

        Arrays.sort(A);
        if(A[0] == A[len-1]){
            // All elements are of same height example 2 2 2 2 2
            return 0;
        }

        int result = 0;
        int duplicateCounts = 1;
        int prev = A[len-1];
        int minHeight = A[0];
        for(int i=len-2; i>=0; i--){
            int current = A[i];
            if(current == prev){
                duplicateCounts++;
            }else{
                result += duplicateCounts;
                duplicateCounts += 1;
                prev = current;
            }

            if(current == minHeight){
                break;
            }
        }
        return result;
    }
}

