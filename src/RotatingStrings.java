//https://www.geeksforgeeks.org/check-strings-rotations-not-set-2/?ref=lbp
public class RotatingStrings {
    public static void main(String[] args) {
        System.out.println(isRotating("ABACD", "CDABA"));
        System.out.println(isRotatingKPSAlgo("ABACD", "CDABA"));
        System.out.println(isRotating("GEEKS", "EKSGE"));
        System.out.println(isRotatingKPSAlgo("GEEKS", "EKSGE"));

    }

    //Approach 1
    private static boolean isRotating(String str1, String str2){
        String s = str1.concat(str1);
        return s.contains(str2);
    }

    //KPS Algorithm, longest prefix or suffix
    //Approach is to get the index of str2 in str1 and then do reverse traverser
    private static boolean isRotatingKPSAlgo(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }

        int[] str2Index = new int[str1.length()];
        int i=0;
        int len = 0;
        while(i<str1.length()){
            if(str1.charAt(i) == str2.charAt(len)){
                str2Index[i] = ++len;
                i++;
            }else{
                if(len == 0){
                    str2Index[i] = 0;
                    i++;
                }else{
                    len = str2Index[len-1];
                }
            }
        }

        //Traverse strings from last index value of Indexes array
        i = 0;
        boolean isRotating = true;
        for(int j=str2Index[str2Index.length-1]; j<str2.length(); j++,i++){
            if(str1.charAt(i) != str2.charAt(j)){
                isRotating = false;
                break;
            }
        }

        return isRotating;
    }
}
