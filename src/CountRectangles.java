import java.util.Arrays;
import java.util.List;

/*
Given a sorted array of distinct integers A and an integer B, find and return how many rectangles with distinct configurations can be created using elements of this array as length and breadth whose area is lesser than B.

(Note that a rectangle of 2 x 3 is different from 3 x 2 if we take configuration into view)



Problem Constraints

1 <= |A| <= 100000
1 <= A[i] <= 109
1 <= B <= 109



Input Format

The first argument given is the integer array A.

The second argument given is integer B.



Output Format

Return the number of rectangles with distinct configurations with area less than B modulo (109 + 7).


Example Input

Input 1:

 A = [1, 2]
 B = 5

Input 2:

 A = [1, 2]
 B = 1



Example Output

Output 1:

 4

Output 2:

 0



Example Explanation

Explanation 1:

 All 1X1, 2X2, 1X2 and 2X1 have area less than 5.

Explanation 2:

 No Rectangle is valid.



See Expected Output
Your input
41 8 15 19 21 26 30 45 48 59 66 67 72 134 143 152 174 182 185 201 207 229 234 250 253 261 303 306 312 330 359 382 385 398 427 439 442 443 455 457 484 491 902
Output
56
 */
public class CountRectangles {
    public static void main(String[] args) {
        System.out.println(solve(Arrays.asList(41, 8, 15, 19 ,21 ,26 ,30, 45 ,48, 59 ,66, 67, 72, 134, 143, 152 ,174,
                182, 185, 201, 207, 229, 234, 250, 253, 261 ,303, 306 ,312, 330 ,359 ,382, 385 ,398,427, 439, 442, 443 ,455, 457 ,484 ,491), 902));
    }

    static int solve(List<Integer> A, int B) {
        int n = A.size();
        if(n<=0) return 0;

        if(n==1) return (A.get(0)*A.get(0))<B?1:0;

        int i=0;
        int j = n-1;

        long count = 0;
        int mod = 1000000007;
        while(i<n && j>=0){
            long x = A.get(i);
            long y= A.get(j);
            if((x*y)<B) {
                count = (count%mod)+j+1;
                i++;
            }else
                j--;

        }
        return (int)(count%mod);
    }
}
