import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
4
6 3
abcd aecd abaa abef acdcc acbcc
2 1 3 4 6 5
ab abc a
5 3
aaaa aacd abaa abaa aadcc
3 4 1 2 6
aa aba abc
2 3
aeedd eaa
3 11
aee aeed aee
14 8
bbd cbbdec eaedbcdd bbddc ccced ed aacdbac dbaae a bddedee abbbdee dcddceb aede c
35 8 54 12 21 46 27 19 66 76 32 58 69 36
a eaedbcd eaedb cbb ccced cbbd a ccce


ANS:
abef abaa abcd
abcd
acdcc acbcc abef abaa abcd
aadcc aacd aaaa
abaa abaa
-1
aeedd
aeedd
aeedd
aede a abbbdee aacdbac
eaedbcdd
eaedbcdd
cbbdec
ccced
cbbdec
aede a abbbdee aacdbac
ccced

 */
public class AutoComplete {
    public static void main(String[] args) {
        //args = 4 6 3 abcd aecd abaa abef acdcc acbcc 2 1 3 4 6 5 ab abc a 5 3 aaaa aacd abaa abaa aadcc 3 4 1 2 6 aa aba abc 2 3 aeedd eaa 3 11 aee aeed aee 14 8 bbd cbbdec eaedbcdd bbddc ccced ed aacdbac dbaae a bddedee abbbdee dcddceb aede c 35 8 54 12 21 46 27 19 66 76 32 58 69 36 a eaedbcd eaedb cbb ccced cbbd a ccce
       // Scanner sc = new Scanner(System.in);
        int index = 0;
        int testCases=Integer.parseInt(args[index]);//sc.nextInt();
        for(int i=1; i<=testCases; i++){
            int n = Integer.parseInt(args[++index]);//sc.nextInt();
            int m = Integer.parseInt(args[++index]);//sc.nextInt();
            String[] words = new String[n];
            int[] weight = new int[n];
            String[] prefixes = new String[m];

            for(int j=0; j<n; j++){
                words[j]= args[++index];//sc.next();
            }

            for(int j=0; j<n; j++){
                weight[j]= Integer.parseInt(args[++index]);//sc.nextInt();
            }

            for(int j=0; j<m; j++){
                prefixes[j]= args[++index];//sc.next();
            }

            Word[] wordsArr = new Word[n];
            for(int j=0; j<n; j++){
                wordsArr[j] = new Word(words[j], weight[j]);
            }

            Arrays.sort(wordsArr,(Word first, Word second)->{
                if(first.weight<second.weight) {
                    return 1;
                } else {
                    return -1;
                }
            });


            Trie trie = new Trie('#');

            for(int j=0; j<n; j++){
                insert(trie, wordsArr[j], j);
            }

            for(String prefix: prefixes){
                List<String> ans = findWords(trie, prefix, wordsArr);
                for(String w:ans){
                    System.out.print(w+" ");
                }
                System.out.println();
            }
        }

    }

    static List<String> findWords(Trie root, String prefix, Word[] words){
        Trie node = root;
        int n = prefix.length();
        List<String> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            char c = prefix.charAt(i);
            int index = c-'a';
            if(node.child[index] == null){
                ans.add("-1");
                return ans;
            }
            node = node.child[index];
        }

        int size = node.wordsIndexes.size();
        for(int j=0; j<size; j++){
            Word w = words[node.wordsIndexes.get(j)];
            if(w != null){
                ans.add(w.str);
            }
        }

        return ans;
    }

    static void insert(Trie root, Word word, int wordIndex){
        Trie node = root;
        int n = word.str.length();
        for(int i=0; i<n; i++){
            char c = word.str.charAt(i);
            int index = c-'a';
            if(node.child[index]== null){
                node.child[index] = new Trie(c);
            }
            node = node.child[index];
            if(node.wordsIndexes.size()<5)
                node.wordsIndexes.add(wordIndex);
        }
        node.isEnd = true;
    }

    static class Trie{
        char c;
        boolean isEnd;
        List<Integer> wordsIndexes = new ArrayList<>();
        Trie[] child = new Trie[26];
        public Trie(char c){
            this.c = c;
        }
    }

    static class Word{
        String str;
        int weight;
        public Word(String str, int weight){
            this.str = str;
            this.weight = weight;
        }
    }
}
