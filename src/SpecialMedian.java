import java.util.*;

public class SpecialMedian {
    /*
    You are given an array A containing N numbers. This array is called special if it satisfies one of the following properties:

    There exists an element A[i] in the array such that A[i] is equal to the median of elements [A[0], A[1], ...., A[i-1]]
    There exists an element A[i] in the array such that A[i] is equal to the median of elements [A[i+1], A[i+2], ...., A[N-1]]

The Median is the middle element in the sorted list of elements. If the number of elements is even then the median will be (sum of both middle elements) / 2.

Return 1 if the array is special else return 0.

NOTE:

    For A[0] consider only the median of elements [A[1], A[2], ..., A[N-1]] (as there are no elements to the left of it)
    For A[N-1] consider only the median of elements [A[0], A[1], ...., A[N-2]]



Problem Constraints

1 <= N <= 1000000.
A[i] is in the range of a signed 32-bit integer.



Input Format

The first and only argument is an integer array A.



Output Format

Return 1 if the given array is special else return 0.



Example Input

Input 1:

 A = [4, 6, 8, 4]

Input 2:

 A = [2, 7, 3, 1]



Example Output

Output 1:

 1

Output 2:

 0



Example Explanation

Explantion 1:

 Here, 6 is equal to the median of [8, 4].

Explanation 2:

 No element satisfies any condition.
     */

    public static void main(String[] args) {
        System.out.println(solve(Arrays.asList(2147483647, -2147483648, 0)));
    }

    static int solve2(List<Integer> A) {
        ArrayList<Double> leftRunningMedian = runningMedian(A,false);
        ArrayList<Double> rightRunningMedian = runningMedian(A,true);
        for(int i=0;i<A.size();i++){
            if( (i > 0 && leftRunningMedian.get(i) == (double) A.get(i)) || (i < A.size()-1 && rightRunningMedian.get(i) == (double) A.get(i))){
                return 1;
            }
        }
        return 0;
    }

    static ArrayList<Double> runningMedian(List<Integer> A,boolean reverse) {
        ArrayList<Double> result = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        if(!reverse){
            result.add(-1.0);
        }
        int i = reverse ? A.size()-1 : 0;
        int k = 1;
        while(k < A.size()) {
            int a = A.get(i);
            if (maxHeap.isEmpty() || maxHeap.peek() >= a) {
                maxHeap.add(a);
                if (maxHeap.size() - minHeap.size() > 1) {
                    minHeap.add(maxHeap.remove());
                }
            } else {
                minHeap.add(a);
                if (minHeap.size() > maxHeap.size()) {
                    maxHeap.add(minHeap.remove());
                }
            }
            boolean isEven = ((maxHeap.size() + minHeap.size()) & 1) == 0;
            double median = 0;
            if(isEven){
                median = ((maxHeap.peek()+minHeap.peek())/ 2.0);
            }else{
                median = maxHeap.peek();
            }
            i += reverse ? -1 : 1;
            k++;
            result.add(median);
        }
        if(reverse){
            Collections.reverse(result);
            result.add(-1.0);
        }
        return result;
    }
    static int solve(List<Integer> A) {
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Double> minHeap = new PriorityQueue<>();

        int n = A.size();
        maxHeap.add(Double.valueOf(A.get(0)));
        Double median = maxHeap.peek();
        for (int i = 1; i < n; i++) {
            if (Objects.equals(median, Double.valueOf(A.get(i)))) {
                return 1;
            }
            if (!maxHeap.isEmpty() && A.get(i) < median) {
                maxHeap.add(Double.valueOf(A.get(i)));
            } else {
                minHeap.add(Double.valueOf(A.get(i)));
            }
            if (maxHeap.size() - minHeap.size() > 1) {
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.add(minHeap.poll());
            }
            if (maxHeap.size() == minHeap.size()) {
                median = (maxHeap.peek() + minHeap.peek()) / 2;
            } else {
                median = maxHeap.peek();
            }
        }

        maxHeap.removeAll(maxHeap);
        minHeap.removeAll(minHeap);


        maxHeap.add(Double.valueOf(A.get(n - 1)));
        median = maxHeap.peek();

        for (int i = (n - 2); i >= 0; i--) {
            if (Objects.equals(median, Double.valueOf(A.get(i)))) {
                return 1;
            }
            if (!maxHeap.isEmpty() && A.get(i) < median) {
                maxHeap.add(Double.valueOf(A.get(i)));
            } else {
                minHeap.add(Double.valueOf(A.get(i)));
            }
            if (maxHeap.size() - minHeap.size() > 1) {
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.add(minHeap.poll());
            }
            if (maxHeap.size() == minHeap.size()) {
                median = (maxHeap.peek() + minHeap.peek()) / 2;
            } else {
                median = maxHeap.peek();
            }
        }
        return  0;
    }
}
