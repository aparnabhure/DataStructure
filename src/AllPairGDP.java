import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPairGDP {
    public static void main(String[] args) {
        System.out.println(solve(Arrays.asList(2, 2, 2, 2, 8, 2, 2, 2, 10)));
    }

    static ArrayList<Integer> solve(List<Integer> A) {
        int n = A.size();

        int sqrt = (int)Math.sqrt(n);

        int max = A.get(0);
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=1; i<=n; i++){
            int current = A.get(i-1);
            if(current>max){
                max = current;
            }

            if(i%sqrt == 0){
                result.add(max);
                max = 0;
            }
        }
        return result;

    }
}
