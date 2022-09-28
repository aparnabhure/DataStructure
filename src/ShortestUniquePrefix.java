import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestUniquePrefix {
    public static void main(String[] args) {
        print(prefix(Arrays.asList("zebra", "dog", "duck", "dot")));
    }
    static void print(ArrayList<String> result){
        for(String s: result){
            System.out.print(s+" ");

        }
        System.out.println();
    }
    static ArrayList<String> prefix(List<String> A) {

        Trie root =new Trie('#');
        for(String word:A){
            insert(root, word);
        }

        ArrayList<String> ans = new ArrayList<>();
        for(String word: A){
            ans.add(findPrefix(root, word));
        }

        return ans;

    }

    static String findPrefix(Trie root, String word){
        int n = word.length();
        Trie node = root;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            char c = word.charAt(i);
            sb.append(c);
            int index = c-'a';
            int count = node.child[index].count;
            if(count == 1) break;
            node = node.child[index];
        }
        return sb.toString();
    }

    static void insert(Trie root, String word){
        int n = word.length();
        Trie node = root;
        for(int i=0; i<n; i++){
            char c = word.charAt(i);
            int index = c-'a';
            if(node.child[index] == null){
                node.child[index] =new Trie(c);
            }else{
                int count = node.child[index].count;
                node.child[index].count = ++count;
            }
            node = node.child[index];
        }
        node.isEnd = true;
    }

    static class Trie{
        char c;
        Trie[] child = new Trie[26];
        boolean isEnd;
        int count;
        public Trie(char c){
            this.c = c;
            this.count = 1;
        }
    }
}
