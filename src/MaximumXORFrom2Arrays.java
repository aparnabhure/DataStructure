public class MaximumXORFrom2Arrays {
    public static void main(String[] args) {
        System.out.println(maxXOR(new int[]{1, 2, 3}, new int[]{4, 1, 2}));
    }

    static int maxXOR(int[] A, int[] B){
        Trie trie = new Trie();
        for(int i:A){
            trie.insert(i);
        }

        int ans = Integer.MIN_VALUE;
        for(int i:B){
            ans = Math.max(ans, trie.max(i));
        }
        return ans;
    }

    static class TrieNode{
        TrieNode oneBits;
        TrieNode zeroBits;
    }

    static class Trie{
        TrieNode root;
        public Trie(){
            root = new TrieNode();
        }

        public void insert(int num){
            TrieNode temp = root;
            //for 32 bits
            for(int i=31; i>=0; i--){
                if(((1<<i)&num) > 0){
                    if(temp.oneBits == null){
                        temp.oneBits = new TrieNode();
                    }
                    temp = temp.oneBits;
                }else{
                    if(temp.zeroBits == null){
                        temp.zeroBits = new TrieNode();
                    }
                    temp = temp.zeroBits;
                }
            }
        }

        public int max(int num){
            //start from root
            TrieNode temp = root;
            int ans = 0;
            for(int i=31; i>=0; i--){
                if(((1<<i)&num) > 0){
                    //xor is alternate attracts
                    if(temp.zeroBits != null){
                        temp = temp.zeroBits;
                        ans += (1<<i);
                    }else{
                        temp = temp.oneBits;
                    }
                }else{
                    if(temp.oneBits != null){
                        temp = temp.oneBits;
                        ans += (1<<i);
                    }else{
                        temp = temp.zeroBits;
                    }
                }
            }
            return ans;
        }
    }
}
