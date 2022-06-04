import java.util.ArrayList;
/*
https://www.scaler.com/academy/mentee-dashboard/class/24898/homework/problems/145/?navref=cl_pb_nv_tb
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer A representing the total number of bits in the code, print the sequence of gray code.

A gray code sequence must begin with 0.



 */
public class GreyCode {
    public static void main(String[] args) {
        ArrayList<Integer> result = grayCode(2);
        print(result);
    }

    static void print(ArrayList<Integer> result){
        for(int i: result){
            System.out.print(i +" ");
        }
        System.out.println();
    }

    static ArrayList<Integer> grayCode(int a) {

        ArrayList<Integer> ans = new ArrayList<>();

        if (a == 0) return null;

        if (a == 1) {

            ans.add(0);

            ans.add(1);

            return ans;

        }

        ArrayList<Integer> codes = grayCode(a - 1);

        int x = codes.size();

        for (int i = 0; i < x; i++)

            ans.add(codes.get(i));

        for (int i = x - 1; i >= 0; i--)

            ans.add(codes.get(i) + (1 << (a - 1)));

        return ans;

    }


}
