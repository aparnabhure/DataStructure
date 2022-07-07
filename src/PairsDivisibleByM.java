import java.util.*;

public class PairsDivisibleByM {
    public static void main(String[] args) {
        System.out.println(solve(Arrays.asList(93, 9, 46, 79, 56, 24, 10, 26, 9, 93, 31, 93, 75, 7, 4, 80, 19, 67, 49, 84, 62, 100, 17, 40, 35, 84, 14, 81, 99, 31, 100, 66, 70, 2, 11, 84, 60, 89, 13, 57, 47, 60, 59, 60, 42, 67, 89, 29, 85, 83, 42, 47, 66, 80, 88, 85, 83, 82, 16, 23, 21, 55, 26, 2, 21, 92, 85, 26, 46, 3, 7, 95, 50, 22, 84, 52, 57, 44, 4, 23, 25, 55, 41, 49),37));
        //ans =84
        System.out.println(solve(Arrays.asList(1,2,3,4,5),2));
        System.out.println(solve(Arrays.asList(5, 17, 100, 11),28));
    }

    static int solve(List<Integer> A, int B) {
        Map<Integer, Long> map =new HashMap<>();
        int mod = 1000000007;
        long result = 0;
        for(int i:A){
            int m = i%B;
            int y = m==0?0:B-m;
            if(map.containsKey(y)){
                result = (result%mod) + map.get(y)%mod;
            }

            long freq = map.getOrDefault(m, 0L);
            map.put(m, ++freq);

        }

        return (int)result%mod;
    }
}
