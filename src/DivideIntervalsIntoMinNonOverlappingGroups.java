import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups
public class DivideIntervalsIntoMinNonOverlappingGroups {
    public static void main(String[] args) {
        System.out.println(minGroups(new int[][]{{5,10},{6,8},{1,5},{2,3},{1,10}}));
    }

    static int minGroups(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        for (int[] interval : intervals) {
            if (heap.isEmpty()) {
                heap.offer(interval);
                continue;
            }
            if (heap.peek()[1] < interval[0]) {
                int[] tmp = heap.poll();
                tmp[1] = interval[1];
                heap.offer(tmp);
                continue;
            }
            heap.offer(interval);
        }
        return heap.size();

    }
}
