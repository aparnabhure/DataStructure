import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/contest/warm-up-contest/problems/lexicographical-numbers/
public class LexicographicalNumbers {
    public static void main(String[] args) {
        print(solve(4555));
        print(solve(350));
        print(solve(121));
        print(solve(50));
        print(solve(10));
    }

    static void print(List<Integer> result){
        for(int i: result){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    static List<Integer> solve(int n){
        List<Integer> result = new ArrayList<>();
        for(int i=1; i<=9; i++){
            if(i>n) break;
            result.add(i);
            traverse(i, n, result);
        }

        return result;
    }

    static void traverse(int num, int n, List<Integer> result){
        if(num>n) return;
        for(int i=0; i<=9; i++){
            num *= 10;
            num += i;
            if(num<=n){
                result.add(num);
            }
            traverse(num, n, result);
            num -= i;
            num /= 10;
        }
    }
}
