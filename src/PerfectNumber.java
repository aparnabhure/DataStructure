import java.util.LinkedList;
import java.util.Queue;

/*
Given an integer A, you have to find the Ath Perfect Number.

A Perfect Number has the following properties:

It comprises only 1 and 2.

The number of digits in a Perfect number is even.

It is a palindrome number.

For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.



Problem Constraints
1 <= A <= 100000



Input Format
The only argument given is an integer A.



Output Format
Return a string that denotes the Ath Perfect Number.



Example Input
Input 1:

 A = 2
Input 2:

 A = 3


Example Output
Output 1:

 22
Output 2:

 1111


Example Explanation
Explanation 1:

First four perfect numbers are:
1. 11
2. 22
3. 1111
4. 1221
Explanation 2:

First four perfect numbers are:
1. 11
2. 22
3. 1111
4. 1221
 */
public class PerfectNumber {
    public static void main(String[] args) {
        System.out.println(solve(4));
    }

    static String solve(int A) {
        if(A==1) return "11";
        if(A==2) return "22";
        Queue<String> queue = new LinkedList<>();
        queue.add("11");
        queue.add("22");
        int count = 2;
        while(!queue.isEmpty()){
            count++;
            String front = queue.poll();
            StringBuilder str = new StringBuilder(front);
            int mid = str.length()/2;
            str.insert(mid, "11");
            if(count == A) return str.toString();
            queue.add(str.toString());

            count++;
            str = new StringBuilder(front);
            mid = str.length()/2;
            str.insert(mid, "22");
            if(count == A) return str.toString();
            queue.add(str.toString());
        }
        return null;
    }
}
