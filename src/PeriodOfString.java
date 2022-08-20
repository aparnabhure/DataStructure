public class PeriodOfString {
    /*
    You are given a string A of length N consisting of lowercase alphabets. Find the period of the string.

Period of the string is the minimum value of k (k >= 1), that satisfies A[i] = A[i % k] for all valid i.
     */
    public static void main(String[] args) {
        System.out.println(solve("abababab"));
        System.out.println(solve("aaaa"));
    }

    static int solve(String A) {
        int n = A.length();
        int[] lps = lpsArray(A, n);
        return n-lps[n-1];
    }

    static  int[] lpsArray(String A, int n){
        int[] lps = new int[n];
        int x = 0;
        int i=1;
        while (i<n){
            if(A.charAt(i) == A.charAt(x)){
                lps[i++]=++x;
            }else{
                if(x!=0) x = lps[x-1];
                else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        return lps;
    }
}
