import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModifySearchExactOneCharReplacement {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("data", "circle", "cricket");
        List<String> B = Arrays.asList("date", "circel", "crikket", "data", "circl");
        Trie root = new Trie('#');
        for(String word: words){
            insert(root, word);
        }

        StringBuilder sb = new StringBuilder();
        for(String word:B){
            if(find(root, word,false, 0)) sb.append('1');
            else sb.append('0');
        }

        System.out.println(sb);

        words = Arrays.asList("hello", "world");
        B = Arrays.asList("hella", "pello", "pella");
        root = new Trie('#');
        for(String word: words){
            insert(root, word);
        }

        sb = new StringBuilder();
        for(String word: B){
            if(find(root, word,false, 0)) sb.append('1');
            else sb.append('0');
        }

        System.out.println(sb);

    }

    static boolean find(Trie root, String word, boolean modified, int index){
        if(root == null || (!modified && root.isEnd)) return false;
        if(modified && root.isEnd) return true;
        int n = word.length();
        if(index>=n) return false;

        char c = word.charAt(index);
        if(modified){
            boolean charFound = false;
            for(Trie child: root.child){
                if(child != null && child.c == c){
                    charFound = true;
                    break;
                }
            }
            //No further matching characters
            if(!charFound) return false;
        }

        for(Trie child: root.child){
            if(child== null) continue;
            if(child.c == c){
                if(find(child, word, modified, index+1)){
                    return true;
                }
            }else if(!modified){
                if(find(child, word, true, index+1)){
                    return true;
                }
            }
        }

        return false;

    }

    static void insert(Trie root, String word){
        Trie node= root;
        int n = word.length();
        for(int i =0; i<n; i++){
            char c = word.charAt(i);
            int index = c-'a';
            if(node.child[index]== null){
                node.child[index]= new Trie(c);
            }
            node = node.child[index];
        }
        node.isEnd = true;
    }

    static class Trie{
        char c;
        boolean isEnd;
        Trie[] child = new Trie[26];
        public Trie(char c){
            this.c = c;
        }
    }
}
