//https://leetcode.com/problems/trapping-rain-water/
public class WaterTrap {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));//  6;
        System.out.println(trap(new int[]{4,2,0,3,2,5})); // 9;

        System.out.println(trap2(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));//  6;
        System.out.println(trap2(new int[]{4,2,0,3,2,5})); // 9;
    }

    static int trap2(int[] height){
       // TC: O(n) SC O(1)
        int n = height.length;
        int left = 0;
        int right = n-1;
        int maxL = height[left];
        int maxR = height[right];
        int count = 0;
        while (left<right){
            if(maxL<=maxR){
                left++;
                int w = maxL-height[left];
                if(w >0){
                    count += w;
                }else{
                    maxL = height[left];
                }
            }else{
                right--;
                int w = maxR - height[right];
                if(w>0){
                    count += w;
                }else{
                    maxR = height[right];
                }
            }
        }
        return count;
    }
    static int trap(int[] height) {

        //TC: O(n) SC O(n) Prefix Left Max & Right Max

        int n = height.length;
        int[] lm = new int[n];
        int[] rm = new int[n];
        lm[0] = height[0];
        rm[n-1] = height[n-1];
        for(int i=1; i<n; i++){
            lm[i] = Math.max(lm[i-1], height[i]);
            rm[n-1-i] = Math.max(rm[n-1-i+1], height[n-1-i]);
        }

        int count = 0;
        for(int i=1; i<n-1; i++){
            int w = Math.min(lm[i], rm[i]) - height[i];
            if(w>0){
                count += w;
            }
        }
        return count;

    }
}
