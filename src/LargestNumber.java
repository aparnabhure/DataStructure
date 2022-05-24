import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an array A of non-negative integers, arrange them such that they form the largest number.
 *
 * Note: The result may be very large, so you need to return a string instead of an integer.
 *
 * [3, 30, 34, 5, 9] ans "9534330"
 * [2, 3, 9, 0] ans "9320"
 * [21, 30, 33, 16,20,15] ans "333021201616"
 * [21, 30, 9, 33, 16,20,15] ans "9333021201616"
 */
public class LargestNumber {
    public static void main(String[] args) {
        int[] A = new int[]{3, 30, 34, 5, 9};
        System.out.println(largest(A));
        A = new int[]{2, 3, 9, 0};
        System.out.println(largest(A));
        A = new int[]{21, 30, 33, 16,20,15};
        System.out.println(largest(A));
        A = new int[]{21, 30, 9, 33, 16,20,15};
        System.out.println(largest(A));
        A = new int[]{0,0,0,0};
        System.out.println(largest(A));
    }

    static String largest(int[] A){

        List<Integer> copy = Arrays.stream(A).boxed().collect(Collectors.toList());
        copy.sort((a, b) -> {
            String s1 = String.valueOf(a) + b;
            String s2 = String.valueOf(b) + a;

            if (s1.compareTo(s2) >= 0) {
                return -1;
            } else {
                return 1;
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int a:copy){
            sb.append(a);
        }
        return sb.charAt(0) == '0'?"0":sb.toString();
    }
}
