public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(reverse(3));
        System.out.println(reverse(400));
    }
    static long reverse(long a) {
        long result = 0;
        int start= 31;
        while(a > 0){
            if((a&1)>0){
                result+= (1L<<start);
            }
            a = a>>1;
            start--;
        }

        if(result < 0){
            //This is to convert it into unsigned
            result = result & 0x00000000ffffffffL;
        }

        return result;
    }
}
