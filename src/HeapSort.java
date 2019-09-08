/**
 * Space complexity O(1)
 * Best Case O(n log (n))
 * Worst & average case O(n log (n))
 *
 * Rule: hepify tree by finding max heap
 */
public class HeapSort {
    public static void main(String[] args){
        int items[] = new int[7];
        items[0] = 1;
        items[1] = 3;
        items[2] = 9;
        items[3] = 7;
        items[4] = 25;
        items[5] = 19;
        items[6] = 2;
        printList(items);
        heapSort(items, items.length);
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
        heapSort(items, items.length);
        printList(items);
    }

    private static void heapSort(int[] items, int size){ //Size is needed to calculate depth

        for(int i= (size/2-1); i>=0; i--){
            heapifyTree(items, size, i);
        }

        //Now do it for the root nodes
        for (int i=size-1; i>=0; i--)
        {
            int temp = items[0];
            items[0]= items[i];
            items[i] = temp;
            heapifyTree(items, i, 0);
        }

    }

    private static void heapifyTree(int[] items, int size, int currentMaxNode){
        int maxHeapNode = currentMaxNode;
        int leftNode = 2*currentMaxNode + 1;
        int rightNode = 2*currentMaxNode + 2;

        //Check if leftnode index is less than actual array size and find the max item from current node and left node
        if (leftNode < size && items[leftNode] > items[maxHeapNode]){
            maxHeapNode = leftNode;
        }

        //Check if right node index is less than actual array size and find the max item from current node and right node
        if(rightNode <size && items[rightNode] > items[maxHeapNode]){
            maxHeapNode = rightNode;
        }

        // Switpe the max heap if find any
        if(maxHeapNode != currentMaxNode){
            int temp = items[currentMaxNode];
            items[currentMaxNode] = items[maxHeapNode];
            items[maxHeapNode] = temp;

            heapifyTree(items, size, maxHeapNode);
        }
    }

    private static void printList(int[] items){
        System.out.println();
        for(int i=0; i<items.length; i++){
            System.out.print(" " + items[i]);
        }
    }
}
