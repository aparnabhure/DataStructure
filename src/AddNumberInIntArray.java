public class AddNumberInIntArray {
    public static void main(String[] args) {
        System.out.println(addNumber(new int[]{0, 9, 9, 9}));
        System.out.println(minimumDeletions("aababbab"));
        System.out.println(minimumDeletions("bbaaaaabb"));

    }

    private static int addNumber(int[] array){
        if(array == null || array.length == 0){
            return 0;
        }
        if(array.length == 1){
            return array[0]+1;
        }
        int sum = 0;
        int len = array.length;
        int pow = len-1;
        for(int i=0; i<len; i++, pow--){
            sum += Math.pow(10, pow) + array[i];
        }
        return sum+1;
    }

    private static int minimumDeletions(String s) {
        int mindel = 0;
        if(s.length() <= 1){
            return mindel;
        }

        int[] aCounts = new int[s.length()+1];
        int[] bCounts = new int[s.length()+1];

        //fill a
        for(int i=0; i<s.length(); i++){
            aCounts[i+1] = aCounts[i] + (s.charAt(i) == 'a'?1:0);
        }

        //Fill b in reverse order
        for(int j=s.length()-1; j>=0; j--){
            bCounts[j] = bCounts[j+1] + (s.charAt(j) == 'b'?1:0);
        }
        mindel = s.length();
        for (int i = 0; i < s.length() + 1; i++) {
            mindel = Math.min(mindel, s.length() - aCounts[i] - bCounts[i]);
        }

        return mindel;
    }
}
