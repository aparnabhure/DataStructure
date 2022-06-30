import java.util.*;

//https://leetcode.com/problems/merge-intervals/submissions/
public class MergeIntervals {
    public static void main(String[] args) {
        Interval interval = new Interval();
        interval.start=5735878;
        interval.end= 14055448;
        Interval newInterval = new Interval();
        newInterval.start = 45639660;
        newInterval.end = 84793834;
        insert(Collections.singletonList(interval), newInterval);

        ArrayList<Interval> intervalList = new ArrayList<>();
        interval = new Interval();
        interval.start=2;
        interval.end= 3;
        intervalList.add(interval);
        interval = new Interval();
        interval.start=4;
        interval.end= 5;
        intervalList.add(interval);
        interval = new Interval();
        interval.start=6;
        interval.end= 7;
        intervalList.add(interval);
        interval = new Interval();
        interval.start=8;
        interval.end= 9;
        intervalList.add(interval);
        interval = new Interval();
        interval.start=1;
        interval.end= 10;
        intervalList.add(interval);
        mergeIntervals(intervalList);

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

    static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

    static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int n = intervals.size();

       Interval currentInterval = newInterval;

        ArrayList<Interval> list= new ArrayList<>();

        for(int i =0; i<n; i++){
            Interval interval = intervals.get(i);
            if(currentInterval.start > interval.end){
                list.add(interval);
            }else if(interval.start > currentInterval.end){
                final Interval current = currentInterval;
                list.add(current);
                currentInterval = interval;
            }else {
                currentInterval.start = Math.min(currentInterval.start, interval.start);
                currentInterval.end = Math.max(currentInterval.end, interval.end);
            }

        }

        list.add(currentInterval);
        return list;
    }

    static List<Interval> mergeIntervals(ArrayList<Interval> intervals) {
        int n = intervals.size();

        if(n == 1){
            return intervals;
        }

        //Sort intervals with star point
        intervals.sort(Comparator.comparing(x->x.start));

        Interval currentInterval = intervals.get(0);

        List<Interval> list= new ArrayList<>();

        for(int i =1; i<n; i++){
            Interval interval = intervals.get(i);
            if(currentInterval.start > interval.end){
                list.add(interval);
            }else if(interval.start > currentInterval.end){
                final Interval current = currentInterval;
                list.add(current);
                currentInterval = interval;
            }else {
                currentInterval.start = Math.min(currentInterval.start, interval.start);
                currentInterval.end = Math.max(currentInterval.end, interval.end);
            }

        }

        list.add(currentInterval);

        return list;
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
