import java.util.Stack;

public class Check2BracketsExpression {
    public static void main(String[] args) {
        System.out.println(solve("-(a-(-z-(b-(c+t)-x)+l)-q)","-a+l-b-(z-(c+t)-x-q)"));
        System.out.println(solve("-(a+b+c)", "-a-b-c"));
        System.out.println(solve("a-b-(c-d)", "a-b-c-d"));
        System.out.println(solve("-(a+((b-c)-(d+e)))", "-(a+b-c-d-e)"));
        System.out.println(solve("-(-(-(-a+b)-d+c)-q)", "a-b-d+c+q"));
    }

    static int solve(String A, String B) {

        int[] a = postfix(A);
        int[] b = postfix(B);
        for(int i =0; i<26; i++){
            if(a[i] != b[i]) return 0;
        }
        return 1;
    }

    static int[] postfix(String A){
        int n = A.length();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<n; i++){
            char c = A.charAt(i);
            if(c == ')'){
                StringBuilder sb = new StringBuilder();
                while(!stack.isEmpty()){
                    char x = stack.pop();
                    if(x == '(') break;
                    sb.insert(0, x);
                }

                String s = sb.toString();
                while(s.startsWith("+")){
                    s = s.substring(1);
                }

                char operator = !stack.empty()?stack.peek():' ';
                if((operator == '+' || operator == '-') && s.startsWith("-")){
                    stack.pop();
                }

                int N = s.length();
                for(int j=0; j<N; j++){
                    char x = s.charAt(j);
                    if(x == '+'){
                        if(operator == '-'){
                            stack.push(operator);
                        }else{
                            stack.push(x);
                        }
                    }else if(x == '-'){
                        if(operator == '-'){
                            stack.push('+');
                        }else{
                            stack.push(x);
                        }
                    }else{
                        stack.push(x);
                    }
                }
            }else{
                stack.push(c);
            }

        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }

        String s = sb.toString();
        while(s.startsWith("+")){
            s = s.substring(1);
        }
        int[] chars = new int[26];
        char operator = ' ';
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '+' || c == '-'){
                operator = c;
            }else if(operator == '-'){
                chars[c-'a']++;
            }
        }

        return chars;
    }
}
