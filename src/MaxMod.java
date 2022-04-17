public class MaxMod {
    public static void main(String[] args) {
      int[] A = new int[]{
          927, 707, 374, 394, 279, 799, 878, 937, 431, 112
      };
      System.out.println(maxMod(A));
    }

    static int maxMod(int[] A){
        int maxMod = Integer.MIN_VALUE;
        for(int i=0;i<A.length-1; i++){
            for(int j=i+1; j<A.length-1; j++){
                int mod1 = A[i]%A[j];
                int mod2 = A[j]%A[i];
                maxMod = Math.max(maxMod, Math.max(mod1,mod2));
            }
        }

        return maxMod;
    }
}
