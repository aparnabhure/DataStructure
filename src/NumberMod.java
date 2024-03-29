//https://www.scaler.com/academy/mentee-dashboard/class/24891/assignment/problems/14605
public class NumberMod {
    public static void main(String[] args) {
        System.out.println((3456%4));
        int[] A = new int[]{3,4,5,6};
        System.out.println(numberMod(A, 4));
        A = new int[]{5,6,8,9,1,4};
        System.out.println((568914%7));
        System.out.println(numberMod(A, 7));
    }

    static int numberMod(int[] A, int m){

        long ans = 0;
        long exp = 1;
        for(int i=A.length-1; i>=0; i--){
            long temp = (A[i] *exp);
            //For very large input this needs to be (ans+temp)%m
            ans = (ans+temp)%m;
            exp = (exp*10)%m;
        }
        return (int)ans%m;
    }
}
