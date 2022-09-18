//https://leetcode.com/contest/weekly-contest-311/problems/sum-of-prefix-scores-of-strings/
public class SumOfPrefixStringScore {
    public static void main(String[] args) {
        SumOfPrefixStringScore sumOfPrefixStringScore = new SumOfPrefixStringScore();
        sumOfPrefixStringScore.print(sumOfPrefixStringScore.sumPrefixScores(new String[]{"abc","ab","bc","b", "abcd", "ac", "bxd", "c"}));
        sumOfPrefixStringScore = new SumOfPrefixStringScore();
        sumOfPrefixStringScore.print(sumOfPrefixStringScore.sumPrefixScores(new String[]{"abc","ab","bc","b"}));
    }

    void print(int[] result){
        for(int i: result){
            System.out.print(i+ " ");
        }
        System.out.println();
    }

    //Trie creates tress at each char level like a->b->c, a->b->c->d etc
    TrieNode root = new TrieNode();  // Trie root.
    class TrieNode {
        int score = 0;
        TrieNode[] child = new TrieNode[26];
    }

    public int[] sumPrefixScores(String[] words) {
        for(String word : words) add(word); // make trie.

        int [] res = new int[words.length];
        for(int i=0; i<res.length; i++)
            res[i] = calculate(words[i]);  // build scores.
        return res;
    }

    void add(String str){
        TrieNode temp = root;
        for(char ch : str.toCharArray()){
            if(temp.child[ch-'a']==null)
                temp.child[ch-'a'] = new TrieNode();
            temp.child[ch-'a'].score++;
            temp = temp.child[ch-'a'];
        }
    }

    int calculate(String str){
        int ans = 0;
        TrieNode temp = root;
        for(char ch : str.toCharArray()){
            ans += temp.child[ch-'a'].score;
            temp = temp.child[ch-'a'];
        }
        return ans;
    }
}
