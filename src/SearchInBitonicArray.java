public class SearchInBitonicArray {
    /*
    A Bitonic Sequence is a sequence of numbers which is first strictly increasing then after a point strictly decreasing.
     */

    public static void main(String[] args) {
        System.out.println(solve(new int[]{3, 9, 10, 20, 17, 5, 1},17));
        System.out.println(solve(new int[]{3, 9, 10, 20, 17, 5, 1},20));
        System.out.println(solve(new int[]{5, 6, 7, 8, 9, 10, 3, 2, 1},30));


    }

    static int solve(int[] A, int B){
        //Find the element/position from where array started desc order
        int n = A.length;
        if(n == 1){
            return A[0]==B?0:-1;
        }
        int low = 0;
        int high = n-1;
        if(A[0]>A[1]){
            if(A[0] == B) return 0;
            low = 1;
        }else if(A[n-1]<A[n-2]){
            if(A[n-1] == B) return n-1;
            high = n-2;
        }

        int ans = 0;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(A[mid]>A[mid+1]){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }


            //Search in left
            low = 0;
            high = ans;
            while(low<=high){
                int mid = low + (high-low)/2;
                if(A[mid] == B) return mid;
                if(A[mid] > B){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }

            //search in right
            low = ans+1;
            high = n-1;
            while(low<=high){
                int mid = low + (high-low)/2;
                if(A[mid] == B) return mid;
                if(A[mid] > B){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }

        return -1;

    }


}
