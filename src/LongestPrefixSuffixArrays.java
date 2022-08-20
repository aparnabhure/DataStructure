public class LongestPrefixSuffixArrays {
    public static void main(String[] args) {
        int[] lps = lpsArray("abacd#dcaba");
        PrintUtil.print(lps);
        PrintUtil.print(lpsArray("abab#abababa"));
    }

    static int[] lpsArray(String s){
        int n = s.length();
        int[] lps = new int[n];
        int x =0;
        lps[0] = x;
        int i=1;
        while ( i<n){
            if (s.charAt(i) == s.charAt(x)) {
                x++;
                lps[i] = x;
                i++;
            }
            else // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (x != 0) {
                    x = lps[x - 1];

                    // Also, note that we do not increment
                    // i here
                }
                else // if (len == 0)
                {
                    lps[i] = 0;
                    i++;
                }
            }
//            x = lps[i-1];
//            while(s.charAt(i) != s.charAt(x)){
//                if(x==0){
//                    break;
//                }
//                x = lps[x-1];
//            }
//            //if(x != 0)
//                lps[i] = x+1;
        }
        return lps;
    }
}
