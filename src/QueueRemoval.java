import java.util.*;

/**
 * Pop X number of elements from the queue
 * iterated till X
 * While popping remove the last largest number from the items, store the original index of the removed item
 * insert remaining items by reducing by 1 if >0 and add them back in the queue in the same order
 * Repeat the iteration by maintaining the original number and its index with the reduced number mapping
 * and finally return the removed items indexes
 *
 * Example
 * input [1 2 2 3 4 5]
 * output [5 6 4 1 2]
 * X = 5
 * Explanation:
 * First iteration
 * popped items 1 2 2 3 4
 * removed 4 Stored original index+1 which is 5
 * pushed back the remaining items by reducing by 1
 * 5 (1-1) (2-1) (2-1) (3-1) : 5 0 1 1 2
 *
 * 2nd iteration
 * popped items 5 0 1 1 2 Max is 5 as there is no change in this item hence it is original value and its index is 6
 * repeat the same for rest by keeping the changed value
 */
public class QueueRemoval {
    public static void main(String[] args) {
        int[] poppedItems = remove(new int[]{1,2,2,3,4,5}, 5);
        printArray(poppedItems); //output 5 6 4 1 2
        poppedItems = remove(new int[]{2,4,2,4,3,1,2,2,3,4,3,4,4}, 4);
        printArray(poppedItems);//output 2 5 10 13
    }

    private static void printArray(int[] arr){
        System.out.println();
        Arrays.stream(arr).forEach(x->System.out.print(x));
        System.out.println();
    }

    private static int[] remove(int[] items, int x){
        if(items == null || items.length <= 0){
            return new int[]{};
        }
        int len = items.length;
        int xLen = x;
        if(len < x){
            xLen = len;
        }

        int[] result = new int[xLen];

        Queue<Item> queue = new LinkedList<>();
        List<Integer> poppedItems = new ArrayList<>();
        //O(n)
        fillQueue(items, queue);

        int iterations = x;
        int i=0;
        while (!queue.isEmpty() && iterations>0){

            popAndInsert(queue, x, result, i);

            iterations--;
            i++;
        }

        return result;
    }

    private static void popAndInsert(Queue<Item> queue, int x, int[] maxPoppedItems, int i){
        Queue<Item> poppedItems = new LinkedList<>();
        Item maxItem = null;
        while (!queue.isEmpty() && x>0){
            Item item = queue.poll();
            if(item == null){
                continue;
            }
            if(maxItem == null || (item.changedValue> maxItem.changedValue)){
                maxItem = item;
            }

            poppedItems.add(item);
            x--;
        }
        if(maxItem == null){
            return;
        }
        while (!poppedItems.isEmpty()){
            Item item = poppedItems.poll();
            if(item.originalIndex == maxItem.originalIndex){
                continue;
            }
            item.changedValue = item.changedValue>0? item.changedValue-1 : 0;
            queue.add(item);
        }

        maxPoppedItems[i] = maxItem.originalIndex;
    }

    private static void fillQueue(int[] items, Queue<Item> queue){
        for(int i=0; i<items.length; i++){
            Item item = new Item();
            item.originalValue = item.changedValue = items[i];
            item.originalIndex = i+1;
            queue.add(item);
        }
    }

    static class Item{
        int originalValue;
        int changedValue;
        int originalIndex;
    }
}
