public class ReverseStringWordByWord {
    public static void main(String[] args) {
        String s = "hello how are you";
        System.out.println(reverseString(s));
        s = "aparna bhure work hard and solve dsa questions fast";
        System.out.println(reverseString(s));
    }

    static String reverseString(String str){
        //Reverse complete string first and then reverse each word
        int n = str.length();
        StringBuilder sb = new StringBuilder(str);
        reverse(sb, 0, n-1);
        for(int i=0; i<n; i++){
            int start = i;
            int end=i;
            while(end<n-1 && sb.charAt(end) != ' '){
                end++;
            }
            reverse(sb, start, end==n-1?end:end-1);
            i=end;
        }
        return sb.toString();
    }

    static void reverse(StringBuilder str, int start, int end){
        while(start < end){
            char t = str.charAt(start);
            str.setCharAt(start, str.charAt(end));
            str.setCharAt(end, t);
            start++;
            end--;
        }
    }
}
