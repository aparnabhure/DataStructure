/**
 * Find the max number from each K size pair from the array
 */
public class MaxNumFromKPairSlidingWindow {
    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int windowSize = 3;
        /*Output: 3 3 4 5 5 5 6
        Explanation:
            Maximum of 1, 2, 3 is 3
            Maximum of 2, 3, 1 is 3
            Maximum of 3, 1, 4 is 4
            Maximum of 1, 4, 5 is 5
            Maximum of 4, 5, 2 is 5
            Maximum of 5, 2, 3 is 5
            Maximum of 2, 3, 6 is 6
         */

        for(int i=0; i<=array.length-windowSize; i++){
            int max = Integer.MIN_VALUE;
            for(int j=i; j<i+windowSize; j++){
                max = Math.max(max, array[j]);
            }
            System.out.print(max+" ");
        }
    }


}
