import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DeleteCAPs {
    public static void main(String[] args) {
        String s = "AbcaZeoB";

        System.out.println(update(s));
    }

    static String update(String s){
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(Character.isUpperCase(c)){
                //Do nothing
            }else if(vowels.contains(c)){
                sb.append("#");
            }else{
                sb.append(c);
            }
        }

        return sb.append(sb).toString();
    }
}
