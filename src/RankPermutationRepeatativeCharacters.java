import java.util.Arrays;

//https://www.geeksforgeeks.org/lexicographic-rank-string-duplicate-characters/
public class RankPermutationRepeatativeCharacters {
    public static void main(String[] args) {
        //rank("strwAasBuOU");
        System.out.println(rank("abab"));
        System.out.println(findRank("abab"));
        System.out.println(rank("asasdsdsadasdadsadasdsa"));
        System.out.println(findRank("asasdsdsadasdadsadasdsa"));
        System.out.println(findRank("sadasdsasassasas"));
        System.out.println(findRank("abab"));
        System.out.println(findRank("settLe"));
    }

    static long rank(String s){

        //Pre calculate factorials ans inverse mode factorials
        int mod = 1000003;
        int n = s.length();
        long[] fact = new long[n+1];
        long[] inverseModeFact = new long[n+1];
        fact[0] = 1;
        inverseModeFact[0] = fastPower(1L, mod-2, mod);
        for(int i=1; i<=n; i++){
            fact[i] = (fact[i-1]*i)%mod;
            inverseModeFact[i] = fastPower(fact[i], mod-2, mod);
        }

        //Frequency array
        int[] freq = new int[52];
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(Character.isLowerCase(c)){
                freq[c-'a'+26]++;
            }else{
                freq[c-'A']++;
            }
        }

        long count = 0;
        for(int i=0; i<n; i++){
            char c1 = s.charAt(i);
            int index;
            if(Character.isLowerCase(c1)){
                index = c1-'a'+26;
            }else{
                index = c1-'A';
            }

            long ans = 0;
            //Run till characters less than current char
            for(int j=0; j<index; j++){
                if(freq[j] !=0){
                    //Reducing freq by one
                    freq[j]--;
                    long factorial = fact[n-i-1];
                    //Calculate denominator for repeated characters
                    for( int k = 0; k < 52; k++){
                        if(freq[k] > 1){
                            long inverseMode = inverseModeFact[freq[k]];
                            factorial = ((factorial % mod) *(inverseMode % mod)) % mod;
                        }
                    }
                    //Add it back
                    freq[j]++;
                    ans = ((ans % mod) + (factorial % mod)) % mod;

                }
            }

            count = (count%mod + ans%mod)%mod;

            //Reduce freq of already processed character
            if(freq[index] != 0) {
                freq[index]--;
            }

        }


        return count+1;
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
