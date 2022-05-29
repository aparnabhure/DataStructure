import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

//https://leetcode.com/contest/weekly-contest-295/problems/steps-to-make-array-non-decreasing/
public class MakeNonDescArray {
    public static void main(String[] args) {
        int[] A = new int[]{10,6,5,10,15};
        System.out.println(totalSteps(A));
        A = new int[]{5,3,4,4,7,3,6,11,8,5,11};
        System.out.println(totalSteps(A));
        A = new int[]{4,5,7,7,13};
        System.out.println(totalSteps(A));
        A = new int[]{10,1,2,3,4,5,6,1,2,3};
        System.out.println(totalSteps(A));

    }

    static int totalSteps(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return 0;
        }

        Stack<int[]> stack = new Stack<>();
        int max = 0;
        for(int num : nums) {
            int score = 0;
            while(!stack.isEmpty() && stack.peek()[0] <= num) {
                score = Math.max(score, stack.pop()[1]);
            }
            stack.add(new int[]{num, stack.isEmpty() ? 0 : score+1});
            max = Math.max(max, stack.peek()[1]);
        }
        return max;


    }
}
