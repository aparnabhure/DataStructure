import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InfixToPostFix {
    public static void main(String[] args) {
        //ans: qct*o*+gg*+qia-*p*+il*-
        System.out.println(solve("q+(c*t)*o+(g*g)+q*(i-a)*p-(i*l)"));
    }

    static String solve(String A) {

        int n = A.length();

        Map<Character, Integer> map = new HashMap<>();
        map.put('^', 3);
        map.put('/', 2);
        map.put('*', 2);
        map.put('+', 1);
        map.put('-', 1);
        map.put('(', 0);

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<n; i++){
            char c = A.charAt(i);
            if(c == ')'){
                while(!stack.isEmpty()){
                    char x = stack.pop();
                    if(x == '(') break;
                    sb.append(x);
                }
            }else if(c == '('){
                stack.push(c);
            }else if(map.containsKey(c)){
                while(!stack.isEmpty()){
                    char x = stack.peek();
                    if(map.get(x) >= map.get(c)){
                        sb.append(stack.pop());
                    }else{
                        break;
                    }
                }
                stack.push(c);

            }else{
                sb.append(c);
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}
