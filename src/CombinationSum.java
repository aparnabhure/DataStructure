import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CombinationSum {
    /*
    Given an array of candidate numbers A and a target number B, find all unique combinations in A where the candidate numbers sums to B.

The same repeated number may be chosen from A unlimited number of times.

Note:

1) All numbers (including target) will be positive integers.

2) Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).

3) The combinations themselves must be sorted in ascending order.

4) CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR ... (a1 = b1 AND a2 = b2 AND ... ai = bi AND ai+1 > bi+1)

5) The solution set must not contain duplicate combinations.



Problem Constraints
1 <= |A| <= 20

1 <= A[i] <= 50

1 <= B <= 500



Input Format
The first argument is an integer array A.

The second argument is integer B.



Output Format
Return a vector of all combinations that sum up to B.



Example Input
Input 1:

A = [2, 3]
B = 2
Input 2:

A = [2, 3, 6, 7]
B = 7


Example Output
Output 1:

[ [2] ]
Output 2:

[ [2, 2, 3] , [7] ]
     */

    public static void main(String[] args) {
        print(combinationSum(new ArrayList<>(Arrays.asList( 8, 10, 6, 11, 1, 16, 8 )), 28));

    }

    static void print(ArrayList<ArrayList<Integer>> result){
        for(ArrayList<Integer> r: result){
            System.out.println();
            for(int i:r){
                System.out.print(i + " ");
            }
        }
    }

    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        find(A, A.size(), 0, B, new ArrayList<>(), ans);
        return ans;
    }

    static void find(ArrayList<Integer> A, int n, int index, int target, ArrayList<Integer> permutation,
              ArrayList<ArrayList<Integer>> ans){
        if(index >= n){
            ArrayList<Integer> temp = new ArrayList<>(permutation);
            if(target == 0 && !ans.contains(temp)){
                ans.add(temp);
            }
            return;
        }

        if(A.get(index) <= target){
            permutation.add(A.get(index));
            find(A, n, index, (target - A.get(index)), permutation, ans);
            permutation.remove(permutation.size() - 1);
        }
        find(A, n, index+1, target, permutation, ans);
    }
}
