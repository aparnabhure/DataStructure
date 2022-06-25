import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
//https://leetcode.com/problems/merge-intervals/submissions/
public class MergeIntervals {
    public static void main(String[] args) {

        int[][] intervals = new int[][]{{2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}};
        int[][] result = merge(intervals);
        print(result);

        intervals = new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}};
        result = merge(intervals);
        print(result);

        intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        result = merge(intervals);
        print(result);
    }

    static void print(int[][] result){
        System.out.print("[");
        for(int[] r:result){
            System.out.print("["+r[0]+","+r[1]+"],");
        }
        System.out.print("]");
        System.out.println();
    }

    static int[][] merge(int[][] intervals) {

        int n = intervals.length;

        if(n == 1){
            return intervals;
        }

        //Sort the array based on 0th index
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int[] currentInterval = intervals[0];

        List<int[]> list= new ArrayList<>();

        for(int i =1; i<n; i++){
            int[] interval = intervals[i];
            if(currentInterval[0] > interval[1]){
                list.add(interval);
            }else if(interval[0] > currentInterval[1]){
                final int[] current = currentInterval;
                list.add(current);
                currentInterval = interval;
            }else {
                currentInterval[0] = Math.min(currentInterval[0], interval[0]);
                currentInterval[1] = Math.max(currentInterval[1], interval[1]);
            }

        }

        list.add(currentInterval);
        return list.toArray(new int[0][]);


    }
}
