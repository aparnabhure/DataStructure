/*
Given two positive integers n and k, the binary string  Sn is formed as follows:

S1 = "0"
Si = Si-1 + "1" + reverse(invert(Si-1)) for i > 1
Where + denotes the concatenation operation, reverse(x) returns the reversed string x, and invert(x) inverts all the bits in x (0 changes to 1 and 1 changes to 0).

For example, the first 4 strings in the above sequence are:

S1 = "0"
S2 = "011"
S3 = "0111001"
S4 = "011100110110001"
Return the kth bit in Sn. It is guaranteed that k is valid for the given n.
 */

public class FindKthBitFromNBitAtring {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findKthBit(3, 1));
        System.out.println(solution.findKthBit(4, 11));
        System.out.println(solution.findKthBit(1, 1));
        System.out.println(solution.findKthBit(2, 3));

    }

     static class  Solution {
        public char findKthBit(int n, int k) {
            String str = "0";
            for(int i=2; i<=n; i++){
                str = str + "1" + reverse(invert(str));
            }

            System.out.println("str = "+str);
            return str.charAt(k-1);
        }


        private String reverse(String s){
            char[] str = s.toCharArray();
            for(int i=0,j=str.length-1; i<str.length/2; i++,j--){
                char temp = str[i];
                str[i] = str[j];
                str[j] = temp;
            }
            return new String(str);
        }

        private String invert(String s){
            s = s.replaceAll("0","X");
            s = s.replaceAll("1","0");
            s = s.replaceAll("X","1");
            return s;
        }
    }
}
