import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CombinationSum2 {
    /*
    Given an array of size N of candidate numbers A and a target number B. Return all unique combinations in A where the candidate numbers sums to B.

Each number in A may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
Warning:

DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.

Example : itertools.combinations in python. If you do, we will disqualify your submission and give you penalty points.



Problem Constraints
1 <= N <= 20



Input Format
First argument is an integer array A denoting the collection of candidate numbers.
Second argument is an integer which represents the target number.



Output Format
Return all unique combinations in A where the candidate numbers sums to B.



Example Input
Input 1:

 A = [10, 1, 2, 7, 6, 1, 5]
 B = 8
Input 2:

 A = [2, 1, 3]
 B = 3


Example Output
Output 1:

 [
  [1, 1, 6 ],
  [1, 2, 5 ],
  [1, 7 ],
  [2, 6 ]
 ]
Output 2:

 [
  [1, 2 ],
  [3 ]
 ]
     */

    public static void main(String[] args) {
        print(combinationSum(new ArrayList<>(Arrays.asList( 10, 1, 2, 7, 6, 1, 5 )), 8));
        print(combinationSum(new ArrayList<>(Arrays.asList( 2, 1, 3 )), 3));


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
            find(A, n, index+1, (target - A.get(index)), permutation, ans);
            permutation.remove(permutation.size() - 1);
        }
        find(A, n, index+1, target, permutation, ans);
    }
}
