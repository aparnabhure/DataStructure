//https://www.geeksforgeeks.org/lexicographic-rank-string-duplicate-characters/
public class RankPermutationRepeatativeCharacters {
    public static void main(String[] args) {
        System.out.println(findRank("asasdsdsadasdadsadasdsa"));
        System.out.println(findRank("sadasdsasassasas"));
        System.out.println(findRank("abab"));
        System.out.println(findRank("settLe"));
    }

    static int findRank(String s) {
        int mod = 1000003;
        int n = s.length();
        long[] fact = new long[n+1];
        fact[0] = 1;
        for(int i=1; i<=n; i++){
            fact[i] = (fact[i-1]*i)%mod;
        }

        long totalRank = 1;
        for(int i=0; i<n; i++){

            //Count number of characters less than current
            long lessThanCounts = 0;
            //Frequency map
            long[] freq = new long[52]; //small & capital letters
            char current = s.charAt(i);
            if(Character.isLowerCase(current)){
                freq[current-'a']++;
            }else{
                freq[current-'A'+26]++;
            }
            for(int j=i+1; j<n; j++){
                char c = s.charAt(j);
                if(c<current){
                    lessThanCounts++;
                }

                if(Character.isLowerCase(c)){
                    freq[c-'a']++;
                }else{
                    freq[c-'A'+26]++;
                }
            }

            //Now calculate permutations with repeatative chars formula
            long freqFactorial = 1;
            for(long fr:freq){
                //freqFactorial = (freqFactorial%mod * fact[(int)fr]%mod)%mod;
                freqFactorial = (freqFactorial * fact[(int)fr])%mod;
            }

            //totalRank += ((fact[n-i-1]*lessThanCounts)%mod/freqFactorial)%mod;
            long d = fastPower(freqFactorial, mod-2, mod);
            totalRank = (totalRank%mod) + ((lessThanCounts*(fact[n-i-1]))*d)%mod;

        }

        return (int)(totalRank%mod);
    }

    static long fastPower(long A, int pow, int mod){
        if(pow == 0)return 1;

        long p = fastPower(A, pow/2, mod) %mod;
        p = ((p*p)%mod);
        if(pow%2 == 0){
            return p;
        }

        return ((A*p)%mod);
    }
}
