import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FinishMaximumJobs {
    public static void main(String[] args) {
        System.out.println(solve(Arrays.asList(3, 7, 12, 4, 10, 8), Arrays.asList(10, 16, 17, 8, 13, 9)));
        System.out.println(solve(Arrays.asList(1, 5, 7, 1), Arrays.asList(7,8,8,8)));
        System.out.println(solve(Arrays.asList(3, 2, 6), Arrays.asList(9, 8, 9)));
    }

    static int solve(List<Integer> A, List<Integer> B){

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.end));

        int n = A.size();
        for(int i=0; i<n; i++){
            pq.add(new Pair(A.get(i), B.get(i)));
        }

        int ans = 1;
        Pair first = pq.poll();
        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            if(first.end<= pair.start){
                ans++;
                first = pair;
            }
        }

        return ans;
    }

    static class Pair{
        int start; int end;
        public Pair(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}
