public class RotateArrayKTimesFromLastToFirst {
    public static void main(String[] args) {
        int[] A = new int[]{4,5,6,7,1,2,3};
        int[] result = rotate(A, 3);
        printArray(result);

        A = new int[]{5,2,3,-1,6};
        result = rotate(A, 3);
        printArray(result);


        A = new int[]{5,2,3,-1,6};
        result = rotate(A, 20);
        printArray(result);


    }

    static void printArray(int[] A){
        for (int j : A) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    //Approach, reverse first part and then 2nd part and then entire array
    //Example A = [ 4,5,6,7, 1, 2, 3] K = 3
    /*
    Steps:
    Rotate 3 times from last to first
    1st rotation, last element 3 will move to 1st position and rest elements will shift, so array would be
    3,4,5,6,7,1,2
    2nd rotation, last element 2 will move to 1st
    2,3,4,5,6,7,1
    3rd rotation, last element 1 will move to 1st
    1,2,3,4,5,6,7
    Observation:
    Last K elements are now moved to 1st place and rest moved to next
    we can consider array as in 2 partitions
    1st partition from 0th element to n-1-K in this case it is 3 those are 4,5,6,7
    2nd partition from n-K to n-1 ie 7-3=4 to 6 ie 1,2,3

    approach is to reverse each partition first and then final reverse
    partition 1 reverse 7,6,5,4
    partition 2 reverse 3,2,1
    reversed array after 1st and 2nd steps 7,6,5,4,3,2,1

    now reverse this final array result would be
    1,2,3,4,5,6,7

     */
    static int[] rotate(int[] A, int K){
        //This is when K is greater than length then it is same as mod/reminder of the length
        K = K%A.length;
        int len = A.length;
        if(K==0 || K == len){
            return A;
        }

        reverse(A, 0, len-1-K);
        reverse(A, len-K, len-1);
        reverse(A, 0, len-1);
        return A;
    }

    static void reverse(int[] A, int from, int to){
        int i=from;
        int j=to;
        while(i<j){
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++;
            j--;
        }
    }
}
