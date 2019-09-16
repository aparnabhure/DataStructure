/**
 * In selection sort, the smallest value among the unsorted elements of the array is selected in every pass and inserted
 * to its appropriate position into the array.
 *
 * First, find the smallest element of the array and place it on the first position. Then, find the second smallest
 * element of the array and place it on the second position. The process continues until we get the sorted array.
 *
 * Time	Ω(n)	θ(n2)	o(n2)
 * Space			o(1)
 */
public class SelectionSort {
    public static void main(String[] args){
        int items[] = new int[7];
        items[0] = 10;
        items[1] = 3;
        items[2] = 59;
        items[3] = 7;
        items[4] = 205;
        items[5] = 19;
        items[6] = 20;
        printList(items);
        selectionSort(items);
        printList(items);
    }

    private static int[] selectionSort(int[] items){
       for(int i=0; i<items.length; i++){
           int smallestItemPosition = smallestItemPos(i, items);
           int temp = items[smallestItemPosition];
           items[smallestItemPosition] = items[i];
           items[i] = temp;
       }

       return items;
    }

    private static int smallestItemPos(int index, int[] items){
        int smallestItem = Integer.MAX_VALUE;
        int smallestItemPosition = 0;
        for(int i=index; i<items.length; i++){
            if(items[i] <= smallestItem){
                smallestItem = items[i];
                smallestItemPosition = i;
            }
        }
        return smallestItemPosition;
    }

    private static void printList(int[] items){
        System.out.println();
        for(int i=0; i<items.length; i++){
            System.out.print(" " + items[i]);
        }
    }
}
