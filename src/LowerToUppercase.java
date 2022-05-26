public class LowerToUppercase {
    public static void main(String[] args) {
        //Change lower case into upper case
        System.out.println(upperCase("aparna"));
        System.out.println(upperCase("bhure"));
    }

    static String upperCase(String str){
        int n = str.length();
        char[] s = str.toCharArray();
        for(int i = 0; i<n; i++){
            char c = (char) (s[i]-32);
            s[i] = c;
        }

        return new String(s);
    }
}
