public class GoodSubArray {
    public static void main(String[] args) {
        int[] A = new int[]{15, 8, 16};
        int B = 242;
        System.out.println(solve(A, B));
        A = new int[]{12, 19, 20, 8, 14, 2, 5, 19, 5, 3, 20, 7, 16, 20, 5, 17, 18};
        B = 214;
        System.out.println(solve(A, B));
        A = new int[]{10, 2, 4, 12, 14, 12, 19, 18, 20, 16, 5, 10, 4, 16, 12, 2, 17, 13};
        B = 223;
        System.out.println(solve(A, B));


    }

    static int solve(int[] A, int B) {
        int len = A.length;
        if(len <= 0 || B == 0){
            return 0;
        }

        int count = 0;

        for(int i=0; i<len; i++){
            int sum = 0;
            int index = 0;
            for(int j=i; j<len; j++){
                sum += A[j];
                index++;
                if(index%2 == 0){
                    count += (sum<B)?1:0;
                }else{
                    count += (sum>B)?1:0;
                }
            }
        }
        return count;
    }
}
