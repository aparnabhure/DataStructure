import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

//https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
public class SortByNumberOf1Bits {
    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,4,5,6,7,8};
        sort(A);
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(0, 1, 2, 0, 1, 2));
        ArrayList<Integer> result = sortColors(arrayList);
        for(int a: result){
            System.out.print(a + " ");
        }
        System.out.println();
    }

    static void sort(int[] arr){

        Integer[] arr1 = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(arr1, (a, b)->{

            int abits = Integer.bitCount(a);
            int bbits = Integer.bitCount(b);
            if(bbits != abits){
                return Integer.compare(abits, bbits);
            }else{
                return Integer.compare(a, b);
            }
        });

        for(int i:arr1){
            System.out.print(i+" ");
        }
        System.out.println();
        arr = Arrays.stream(arr1).mapToInt(i->i).toArray();
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    static ArrayList<Integer> sortColors(ArrayList<Integer> A) {
        Collections.sort(A, Comparator.reverseOrder());
        return A;
    }

}
