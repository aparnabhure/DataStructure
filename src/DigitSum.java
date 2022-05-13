//https://leetcode.com/contest/weekly-contest-289/problems/calculate-digit-sum-of-a-string/
public class DigitSum {
    public static void main(String[] args) {
        System.out.println(digitSum("1234", 2));
        System.out.println(digitSum("00000000", 3));
    }

    static String digitSum(String s, int k) {

        int len = s.length();
        if(len<=k){
            return s;
        }

        StringBuilder sb = new StringBuilder();

        int sum = 0;
        int kLen = 0;
        while(len>k){
            sum = -1;
            kLen = 0;
            for(int i=0; i<len; i++){
                if(sum == -1){
                    sum = 0;
                }

                sum += Integer.parseInt(s.charAt(i)+"");
                kLen++;
                if(kLen == k){
                    sb.append(sum);
                    sum = -1;
                    kLen = 0;
                }
            }

            if(sum > -1){
                sb.append(sum);
            }

            s = sb.toString();
            len = s.length();
            sb = new StringBuilder();

        }

        return s;

    }
}
