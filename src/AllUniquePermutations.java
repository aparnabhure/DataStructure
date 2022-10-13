import java.util.*;

public class AllUniquePermutations {
    public static void main(String[] args) {
        print(permute(new ArrayList<>(Arrays.asList(1,2,3))));
    }

    static Set<ArrayList<Integer>>set= new HashSet<>();
    static void print(ArrayList<ArrayList<Integer>> result){
        for(ArrayList<Integer> i: result){
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        permute(A, A.size(), 0, new ArrayList<>(A), result);
        return result;
    }

    static void permute(ArrayList<Integer>A, int n, int index, ArrayList<Integer> permutation, ArrayList<ArrayList<Integer>> result){
        if(index >= n){
            ArrayList<Integer> list = new ArrayList<>(permutation);
            if(!set.contains(list)) {
                result.add(list);
                set.add(list);
            }
            return;
        }

        for(int j=index; j<n; j++){
            Collections.swap(permutation, j, index);
            permute(A, n, index+1, permutation, result);
            Collections.swap(permutation, j, index);
        }
    }
}
