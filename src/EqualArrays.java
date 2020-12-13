import java.util.Arrays;

public class EqualArrays {
    public static void main(String[] args) {
        System.out.println(areTheyEqual(new int[]{1,2,3,4}, new int[]{1,4,3,2}));
    }

    private static boolean areTheyEqual(int[] array_a, int[] array_b) {
        if(array_a == null || array_a.length<=0 || array_b == null || array_b.length <=0 || array_b.length != array_b.length){
            return false;
        }

        //Assumption a will always be in sorted order
        String aStr = Arrays.toString(array_a);
        String bStr = Arrays.toString(array_b);
        if(aStr.equals(bStr)){
            return true;
        }

        int i=0;
        int len = array_a.length;
        boolean isEqual = false;

        do{

            if(array_a[i] != array_b[i]){
                String s = ""+array_b[i];

                if(!aStr.contains(s)){
                    break;
                }

                Arrays.sort(array_b, i, len);

                if(array_a[i] != array_b[i]){
                    //This means after reversing as well arrays are not having same items
                    break;
                }

                bStr = Arrays.toString(array_b);
                if(aStr.equals(bStr)){
                    isEqual = true;
                    break;
                }
            }

            i++;


        }while(i<len);

        return isEqual;
    }
}
