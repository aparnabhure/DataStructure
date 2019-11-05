/**
 * https://leetcode.com/problems/container-with-most-water/
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

 Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49
 *
 */
public class MaxArea {

	public static void main(String[] args) {
		int[] height = new int[]{1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(height));
		height = new int[]{1,1};
		System.out.println(maxArea(height));
		height = new int[]{1,2, 1};
		System.out.println(maxArea(height));
		height = new int[]{1,2};
		System.out.println(maxArea(height));
		
		System.out.println("****** With 2 direction ***");
		
		height = new int[]{1,8,6,2,5,4,8,3,7};
		System.out.println(maxAreaTwoPointers(height));
		height = new int[]{1,1};
		System.out.println(maxAreaTwoPointers(height));
		height = new int[]{1,2, 1};
		System.out.println(maxAreaTwoPointers(height));
		height = new int[]{1,2};
		System.out.println(maxAreaTwoPointers(height));
	}
	
	private static int maxArea(int[] height) {
		
		if(height.length < 2){
			return 0;
		}
		
		int maxArea = 0;
		for(int i=0; i<height.length; i++){
			for(int j=i+1;j<height.length;j++){
				int distance = j-i;
				int area = Math.min(height[i], height[j])*distance;
				//System.out.println(area);
				maxArea =Math.max(maxArea, area);
			}
		}
		
        return maxArea;
    }

	public static int maxAreaTwoPointers(int[] height) {
        int maxarea = 0;
        if(height.length < 2){
			return maxarea;
		}
        
        for(int i=0, j= height.length-1; j > i;){
        	int heightToCalculateArea = 0;
        	int distance = (j-i);
        	if(height[i] <= height[j]){
        		heightToCalculateArea = height[i];
        		i++;
        	}else{
        		heightToCalculateArea = height[j];
        		j--;
        	}
        	int area = heightToCalculateArea * distance;
        	maxarea = Math.max(maxarea, area);	
        }
        
        return maxarea;
    }
}
