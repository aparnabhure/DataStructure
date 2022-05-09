public class BinarySum {
    public static void main(String[] args) {
        System.out.println(addBinary("101", "11"));
        System.out.println(addBinary("100", "11"));
        System.out.println(addBinary("100", "10101"));
    }
    static String addBinary(String A, String B){

        StringBuilder result = new StringBuilder();

        int aLen = A.length();
        int bLen = B.length();

        int aStart = aLen-1;
        int bStart = bLen-1;
        int carry = 0;

        while(aStart >= 0 || bStart >= 0){
            int a = aStart<0?0:Character.getNumericValue(A.charAt(aStart));
            int b = bStart<0?0:Character.getNumericValue(B.charAt(bStart));
            int sum = a+b+carry;

            if(sum > 1){
                result.insert(0, sum%2);
            }else{
                result.insert(0, sum);
            }
            carry = sum/2;
            aStart--;
            bStart--;
            if(aStart<0 && bStart<0){
                break;
            }
        }

        if(carry>0){
            result.insert(0, carry);
        }

        return result.toString();
    }
}
