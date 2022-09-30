import java.util.*;

public class MaximumXORSubArray {
    public static void main(String[] args) {
        print(solve(Arrays.asList(1, 4, 3)));
    }

    static void print(ArrayList<Integer> result){
        for(int i:result){
            System.out.print(i+",");
        }
        System.out.println();
    }

    static ArrayList<Integer> solve(List<Integer> A) {
        int n = A.size()+1;
        int[] xorpf = new int[n];
        xorpf[0] = 0;
        for(int i=1; i<n ; i++ ){
            xorpf[i] = xorpf[i-1]^A.get(i-1);
        }

        Trie root = new Trie();
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            insert(root, xorpf[i]);
            max= Math.max(max, max(root, xorpf[i]));
        }

        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        int minStart = Integer.MAX_VALUE;
        int minEnd = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            int val = max^xorpf[i];
            if(map.containsKey(val)) {
                int start = map.get(val)+1;
                int end = i;
                int len = end-start+1;
                if(len<minLen) {
                    minLen = len;
                    minStart = start;
                    minEnd = end;
                }
                else if(len==minLen && start<minStart) {
                    minLen = len;
                    minStart = start;
                    minEnd = end;
                }
            }
            map.put(xorpf[i],i);
        }
        ans.add(minStart);
        ans.add(minEnd);
        return ans;

    }

    static int max(Trie root, int num){
        int newNum = 0;
        Trie node = root;
        for(int i=31; i>=0; i--){
            int n = ((1<<i)&num)>0?1:0;
            int x = 1-n;
            if(node.child[x] != null){
                newNum += (x*(1<<i));
                node = node.child[x];
            }else{
                node = node.child[n];
                if(node == null) return 0;
                newNum += (n*(1<<i));
            }
        }
        return (num^newNum);
    }


    static void insert(Trie root, int num){
        Trie node = root;
        for(int i=31; i>=0; i--){
            int n = ((1<<i)&num)>0?1:0;
            if(node.child[n] == null){
                node.child[n] = new Trie();
            }
            node = node.child[n];
        }
    }
    static class Trie{
        Trie[] child = new Trie[2];
    }
}
