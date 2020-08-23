import java.util.Arrays;
//https://leetcode.com/problems/maximum-number-of-coins-you-can-get/
public class MaxCoinsYouGet {
    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{2,4,1,2,7,8}));
        System.out.println(maxCoins(new int[]{2,4,5}));
        System.out.println(maxCoins(new int[]{9,8,7,6,5,1,2,3,4}));
    }
    private static int maxCoins(int[] piles){

        //Sort the array
        Arrays.sort(piles);
        if(piles.length == 3){
            return piles[1];
        }
        //Pick very list item for 3rd frd and last 2 for you and your 1stfriend
        int binIndex =0;
        int aliceIndex = piles.length-1;
        int yourIndex = aliceIndex-1;
        int maxSum = 0;
        while (binIndex < yourIndex){
            maxSum += piles[yourIndex];
            binIndex++;
            aliceIndex = yourIndex -1;
            yourIndex = aliceIndex- 1;
        }


        return maxSum;
    }
}
