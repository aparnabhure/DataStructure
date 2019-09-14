import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Dynamic programming is helpful to get the shortest path
 * Below program uses 4 approaches
 *
 */
public class FibonacciDynamicProgramming {

    private static Map<Integer, Integer> memorizedMap = null;
    public static void main(String[] args){
        System.out.println(naiveApproach(6));
        System.out.println(naiveApproach(2));
        System.out.println(naiveApproach(7));

        System.out.println(naiveRecursiveApproach(6));
        System.out.println(naiveRecursiveApproach(2));
        System.out.println(naiveRecursiveApproach(7));

        memorizedMap = new HashMap<>();
        System.out.println(memorizationApproach(6));
        System.out.println(memorizationApproach(2));
        System.out.println(memorizationApproach(7));

        System.out.println(bottomUpApproach(6));
        System.out.println(bottomUpApproach(2));
        System.out.println(bottomUpApproach(7));

    }

    private static int naiveApproach(int n){

        if(n <= 2){
            return 1;
        }

        int a = 1;
        int b = 1;

        int result = 0;
        for(int i=2; i<n;i++){
            result = a + b;
            a = b;
            b = result;
        }

        return result;
    }

    private static int naiveRecursiveApproach(int n){
        if(n <= 2){
            return 1;
        }

        int f = naiveRecursiveApproach(n-1)+ naiveRecursiveApproach(n-2);
        return f;
    }

    private static int memorizationApproach(int n){

        if(n <= 2){
            return 1;
        }

        if(!memorizedMap.containsKey(n)){
            int f = memorizationApproach(n-1)+ memorizationApproach(n-2);
            memorizedMap.put(n, f);
            return f;
        }
        return memorizedMap.get(n);
    }

    private static int bottomUpApproach(int n){
        List<Integer> tempArray = new ArrayList<>();
        tempArray.add(0, 0);
        int f;
        for(int i=1; i<=n; i++){
            if(i<=2){
                f = 1;
            }else{
                f = tempArray.get(i-1)+tempArray.get(i-2);
            }
            tempArray.add(i, f);
        }
        return tempArray.get(tempArray.size()-1);
    }
}
