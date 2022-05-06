// https://leetcode.com/contest/weekly-contest-291/problems/remove-digit-from-number-to-maximize-result/
public class RemoveDigitToMAkeMAxNumber {
    public static void main(String[] args) {
        System.out.println(removeDigit("123", '3'));
        System.out.println(removeDigit("1231", '1'));
        System.out.println(removeDigit("551", '5'));
        System.out.println(removeDigit("5151", '5'));
        System.out.println(removeDigit("151515", '5'));
        System.out.println(removeDigit("133235", '3'));

        System.out.println(removeDigit("7795478535679443616467964135298543163376223791274561861738666981419251859535331546947347395531332878",'5'));

    }

    static String removeDigit(String number, char digit){

        int start = number.indexOf(digit);
        int end = number.lastIndexOf(digit);
        if(start == end){
            //Means there is only one occurrence
            return number.substring(0, start) + number.substring(start+1);
        }
        StringBuilder sb = new StringBuilder(number);

        StringBuilder ans = new StringBuilder();

        for(int i=0; i<sb.length(); i++){
            if(sb.charAt(i) == digit){
                sb.deleteCharAt(i);
                if(sb.compareTo(ans) >0 ){
                    ans = new StringBuilder(sb);
                }
                sb.insert(i, digit);
            }

        }

        return ans.toString();

    }
}
