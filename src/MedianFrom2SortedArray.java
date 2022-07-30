import java.util.Arrays;
import java.util.List;

public class MedianFrom2SortedArray {
    public static void main(String[] args) {
        System.out.println(median(Arrays.asList(7, -50, -41, -40, -19, 5, 21, 28), Arrays.asList(3, -50, -21 ,-10)));
        System.out.println(median(Arrays.asList(-50, -41, -40, -19, 5, 21, 28), Arrays.asList(-50, -21, -10)));
    }

    static double median(List<Integer> a, List<Integer> b) {
        int m = a.size(); //[-50, -21, -10]
        int n = b.size(); //[-50, -41, -40, -19, 5, 21, 28]

        if (m == 0 && n == 0) {
            return 0.0;
        } else if (m == 0) {
            if (n % 2 == 0) {
                return (b.get(n / 2 - 1) + b.get(n / 2)) / 2.0;
            } else {
                return (b.get(n / 2));
            }
        } else if (n == 0) {
            if (m % 2 == 0) {
                return (a.get(m / 2 - 1) + a.get(m / 2)) / 2.0;
            } else {
                return (a.get(m / 2));
            }
        }

        if(m>n){
            return median(b, a);
        }

        int total = m + n;
        int low = 0;
        int high = m;
        int half = (m + n) / 2;  //10 / 2 => 5

        while (low <= high) {
            int midA = low + ((high - low) >> 1); //[-50]
            int midB = half - midA; //5 - 1 = 4 =>[-50, -41, -40, -19, 5]
            if (midA < m && midB > 0 && b.get(midB - 1) > a.get(midA)) {
                low = midA + 1;
            } else if (midA > 0 && a.get(midA - 1) > b.get(midB)) {
                high = midA - 1;
            } else {
                double left, right;
                if (midA == 0) {
                    left = b.get(midB - 1);
                } else if (midB == 0) {
                    left = a.get(midA - 1);
                } else {
                    left = Math.max(a.get(midA - 1), b.get(midB - 1));
                }

                if (midA == a.size()) {
                    right = b.get(midB);
                } else if (midB == n) {
                    right = a.get(midA);
                } else {
                    right = Math.min(a.get(midA), b.get(midB));
                }

                if (total % 2 == 0) {
                    return (left + right) / 2.0;
                } else {
                    return right;
                }
            }
        }
        return 0.0;
    }
}
