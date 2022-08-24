import java.util.HashMap;
import java.util.Map;

public class CountStringPermutations {
    public static void main(String[] args) {
        System.out.println(solve("ebbp", "qaoedpcebeaqocbacoccqoebpqdoqcpbdbqcecdoqcpebqpebbabqdpepcpbqbepbabocpc"));
    }

    static int solve(String A, String B) {
        Map<Character, Integer> chars = new HashMap<>();
        int n = A.length();
        for(int i =0; i<n; i++){
            char c = A.charAt(i);
            int count = chars.getOrDefault(c, 0);
            chars.put(c, ++count);
        }

        int ans = 0;
        int x = B.length();
        for(int i=0; i<n;i++){
            char c = B.charAt(i);
            if(chars.containsKey(c)){
                int count = chars.get(c);
                chars.put(c, --count);
            }
        }

        if(isPermutation(chars)){
            ans++;
        }

        for(int i=1; i<=x-n; i++){
            char c = B.charAt(i-1);
            if(chars.containsKey(c)){
                int count = chars.get(c);
                chars.put(c, ++count);
            }
            c = B.charAt(i+n-1);
            if(chars.containsKey(c)){
                int count = chars.get(c);
                chars.put(c, --count);
            }
            if(isPermutation(chars)){
                ans++;
            }
        }

        return ans;
    }

    static boolean isPermutation(Map<Character, Integer> chars){
        for(char c='a'; c<='z'; c++){
            int count = chars.getOrDefault(c, 0);
            if(count != 0) return false;
        }
        return true;
    }
}
