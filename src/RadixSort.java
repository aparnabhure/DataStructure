/**
 * The idea is to extend the CountSort algorithm to get a better time complexity when k goes O(n^2).
 * Algorithm:
 * For each digit i where i varies from the least significant digit to the most significant digit of a number
 * Sort input array using countsort algorithm according to ith digit.
 *
 * Time Complexity	Ω(n+k)	θ(nk)	O(nk)
 * Space Complexity			O(n+k)
 *
 * Example: Assume the input array is:
 * 10,21,17,34,44,11,654,123
 * Based on the algorithm, we will sort the input array according to the one's digit (least significant digit).
 * 0: 10
 * 1: 21 11
 * 2:
 * 3: 123
 * 4: 34 44 654
 * 5:
 * 6:
 * 7: 17
 * 8:
 * 9:
 *
 * So, the array becomes 10,21,11,123,24,44,654,17
 * Now, we'll sort according to the ten's digit:
 * 0:
 * 1: 10 11 17
 * 2: 21 123
 * 3: 34
 * 4: 44
 * 5: 654
 * 6:
 * 7:
 * 8:
 * 9:
 *
 * Now, the array becomes : 10,11,17,21,123,34,44,654
 * Finally , we sort according to the hundred's digit (most significant digit):
 * 0: 010 011 017 021 034 044
 * 1: 123
 * 2:
 * 3:
 * 4:
 * 5:
 * 6: 654
 * 7:
 * 8:
 * 9:
 *
 * The array becomes : 10,11,17,21,34,44,123,654 which is sorted.
 *
 */
public class RadixSort {
    public static void main(String[] args){
        int items[] = new int[]{10,21,17,34,44,11,654,123};

        int[] sortedArray = radixSort(items);
        printList(sortedArray);


    }

    private static int[] radixSort(int[] array){
        int largest = 0;
        //Find the max value from the array
        for(int i=0; i<array.length; i++){
            if(array[i] > largest){
                largest = array[i];
            }
        }

        //Find the largest number length
        int lengthOfLargestNumber = 0;
        while (largest>0){
            lengthOfLargestNumber++;
            largest = largest/10;
        }

        int bucket[][]=new int[array.length][array.length];
        int bucket_count[]=new int[array.length];
        int divisor = 1;

        for(int pass=0;pass<lengthOfLargestNumber;pass++) // Initialize the buckets
        {
            //Refill the array
            for(int i=0;i<array.length;i++)
                bucket_count[i]=0;

            // sort the numbers according to the digit at passth place
            for(int i=0;i<array.length;i++)
            {
                int remainder = (array[i]/divisor)%10;
                bucket[remainder][bucket_count[remainder]] = array[i];
                bucket_count[remainder] += 1;
            }
            // collect the numbers after PASS pass
            for(int i=0, k=0;k<array.length;k++)
            {
                for(int j=0;j<bucket_count[k];j++)
                {
                    array[i] = bucket[k][j];
                    i++;
                }
            }
            divisor *= 10;
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
