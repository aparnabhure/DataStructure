import java.util.Arrays;

public class SmallestDifference {
    public static void main(String[] args) {

        /**
         * Find the pair from two array where they have the smallest difference among all other pairs
         */
        int[] array1 =new int[]{-1,5,10,20,28,3};
        int[] array2 = new int[]{26,134,135,15,17};
        Smallest smallest =finsSmallestDifference(array1, array2);
        System.out.println(smallest.x + " "+smallest.y + " "+smallest.difference);

    }

    //O(nLog(n) + mLog(m)) | O(1) space
    private static Smallest finsSmallestDifference(int[] array1, int[] array2){
        Smallest smallest = new Smallest();
        Arrays.sort(array1);
        Arrays.sort(array2);
        int i=0;
        int j=0;
        while (i<array1.length && j<array2.length){
            int x = array1[i];
            int y = array2[j];
            int diffrence = 0;
            if(x<y){
                diffrence = y - x;
                i++;
            }else if(x>y){
                diffrence = x - y;
                j++;
            }else{
                diffrence = y - x;
                smallest.difference = diffrence;
                smallest.x = x;
                smallest.y = y;
                break;
            }
            if(diffrence <= smallest.difference){
                smallest.difference = diffrence;
                smallest.x = x;
                smallest.y = y;
            }
        }

        return smallest;
    }

    static class Smallest{
        int difference = Integer.MAX_VALUE; //Difference between X & y
        int x;  //Value from first array
        int y; //value from second array
    }
}
