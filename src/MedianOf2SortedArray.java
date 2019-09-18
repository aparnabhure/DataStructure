/**
 * https://leetcode.com
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 *
 * Example
 * Input : ar1[] = {-5, 3, 6, 12, 15}
 *         ar2[] = {-12, -10, -6, -3, 4, 10}
 *         The merged array is :
 *         ar3[] = {-12, -10, -6, -5 , -3,
 *                  3, 4, 6, 10, 12, 15}
 * Output : The median is 3.
 *
 * Input : ar1[] = {2, 3, 5, 8}
 *         ar2[] = {10, 12, 14, 16, 18, 20}
 *         The merged array is :
 *         ar3[] = {2, 3, 5, 8, 10, 12, 14, 16, 18, 20}
 *         if the number of the elements are even,
 *         so there are two middle elements,
 *         take the average between the two :
 *         (10 + 12) / 2 = 11.
 * Output : The median is 11.
 */

public class MedianOf2SortedArray {
    public static void main(String[] args){
        int[] a1 = new int[]{};
        int[] a2 = new int[]{1,2,3,4,5};
        System.out.println(getMedian(a1, a2));

        a1 = new int[]{};
        a2 = new int[]{1};
        System.out.println(getMedian(a1, a2));

        a1 = new int[]{};
        a2 = new int[]{2,3};
        System.out.println(getMedian(a1, a2));

        a1 = new int[]{1,2};
        a2 = new int[]{3, 4};
        System.out.println(getMedian(a1, a2));

        a1 = new int[]{};
        a2 = new int[]{1,2,3,4,5,6};
        System.out.println(getMedian(a1, a2));

        a1 = new int[]{1,3};
        a2 = new int[]{2};
        System.out.println(getMedian(a1, a2));

        a1 = new int[]{5};
        a2 = new int[]{6,8};
        System.out.println(getMedian(a1, a2));

        int[] merged = mergedArray(a1, a2);
        printList(merged);

        a1 = new int[]{};
        a2 = new int[]{ 2};
        merged = mergedArray(a1, a2);
        printList(merged);

        a1 = new int[]{ 1, 3};
        a2 = new int[]{ 2, 5};
        merged = mergedArray(a1, a2);
        printList(merged);

        a1 = new int[]{ 1};
        a2 = new int[]{ 2, 5};
        merged = mergedArray(a1, a2);
        printList(merged);

        a1 = new int[]{ 3};
        a2 = new int[]{ 2, 5};
        merged = mergedArray(a1, a2);
        printList(merged);

        a1 = new int[]{ 1, 3};
        a2 = new int[]{ 5};
        merged = mergedArray(a1, a2);
        printList(merged);

        a1 = new int[]{ 1, 3};
        a2 = new int[]{ 2};
        merged = mergedArray(a1, a2);
        printList(merged);

        a1 = new int[]{ 8};
        a2 = new int[]{ 5};
        merged = mergedArray(a1, a2);
        printList(merged);

    }

    private static float getMedian(int[] array1, int[] array2){
        int[] mergedArray = mergedArray(array1, array2);
//        if(mergedArray.length == 1){
//            return mergedArray[0];
//        }
//
//        if(mergedArray.length == 2){
//            return (float) (mergedArray[0] + mergedArray[1])/2;
//        }

        int mode = mergedArray.length%2;
        int cIndex = mergedArray.length/2;
        float median;
        if(mode == 0){
            median = (float) (mergedArray[cIndex] + mergedArray[cIndex-1])/2;
        }else{
            median = mergedArray[cIndex];
        }
        return median;
    }

    private static int[] mergedArray(int[] array1, int[] array2){
        int a1Len = array1.length;
        int a2Len = array2.length;
        int[] mergedArray = new int[a1Len+a2Len];

        int i=0, j=0, k=0;

        while (i < a1Len && j < a2Len){
            if(array1[i] < array2[j]){
                mergedArray[k] = array1[i];
                i++;
            }else{
                mergedArray[k] = array2[j];
                j++;
            }
            k++;
        }

        while (i<a1Len){
            mergedArray[k] = array1[i];
            i++;
            k++;
        }

        while (j<a2Len){
            mergedArray[k] = array2[j];
            j++;
            k++;
        }

        return mergedArray;

    }

    private static void printList(int[] items){
        System.out.println();
        for(int i=0; i<items.length; i++){
            System.out.print(" " + items[i]);
        }
    }
}
