/**
 * Bucket sort is a comparison sort algorithm that operates on elements by dividing them into different buckets and then
 * sorting these buckets individually. Each bucket is sorted individually using a separate sorting algorithm or by
 * applying the bucket sort algorithm recursively. Bucket sort is mainly useful when the input is uniformly distributed over a range.
 *
 * Time Complexity	Ω(n+k)	θ(n+k)	O(n^2)
 * Space Complexity			O(1)
 */
public class BucketSort {
    public static void main(String[] args){
        int items[] = new int[]{7, 3, 2, 1, 0, 45};

        int[] sortedArray = bucketSort(items);
        printList(sortedArray);

    }

    private static int[] bucketSort(int[] array){

       int largestNumber = 0;

        //Find the largest number in array
        for(int i=0; i<array.length; i++){
            if(array[i] > largestNumber){
                largestNumber = array[i];
            }
        }

        int[] bucket = new int[largestNumber+1];
        int[] sortedArray = new int[array.length];

        //Fill the bucket
        for( int j=0; j<array.length; j++){
            int index = array[j];
            bucket[index] = index;
        }

        int outPos = 0;
        for (int i = 0; i < bucket.length; i++) {
            int bucketItem = bucket[i];
            if (bucketItem > 0) {
                sortedArray[outPos++] = bucketItem;
            }
        }
        return sortedArray;

    }

    private static void printList(int[] items){
        System.out.println();
        for(int i=0; i<items.length; i++){
            System.out.print(" " + items[i]);
        }
    }

}