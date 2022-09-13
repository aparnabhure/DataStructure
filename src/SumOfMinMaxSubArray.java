import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/*
Given an array A of both positive and negative integers.

Your task is to compute the sum of minimum and maximum elements of all sub-array of size B.

NOTE: Since the answer can be very large, you are required to return the sum modulo 109 + 7.



Problem Constraints
1 <= size of array A <= 105

-109 <= A[i] <= 109

1 <= B <= size of array



Input Format
The first argument denotes the integer array A.
The second argument denotes the value B



Output Format
Return an integer that denotes the required value.



Example Input
Input 1:

 A = [2, 5, -1, 7, -3, -1, -2]
 B = 4
Input 2:

 A = [2, -1, 3]
 B = 2


Example Output
Output 1:

 18
Output 2:

 3


Example Explanation
Explanation 1:

 Subarrays of size 4 are :
    [2, 5, -1, 7],   min + max = -1 + 7 = 6
    [5, -1, 7, -3],  min + max = -3 + 7 = 4
    [-1, 7, -3, -1], min + max = -3 + 7 = 4
    [7, -3, -1, -2], min + max = -3 + 7 = 4
    Sum of all min & max = 6 + 4 + 4 + 4 = 18
Explanation 2:

 Subarrays of size 2 are :
    [2, -1],   min + max = -1 + 2 = 1
    [-1, 3],   min + max = -1 + 3 = 2
    Sum of all min & max = 1 + 2 = 3
 */
public class SumOfMinMaxSubArray {
    public static void main(String[] args) {
        System.out.println(solve(Arrays.asList(2, 5, -1, 7, -3, -1, -2), 4));
        System.out.println(solve(Arrays.asList(2, -1, 3), 2));
    }

    static int solve(List<Integer> A, int B){
        int mod = 1000000007;

        Deque<Integer> maxDequeue = new ArrayDeque<>();
        Deque<Integer> minDequeue = new ArrayDeque<>();

        for(int i=0; i<B; i++){
            while(!maxDequeue.isEmpty() && A.get(i)>maxDequeue.peekLast()){
                maxDequeue.pollLast();
            }
            maxDequeue.addLast(A.get(i));

            while(!minDequeue.isEmpty() && A.get(i)<minDequeue.peekLast()){
                minDequeue.pollLast();
            }
            minDequeue.addLast(A.get(i));
        }
        long ans = ((maxDequeue.peekFirst()+minDequeue.peekFirst())%mod);
        int n = A.size();
        for(int i=B; i<n; i++){
            while(!maxDequeue.isEmpty() && A.get(i)>maxDequeue.peekLast()){
                maxDequeue.pollLast();
            }
            maxDequeue.addLast(A.get(i));

            if( !maxDequeue.isEmpty() && maxDequeue.peekFirst().equals(A.get(i-B))){
                maxDequeue.pollFirst();
            }

            while(!minDequeue.isEmpty() && A.get(i)<minDequeue.peekLast()){
                minDequeue.pollLast();
            }
            minDequeue.addLast(A.get(i));

            if( !minDequeue.isEmpty() && minDequeue.peekFirst().equals(A.get(i-B))){
                minDequeue.pollFirst();
            }

            ans = (ans%mod) + ((maxDequeue.peekFirst()+minDequeue.peekFirst())%mod);
        }

        return (int) ((ans+mod)%mod);
    }
}
