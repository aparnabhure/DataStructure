import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique
public class MinDeleteInString {
    public static void main(String[] args) {
        //System.out.println(minDelete("aabbabcc"));
        System.out.println(minDelete("ababerhhrrrqwiiiii"));
        System.out.println(minDeleteUsingQueue("ababerhhrrrqwiiiii"));
    }
    static int minDelete(String s){
        if(s == null || s.length()<=1){
            return 0;
        }

        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i)-'a']++;
        }
        Arrays.sort(freq);
        int count = 0;
        for(int i = freq.length-2; i>=0; i--){
            if(freq[i] == 0)
                break;
            if (freq[i] >= freq[i + 1]) {
                if (freq[i + 1] > 0) {
                    count += freq[i] - freq[i + 1] + 1;
                    freq[i] = freq[i + 1] - 1;
                } else {
                    count += freq[i];
                    freq[i] = 0;
                }
            }
        }

        return count;
    }

    static int minDeleteUsingQueue(String s){
        Map<Character,Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            map.compute(s.charAt(i),(key,value)->{
                if(value==null){
                    value = 0;
                }
                value++;
                return value;
            });
            max = Math.max(max,map.get(s.charAt(i)));
        }
        int freq[] = new int[max+1];
        for(Map.Entry<Character,Integer>entry:map.entrySet()){
            freq[entry.getValue()]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for(int i=max;i>=0;i--){
            if(freq[i]>0){
                while(freq[i]>1){
                    queue.add(i);
                    freq[i]--;
                }
            } else if(freq[i] == 0 && !queue.isEmpty()) {
                count =  count + queue.poll()-i;
            }
        }
        while(!queue.isEmpty()) {
            count+=queue.poll();
        }
        return count;
    }
}
