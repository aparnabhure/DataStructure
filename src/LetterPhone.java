import java.util.ArrayList;

public class LetterPhone {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations("012"));
    }

    static String[] phone = new String[]{"0","1","abc","def","ghi", "jkl", "mno", "pqrs", "tuv","wxyz"};

    static ArrayList<String> result = new ArrayList<>();
    static ArrayList<String> letterCombinations(String A) {
        result = new ArrayList<>();
        solve(A, A.length(), 0, new StringBuilder());
        return result;
    }
    static void solve(String A, int n, int index, StringBuilder str){
        if(index>= n){
            result.add(str.toString());
            return;
        }

        String code = phone[Character.getNumericValue(A.charAt(index))];
        for(int i=0; i<code.length(); i++){
            str.append(code.charAt(i));
            solve(A, n, index+1, str);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
