public class ValidateSequenceOfArray {
    public static void main(String[] args) {
        int[] array = new int[]{5,1,22,25,6,-1,8,10};
        int[] sequence = new int[]{1,6,-1,10};

        int s =0;
        int i=0;
        //O(n) n=main array length Space Complexity O(1)
        while (i<array.length && s<sequence.length){
            if(sequence[s] == array[i]){
                s++;
            }
            i++;
        }

        if(s == sequence.length){
            System.out.println("Sequence present");
        }else{
            System.out.println("Sequence not found");
        }
    }
}
