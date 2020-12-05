import java.util.HashSet;
import java.util.Set;

//https://www.geeksforgeeks.org/remove-characters-from-the-first-string-which-are-present-in-the-second-string/?ref=lbp
public class RemoveCharacterPresentIn2ndString {
    public static void main(String[] args) {
        System.out.println(removeCharacters("geegsforgeeks", "goals"));
        System.out.println(isRotatingStringWithTwiceRotationInLeftOrRightDirection("amazon", "azonam"));
        System.out.println(isRotatingStringWithTwiceRotationInLeftOrRightDirection("amazon", "onamaz"));
    }

    private static String removeCharacters(String str1, String str2){
        if(str2.length() <= 0){
            return str1;
        }

        //Create set of unique characters from str2
        Set<Character> cSet = new HashSet<>();
        for(int i=0;i<str2.length();i++){
            cSet.add(str2.charAt(i));
        }

        StringBuilder s = new StringBuilder();
        for(int i=0; i<str1.length();i++){
            if(!cSet.contains(str1.charAt(i))){
                s.append(str1.charAt(i));
            }
        }
        return s.toString();
    }

    //https://www.geeksforgeeks.org/check-string-can-obtained-rotating-another-string-2-places/?ref=lbp
    private static boolean isRotatingStringWithTwiceRotationInLeftOrRightDirection(String str1, String str2){
        String clockStr = str1.substring(str1.length()-2).concat(str1.substring(0, str1.length()-2));
        String antiClockStr = str1.substring(2).concat(str1.substring(0,2));
        return (clockStr.equals(str2) || antiClockStr.equals(str2));
    }
}
