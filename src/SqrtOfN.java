public class SqrtOfN {
    public static void main(String[] args) {
        System.out.println(sqrt(2147483647));
        System.out.println(sqrt(2));
        System.out.println(sqrt(25));
    }

    //binary searchTC logN
    static int sqrt(int N){
        int low = 1;
        int high = N;
        int ans = 0;
        while(low<=high){
            int mid = low + (high-low)/2;
            long sqrt = (long) mid *mid;
            if(sqrt == N) return mid;
            if(sqrt<N) {
                ans = mid;
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return ans;
    }

}
