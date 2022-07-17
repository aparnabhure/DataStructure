
//https://leetcode.com/contest/leetcode-weekly-contest-3/problems/decode-string/
public class DecodedString {
    public static void main(String[] args) {
        System.out.println(recursiveDecodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
        System.out.println(recursiveDecodeString("100[leetcode]"));
        System.out.println(recursiveDecodeString("3[a]2[bc]"));
        System.out.println(recursiveDecodeString("3[a2[c]]"));
        System.out.println(recursiveDecodeString("2[abc]3[cd]ef"));
    }

    static String recursiveDecodeString(String s){
        int index = s.lastIndexOf("[");
        if(index<0) return s;
        //Get the digit value prior to [
        int numIndex = index-1;
        while(numIndex>=0){
            if(Character.isDigit(s.charAt(numIndex))){
                numIndex--;
            }else{
                break;
            }
        }

        int k = Integer.parseInt(s.substring(numIndex+1, index));
        //Find character before ]
        StringBuilder sb = new StringBuilder();
        String rpStr = s.substring(index+1, s.indexOf(']',index));
        //rpStr = rpStr.repeat(k); //Introduced in Java 11
        while(k>0){
            sb.append(rpStr);
            k--;
        }
        //replace string for first []
        s=s.replace((s.substring(numIndex+1,s.indexOf(']',numIndex+1)+1)),sb.toString());
        return recursiveDecodeString(s);
    }
}
