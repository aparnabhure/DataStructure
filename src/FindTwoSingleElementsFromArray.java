public class FindTwoSingleElementsFromArray {
    public static void main(String[] args) {
        int[] A = new int[]{186, 256, 102, 377, 186, 377};
        int[] result = twoSingleNumbers(A);
        for(int i:result){
            System.out.println(i +" ");
        }
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
