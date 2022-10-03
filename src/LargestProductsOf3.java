import java.util.*;

public class LargestProductsOf3 {
    /*
    You have to find the product of the three largest integers in array A from range 1 to i, where i goes from 1 to N.

Return an array B where B[i] is the product of the largest 3 integers in range 1 to i in array A. If i < 3, then the integer at index i in B should be -1.



Problem Constraints

1 <= N <= 105
0 <= A[i] <= 103



Input Format

First and only argument is an integer array A.



Output Format

Return an integer array B. B[i] denotes the product of the largest 3 integers in range 1 to i in array A.



Example Input

Input 1:

 A = [1, 2, 3, 4, 5]

Input 2:

 A = [10, 2, 13, 4]



Example Output

Output 1:

 [-1, -1, 6, 24, 60]

Output 2:

 [-1, -1, 260, 520]



Example Explanation

Explanation 1:

 For i = 1, ans = -1
 For i = 2, ans = -1
 For i = 3, ans = 1 * 2 * 3 = 6
 For i = 4, ans = 2 * 3 * 4 = 24
 For i = 5, ans = 3 * 4 * 5 = 60

 So, the output is [-1, -1, 6, 24, 60].


Explanation 2:

 For i = 1, ans = -1
 For i = 2, ans = -1
 For i = 3, ans = 10 * 2 * 13 = 260
 For i = 4, ans = 10 * 13 * 4 = 520

 So, the output is [-1, -1, 260, 520].

     */
    public static void main(String[] args) {
        print(solve(Arrays.asList(10, 2, 13, 4)));
        print(solve(Arrays.asList(1, 2, 3, 4, 5)));
    }

    static void print(ArrayList<Integer> result){
        for(int i:result){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    static ArrayList<Integer> solve(List<Integer> A) {
        PriorityQueue<Integer> pq =new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> ans = new ArrayList<>();

        int n = A.size();
        for(int i=0; i<n; i++){
            pq.add(A.get(i));
            if(i<2){
                ans.add(-1);
            }else{
               int x = pq.poll();
               int y = pq.poll();
               int z = pq.poll();
               int product = (x*y*z);
               ans.add(product);
               pq.add(x);
               pq.add(y);
               pq.add(z);
            }
        }

        return ans;
    }
}
