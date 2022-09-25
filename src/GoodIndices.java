import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/contest/weekly-contest-312/problems/find-all-good-indices/
public class GoodIndices {
    public static void main(String[] args) {

        System.out.println(goodIndices(new int[]{2,1,1,1,3,4,1}, 2).toArray());

    }
    static List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        int[] pf = new int[n];
        int[] sf = new int[n];

        pf[0] = 1;

        for(int i=1; i<n; i++){
            if(nums[i]<=nums[i-1]){
                pf[i] = pf[i-1]+1;
            }else{
                pf[i] = 1;
            }
        }

        sf[n-1] = 1;
        for(int i=n-2; i>=0; i--){
            if(nums[i+1]>=nums[i]){
                sf[i] = sf[i+1]+1;
            }else{
                sf[i] = 1;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=k; i<n-k; i++){
            if(pf[i-1]>=k && sf[i+1]>=k) {
                ans.add(i);
            }
        }

        return ans;
    }
}
