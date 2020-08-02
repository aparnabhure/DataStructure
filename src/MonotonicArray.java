/**
 * Identify if an array ismonotonic or not
 * which means array either be entirly increasing or decreasing
 * A[i]>=A[j] or A[i]<=A[j]
 */
public class MonotonicArray {
    public static void main(String[] args) {
        int[] array = new int[]{-1,-5,-10,-1100,-1100,-1101,-1102,-9001}; //True
        int[] array2 =new int[]{1,1,1,3,4,8,10,14}; //True
        int[] array3 = new int[]{1,2,2,6,9,5,10}; //False
        int[] array4 =new int[]{100,90,50,40,20,10,4}; //True
        System.out.println(isMonotonic(array));
        System.out.println(isMonotonic(array2));
        System.out.println(isMonotonic(array3));
        System.out.println(isMonotonic(array4));
    }

    //O(n) | O(1)
    private static boolean isMonotonic(int[] array){
        boolean isMonotonic = true;
        if(array.length <=2){
            return isMonotonic;
        }

        boolean isDirectionFound = false;
        boolean direction = false;
        for (int i=0; i<array.length-1; i++){
            while (i<array.length && array[i] == array[i+1]){
                i++;
            }
            if(!isDirectionFound){
                direction = array[i]<array[i+1];
                isDirectionFound = true;
            }

            boolean currentDirection = array[i]<array[i+1];
            if(currentDirection != direction){
                isMonotonic = false;
                break;
            }
        }

        return isMonotonic;
    }
}
