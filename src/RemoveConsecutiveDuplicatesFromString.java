//https://www.geeksforgeeks.org/remove-consecutive-duplicates-string/?ref=lbp
public class RemoveConsecutiveDuplicatesFromString {
    public static void main(String[] args) {

        System.out.println(removeDuplicatesRecursively("aaaaabbbbbb"));
        System.out.println(removeDuplicates("geeksforgeeks"));
        System.out.println(removeDuplicates("aabccba"));
        System.out.println(removeDuplicates("aa"));


        System.out.println(removeDuplicates("aaaaabbbbbb"));
        System.out.println(removeDuplicates("geeksforgeeks"));
        System.out.println(removeDuplicates("aabccba"));
        System.out.println(removeDuplicates("aa"));
    }

    private static String removeDuplicates(String str){
        if(str == null || str.length() <= 1){
            return str;
        }
        StringBuilder s = new StringBuilder();
        for (int i=0; i<str.length(); i++){
            if(i<str.length()-1 && str.charAt(i) != str.charAt(i+1)){
                s.append(str.charAt(i));
            }
            if(i == str.length()-1){
                s.append(str.charAt(i));
            }
        }
        return s.toString();
    }

    private static String removeDuplicatesRecursively(String str){
        if(str == null || str.length() <= 1){
            return str;
        }
        int i=0;
        while (i<str.length()){
            if(i<str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                int j= i;
                while (j<str.length()-1 && str.charAt(j) == str.charAt(j+1)) {
                    j++;
                }
                String newStr = str.substring(0, i+1);
                if(j<str.length()-1) {
                    newStr = newStr.concat(str.substring(j + 1));
                }
                str = removeDuplicatesRecursively(newStr);
            }else{
                i++;
            }




        }

        return str;
    }
}
