import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SubSequenceSum {
    public static void main(String[] args) {
        print(allSubSequence(Arrays.asList(10, 3, 19)));
        System.out.println(solve(Arrays.asList(10, 3, 19), 29));
        System.out.println(solve(Arrays.asList(10, 8, 19, 7, 16), 23));
    }

    static class ListComparator<T extends Comparable<T>> implements Comparator<List<T>> {

        @Override
        public int compare(List<T> o1, List<T> o2) {
            for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
                int c = o1.get(i).compareTo(o2.get(i));
                if (c != 0) {
                    return c;
                }
            }
            return Integer.compare(o1.size(), o2.size());
        }

    }

    static void print(List<List<Integer>> result){
        //result.sort(Comparator.comparingInt(List::size));
        Collections.sort(result, new ListComparator<>());
        System.out.print("[");
        for(List<Integer> sub:result){
            System.out.print("[");
            for(int i: sub){
                System.out.print(i+" ,");
            }
            System.out.print("],");
        }
        System.out.print("]");
        System.out.println();
    }

    static List<List<Integer>> allSubSequence(List<Integer> array){
        int n = array.size();
        int n2 = 1<<n;
        List<List<Integer>> result = new ArrayList<>();
        for(int i =0; i<n2; i++){
            List<Integer> sub = new ArrayList<>();
            for(int j=0;j<n;j++){
                if((i&(1<<j))>0){
                    sub.add(array.get(j));
                }
            }
            Collections.sort(sub);
            result.add(sub);
        }
        return result;
    }

    static int solve(List<Integer> A, int B) {
        int n = A.size();
        if(n==1){
            return (B==A.get(0))?1:0;
        }
        int n2 = 1<<n;
        for(int i =0; i<n2; i++){
            long sum = 0;
            for(int j=0;j<n;j++){
                if((i&(1<<j))>0){
                    sum += A.get(j);
                }
            }
            if(sum == B) return 1;
        }

        return 0;
    }
}
