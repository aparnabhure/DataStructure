import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumPairs {
    /*
    Input 1:

 A = ["apple", "ap", "app", "ap"]
 B = [3, -1, 2, -1]

Input 2:

 A = ["ban", "banana", "ba"]
 B = [10, -1, -1]



Example Output

Output 1:

 [3, 5]

Output 2:

 [0, 10]

     */

    public static void main(String[] args) {
        print(solve(
                Arrays.asList("aaac", "aaca", "babb", "ccca", "ccbc", "ccac", "bcbb", "abbb", "bbca", "cbba",
                        "ccaa",   "ccbb", "baac", "bbaa", "caaa", "aaca", "cbcb", "abaa", "accb", "abcb",
                        "bb", "cb", "ab", "ba", "aa", "cc", "aa", "aa", "bc", "aa"),
                Arrays.asList(42, 68, 35, 1, 70, 25, 79, 59, 63, 65, 6, 46, 82, 28, 62, 92, 96, 43, 28, 37,
                        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1)));
    }

    static void print(ArrayList<Integer> result){
        for(int i:result){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    static ArrayList<Integer> solve(List<String> A, List<Integer> B) {
        ArrayList<Integer> ans = new ArrayList<>();
        Trie root=new Trie();
        int n = A.size();
        for(int i =0; i<n; i++){
            String str = A.get(i);
            int val = B.get(i);
            if(val != -1){
                insert(root, str, val);
            }else{
                ans.add(find(root, str));
            }
        }

        return ans;

    }

    static int find(Trie root, String str){
        int n = str.length();
        for(int i=0; i<n; i++){
            char c = str.charAt(i);
            int index = c-'a';
            if(root.child[index] == null){
                return 0;
            }
            root = root.child[index];
        }
        sum = 0;
        sumOfAllValidWordValue(root);
        return sum;
    }

    static int sum = 0;
    static void sumOfAllValidWordValue(Trie curr){
        if(curr== null)
            return;
        sum += curr.val;
        for(Trie node:curr.child){
            if(node != null){
                sumOfAllValidWordValue(node);
            }
        }
    }

    static void insert(Trie root, String str, int val){
        int n = str.length();
        for(int i=0; i<n; i++){
            char c = str.charAt(i);
            int index = c-'a';
            if(root.child[index] == null){
                root.child[index] =new Trie();
            }

            root = root.child[index];
        }
        root.val =val;
    }

    static class Trie{
        int val;
        Trie[] child = new Trie[26];

    }
}
