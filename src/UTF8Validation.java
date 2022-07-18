//https://leetcode.com/contest/leetcode-weekly-contest-3/problems/utf-8-validation/
public class UTF8Validation {
    public static void main(String[] args) {
        System.out.println(validUtf8(new int[]{237}));
        System.out.println(validUtf8(new int[]{197,130,1}));
        System.out.println(validUtf8(new int[]{235,140,4}));
    }

    static boolean validUtf8(int[] data) {
        int n = data.length;
        /*
        Here for each element in array we need to firs check the number of bytes in 1st element
        Number of Bytes   |        UTF-8 Octet Sequence
                       |              (binary)
   --------------------+-----------------------------------------
            1          |   0xxxxxxx
            2          |   110xxxxx 10xxxxxx
            3          |   1110xxxx 10xxxxxx 10xxxxxx
            4          |   11110xxx 10xxxxxx 10xxxxxx 10xxxxxx

            if starts with 0 then check or next
            if that starts with 110.. then bit after that should starts with 10
            if it starts with 1110 means next 2 numbers should starts with 10
            if it starts with 11110 means next 3 numbers should starts with 10

            8 bit binary
            128 64 32 16 8 4 2 1
         */

        int i =0;
        while(i<n){
            //Compare starting bits to check how many bytes are there
            int numberOfBytes;
            int num = data[i];
            if(num>=255){
                return false;
            }

            if((num & 128) == 0){ //1st condition in chart
                numberOfBytes = 1;
            }else if((num & 224) == 192){
                numberOfBytes = 2;
            }else if((num & 240) == 224){
                numberOfBytes = 3;
            }else if((num & 248) == 240){
                numberOfBytes = 4;
            }else{
                return false;
            }

            //now check for next bytes
            for(int j=i+1; j<i+numberOfBytes; j++){
                if(j>=n) return false;
                num = data[j];
                if((num & 192) != 128){
                    return false;
                }
            }


            i+= numberOfBytes;

        }

        return true;
    }
}
