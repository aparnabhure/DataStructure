
import java.util.ArrayList;
import java.util.List;

public class BitwiseOperator {
    public static void main(String[] args) {
        System.out.println(evenOrOdd(10));
        System.out.println(evenOrOdd(5));
        System.out.println(evenOrOdd(101));
        System.out.println(evenOrOdd(115));
        System.out.println(evenOrOdd(2));
        System.out.println(evenOrOdd(700));

        System.out.println("***************");
        System.out.println(getUniqueNonDuplicateNumerFromArray(new int[]{1,2,3,2,1,3,4,5,5,6,7,7,6}));

        System.out.println("***************");


    }

    private static int findStep(int arr[], int m){
        int[] binary = new int[arr.length];
        int count = 0;
        for(int i=0; i<arr.length; i++){
            int x = arr[i];
            binary[x-1]= 1;
            count+=groups(binary,m);
        }
        return count<=0?-1:count;
    }

    private static int groups(int[] binary, int m){
        int count = 0;
        List<java.lang.String> groups = new
                ArrayList<>();

        StringBuilder str = new StringBuilder();
        for(int i=0; i<binary.length; i++){
            if(binary[i] == 0){
                if(str.length() > 0){
                    groups.add(str.toString());
                }
                str = new StringBuilder();
                continue;
            }
            str.append(binary[i]);
        }

        if(str.length() > 0){
            groups.add(str.toString());
        }

        for(java.lang.String s:groups){
            if(s.length() ==m){
                count++;
            }
        }


        return count;
    }

    private static java.lang.String evenOrOdd(int number){
        int num = number&1;
        return (num == 1?"Odd": "Even");
    }

    /**
     * Assumption there would be only one number in the array which would not be reapeating
     * [1,2,3,2,1,3,4,5,5,6,7,7,6]
     * Here only 4 is non repeatative number
     * @param array
     * @return
     */
    private static int getUniqueNonDuplicateNumerFromArray(int[] array){
        int result = 0;
        for(int i: array){
            result = result^i;
        }
        return result;
    }

    private static java.lang.String reverseString(java.lang.String str){
        char[] chars = str.toCharArray();

        for(int i=0,j=chars.length-1; i<chars.length/2; i++, j--){
            int x = chars[i]^chars[j];
            int y = chars[j]^x;
            x = y^x;

        }
        return new java.lang.String(chars);
    }

}
