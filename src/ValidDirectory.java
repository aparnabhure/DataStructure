import java.util.Arrays;
import java.util.List;

public class ValidDirectory {
    /*
    Given a phone directory in the form of string array A containing N numeric strings.

If any phone number is prefix of another phone number then phone directory is invalid else it is valid.

You need to check whether the given phone directory is valid or not if it is valid then return 1 else return 0.
     */
    public static void main(String[] args) {
        System.out.println(solve(Arrays.asList("1234", "2342", "567")));
        System.out.println(solve(Arrays.asList("00121", "001")));
    }

    static int solve(List<String> A) {
        Trie root = new Trie(-1);
        for(String s: A){
            if(!valid(root, s)) return 0;
        }
        return 1;
    }

    static boolean valid(Trie root, String num){
        char c =num.charAt(0);
        int index = c-'0';
        if(root.child[index] != null) return false;
        root.child[index] = new Trie(1);
        return true;
    }
    static class Trie {
        int weight;
        Trie[] child = new Trie[10];
        public Trie(int weight){
            this.weight =weight;
        }
    }
}
