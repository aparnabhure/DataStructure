public class FindLowerBoundInSortedArray {
    /*
    LowerBound(k) is the first element such that element is >=k
    2,5,10,16,20
    lb(5) = 1, lb(9) = 2 (10), lb(50) = 5 (length)
     */
    public static void main(String[] args) {
        System.out.println(lowerBound(new int[]{2,5,10,16,20}, 5));
        System.out.println(lowerBound(new int[]{2,5,10,16,20}, 9));
        System.out.println(lowerBound(new int[]{2,5,10,16,20}, 50));
        System.out.println(lowerBound(new int[]{2,5,10,16,20}, -1));
    }

    static int lowerBound(int[] A, int K){
        int n = A.length;

        int low = 0;
        int high = n;

        while(low<high){
            int mid = low+(high-low)/2;

            if(A[mid] == K) return mid;
            if(A[mid]>K) high = mid;
            else low = mid+1;
        }

        if(low<n && A[low]<K){
            low++;
        }

        return low;
    }
}
