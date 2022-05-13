import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/contest/weekly-contest-289/problems/minimum-rounds-to-complete-all-tasks/
public class MinimumRounds {
    public static void main(String[] args) {
        int[] A = new int[]{2,2,3,3,2,4,4,4,4,4};
        System.out.println(minimumRounds(A));
        A = new int[]{2,3,3};
        System.out.println(minimumRounds(A));
        A = new int[]{4,5,6,7,2,4,2,7,6,6,6,6,6,6,6,6,6,5,5};
        System.out.println(minimumRounds(A));
    }

    static int minimumRounds(int[] tasks) {
        int len = tasks.length;
        if (len <= 1) {
            return -1;
        }

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int task : tasks) {
            int count = freqMap.getOrDefault(task, 0);
            count++;
            freqMap.put(task, count);
        }

        int result = 0;
        for (int value: freqMap.values()) {
            if(value<2){
                result = -1;
                break;
            }
            //To minimize the rounds batch of 3 items would be preferred
            result += value/3 + (value%3 != 0 ? 1 : 0);

        }

        return result;
    }
}
