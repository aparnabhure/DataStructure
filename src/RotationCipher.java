import java.util.HashMap;
import java.util.Map;

public class RotationCipher {
    public static void main(String[] args) {
        System.out.println(rotationCipher("01234567890123456789", 39));
        System.out.println(rotationCipher("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 39));
        System.out.println(rotationCipher("AZAssawQqQ-*ij&", 39));

        System.out.println(rotationCipher("abcdefghijklmnopqrstuvwxyz", 39));
        System.out.println(rotationCipher("abcdefghijklmNOPQRSTUVWXYZ0123456789", 39));
        System.out.println(rotationCipher("abcdZXYzxy-999.@", 200));

    }

    private static String rotationCipher(String input, int rotationFactor){
        if(input == null || input.length() <= 0 || rotationFactor <= 0){
            return input;
        }

        int minCapitalA = 'A';
        int maxCapitalZ = 'Z';
        int minA = 'a';
        int maxZ = 'z';
        int numericFactor = rotationFactor%10;
        int charFactor = rotationFactor%26;

        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> numMap = new HashMap<>();
        Map<Character, Character> map = new HashMap<>();
        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);

            if(Character.isDigit(c) && numericFactor>0){
                if(numMap.containsKey(c)){
                    int n = numMap.get(c);
                    sb.append(n);
                    continue;
                }

                int num = Math.abs(10-Character.getNumericValue(c)-numericFactor);
                if(c == '0'){
                    num = numericFactor;
                }
                numMap.put(c, num);
                sb.append(num);
            }else if(Character.isAlphabetic(c) && charFactor>0){
                if(map.containsKey(c)){
                    sb.append(map.get(c));
                    continue;
                }

                int min = minCapitalA;
                int max = maxCapitalZ;
                if(Character.isLowerCase(c)){
                    min = minA;
                    max = maxZ;
                }
                int maxNumDiff = max-c;
                int num;
                if(maxNumDiff < charFactor){
                    num = charFactor-maxNumDiff+min-1;
                }else{
                    num = c+charFactor;
                }
                map.put(c, (char)num);
                sb.append((char)num);
            }else{
                sb.append(c);
            }

        }


        return sb.toString();
    }
}
