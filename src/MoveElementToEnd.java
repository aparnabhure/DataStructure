public class MoveElementToEnd {
    public static void main(String[] args) {

        int[] array = new int[]{2,1,3,2,2,2,5,2};

        int[] movedArray = moveElementToEnd(array, 2);
        for (int i:movedArray){
            System.out.print(i +" ");
        }

    }

    //O(n) time | O(1) space
    private static int[] moveElementToEnd(int[] array, int itemToMove){

        int left = 0;
        int right = array.length-1;
        while (left<right){

            while (left<right && array[right] == itemToMove){
                right--;
            }
            if(array[left] == itemToMove){
                //Swipe the items
                int temp =array[left];
                array[left] = array[right];
                array[right] = temp;
            }
            left++;
        }

        return array;
    }
}
