import java.util.*;

/**
 * https://leetcode.com/problems/valid-parentheses/
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 */
public class ValidParentheses {
    public static void main(String[] args){
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("){"));
        System.out.println(isValid(")"));
        System.out.println(isValid("(])"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("]"));
        System.out.println(isValid("()]"));
        System.out.println(isValid("(()"));

    }

    private static boolean isValid(String s) {
        Set<String> openParentheses = new HashSet<>();
        openParentheses.add("[");
        openParentheses.add("{");
        openParentheses.add("(");

        Set<String> closeParentheses = new HashSet<>();
        closeParentheses.add("]");
        closeParentheses.add("}");
        closeParentheses.add(")");

        boolean status = false;
        if(s == null || s.length() == 1){
            return status;
        }
        if(s.isEmpty()){
            return true;
        }

        status = true;
        Deque<String> parentheses = new LinkedList<>();
        for(int i=0; i<s.length(); i++){
           String item = Character.toString(s.charAt(i));
           if(openParentheses.contains(item)){
               parentheses.push(item);
           }else if(closeParentheses.contains(item) && parentheses.isEmpty()) {
                status = false;
                break;
           }else if(closeParentheses.contains(item) && !parentheses.isEmpty()){
               String topItem = parentheses.pop();
               if((item.equals("]") && topItem.equals("[")) ||
                       (item.equals("}") && topItem.equals("{")) ||
                       (item.equals(")") && topItem.equals("("))){
                   //do-nothing
               }else{
                   status = false;
                   break;
               }
           }
        }

        if(!parentheses.isEmpty()){
            status = false;
        }

        return status;
    }
}
