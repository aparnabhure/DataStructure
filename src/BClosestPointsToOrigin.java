import java.util.*;

public class BClosestPointsToOrigin {
    /*
    We have a list A of points (x, y) on the plane. Find the B closest points to the origin (0, 0).

Here, the distance between two points on a plane is the Euclidean distance.

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)

NOTE: Euclidean distance between two points P1(x1, y1) and P2(x2, y2) is sqrt( (x1-x2)2 + (y1-y2)2 ).



Problem Constraints
1 <= B <= length of the list A <= 105
-105 <= A[i][0] <= 105
-105 <= A[i][1] <= 105



Input Format
The argument given is list A and an integer B.



Output Format
Return the B closest points to the origin (0, 0) in any order.



Example Input
Input 1:

 A = [
       [1, 3],
       [-2, 2]
     ]
 B = 1
Input 2:

 A = [
       [1, -1],
       [2, -1]
     ]
 B = 1


Example Output
Output 1:

 [ [-2, 2] ]
Output 2:

 [ [1, -1] ]


Example Explanation
Explanation 1:

 The Euclidean distance will be sqrt(10) for point [1,3] and sqrt(8) for point [-2,2].
 So one closest point will be [-2,2].
Explanation 2:

 The Euclidean distance will be sqrt(2) for point [1,-1] and sqrt(5) for point [2,-1].
 So one closest point will be [1,-1].
     */
    public static void main(String[] args) {
        print(solveUsingHeapPriorityQueue(Arrays.asList(new ArrayList<>(Arrays.asList(1,3)), new ArrayList<>(Arrays.asList(-2,2))),1));
        print(solveUsingHeapPriorityQueue(Arrays.asList(new ArrayList<>(Arrays.asList(1,-1)), new ArrayList<>(Arrays.asList(2,-1))),1));

        int[][] result = solve(new int[][]{{1,3},{-2,2}}, 1);
        print(result);
        result = solve(new int[][]{{1,-1},{2,-1}}, 1);
        print(result);
    }

    static void print(int[][] result){
        for(int[] i: result){
            System.out.print(i[0] +" " + i[1]+ ", ");
        }
        System.out.println();
    }

    static void print(ArrayList<ArrayList<Integer>> result){
        for(ArrayList<Integer> point:result){
            System.out.println(point.get(0) + ", " + point.get(1));
        }
    }
    static ArrayList<ArrayList<Integer>> solveUsingHeapPriorityQueue(List<ArrayList<Integer>> A, int B) {
        PriorityQueue<ArrayList<Integer>> pq =new PriorityQueue<>((o1, o2) -> {
            long x2 = (long) o1.get(0) *o1.get(0);
            long y2 = (long) o1.get(1) *o1.get(1);
            long X = x2+y2;
            x2 = (long) o2.get(0) *o2.get(0);
            y2 = (long) o2.get(1) *o2.get(1);
            long Y = x2+y2;

            return Long.compare(X, Y);
        });
        for(ArrayList<Integer> point: A){
            pq.add(point);
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        while(B>0){
            ans.add(pq.poll());
            B--;
        }
        return ans;
    }
    static int[][] solve(int[][] A, int B) {

        Arrays.sort(A, (o1, o2) -> {
            long x2 = (long) o1[0] *o1[0];
            long y2 = (long) o1[1] *o1[1];
            long X = x2+y2;
            x2 = (long) o2[0] *o2[0];
            y2 = (long) o2[1] *o2[1];
            long Y = x2+y2;

            return Long.compare(X, Y);
        });

        int[][] result = new int[B][2];
        for(int i=0; i<B; i++){
            result[i] = Arrays.copyOf(A[i], A[i].length);
        }

        return result;
    }
}
