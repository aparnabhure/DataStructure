import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class MaximumFreqStack {
    public static void main(String[] args) {
        ArrayList<List<Integer>> A = new ArrayList<>();
        A.add(Arrays.asList(1,5));
        A.add(Arrays.asList(1,7));
        A.add(Arrays.asList(1,5));
        A.add(Arrays.asList(1,7));
        A.add(Arrays.asList(1,4));
        A.add(Arrays.asList(1,5));
        A.add(Arrays.asList(2,0));
        A.add(Arrays.asList(2,0));
        A.add(Arrays.asList(2,0));
        A.add(Arrays.asList(2,0));
        print(solve(A));
    }

    static void print(ArrayList<Integer> result){
        for(int i:result){
            System.out.print(i+" ,");
        }
        System.out.println();
    }

    static ArrayList<Integer> solve(ArrayList<List<Integer>> A) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        Map<Integer, Stack<Integer>> freStackMap = new HashMap<>();

        int maxFreq = Integer.MIN_VALUE;
        ArrayList<Integer> ans = new ArrayList<>();
        for(List<Integer> operation:A){
            int op = operation.get(0);
            int val = operation.get(1);
            if(op == 1){
                int freq = freqMap.getOrDefault(val, 1);
                ++freq;
                maxFreq = Math.max(maxFreq, freq);
                freqMap.put(val, freq);

                Stack<Integer> st = freStackMap.getOrDefault(freq, new Stack<>());
                st.push(val);
                freStackMap.put(freq, st);
                ans.add(-1);
            }else{
                Stack<Integer> st = freStackMap.get(maxFreq);
                val = st.pop();
                //REduce the frequency
                int freq = freqMap.get(val);
                freqMap.put(val, --freq);
                if(st.isEmpty()){
                    maxFreq--;
                }
                ans.add(val);
            }
        }

        return ans;
    }
}
