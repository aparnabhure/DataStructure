import java.util.HashMap;
import java.util.HashSet;

public class CompareSortedSubArrays {
    /*
    Given an array A of length N. You have to answer Q queries.

Each query will contain four integers l1, r1, l2, and r2. If sorted segment from [l1, r1] is the same as the sorted segment from [l2 r2], then the answer is 1 else 0.

NOTE The queries are 0-indexed.



Problem Constraints
0 <= A[i] <= 100000
1 <= N <= 100000
1 <= Q <= 100000



Input Format
The first argument is an array A.
The second is a 2D array B denoting queries with dimension Q * 4.
Consider ith query as l1 = B[i][0], r1 = B[i][1], l2 = A[i][2], r2 = B[i][3].



Output Format
Return an array of length Q with answers to the queries in the same order as the input.



Example Input
Input 1:

 A = [1, 7, 11, 8, 11, 7, 1]
 B = [
       [0, 2, 4, 6]
     ]
Input 2:

 A = [1, 3, 2]
 B = [
       [0, 1, 1, 2]
     ]


Example Output
Output 1:

 [1]
Output 2:

 [0]


Example Explanation
Explanation 1:

 (0, 2) -> [1, 7, 11]
 (4, 6) -> [11, 7, 1]
 Both are same when sorted hence 1.
Explanation 2:

 (0, 1) -> [1, 3]
 (1, 2) -> [3, 2]
 Both are different when sorted hence 0.
     */

    public static void main(String[] args) {
       print(solve(new int[]{1, 7, 11, 8, 11, 7, 1}, new int[][]{{0, 2, 4, 6}}));
    }

    static void print(int[] result){
        for(int i: result){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    static HashMap<Integer, Integer> map = new HashMap<>();
    static HashSet<Integer> set = new HashSet<>();
    static int[] solve(int[] A, int[][] B) {

        rand(A);
        int[] res = new int[B.length];
        long[] prefix = new long[A.length+1];
        prefix[0] = 0;
        int k = 1;
        for(int a : A)
        {
            prefix[k] = prefix[k-1]+map.get(a);
            k++;
        }
        for(int i=0; i<B.length; i++)
        {
            if(B[i][1]-B[i][0] == B[i][3]-B[i][2])
            {
                if(prefix[ B[i][1]+1 ]-prefix[ B[i][0] ] == prefix[ B[i][3]+1 ]-prefix[ B[i][2] ])
                    res[i] = 1;
                else
                    res[i] = 0;
            }
            else
                res[i] = 0;
        }
        return res;
    }

    //To create hash value for distinct number using random function.
    static void rand(int[] A)
    {
        int min = 1;
        int max = 1000000007;
        int range = max-min+1;
        for(int i=0; i<A.length; i++)
        {
            if( !map.containsKey(A[i]) )
            {
                int value = (int)(0D+ 1D*Math.random()*range + min);
                while(set.contains(value))
                {
                    value = (int)(0D+ 1D*Math.random()*range + min);
                }
                map.put(A[i], value);
                set.add(value);
            }
        }
    }
}
