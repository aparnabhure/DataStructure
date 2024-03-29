import java.util.Arrays;
import java.util.List;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(search(new int[]{5,1,3}, 5));
        System.out.println(search(new int[]{101, 103, 106, 106, 109, 158, 164, 182, 187, 202, 205, 205, 2, 3, 32, 57, 69, 74, 81, 99, 100}, 202));

        System.out.println(search(Arrays.asList(180, 181, 182, 183, 184, 187, 188, 189, 191, 192, 193, 194, 195, 196, 201, 202, 203, 204, 3, 4, 5, 6, 7, 8, 9, 10, 14, 16, 17, 18, 19, 23, 26, 27, 28, 29, 32, 33, 36, 37, 38, 39, 41, 42, 43, 45, 48, 51, 52, 53, 54, 56, 62, 63, 64, 67, 69, 72, 73, 75, 77, 78, 79, 83, 85, 87, 90, 91, 92, 93, 96, 98, 99, 101, 102, 104, 105, 106, 107, 108, 109, 111, 113, 115, 116, 118, 119, 120, 122, 123, 124, 126, 127, 129, 130, 135, 137, 138, 139, 143, 144, 145, 147, 149, 152, 155, 156, 160, 162, 163, 164, 166, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177),42));
        System.out.println(search(Arrays.asList(101, 103, 106, 109, 158, 164, 182, 187, 202, 205, 2, 3, 32, 57, 69, 74, 81, 99, 100), 202));
    }
//binary search TC logN
    static int search(final int[] A, int B) {
        //find the position from where the rotation starts
        int low = 0;
        int high = A.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(A[mid] > A[0]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        if(high<0){
            high = 0;
        }

        //high will be the last element
        if(B>=A[0] && B<=A[high]){
            //BS in left array
            return binarySearch(A, 0, high, B);
        }

        //BS in right array
        return binarySearch(A, high+1, A.length-1, B);
    }

    static int binarySearch(int[] A, int low, int high, int K){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(A[mid]== K) return mid;
            if(A[mid] < K) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }

    static int search(final List<Integer> A, int B) {

        int n = A.size();
        int low = 0;
        int high = n-1;

        while(low<=high){
            int mid = low + (high-low)/2;
            int m = A.get(mid);
            int l = A.get(low);
            int h = A.get(high);
            if(m == B) return mid; if(l == B) return l; if(h== B) return high;

            if(B<=A.get(n-1)){
                if(m>A.get(n-1) || m<B) low=mid+1;
                else high = mid-1;
            }else{
                if(m<B) low = mid+1;
                else high = mid-1;
            }
        }

        return -1;

    }

}
