import java.util.Arrays;

//https://leetcode.com/contest/weekly-contest-303/problems/number-of-excellent-pairs/
public class NumberOfExcellentPairs {

    /*
    Explanation by : votrubac

    The important point to realize is that the sum of OR and AND is just the sum of bits of two numbers.

We dedup the input array, and count numbers containing n number of bits (where n is [1..29]);

Then, we pick any combination of bits i and j, such that i + j >= k.

If i != j, the number of pairs is cnt[i] * cnt[j] * 2; numbers for i and j are different, so they form two pairs.

If i == j, the number of pairs is cnt[i] * cnt[i]. No multiplication to make sure we do not count the same number twice.

If i == j the number of pairs is n * (n + 1) / 2. Then, we multiply it by 2, and we get n * (n + 1).
Now, we need to remove n elements as they only form one pair. Thus, we get n * n.
     */

    public static void main(String[] args) {
        System.out.println(countExcellentPairs(new int[]{1,2,3,1}, 3));
    }

    static long countExcellentPairs(int[] nums, int k) {
        //31 bits array to count for each distinct number, 0th bit exclusion for -ve number
        long[] bits = new long[30];
        for(int num: Arrays.stream(nums).distinct().toArray()){
            bits[Integer.bitCount(num)]++;
        }
        long ans=0;
        for (int i = 1; i < 30; ++i)
            for (int j = Math.max(i, k - i); j < 30; ++j)
                ans += bits[i] * bits[j] * (i == j ? 1 : 2);
        return ans;

    }
}
