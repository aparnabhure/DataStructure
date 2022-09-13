import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        print(slidingMaximum(Arrays.asList(1, 3, -1, -3, 5, 3, 6, 7), 3));
    }

    static void print(ArrayList<Integer> result){
        for(int i:result){
            System.out.print(i+" ,");
        }
        System.out.println();
    }
    static ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        int len = A.size();
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> dequeue = new ArrayDeque<>();

        for(int i=0; i<B; i++){
            while(!dequeue.isEmpty() && A.get(i)>dequeue.peekLast()){
                dequeue.pollLast();
            }
            dequeue.addLast(A.get(i));
        }
        result.add(dequeue.peekFirst());

        for(int i=B; i<len; i++){
            while(!dequeue.isEmpty() && A.get(i)>dequeue.peekLast()){
                dequeue.pollLast();
            }
            dequeue.addLast(A.get(i));

            if( !dequeue.isEmpty() && dequeue.peekFirst().equals(A.get(i-B))){
                dequeue.pollFirst();
            }

            result.add(dequeue.peekFirst());
        }

        return result;
    }
}
