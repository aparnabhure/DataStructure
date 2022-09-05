import java.util.*;

public class EvaluateExpression {
    public static void main(String[] args) {
        System.out.println(evalRPN(Arrays.asList("5", "1", "2", "+", "4", "*", "+","3", "-")));
    }

    static int evalRPN(List<String> A) {
        int n = A.size();
        if(n == 1) return Integer.parseInt(A.get(0));
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");

        Stack<Integer> nums = new Stack<>();
        for(String s: A){
            if(operators.contains(s)){
                int b = nums.pop();
                int a = nums.pop();
                int x = polish(a, b, s);
                nums.push(x);
            }else{
                nums.push(Integer.parseInt(s));
            }
        }
        return nums.pop();
    }

    static int polish(int A, int B, String operator){
        if(operator.equals("+")) return A+B;
        if(operator.equals("-")) return A-B;
        if(operator.equals( "*")) return A*B;
        return A/B;
    }
}
