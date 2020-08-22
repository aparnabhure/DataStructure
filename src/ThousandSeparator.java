import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Stack;

public class ThousandSeparator {
    public static void main(String[] args) {
        System.out.println(d(54040));
         System.out.println(d(987));

         System.out.println(d(0));
        System.out.println(d(51040));
         System.out.println(d(1987));
         System.out.println(d(93387));
         System.out.println(d(777111987));
    }
    private static String d(int n){

        if(n <1000){
            return ""+n;
        }

        String strNum = Integer.toString(n);
        Stack<String> numbers = new Stack<>();
        while (strNum.length()>0){
            int num = Integer.parseInt(strNum);
            if(num < 1000){
                numbers.push(strNum);
                break;
            }
            numbers.push(strNum.substring(strNum.length()-3));
            strNum = strNum.substring(0, strNum.length()-3);
        }

        StringBuilder str = new StringBuilder();
        while (numbers.size() > 0) {
            str.append(numbers.pop()).append(".");
        }

        String result = str.toString();
        if(result.endsWith(".")){
            result = result.substring(0, result.length()-1);
        }
        return result;
    }
}
