import java.util.ArrayList;
import java.util.List;

public class AlternativeSubArrays {
    public static void main(String[] args) {
        int[] A = new int[]{1,1,0,1,0,1,0,1,0,1};
        int B = 1;
        int[] result = solve(A, B);
        print(result);

        A = new int[]{1, 0, 1, 0, 1};
        B = 1;
        result = solve(A, B);
        print(result);

        A = new int[]{0, 0, 0, 1, 1, 0, 1};
        B = 0;
        result = solve(A, B);
        print(result);
    }
    static void print(int[] result){
        for(int i:result){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    static  int[] solve(int[] A, int B) {
        int len = A.length;
        if(len <= 0){
            return new int[]{};
        }

        int subArrayLen = (2*B+1);
        if(subArrayLen>len){
            return new int[]{};
        }

        List<Integer> indices = new ArrayList<>();
        int prev = -1;
        int sLen = 0;
        for(int i=0; i<len; i++){
            if(subArrayLen == 1){
                indices.add(i);
            }else{
                if(prev != A[i]){
                    sLen++;
                }else{
                    sLen = 1;
                }
                prev = A[i];
                if(sLen == subArrayLen){
                    indices.add(i-(subArrayLen/2));
                    sLen--;
                }
            }
        }

        return indices.stream().mapToInt(i->i).toArray();
    }
}
