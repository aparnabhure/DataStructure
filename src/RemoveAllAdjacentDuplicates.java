import java.util.Stack;

//https://www.geeksforgeeks.org/recursively-remove-adjacent-duplicates-given-string/
public class RemoveAllAdjacentDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("aazxxzy"));
        System.out.println(removeDuplicates("azxxzy"));
        System.out.println(removeDuplicates("geeksforgeeg"));
        System.out.println(removeDuplicates("caaabbbaacdddd"));
        System.out.println(removeDuplicates("aabbccvvv"));
        System.out.println(removeDuplicates("aaaa"));
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
