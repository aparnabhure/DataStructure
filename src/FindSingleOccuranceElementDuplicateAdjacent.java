public class FindSingleOccuranceElementDuplicateAdjacent {
    public static void main(String[] args) {
        System.out.println(find(new int[]{3,3,1,1,8,8,10,10,9,6,6,8,8}));
    }

    //Binarysearch TC O(log(n)) SC:O(1)
    static int find(int[] A){
        int n = A.length;
        if(n==1) return A[0];
        if(A[0]!= A[1]) return A[0];
        if(A[n-1] != A[n-2]) return A[n-1];
        int low = 2;
        int high = n-3;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(A[mid-1] != A[mid] && A[mid+1] != A[mid])
                return A[mid];
            if(A[mid-1] == A[mid])
                mid--;
            if(mid%2 == 0){
                low = mid +2;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
}
