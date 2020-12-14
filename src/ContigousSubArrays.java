import java.util.Arrays;

public class ContigousSubArrays {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(contigousArray(new int[]{2,4,1,7,5,3})));
        System.out.println(Arrays.toString(contigousArray(new int[]{2, 4, 7, 1, 5, 3})));
        System.out.println(Arrays.toString(contigousArray(new int[]{3, 4, 1, 6, 2})));
        System.out.println(Arrays.toString(contigousArray(new int[]{9, 4, 7, 6, 2})));

    }

    private static int[] contigousArray(int[] arr){
        if(arr == null || arr.length <=0){
            return arr;
        }

        int len = arr.length;

        int[] result = new int[len];


        for(int i=len-1;i>=0;i--){
            //Fill with self pair
            result[i] += 1;

            int j=i;
            int count=0;
            while(j>0){
                if(arr[i]<arr[j-1]){
                    result[j-1] += result[i];
                    break;
                }else{
                  count++;
                }
                j--;
            }
            result[i] += count;


        }

        return result;
    }
}
