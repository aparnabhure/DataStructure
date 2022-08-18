public class CountA {
    /*
    Find the number of substrings that start and end with 'a'.
     */
    public static void main(String[] args) {
        System.out.println(solve("fnmzxvozgkpkwuuwbnlbajogijoaxipjwwfaqefjnvfbcilerkdaeysamehgdouvspojtuvh"));
    }

    static int solve(String A) {
        int n = A.length();
        int[] asarr = new int[n];
        asarr[0] = A.charAt(0) == 'a'?1:0;
        for(int i =1; i<n; i++){
            if(A.charAt(i) == 'a'){
                asarr[i] += asarr[i-1]+1;
            }else{
                asarr[i] = asarr[i-1];
            }
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            ans += (A.charAt(i) == 'a'?asarr[i]:0);
        }

        return ans;
    }
}
