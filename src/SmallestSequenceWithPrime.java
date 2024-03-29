import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/*
Given three prime number(A, B, C) and an integer D. Find the first(smallest) D integers which have only A, B, C or a combination of them as their prime factors.


Problem Constraints

1 <= A, B, C <= 10000

1 <= D <= 100000



Input Format

First argument is an integer A.
Second argument is an integer B.
Third argument is an integer C.
Fourth argument is an integer D.


Output Format

Return an integer array of size D, denoting the first D integers described above.

NOTE: The sequence should be sorted in ascending order



Example Input

Input 1:

 A = 2
 B = 3
 C = 5
 D = 5

Input 2:

 A = 3
 B = 2
 C = 7
 D = 3



Example Output

Output 1:

 [2, 3, 4, 5, 6]

Output 2:

 [2, 3, 4]



Example Explanation

Explanation 1:

 4 = A * A ( 2 * 2 ), 6 = A * B ( 2 * 3 )

Explanation 2:

 2 has only prime factor 2. Similary 3 has only prime factor 3. 4 = A * A ( 2 * 2 )
 */
public class SmallestSequenceWithPrime {
    public static void main(String[] args) {
        PrintUtil.print(solve(2,3,5,5));
    }

    static int[] solve(int A, int B, int C, int D) {
        Set<Integer> set = new HashSet<>();
        set.add(A);
        set.add(B);
        set.add(C);
        PriorityQueue<Integer> pq = new PriorityQueue<>(set);

        int[] ans = new int[D];

        for(int i=0;i<D && !pq.isEmpty();i++) {
            int t = pq.poll();
            ans[i]=t;
            int t1 = t*A;
            int t2 = t*B;
            int t3 = t*C;
            if(!set.contains(t1)){
                set.add(t1);
                pq.add(t1);
            }
            if(!set.contains(t2)){
                set.add(t2);
                pq.add(t2);
            }
            if(!set.contains(t3)){
                set.add(t3);
                pq.add(t3);
            }
        }

        return ans;
    }
}
