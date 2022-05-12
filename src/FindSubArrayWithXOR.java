import java.util.Arrays;

public class FindSubArrayWithXOR {
    public static void main(String[] args) {
        int[] A = new int[]{1,0,1};
        System.out.println(findXOR1SubArraysDeductions(3, A));
        A= new int[]{0, 1, 1, 0, 1};
        System.out.println(findXOR1SubArraysDeductions(5, A));
        A = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        A = new int[100000];
        Arrays.fill(A, 1);
        System.out.println(findXOR1SubArraysDeductions(100000, A));
        A= new int[]{0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1};
        System.out.println(findXOR1SubArraysDeductions(76, A));
    }

    static long findXOR1SubArraysDeductions(int A, int[] B) {
        long zeros = 0;
        long deductions = 0;
        for(int i:B){
            if(i == 0){
                zeros++;
            }else if(zeros>0){
                deductions += ((zeros*(zeros+1))/2);
                zeros = 0;
            }
        }
        if(zeros>0){
            deductions += (zeros*(zeros+1))/2;
        }

        return (A*(A+1L)/2)-deductions;
    }
}
