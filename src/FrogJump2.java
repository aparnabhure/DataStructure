import java.util.Arrays;

/*https://leetcode.com/contest/biweekly-contest-93/problems/frog-jump-ii/

 */
public class FrogJump2 {
    public static void main(String[] args) {
        System.out.println(maxJump(new int[]{0,2,5,6,7}));
        System.out.println(maxJump(new int[]{0,3,9}));
    }

    static  int maxJump(int[] stones) {
        int ans = stones[1] - stones[0];
        for(int i=2;i<stones.length;i++){
            ans = Math.max(ans,stones[i]-stones[i-2]);
        }
        return ans;
    }

}
