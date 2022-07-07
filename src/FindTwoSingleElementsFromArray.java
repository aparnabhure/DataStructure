public class FindTwoSingleElementsFromArray {
    public static void main(String[] args) {
        int[] A = new int[]{186, 256, 102, 377, 186, 377};
        int[] result = twoSingleNumbers(A);
        print(result);
        result = solve(A);
        print(result);
    }

    static void print(int[] result){
        for(int i:result){
            System.out.println(i +" ");
        }
        System.out.println();
    }
    static int[] solve(int[] A) {
        int n =A.length;

        int xor = 0;
        for(int i:A){
            xor ^= i;
        }

        //Get the 1stset bit to get the position
        int pos = 0;
        while((xor & 1) != 1){
            xor = xor>>1;
            pos++;
        }

        //Now put the elements in0bitbucket and 1bit bucket for the position
        //do the inplace xor
        int set = 0;
        int unset = 0;
        for(int i: A){
            if((i &(1<<pos)) > 0){
                set ^= i;
            }else{
                unset ^= i;
            }
        }

        return new int[]{Math.min(set, unset), Math.max(set, unset)};
    }

    static int[] twoSingleNumbers(int[] A) {
        int result = 0;
        for(int i:A){
            result ^= i;
        }

        int mask = ((result & (result-1))^result);
        int a = 0;
        int b = 0;
        for(int i:A){
            if((mask&i) != 0){
                a^=i;
            }else{
                b^=i;
            }
        }

        return new int[]{Math.min(a, b), Math.max(a, b)};
    }
}
