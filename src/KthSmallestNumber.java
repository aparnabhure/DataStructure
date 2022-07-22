import java.util.Arrays;
import java.util.List;

public class KthSmallestNumber {
    public static void main(String[] args) {
        System.out.println(kthsmallest(Arrays.asList(8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92), 9));
    }

    static int kthsmallest(final List<Integer> A, int B) {
        int n = A.size();
        if(B>n) return 0;

        int[] b = new int[B];

        for(int i=0; i<n; i++){

            for(int j=0; j<B;j++){
                if(b[j] == 0){
                    b[j] = A.get(i);
                    break;
                }
                if(b[j]>=A.get(i)){
                    //Shift elements
                    for(int k=B-1; k>j; k--){
                        b[k] = b[k-1];
                    }
                    b[j] = A.get(i);
                    break;
                }

            }

        }

        return b[B-1];
    }
}
