/**
 * Given a sorted array that contains n numbers out of which except one value all the other values are repeated twice.
 * Find the number in the array that occurs only once. Do it with constant space and log(n) time.
 */
public class FindNumberWithSingleOccurrence {
    public static void main(String[] args) {
        System.out.println(findNumber(new int[]{1,1,2,2,3,4,4,5,5}));
        System.out.println(findNumber(new int[]{1,1,2,3,3,4,4,5,5}));
        System.out.println(findNumber(new int[]{1,2,2,3,3,4,4,5,5}));
        System.out.println(findNumber(new int[]{1,1,2,2,3,3,4,5,5}));
        System.out.println(findNumber(new int[]{1,1,2,2,3,3,4,4,5}));
        System.out.println(findNumber(new int[]{1,1,2,2,3,3,4,4,5, 6,6,7,7,8,8,9,9}));

    }

    //Log(n) as we are dividing the arrays
    // Idea is as there is guarantee that except one all other numbers will have twice occurrence which means length of
    // the array would be odd. So we can device the array and check center item
    // If it is not equal to it's left or right then that is the ans else move or decide the direction based on the
    // even odd length of the divided array
    private static int findNumber(int[] numbers){
       int number = -1;
       if(numbers.length%2 == 0){
           return number;
       }

       int start = 0;
       int end = numbers.length-1;
       int mid = (end-start)/2;
       boolean isFound = false;

       do{
           if(start == end){
               isFound = true;
               number = numbers[start];
           }else{
               number = numbers[mid];
               if(number != numbers[mid-1] && number != numbers[mid+1]){
                   isFound = true;
               }else {
                   int lLen = 0;
                   int rLen = 0;
                   if(number == numbers[mid -1]){
                       lLen = mid - 1 - start;
                       rLen = end - mid;
                       if(lLen%2 != 0){
                           //Means left side
                           end = mid - 2;
                       }

                       if(rLen%2 != 0){
                           //Means right side
                           start = mid + 1;
                       }

                   }else{
                       lLen = mid - start;
                       rLen = end - mid - 1;

                       if(lLen%2 != 0){
                           //Means left side
                           end = mid - 1;
                       }

                       if(rLen%2 != 0){
                           //Means right side
                           start = mid + 2;
                       }
                   }


                   mid = start + (end -start)/2;
               }
           }

       }while (!isFound);

       return number;
    }
}
