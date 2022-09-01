import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    public static void main(String[] args) {
        Solution solution = new Solution(4);
        solution.set(5, 13);
        solution.set(9, 6);
        solution.set(4, 1);
        System.out.println(solution.get(4));
        solution.set(6, 1);
        solution.set(8, 11);
        System.out.println(solution.get(13));
        System.out.println(solution.get(1));
        solution.set(12, 12);
        System.out.println(solution.get(10));
        solution.set(15, 13);
        solution.set(2, 13);
        solution.set(7, 5);
        solution.set(10, 3);
        System.out.println(solution.get(6));
        System.out.println(solution.get(10));
        solution.set(15, 14);
        solution.set(5, 12);
        System.out.println(solution.get(5));
        System.out.println(solution.get(7));
        System.out.println(solution.get(15));
        System.out.println(solution.get(5));
        System.out.println(solution.get(6));
        System.out.println(solution.get(10));
        solution.set(7, 13);
        System.out.println(solution.get(14));
        solution.set(8, 9);
        System.out.println(solution.get(4));
        solution.set(6, 11);
        System.out.println(solution.get(9));
        solution.set(6, 12);
        System.out.println(solution.get(3));
        System.out.println("*******************");


        solution = new Solution(1);
        solution.set(2,1);
        solution.set(2,2);
        System.out.println(solution.get(2));
        solution.set(1,1);
        solution.set(4,1);
        System.out.println(solution.get(2));
        System.out.println("*******************");
        solution = new Solution(1);
        solution.set(2,1);
        System.out.println(solution.get(2));
        solution.set(3,2);
        System.out.println(solution.get(2));
        System.out.println(solution.get(3));

        System.out.println("*******************");
        solution = new Solution(2);
        solution.set(2,1);
        solution.set(1,1);
        solution.set(2,3);
        solution.set(4,1);
        System.out.println(solution.get(1));
        System.out.println(solution.get(2));
    }

    static class Solution {
        private int capacity;
        private Map<Integer, Integer> lru;
        int length = 0;

        public Solution(int capacity) {
            this.capacity = capacity;
            this.lru = new LinkedHashMap<>();
        }

        public int get(int key) {
            int val = -1;
            if(lru.containsKey(key)){
                val = lru.get(key);
                lru.remove(key);
                lru.put(key, val);
            }
            return val;
        }

        public void set(int key, int value) {
            if (capacity == 0) return;
            if(lru.containsKey(key)){
                lru.remove(key);
                lru.put(key, value);
            }else{
                if(length < capacity){
                    lru.put(key, value);
                    length++;
                }else{
                    int keyToRemove = lru.keySet().stream().findFirst().get();
                    lru.remove(keyToRemove);
                    lru.put(key, value);
                }
            }
        }
    }
}
