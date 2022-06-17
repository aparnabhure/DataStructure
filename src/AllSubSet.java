import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubSet {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = subsets(Arrays.asList(1,2,3));
        print(result);
    }

    static void print(ArrayList<ArrayList<Integer>> result){
        System.out.print("[");
        for(ArrayList<Integer> item:result){
            System.out.print("[");
            for(int i:item){
                System.out.print(i+" ");
            }
            System.out.print("], ");
        }
        System.out.print("]");
    }

    static ArrayList<ArrayList<Integer>> subsets(List<Integer> A) {
        int n = A.size();

        int n2 = 1<<n;

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i=0; i<n2; i++){
            ArrayList<Integer> subSeq = new ArrayList<>();
            for(int j=0; j<n; j++){
                if(((1<<j)&i) >0){
                    subSeq.add(A.get(j));
                }
            }
            result.add(subSeq);
        }

        return result;
    }
}
