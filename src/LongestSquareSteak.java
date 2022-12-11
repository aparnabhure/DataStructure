import java.util.HashSet;
import java.util.Set;

/**https://leetcode.com/contest/weekly-contest-323/problems/longest-square-streak-in-an-array/
 *
 */
public class LongestSquareSteak {
    public static void main(String[] args) {
        System.out.println(longestSquareStreak(new int[]{4,3,6,16,8,2}));
    }

    static int longestSquareStreak(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int i:nums){
            set.add(i);
        }

        int max = -1;
        for(int num: nums){
            int count = 1;
            while(set.contains(num*num)){
                num = num*num;
                count++;
            }
            if(count>1 && count > max){
                max= count;
            }
        }

        return max;
    }
}
