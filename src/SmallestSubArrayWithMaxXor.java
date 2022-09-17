public class SmallestSubArrayWithMaxXor {
    public static void main(String[] args) {
       print(smallestSubarrays(new int[]{1,0,2,1,3}));
    }

    static void print(int[] result){
        for(int i:result){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    static int[] smallestSubarrays(int[] nums) {

        int n = nums.length;
        int[] bits = new int[30];
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            ans[i] = 1;
            for (int j = 0; j < 30; ++j) {
                if ((nums[i] & (1 << j)) > 0)
                    bits[j] = i;
                ans[i] = Math.max(ans[i], bits[j] - i + 1);
            }
        }
        return ans;

    }
}
