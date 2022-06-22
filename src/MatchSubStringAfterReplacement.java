//https://leetcode.com/contest/biweekly-contest-80/problems/match-substring-after-replacement/
public class MatchSubStringAfterReplacement {
    public static void main(String[] args) {
        String s = "fool3e7bar";
        String sub = "leet";
        char[][] mappings = new char[][]{{'e','3'},{'t','7'},{'t','8'}};
        System.out.println(matchReplacement(s, sub, mappings));

        s = "fooleetbar";
        sub = "f00l";
        mappings = new char[][]{{'o','0'}};
        System.out.println(matchReplacement(s, sub, mappings));

        s = "Fool33tbaR";
        sub = "leetd";
        mappings = new char[][]{{'e','3'},{'t','7'},{'t','8'},{'d','b'},{'p','b'}};
        System.out.println(matchReplacement(s, sub, mappings));
    }

    static boolean matchReplacement(String s, String sub, char[][] mappings){

        int n = s.length();
        int m = sub.length();
        int[][] canChange = new int[256][256];

        for(int i=0; i<256; i++){
            canChange[i][i] = 1;
        }
        //Fill for mapping
        for(char[] map: mappings){
            canChange[map[0]][map[1]] = 1;
        }

        for(int i=0; i<n-m+1; i++){
            boolean found = true;

            for(int j=0; j<m; j++){
                if(canChange[sub.charAt(j)][s.charAt(i+j)] == 0){
                    found = false;
                    break;
                }
            }

            if(found){
                return true;
            }
        }

        return false;

    }
}
