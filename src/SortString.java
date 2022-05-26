public class SortString {
    public static void main(String[] args) {
        System.out.println(sort("aparna"));
        System.out.println(sort("bhure"));
    }

    static String sort(String str){
        int[] chars = new int[26];
        int n = str.length();
        for(int i=0; i<n; i++){
            chars[str.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(char c='a'; c<='z'; c++){
            int index = c-'a';
            for(int i=0; i<chars[index]; i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
