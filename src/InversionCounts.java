public class InversionCounts {
    /*
    Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).



Problem Constraints
1 <= length of the array <= 100000

1 <= A[i] <= 10^9



Input Format
The only argument given is the integer array A.



Output Format
Return the number of inversions of A modulo (109 + 7).



Example Input
Input 1:

A = [3, 2, 1]
Input 2:

A = [1, 2, 3]


Example Output
Output 1:

3
Output 2:

0


Example Explanation
Explanation 1:

 All pairs are inversions.
Explanation 2:

 No inversions.
     */

    static int mod = 1000000007;
    public static void main(String[] args) {
        System.out.println(solve(new int[]{45, 10, 15, 25, 50}));
        System.out.println(solve(new int[]{3,2,1}));
        System.out.println(solve(new int[]{1,2,3}));
    }

    static int solve(int[] A){
        //Divide the list using merge sort and then do comparison on sorted array with formula count = count + (no of elements left to be processed in A)
        // pairs in A + pairs in B + pairs in between A&B
        return mergeSort(A, 0, A.length-1);
    }

    static int mergeSort(int[] A, int start, int end){
        if(start == end) return 0;
        int mid = (end+start)/2;
        int left = mergeSort(A, start, mid)%mod;
        int right = mergeSort(A, mid+1, end)%mod;

        return (left+right+merge(A, start, mid, end))%mod;
    }

    static int merge(int[] A, int start, int mid, int end){
        int[] temp = new int[end-start+1];
        int p1 = start;
        int p2 = mid+1;
        int p3 = 0;
        int count = 0;

        while (p1<= mid && p2 <= end){
            if(A[p1] <= A[p2]){
                temp[p3] = A[p1];
                p1++;
            }else{
                temp[p3] = A[p2];
                p2++;
                count += (mid-p1+1)%mod;
            }
            p3++;
        }

        while (p1<=mid){
            temp[p3] = A[p1]; p1++; p3++;
        }

        while(p2<=end){
            temp[p3] = A[p2]; p2++; p3++;
        }
        //Copy temp into A
        for(int i=start,j=0; i<=end; i++,j++){
            A[i] = temp[j];
        }
        return count%mod;
    }
}
