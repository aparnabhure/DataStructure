/**
 * In Counting sort, the frequencies of distinct elements of the array to be sorted is counted and stored in an auxiliary array, by mapping its value as an index of the auxiliary array.
 *
 * Example:
 * A = {5, 2, 9, 5, 2, 3, 5}
 * Aux will be of the size 9+1 = 10
 * Occurrences as per index 5 = 3 times, 2 = 2 times
 * Aux = {0, 0, 2, 1, 0, 3, 0, 0, 0, 1}
 * After applying the counting sort algorithm result would be {2, 2, 3, 5, 5, 5, 9}
 *
 * Time Complexity	Ω(n+k)	θ(n+k)	O(n+k)
 * Space Complexity			O(k)
 */
public class CountingSort {
    public static void main(String[] args){
        int items[] = new int[]{5, 2, 9, 5, 2, 3, 5};

        int[] sortedArray = countingSort(items);
        printList(sortedArray);
    }

    private static int[] countingSort(int[] array){
        int k = 0;
        //Find the max value from the array
        for(int i=0; i<array.length; i++){
            if(array[i] > k){
                k = array[i];
            }
        }

        //Declare the aux array
        int[] auxArray = new int[k+1];

        //Fill the aux array for the occurrences
        for(int i=0; i<array.length; i++){
            auxArray[array[i]]++;
        }

        System.out.println();
        printList(auxArray);

        //Create the sorted array
        int sortedArrayIndex = 0;
        for(int i=0; i<auxArray.length; i++){
            int occurrence = auxArray[i];
            while (occurrence > 0){
                array[sortedArrayIndex] = i;
                sortedArrayIndex++;
                occurrence--;
            }
        }

        return array;
    }

    private static void printList(int[] items){
        System.out.println();
        for(int i=0; i<items.length; i++){
            System.out.print(" " + items[i]);
        }
    }

}
