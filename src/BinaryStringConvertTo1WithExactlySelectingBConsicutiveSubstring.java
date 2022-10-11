public class BinaryStringConvertTo1WithExactlySelectingBConsicutiveSubstring {
    public static void main(String[] args) {
        System.out.println(solve("00010110", 3));
    }

    static int solve(String A, int B) {

        int ans = 0;
        int n = A.length();
        int [] counter = new int [n];
        int count =0;

        for(int i=0; i< n; i++) {
            count = count + counter[i];
            if(A.charAt(i) == '0' && count %2 ==0 || A.charAt(i)  == '1' && count %2 ==1) {
                count++;
                if(i <=n-B) {
                    ans ++;
                    if(i+B < n) {
                        counter[i+B] = -1;
                    }
                }else {
                    return -1;
                }
            }
        }

        return ans;

    }
}
