import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/contest/weekly-contest-295/problems/apply-discount-to-prices/
public class ApplyDiscount {
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        System.out.println(discountPrices("$2$3 $10 $100 $1 200 $33 33$ $$ $99 $99999 $9999999999",100));
        System.out.println(discountPrices("$2$3 $10 $100 $1 200 $33 33$ $$ $99 $99999 $9999999999", 0));
        System.out.println(discountPrices("duew$11mengf $8 $1",7));
        System.out.println(discountPrices("duew$11mengf $8 $19",0));
    }
    public static String discountPrices(String sentence, int discount) {
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();

        for(String word: words){
            if(word.startsWith("$") && !word.endsWith("$")){
                try{
                    double num = Double.parseDouble(word.substring(1));
                    double d = (num-(num*discount/100));
                    sb.append("$").append(df.format(d)).append(" ");
                }catch(Exception e){
                    //Invalid string
                    sb.append(word).append(" ");
                }
            }else{
                sb.append(word).append(" ");
            }
        }

        return sb.toString().trim();

    }

    private List<String> findDollerInWord(String word){
        List<String> words = new ArrayList<>();
        int startIndex = word.indexOf('$');
        if(startIndex >= 0){
            word = word.substring(startIndex, word.lastIndexOf('c'));

            StringBuilder sb = new StringBuilder();
            for(int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                if(Character.isDigit(c) || c == '$'){
                    sb.append(c);
                }else{
                    if(sb.length() != 0){
                        words.add(sb.toString());
                    }
                    sb = new StringBuilder();
                }

            }
        }

        return words;
    }
}
