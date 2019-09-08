/**
 * Space complexity O(n)
 * BWA case O(n log (n))
 *
 * Rule: Breaking up the array in multiple arrays using pivot(mid point) and sort them individually and merge
 *
 */
public class MergeSort {
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
        mergeSort(items, 0, items.length-1);
        printList(items);
    }

    private static void mergeSort(int[] items, int start, int end){
        if(start < end){
            int mid = (end + start)/2;
            mergeSort(items, start, mid);
            mergeSort(items, mid+1, end);
            printListMerged(items, start, mid, end);
        }
    }
    private static void printListMerged(int[] items, int start, int mid , int end) {

        int l = mid - start + 1;
        int r = end - mid;

        int LeftArray[] = new int[l];
        int RightArray[] = new int[r];

        //Fill Left array
        for (int i = 0; i < l; ++i)
            LeftArray[i] = items[start + i];

        //Fill right array
        for (int j = 0; j < r; ++j)
            RightArray[j] = items[mid + 1 + j];

//        System.out.println();
//        System.out.println(" LEFT ARRAY " + l);
//        for (int i = 0; i < LeftArray.length; i++) {
//            System.out.print(" " + LeftArray[i]);
//        }
//        System.out.println();
//        System.out.println(" RIGHT ARRAY " + r);
//        for (int i = 0; i < RightArray.length; i++) {
//            System.out.print(" " + RightArray[i]);
//        }

        //Sort the left and right arrays and merge into main array
        int i = 0, j = 0;
        int k = start;
        while (i < l && j < r) {
            if (LeftArray[i] <= RightArray[j]) {
                items[k] = LeftArray[i];
                i++;
            } else {
                items[k] = RightArray[j];
                j++;
            }
            k++;
        }

//        System.out.println();
//        System.out.println(" MAIN ARRAY STEP 1");
//        for (int x = 0; x < items.length; x++) {
//            System.out.print(" " + items[x]);
//        }

        //Copy all items remaining in the left aray
        while (i < l) {
            items[k] = LeftArray[i];
            i++;
            k++;
        }

//        System.out.println();
//        System.out.println(" MAIN ARRAY STEP 2");
//        for (int x = 0; x < items.length; x++) {
//            System.out.print(" " + items[x]);
//        }

        //Copy all items remaining in the right array
        while (j < r) {
            items[k] = RightArray[j];
            j++;
            k++;
        }

//        System.out.println();
//        System.out.println(" MAIN ARRAY STEP 3");
//        for (int x = 0; x < items.length; x++) {
//            System.out.print(" " + items[x]);
//        }
    }

    private static void printList(int[] items){
        System.out.println();
        for(int i=0; i<items.length; i++){
            System.out.print(" " + items[i]);
        }
    }
}
