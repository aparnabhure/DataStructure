public class MaxProductSubArray {
    public static void main(String[] args) {

        System.out.println(solve(new int[]{-1, -2, -3, -4}));
        System.out.println(solve(new int[]{2,6,-12,10,20}));
    }

    static int solve(int[] A){
        int n = A.length;
        // max positive product
        // ending at the current position
        int max_ending_here = A[0];

        // min negative product ending
        // at the current position
        int min_ending_here = A[0];

        // Initialize overall max product
        int max_so_far = A[0];

        // /* Traverse through the array.
        // the maximum product subarray ending at an index
        // will be the maximum of the element itself,
        // the product of element and max product ending previously
        // and the min product ending previously. */
        for(int i=1;i<n;i++){
            int temp = Math.max(Math.max(A[i], A[i] * max_ending_here), A[i] * min_ending_here);
            min_ending_here = Math.min(Math.min(A[i], A[i] * max_ending_here), A[i] * min_ending_here);
            max_ending_here = temp;
            max_so_far = Math.max(max_so_far, max_ending_here);
        }

        return max_so_far;
    }
}
