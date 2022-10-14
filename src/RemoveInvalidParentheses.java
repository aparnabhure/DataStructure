import java.util.*;

public class RemoveInvalidParentheses {
    /*
    Given a string A consisting of lowercase English alphabets and parentheses '(' and ')'. Remove the minimum number of invalid parentheses in order to make the input string valid.

Return all possible results.

You can return the results in any order.



Problem Constraints

1 <= length of the string <= 20



Input Format

The only argument given is string A.



Output Format

Return all possible strings after removing the minimum number of invalid parentheses.



Example Input

Input 1:

 A = "()())()"

Input 2:

 A = "(a)())()"



Example Output

Output 1:

 ["()()()", "(())()"]

Output 2:

 ["(a)()()", "(a())()"]



Example Explanation

Explanation 1:

 By removing 1 parentheses we can make the string valid.
        1. Remove the parentheses at index 4 then string becomes : "()()()"
        2. Remove the parentheses at index 2 then string becomes : "(())()"

Explanation 2:

 By removing 1 parentheses we can make the string valid.
        1. Remove the parentheses at index 5 then string becomes : "(a)()()"
        2. Remove the parentheses at index 2 then string becomes : "(a())()"

     */

    public static void main(String[] args) {
        print(solve("()))()"));
        print(solve("(a)())()"));
        print(solve("()())()"));
    }

    static void print(ArrayList<String> result) {
        System.out.println("***** Result size "+result.size());
        for (String s : result) {
            System.out.println(s);
        }
    }

    static ArrayList<String> ans;

    static ArrayList<String> solve(String A) {
        int n = A.length();
        ans = new ArrayList<>();
        if (n == 1) {
            if (isParentheses(A.charAt(0)))  ans.add("");
            else ans.add(A);
            return ans;
        }

        findValidStrings(A);
        if(ans.isEmpty()) ans.add("");
        return ans;

    }

    static void findValidStrings(String A) {
        if (A.isEmpty()) return;

        Queue<String> q = new LinkedList<>();
        q.add(A);
        Set<String> visited = new HashSet<>();
        visited.add(A);

        boolean found= false;
        while (!q.isEmpty()) {
            String str = q.poll();
            if (isValidString(str)) {
                ans.add(str);
                found = true;
            }
            if(found) continue;

            for (int i = 0; i < str.length(); i++) {
                if (isParentheses(str.charAt(i))) {
                    String tmp = str.substring(0, i) + str.substring(i + 1);
                    if (!visited.contains(tmp)) {
                        q.add(tmp);
                        visited.add(tmp);
                    }
                }
            }
        }
    }

    static boolean isParentheses(char c) {
        return (c == '(' || c == ')');
    }

    static boolean isValidString(String s) {
        if (s.isEmpty()) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.add('(');
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty() || stack.peek() != '(') return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
