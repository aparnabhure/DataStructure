import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class ASortedArray {
    /*
    N people having different priorities are standing in a queue.

The queue follows the property that each person is standing at most B places away from its position in the sorted queue.

Your task is to sort the queue in the increasing order of priorities.

NOTE:

    No two persons can have the same priority.
    Use the property of the queue to sort the queue with complexity O(NlogB).



Problem Constraints

1 <= N <= 100000
0 <= B <= N



Input Format

The first argument is an integer array A representing the priorities and initial order of N persons.
The second argument is an integer B.



Output Format

Return an integer array representing the sorted queue.



Example Input

Input 1:

 A = [1, 40, 2, 3]
 B = 2

Input 2:

 A = [2, 1, 17, 10, 21, 95]
 B = 1



Example Output

Output 1:

 [1, 2, 3, 40]

Output 2:

 [1, 2, 10, 17, 21, 95]



Example Explanation

Explanation 1:

 Given array A = [1, 40, 2, 3]
 After sorting, A = [1, 2, 3, 40].
 We can see that difference between initial position of elements amd the final position <= 2.

Explanation 2:

 After sorting, the array becomes [1, 2, 10, 17, 21, 95].
     */

    public static void main(String[] args) {
        print(solve(new ArrayList<>(Arrays.asList(25, 16, 11, 31, 28, 20, 3, 8)), 6));
    }

    static void print(ArrayList<Integer> result){
        for(int i: result){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = A.size();
        int i=0;
        for(; i<=B; i++){
            pq.add(A.get(i));
        }

        int j =0;
        while(!pq.isEmpty() && i<n){
            A.set(j, pq.poll());
            pq.add(A.get(i));
            i++;
            j++;
        }

        while(!pq.isEmpty() && j<n){
            int min = pq.poll();
            A.set(j++, min);
        }

        return A;
    }


}
