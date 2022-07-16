//https://www.geeksforgeeks.org/lexicographic-rank-of-a-string/?ref=gcse
public class SortedPermutationRank {
    public static void main(String[] args) {
        System.out.println(findRank("acb"));
        System.out.println(findRank("a"));
    }

    static int findRank(String A){
        int n = A.length();
        if(n == 1) return 1;
        int mod = 1000003;
        long[] fact = new long[n+1];
        fact[0] = 1;
        for(int i=1; i<=n; i++){
            fact[i] = (fact[i-1]*i)%mod;
        }

        long totalRank = 1;
        for(int i=0; i<n; i++){
            int count = 0;
            //find smaller characters in right
            for(int j=i+1; j<n; j++){
                if(A.charAt(i)>A.charAt(j)){
                    count++;
                }
            }

            totalRank = (totalRank%mod) + (count*fact[n-i-1])%mod;

        }

        return (int)(totalRank%mod);
    }

}
