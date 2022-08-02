import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class KthSmallestPrice {
    /*
    Given the price list at which tickets for a flight were purchased, figure out the kth smallest price for the flight. kth smallest price is the minimum possible n such that there are at least k price elements in the price list with value <= n. In other words, if the price list was sorted, then A[k-1] ( k is 1 based, while the array is 0 based ).

NOTE You are not allowed to modify the price list ( The price list is read only ). Try to do it using constant extra space.

Example:

A : [2 1 4 3 2]
k : 3

Answer : 2
Constraints :

1 <= number of elements in the price list <= 1000000
1 <= k <= number of elements in the price list
     */
    public static void main(String[] args) {
        System.out.println(solve(new int[]{74, 90, 85, 58, 69, 77, 90, 85, 18, 36}, 1));
        System.out.println(solve(new int[]{8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92}, 9));
        System.out.println(solve(new int[]{2,1,4,3,2}, 3));

    }

    static int solve(int[] A, int K){
        int n = A.length;
        if(K>n) return -1;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int i:A){
            low = Math.min(low, i);
            high = Math.max(high, i);
        }
        while (low<=high){
            int mid = low + (high-low)/2;
            if(!isValid(A, mid, K)){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return low;
    }

    static boolean isValid(int[] A, int mid, int K){
        int count = 0;
        for(int i:A){
            if(i<=mid) count++;
        }
        return count>=K;
    }

}
