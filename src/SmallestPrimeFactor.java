import java.util.*;

public class SmallestPrimeFactor {
    /*
    Given a sorted array of integers A which contains 1 and some number of primes.
Then, for every p < q in the list, we consider the fraction p / q.

What is the B-th smallest fraction considered?

Return your answer as an array of integers, where answer[0] = p and answer[1] = q.



Problem Constraints

1 <= length(A) <= 2000
1 <= A[i] <= 30000
1 <= B <= length(A)*(length(A) - 1)/2



Input Format

The first argument of input contains the integer array, A.
The second argument of input contains an integer B.



Output Format

Return an array of two integers, where answer[0] = p and answer[1] = q.



Example Input

Input 1:

 A = [1, 2, 3, 5]
 B = 3

Input 2:

 A = [1, 7]
 B = 1



Example Output

Output 1:

 [2, 5]

Output 2:

 [1, 7]



Example Explanation

Explanation 1:

 The fractions to be considered in sorted order are:
 [1/5, 1/3, 2/5, 1/2, 3/5, 2/3]
 The third fraction is 2/5.

Explanation 2:

 The fractions to be considered in sorted order are:
 [1/7]
 The first fraction is 1/7.
     */
    public static void main(String[] args) {
        print(solve(Arrays.asList(1,2,3,5), 3));
    }

    static void print(ArrayList<Integer> result){
        for(int i:result){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    static class Helper{
        float fraction;
        int x;
        int y;
    }
    static ArrayList<Integer> solve(List<Integer> A, int B) {
        PriorityQueue<Helper> pd = new PriorityQueue<>(Comparator.comparing(x->x.fraction));
        int n = A.size();
        for(int i=0; i<n; i++){
            Helper helper = new Helper();
            helper.x = i;
            helper.y = n-1;
            helper.fraction = (float) A.get(helper.x)/ A.get(helper.y);
            pd.add(helper);
        }

        while(B>1){
            Helper helper = pd.poll();
            if(helper.y-1 > helper.x){
                Helper h = new Helper();
                h.x = helper.x;
                h.y = helper.y-1;
                h.fraction = (float) A.get(h.x)/A.get(h.y);
                pd.add(h);
            }
            B--;
        }

        Helper ans = pd.poll();
        return new ArrayList<>(Arrays.asList(A.get(ans.x), A.get(ans.y)));
    }


}
