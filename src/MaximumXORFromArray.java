public class MaximumXORFromArray {
    public static void main(String[] args) {
        System.out.println(maxXOR(new int[]{3,10,5,25,2,8}));
        System.out.println(maxXOR(new int[]{14,70,53,83,49,91,36,80,92,51,66,70}));
    }

    static int maxXOR(int[] nums){
        Trie trie = new Trie();

        //Fill Trie data structure
        for(int i: nums) {
            trie.insert(i);
        }

        int max = Integer.MIN_VALUE;
        for(int i:nums){
            max = Math.max(max, trie.max(i));
        }
        return max;

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

    static class TrieNode{
        TrieNode oneBits;
        TrieNode zeroBits;
    }

}
