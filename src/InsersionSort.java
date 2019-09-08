/**
 * Space complexity O(1)
 * Best Case O(n)
 * Worst & average case O(n^2)
 */
public class InsersionSort {
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
        insertionSort(items);
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
        insertionSort(items);
        printList(items);
    }

    private static void insertionSort(int[] items){
        for(int i= 1; i<items.length; i++){
            int temp = items[i];
            int j = i - 1;

            while(j >= 0 && temp <= items[j]){
                items[j+1] = items[j];
                j--;
            }
            items[j+1] = temp;
        }
    }

    private static void printList(int[] items){
        System.out.println();
        for(int i=0; i<items.length; i++){
            System.out.print(" " + items[i]);
        }
    }
}
