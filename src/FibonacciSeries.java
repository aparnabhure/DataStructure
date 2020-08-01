import java.util.HashMap;
import java.util.Map;

public class FibonacciSeries {
    public static void main(String[] args) {
        System.out.println(fibonacci(6));
        Map<Integer, Integer> memolize = new HashMap<>();
        memolize.put(1,0);
        memolize.put(2,1);
        System.out.println(fib(6, memolize));
        System.out.println(fib(6));
    }

    //O(2^n) | O(n) space
    private static int fibonacci(int n){
        if(n == 2){
            return 1;
        }else if(n == 1){
            return 0;
        }else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    //Using pre computed result
    //O(n) | O(n) space
    private static int fib(int n, Map<Integer, Integer> precomputedMap){
        if(precomputedMap.containsKey(n)){
            return precomputedMap.get(n);
        }
        precomputedMap.put(n, fib(n-1, precomputedMap)+fib(n-2, precomputedMap));
        return precomputedMap.get(n);
    }

    // Iterator way
    //O(N) | O(1) space
    private static int fib(int n){
        int a = 0;
        int b = 1;
        int c =1;
        for(int i=0; i<n-2; i++){
            c = a+b;
            a=b;
            b=c;
        }
        return c;
    }

}
