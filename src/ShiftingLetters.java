public class ShiftingLetters {
    public static void main(String[] args) {
        System.out.println(solve("abc", new int[][]{{0,1,0},{1,2,1},{0,2,1}}));
    }

    static String solve(String s, int[][] shifts){
        char[] ch = s.toCharArray();
        int[] count = new int[s.length()+1];

        for(int[] shift : shifts){
            int value = shift[2] == 1 ? 1 : -1;
            count[shift[0]] += value;
            count[shift[1] + 1] -= value;
        }

        int sum = 0;
        for(int i = 0; i < count.length - 1; i++){
            sum += count[i];
            int newChar = ((ch[i] - 'a') + sum) % 26;
            if(newChar < 0) newChar+= 26;
            ch[i] =  (char)('a' + newChar);
        }

        return String.valueOf(ch);
    }
}
