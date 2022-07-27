/**
 * Space complexity O(1)
 * Best & Average Case O(n log (n))
 * Worst case O(n^2)
 *
 * Rule: Split the array using pivot and sort individually
 */
public class QuickSort {
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
        quickSort(items, 0, items.length-1);
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
        quickSort(items, 0, items.length -1);
        printList(items);
    }

    static void quickSort2(int[] A, int start, int end){
        if(start>=end) return;
        int index = rearrange(A, start, end);
        quickSort2(A, start, index-1);
        quickSort2(A, index+1, end);
    }

    static int rearrange(int[] A, int start, int end){
        if(A.length == 1) return 0;

        int left = start+1;
        int right = end;
        while(left<=right){
            if(A[left]<=A[start]){
                left++;
            }else if(A[right]>A[start]){
                right--;
            }else{
                int tmp = A[left];
                A[left] = A[right];
                A[right] = tmp;
                left++;
                right--;
            }
        }

        int tmp = A[start];
        A[start] = A[right];
        A[right] = tmp;

        return right;
    }

    private static void quickSort(int[] items, int start, int end){
        if(start < end){
            int pivot = getPivot(items, start, end);//Get partition pivot
            quickSort(items, start, pivot-1);
            quickSort(items, pivot+1, end);
        }
    }
    private static int getPivot(int[] items, int start, int end){
        int pivot = start;
        int flag = 0;
        int left = start;
        int right = end;
        System.out.println();
        System.out.println(" start : " + start + " end : " + end);

        while(flag != 1){
            //Check from right
            while ((items[pivot] <= items[right]) && (pivot != right)){
                right--;
            }

            if(pivot == right){
                flag = 1;
            }else if(items[pivot] > items[right]){   //Here items become iteration 1:  7 3 59 10 205 19 20
                //Swipe
                int temp = items[pivot];
                items[pivot] = items[right];
                items[right] = temp;
                pivot = right;
            }
            System.out.println();
            System.out.println(" right : " + right + " pivot : " + pivot);

            if(flag != 1){
                while ((items[pivot] >= items[left]) && (pivot != left)){
                    left++;
                }


                if(pivot == left){
                    flag = 1;
                }else if(items[pivot] < items[left]){ // Here items become iteration 1:  7 3 10 59 205 19 20
                    //Swipe
                    int temp = items[pivot];
                    items[pivot] = items[left];
                    items[left] = temp;
                    pivot = left;
                }
                System.out.println();
                System.out.println(" left : " + left + " pivot : " + pivot);
            }
        }

        printList(items);

        return pivot;
    }

    private static void printList(int[] items){
        System.out.println();
        for(int i=0; i<items.length; i++){
            System.out.print(" " + items[i]);
        }
    }
}
