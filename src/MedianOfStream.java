import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfStream {
    /*
    Given an array of integers, A denoting a stream of integers. New arrays of integer B and C are formed.
Each time an integer is encountered in a stream, append it at the end of B and append the median of array B at the C.

Find and return the array C.

NOTE:

    If the number of elements is N in B and N is odd, then consider the median as B[N/2] ( B must be in sorted order).
    If the number of elements is N in B and N is even, then consider the median as B[N/2-1]. ( B must be in sorted order).



Problem Constraints

1 <= length of the array <= 100000
1 <= A[i] <= 109



Input Format

The only argument given is the integer array A.



Output Format

Return an integer array C, C[i] denotes the median of the first i elements.



Example Input

Input 1:

 A = [1, 2, 5, 4, 3]

Input 2:

 A = [5, 17, 100, 11]



Example Output

Output 1:

 [1, 1, 2, 2, 3]

Output 2:

 [5, 5, 17, 11]



Example Explanation

Explanation 1:

 stream          median
 [1]             1
 [1, 2]          1
 [1, 2, 5]       2
 [1, 2, 5, 4]    2
 [1, 2, 5, 4, 3] 3

Explanation 2:

 stream          median
 [5]              5
 [5, 17]          5
 [5, 17, 100]     17
 [5, 17, 100, 11] 11
     */

    public static void main(String[] args) {
        print(solve(new ArrayList<>(Arrays.asList(59, 64, 10, 39))));
        print(solve(new ArrayList<>(Arrays.asList(1, 2, 5, 4, 3))));
        print(solve(new ArrayList<>(Arrays.asList(5, 17, 100, 11))));
    }

    static void print(ArrayList<Integer> result){
        for(int i: result){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    static ArrayList<Integer> solve(ArrayList<Integer> A) {

        PriorityQueue<Integer> maxheap =new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minheap =new PriorityQueue<>();

        int i=0;
        maxheap.add(A.get(i++));
        int j=1;
        int n = A.size();
        for(;i<n; i++){
            if(!maxheap.isEmpty() && A.get(i)>maxheap.peek()){
                minheap.add(A.get(i));

                int maxh = maxheap.size();
                int minh = minheap.size();

                if(minh>maxh){
                    maxheap.add(minheap.poll());
                }

            }else{
                maxheap.add(A.get(i));

                int maxh = maxheap.size();
                int minh = minheap.size();

                if((maxh - minh) >1){
                    minheap.add(maxheap.poll());
                }

            }

            int maxh = maxheap.size();
            int minh = minheap.size();
            if((maxh+minh)%2 == 0 || maxh>minh){
                A.set(j, maxheap.peek());
            }else {
                A.set(j, minheap.peek());
            }

            j++;
        }

        return A;
    }
}
