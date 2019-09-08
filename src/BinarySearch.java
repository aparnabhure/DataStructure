/**
 * It always performed on sorted array
 *
 * Rule: Divide the list and identify which way to go by comparing the middle element
 * Worst O(n)
 */
public class BinarySearch {
    public static void main(String[] args){
        int items[] = new int[7];
        items[0] = 1;
        items[1] = 3;
        items[2] = 9;
        items[3] = 11;
        items[4] = 15;
        items[5] = 19;
        items[6] = 29;

        System.out.println("found " + binarySearch(items, 25));
        System.out.println("found " + binarySearch(items, 15));
        System.out.println("found " + binarySearch(items, 30));
        System.out.println("found " + binarySearch(items, 0));
        System.out.println("found " + binarySearch(items, 29));
    }

    private static boolean binarySearch(int[] items, int searchItem){
        boolean itemFound = false;
        int high = items.length-1;
        int low = 0;

        while(low<=high){
            int mid = high-low/2;
            if(items[mid] == searchItem){
                itemFound = true;
                break;
            }
            if(items[mid] < searchItem){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return itemFound;
    }
}
