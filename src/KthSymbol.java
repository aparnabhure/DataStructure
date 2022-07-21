public class KthSymbol {
    /*
    On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.

Given row number A and index B, return the Bth indexed symbol in row A. (The values of B are 1-indexed.).



Problem Constraints
1 <= A <= 20

1 <= B <= 2A - 1



Input Format
First argument is an integer A.

Second argument is an integer B.



Output Format
Return an integer denoting the Bth indexed symbol in row A.



Example Input
Input 1:

 A = 2
 B = 1
Input 2:

 A = 2
 B = 2


Example Output
Output 1:

 0
Output 2:

 1


Example Explanation 1:

 Row 1: 0
 Row 2: 01
Explanation 2:

 Row 1: 0
 Row 2: 01
     */
    public static void main(String[] args) {
        int A= 9;
        int B = 175;
        System.out.println(symbol(A, B-1));
    }

    static int symbol(int A, int B){
        if(A==1 || B == 0) return 0;
        int parent = symbol(A-1, B/2);
        if(B%2 == 0) return parent;
        return (1-parent);
    }
}
