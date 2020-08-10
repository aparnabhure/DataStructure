import java.util.Arrays;
import java.util.List;

/**
 * Space complexity O(1)
 * Best Case O(n)
 * Worst & average case O(n^2)
 */
public class BubbleSort {
    public static void main(String[] args){
        ThreadDemo A = new ThreadDemo("A");
        ThreadDemo B = new ThreadDemo("B");
        B.start();
        A.start();

        List<Integer> arrays = Arrays.asList(3,2,5,1);
        Object[] obj = arrays.toArray();
        Arrays.sort(obj);

        int i= 010;
        int j = 07;
        System.out.println(i);
        System.out.println(j);
        int items[] = new int[7];
        items[0] = 1;
        items[1] = 3;
        items[2] = 9;
        items[3] = 7;
        items[4] = 25;
        items[5] = 19;
        items[6] = 2;
        printList(items);
        bubbleSort(items);
        printList(items);

        items = new int[7];
        items[0] = 10;
        items[1] = 3;
        items[2] = 59;
        items[3] = 7;
        items[4] = 205;
        items[5] = 19;
        items[6] = 20;
        printList(items);
        bubbleSort(items);
        printList(items);
    }

    private static int[] bubbleSort(int[] items){
        for(int i=0; i<items.length; i++){
            for(int j=i; j<items.length; j++){
                if(items[i] > items[j]){
                    int x = items[i];
                    items[i] = items[j];
                    items[j] = x;
                }
            }
        }
        return items;
    }

    private static int[] sortUsingTwoPointers(int[] items){
        int l = 0;
        int r= items.length-1;

        
        return items;
    }


    private static void printList(int[] items){
        System.out.println();
        for(int i=0; i<items.length; i++){
            System.out.print(" " + items[i]);
        }
    }

    static class ThreadDemo implements Runnable{
        Thread t;
        String threadName;
        public ThreadDemo(String threadName){
            this.threadName = threadName;
        }

        @Override
        public void run() {
            while (true){
                System.out.print(threadName);
            }
        }

        public void start(){
            if(t == null){
                Thread t = new Thread();
                t.start();
            }
        }
    }
}
