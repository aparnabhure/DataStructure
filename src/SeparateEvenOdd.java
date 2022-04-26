import java.util.ArrayList;
import java.util.List;

public class SeparateEvenOdd {
    public static void main(String[] args) {

        int len = 7;
        int[] A = new int[]{509800927, 348992125, 733735508, 654457679, 499101452, 855551825, 443382987};
        print(A, len);
        len = 8;
        A = new int[]{905578050, 972494652, 245375028, 878368500, 105860782, 944700823, 490393895, 948966983};
        print(A, len);
        len = 9;
        A = new int[]{798010236, 29079384, 720590272, 493468480, 808983313, 722971196, 470315704, 720150938, 679454398};
        print(A, len);
        len = 2;
        A = new int[]{860913338, 587475971};
        print(A, len);
        len = 8;
        A = new int[]{517757309, 70339184, 520722130, 366035448, 185927255, 578942245, 538351388, 348346547};
        print(A, len);
        len = 10;
        A = new int[]{452362886, 75768689, 247249986, 472805849, 415014921, 242296902, 57978761, 364718082, 268628454, 774115327};
        print(A, len);
        len = 7;
        A = new int[]{225137014, 98149921, 536535463, 21434335, 358473307, 153990006, 582935602};
        print(A, len);
        len = 3;
        A = new int[]{897324350, 664604339, 44410966};
        print(A, len);
        len = 1;
        A = new int[]{968819918};
        print(A, len);
        len = 9;
        A = new int[]{467587686, 584409350, 192985738, 440958471, 883800429, 304643155, 432387944 ,370170046, 791202706};
        print(A, len);

    }

    static void print(int[] A, int len){
        List<List<Integer>> result = separateOddEven(A, len);
        for(List<Integer> array: result){
            for(Integer element:array){
                System.out.print(element+" ");
            }
            System.out.println();
        }
    }

    static List<List<Integer>> separateOddEven(int[] A, int len){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> evenArray = new ArrayList<>();
        List<Integer> oddArray = new ArrayList<>();
        for(int i=0; i<len; i++){
            if(A[i]%2 == 0){
                evenArray.add(A[i]);
            }else{
                oddArray.add(A[i]);
            }
        }
        result.add(oddArray);
        result.add(evenArray);
        return result;
    }
}
