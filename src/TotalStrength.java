import java.util.Stack;

public class TotalStrength {
    public static void main(String[] args) {
        int[] strength = new int[]{1,3,1,2};
        System.out.println(totalStrength(strength));
        strength = new int[]{1,3,1,2};
        System.out.println(totalStrengthPrefixSum(strength));
    }

    static int totalStrengthPrefixSum(int[] strength){
        long mod = 1000000007, res = 0;
        int n = strength.length;

        long[] leftsum = new long[n + 1], rightsum = new long[n + 1];
        long[] leftmul = new long[n + 1], rightmul = new long[n + 1];
        Stack<Integer> asc = new Stack<>();

        for (int i = 0; i < n; i++) {
            leftsum[i + 1] = (leftsum[i] + strength[i]) % mod;
            leftmul[i + 1] = (leftmul[i] + (long)(i + 1) * strength[i]) % mod;
        }

        for (int i = n - 1; i >= 0; i--) {
            rightsum[i] = (rightsum[i + 1] + strength[i]) % mod;
            rightmul[i] = (rightmul[i + 1] + (long)(n - i) * strength[i]) % mod;
        }

        // j is the exclusive right index
        for (int j = 0; j <= n; j++) {
            while (!asc.empty() && (j == n || strength[asc.peek()] >= strength[j])) {
                int k = asc.pop();
                int i = asc.empty() ? 0 : asc.peek() + 1;
                long left = (mod + leftmul[k + 1] - leftmul[i] - (i * (leftsum[k + 1] - leftsum[i])) % mod) % mod;
                long right = (mod + rightmul[k + 1] - rightmul[j] - ((n - j) * (rightsum[k + 1] - rightsum[j])) % mod) % mod;
                long sum = (left * (j - k) + right * (k - i + 1)) % mod;
                res = (res + sum * strength[k]) % mod;
            }
            asc.push(j);
        }
        return (int)res;
    }

    //O(n^2) but will not work
    static int totalStrength(int[] strength) {
        int n = strength.length;
        if(n == 1){
            return strength[0]*strength[0];
        }
        int mod = 1000000007;

        long total = 0;

        for(int i=0; i<n; i++){
            long min = strength[i];
            long sum = strength[i];
            total = (total + (min%mod) * (sum%mod))%mod;
            for(int j = i+1; j<n; j++){
                int x = strength[j];
                min = Math.min(min, x);
                sum = (sum + x)%mod;
                total = (total + ((min%mod) * (sum%mod))%mod);
            }
        }

        return (int)(total%mod);

    }
}
