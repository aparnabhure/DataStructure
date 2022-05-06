import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/contest/weekly-contest-291/problems/k-divisible-elements-subarrays/
public class CountDistinctSubArray {
    public static void main(String[] args) {
        int[] A = new int[]{2,3,3,2,2};
        System.out.println(countDistinctSubArrays(A, 2, 2));
        A = new int[]{1,9,8,7,19};
        System.out.println(countDistinctSubArrays(A, 1, 6));
        A = new int[]{10,2,17,7,20};
        System.out.println(countDistinctSubArrays(A, 1, 10));
    }

    static int countDistinctSubArrays(int[] A, int k, int p){
        Set<String> subArrays = new HashSet<>();

        for(int i=0; i<A.length; i++){
            String s = "";
            int count = 0;
            for(int j=i; j<A.length; j++){
                if(A[j]%p ==0){
                    if(count == k){
                        break;
                    }
                    count++;
                }
                s+= A[j]+":";
                subArrays.add(s);
            }
        }
        return subArrays.size();
    }
}
