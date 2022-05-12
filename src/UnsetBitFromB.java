public class UnsetBitFromB {
    public static void main(String[] args) {
        System.out.println(unsetFromB(53, 5));
    }

    static long unsetFromB(long A, int B) {
        int i=0;
        long deductions = 0;
        long temp = A;
        while(i<B){
            long bit = temp&1;
            if(bit == 1){
                deductions += 1L<<i;
            }
            temp = temp>>1;
            i++;
        }
        return (A-deductions);
    }
}
