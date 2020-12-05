import java.util.Stack;

//https://www.geeksforgeeks.org/recursively-remove-adjacent-duplicates-given-string/
public class RemoveAllAdjacentDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicatesRecursively("abxxxybb"));
        System.out.println(removeDuplicatesRecursively("aazxxzy"));
        System.out.println(removeDuplicatesRecursively("azxxzy"));
        System.out.println(removeDuplicatesRecursively("geeksforgeeg"));
        System.out.println(removeDuplicatesRecursively("caaabbbaacdddd"));
        System.out.println(removeDuplicatesRecursively("aabbccvvv"));
        System.out.println(removeDuplicatesRecursively("aaaa"));

        System.out.println(removeDuplicates("abxxxybb"));
        System.out.println(removeDuplicates("aazxxzy"));
        System.out.println(removeDuplicates("azxxzy"));
        System.out.println(removeDuplicates("geeksforgeeg"));
        System.out.println(removeDuplicates("caaabbbaacdddd"));
        System.out.println(removeDuplicates("aabbccvvv"));
        System.out.println(removeDuplicates("aaaa"));
    }

    private static String removeDuplicatesRecursively(String str){
        if(str == null || str.length() <= 1){
            return str;
        }

        int i=0;
        while (i<str.length()){
            if(i < str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                int j = i;
                while (j<str.length()-1 && str.charAt(j) == str.charAt(j+1)){
                    j++;
                }
                String newStr = str.substring(0, i);
                if(j<str.length()-1) {
                    newStr = newStr.concat(str.substring(j + 1));
                }
                str = removeDuplicatesRecursively(newStr);
            }else{
                i++;
            }
        }

        return str;
    }

    private static String removeDuplicates(String str){
        if(str == null || str.length()<=1){
            return str;
        }

        Stack<Character> cstack = new Stack<>();
        boolean isDuplicateFound = false;
        for(int i=0; i<str.length(); i++){
            char cx = str.charAt(i);

            if(i<str.length()-1 && cx==str.charAt(i+1)){
                isDuplicateFound = true;
                continue;
            }
            if(isDuplicateFound){
                isDuplicateFound = false;
                continue;
            }
            {
                //traverse the stack and remove the characters present in the stack
                if(cstack.isEmpty()){
                    cstack.push(cx);
                }else {
                    char sx = cstack.peek();
                    if (cx == sx) {
                        cstack.pop();
                    } else {
                        cstack.push(cx);
                    }
                }
            }
        }
        return cstack.toString();
    }
}
