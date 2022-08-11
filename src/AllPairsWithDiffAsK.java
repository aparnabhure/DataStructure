import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AllPairsWithDiffAsK {
    public static void main(String[] args) {
        System.out.println(pairs(new int[]{82, 23, 50, 44, 6, 39, 15, 44, 27, 47, 29, 30, 44, 28, 42, 7 ,32 ,16, 40, 8, 7, 5, 48, 48, 16, 9 ,5 ,50,
                16, 18, 9, 21, 26, 48, 37, 27, 7, 5 ,29, 24,28 ,10 ,44 ,21 ,1, 48, 15, 31 ,41, 42,
                23 ,4 ,32 ,40, 40 ,27 ,20, 29 ,42, 25, 18, 37, 43, 13 ,30 ,42, 24, 17, 42 ,14, 42 ,43 ,36, 31, 29, 24 ,24, 8, 3, 12 ,34, 14, 6},62));
        System.out.println(pairs(new int[]{8, 5, 1, 10, 5, 9, 9, 3, 5, 6, 6, 2, 8, 2, 2, 6, 3, 8, 7, 2, 5, 3, 4, 3, 3, 2, 7, 9, 6, 8, 7, 2, 9, 10, 3, 8, 10, 6, 5, 4, 2, 3}, 3));
    }

    static int pairs(int[] A, int B){
        Arrays.sort(A);
        int n = A.length;
        int i=0;
        int j=1;
        Set<String> keys = new HashSet<>();
        while(j<n){
            int diff = A[j]-A[i];
            if(diff == B){
                String key = Math.max(A[i],A[j])+":"+Math.min(A[i],A[j]);
                keys.add(key);
                i++;j++;

            }else if(diff <B){
                j++;
            }else{
                i++;
            }
            if(i==j){
                j++;
            }
        }

        return keys.size();
    }
}
