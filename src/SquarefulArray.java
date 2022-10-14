import java.util.*;

public class SquarefulArray {
    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(Arrays.asList(16777, 1179, 265, 135, 90, 135, 34))));
        System.out.println(solve(new ArrayList<>(Arrays.asList(1, 17, 8))));
    }

    static int count = 0;
    static int solve(ArrayList<Integer> A){
        count = 0;
        int n = A.size();
        if(n == 1) return 0;
        find(A, n, 0);
        return count;
    }

    static boolean isPerfectSquare(int n) {
        if(n>0) {
            double sr = Math.sqrt(n);
            return Math.ceil(sr) == Math.floor(sr);
        }
        return false;
    }

    static public boolean isSquareFul(int n){
        return (Math.sqrt(n)) % 1 == 0;
    }

    static void swap(ArrayList<Integer> A, int i, int j){
        int temp = A.get(i);
        A.set(i,A.get(j));
        A.set(j,temp);
    }

    static void find(ArrayList<Integer> A, int n, int index){
        if(index>=n){
            count++;
        }

        Set<Integer> visitedIdx = new HashSet<>();
        for(int i = index; i < n; i++){
            int num = A.get(i);
            if(!visitedIdx.contains(num) && (i==index || num != A.get(index))){
                swap(A, i, index);
                int sum = index>0?A.get(index) + A.get(index-1):0;
                if(isSquareFul(sum)) {
                   // System.out.println(num + " "+A.get(i-1));
                    find(A, n, index + 1);
                }
                //Reset
                swap(A, index, i);
                visitedIdx.add(A.get(i));
            }
        }
    }
}
