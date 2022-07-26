import java.util.ArrayList;
import java.util.List;

public class ReversePairs {
    /*
    Given an array of integers A, we call (i, j) an important reverse pair if i < j and A[i] > 2*A[j].
Return the number of important reverse pairs in the given array A.



Problem Constraints
1 <= length of the array <= 105

-2 * 109 <= A[i] <= 2 * 109



Input Format
The only argument given is the integer array A.



Output Format
Return the number of important reverse pairs in the given array A.



Example Input
Input 1:

 A = [1, 3, 2, 3, 1]
Input 2:

 A = [4, 1, 2]


Example Output
Output 1:

 2
Output 2:

 1


Example Explanation
Explanation 1:

 There are two pairs which are important reverse i.e (3, 1) and (3, 1).
Explanation 2:

 There is only one pair i.e (4, 1).
     */

    public static void main(String[] args) {
        System.out.println(solve(new int[]{14046, 57239, 78362, 99387, 27609, 55100, 65536, 62099, 40820, 33056, 88380, 78549, 57512, 33137, 81212, 32365, 42276, 65368, 52459, 74924, 25355, 76044, 78056, 45190, 94365, 58869, 20611}));
        System.out.println(solve(new int[]{1, 3, 2, 3, 1}));
        System.out.println(solve(new int[]{4,1,2}));
    }

    static int solve(int[] A){
        return mergeSort(A, 0, A.length-1);
    }

    static int mergeSort(int[] A, int start, int end){
        if(start == end) return 0;
        int mid = (start+end)/2;
        int left = mergeSort(A, start, mid);
        int right = mergeSort(A, mid+1, end);
        return (left+right+merge(A, start, mid, end));
    }

    static int merge(int[] A, int start, int mid, int end){
        List<Integer> temp = new ArrayList<>();
        int p1=start;
        int p2 = mid+1;
        int count = 0;

        while(p1<=mid && p2<=end){
            if(A[p1]> (2L*A[p2])){
                p2++;
                count += (mid-p1+1);
            }else{
                p1++;
            }
        }

        p1 = start;p2=mid+1;
        while(p1<=mid && p2<=end){
            if(A[p1]<=A[p2]) temp.add(A[p1++]);
            else temp.add(A[p2++]);
        }

        while(p1<=mid){
            temp.add(A[p1]);
            p1++;
        }

        while(p2<=end){
            temp.add(A[p2]);
            p2++;
        }

        //Copy to main array
        for(int i=start,j=0; i<=end; i++, j++){
            A[i] = temp.get(j);
        }

        return count;

    }
}
