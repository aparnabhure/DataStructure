//https://leetcode.com/problems/xor-operation-in-an-array/
public class XOROperation {
    public static void main(String[] args) {
        System.out.println( (0^2^4^6^8));
        System.out.println(xorOperations(5, 0));
    }

    static int xorOperations(int n, int start){
        int result = start;
        for(int i=1; i<n; i++){
            int x = (start+(i<<1));
            result ^= x;
        }
        return result;
    }
}
