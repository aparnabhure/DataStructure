import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PairsWithGivenXOR {
    /*
    Given an integer array A containing N distinct integers.

Find the number of unique pairs of integers in the array whose XOR is equal to B.

NOTE:

Pair (a, b) and (b, a) is considered to be the same and should be counted once.

Input 1:

 A = [5, 4, 10, 15, 7, 6]
 B = 5
Input 2:
ans: 1
explanation: (10 ^ 15) = 5

 A = [3, 6, 8, 10, 15, 50]
 B = 5
 ans: 2
 explanation: (3 ^ 6) = 5 and (10 ^ 15) = 5

     */

    public static void main(String[] args) {
        System.out.println(solve(Arrays.asList(5, 4, 10, 15, 7, 6), 5));
        System.out.println(solve(Arrays.asList(3, 6, 8, 10, 15, 50), 5));
        System.out.println(solve(Arrays.asList(3, 6, 8, 10, 15, 50), 11));
    }

    static int solve(List<Integer> A, int B) {
        Set<Integer> xorSet = new HashSet<>();
        int count =0;
        for(int i:A){
            int xor = i^B;
            if(xorSet.contains(xor)){
                count++;
            }
            xorSet.add(i);
        }

        return count;
    }
}
