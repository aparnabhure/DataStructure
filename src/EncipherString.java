/**
 * Encipher String with ciper text and keyword
 * Logic :
 * Fill matrix with rest of the alphabets out from the keyword
 * example
 * KeyWord is SECERT
 * Matrix with Rest A-Z alphabets would be including distinct Characters in keyword
 *  S E C R T
 *  A B D F G
 *  H I J K L
 *  M N O P Q
 *  U V W X Y
 *  Z
 *
 *  Now create substitute words by reading columns from above matrix in keywords sorted order
 *  Ordered Characters from the Keyword would be
 *  CERST
 *  Now create substitute words by reading columns
 *  C is first then word would be CDJOW
 *  then E - EBINV
 *  and so on so the substitution String of A-Z characters would be
 *  substitution string = CDJOWEBINVRFKPXSAHMUZTGLQY
 *  original alphabets  = ABCDEFGHIJKLMNOPQRSTUVWXYZ
 *  which means
 *  A would be replaced with C
 *  B would be with D AND SO on
 *
 *  Now if given cipher text is
 *  JHQSU XFXBQ
 *  With the help of substitution matrix Encipher text would be
 *  CRYPT OLOGY
 */

import java.util.*;

public class EncipherString {
    public static void main(String[] args) {
        //This is the way to fetch input from java programs on TechGig
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int testCases = Integer.parseInt(br.readLine());
//        for(int i=0; i<testCases; i++){
//            String keyWord = br.readLine();
//            String cipher = br.readLine();
//            System.out.println(enCipher(keyWord, cipher));
//        }


        System.out.println(encipher("SPORT", "LDXTW KXDTL NBSFX BFOII LNBHG ODDWN BWK"));
        String s = "25 26 7 8 10 11 79";
        String[] sArray = s.split(" ");
        System.out.println(find3rdLargestItem(7, sArray));

        s = "78 92 44 63 71 97";
        sArray = s.split(" ");
        System.out.println(bigOddNum(6, sArray));

        s = "90 98 100 102 105 110";
        sArray = s.split(" ");
        System.out.println(range(6, sArray));

        s = "6 3 8 1";
        sArray = s.split(" ");
        System.out.println(war(4, sArray));

        s = "2 3 4 5";
        sArray = s.split(" ");
        System.out.println(war(4, sArray));

    }

    private static String bigOddNum(int len, String[] sArray){
        TreeSet<String> oddNum = new TreeSet<>();
        for(String s:sArray){
            int num = Integer.parseInt(s);
            if(num%2 != 0){
                oddNum.add(s);
            }
        }
        if(oddNum.isEmpty()){
            return "0";
        }

        StringBuffer sb = new StringBuffer();
        Iterator<String> it = oddNum.descendingSet().iterator();
        while (it.hasNext()){
            sb.append(it.next());
        }

        return sb.toString();
    }

    private static int range(int len, String[] sArray){
        //Sort the array
        Arrays.sort(sArray, (o1, o2) -> {
            int a1 = Integer.parseInt(o1);
            int a2 = Integer.parseInt(o2);
            return a1-a2;
        });
        int end = Integer.parseInt(sArray[len-1]);
        int start = Integer.parseInt(sArray[0]);
        return end-start;
    }

    private static String war(int len, String[] sArray){
        int odd = 0;
        int even = 0;
        for(String s: sArray){
            int item = Integer.parseInt(s);
            if(item %2 == 0){
                even += item;
            }else{
                odd += item;
            }
        }

        if(odd == even){
            return "Tied";
        }

        return (odd > even?"Odd":"Even");
    }

    private static int find3rdLargestItem(int len, String[] sArray){

        //Create temp array of length 3
        int[] largestItemsArr = new int[3];

        for(String s: sArray){
            int item = Integer.parseInt(s);

            for(int i=2;i>=0;i--){
                if(item > largestItemsArr[i]){
                    //Shift other items and place it at the end
                    for(int j=1; j<=i;j++){
                        largestItemsArr[j-1] = largestItemsArr[j];
                    }

                    largestItemsArr[i] = item;
                    break;
                }
            }

        }

        return largestItemsArr[0];
    }

    private static String encipher(String keyWord, String cipherTexts){
        //Get distinct characters from the keyword
        Set<Character> distinctKeyChars = new LinkedHashSet<>();
        char[] keyChar = keyWord.toCharArray();
        for(char key:keyChar){
            distinctKeyChars.add(key);
        }
        //Create matrix with remaining alphabets of the key word
        int distinctKeyWordLen = distinctKeyChars.size();
        int rows = (26/distinctKeyWordLen);
        if(distinctKeyWordLen%2 != 0){
            rows++;
        }
        //Create map for columns and word, help to get all column values when traversing
        Map<Character, Integer> keyColumnMap = new HashMap<>();
        char[][] matrix = new char[rows][distinctKeyWordLen];
        Iterator<Character> it = distinctKeyChars.iterator();
        int i =0;
        int j = 0;
        while (it.hasNext()){
            Character c = it.next();
            matrix[i][j] = c;
            keyColumnMap.put(c, j);
            j++;
        }

        //fill the matrix with rest of the alphabets
        char startChar = 'A';
        for(i=1; i<rows; i++){
            for(j=0; j<distinctKeyWordLen;  startChar++){
                if(startChar > 'Z'){
                    break;
                }
                if(!distinctKeyChars.contains(startChar)){
                    matrix[i][j] = startChar;
                    j++;
                }
            }
        }

        //Create map for substitute alphabets
        Iterator<Character> iterator = distinctKeyChars.stream().sorted().iterator();
        startChar = 'A';
        Map<Character, Character> map = new HashMap<>();
        while (iterator.hasNext()){
            Character c = iterator.next();
            j = keyColumnMap.get(c);
            for(i=0;i<rows; i++){
                char ch = matrix[i][j];
                if(startChar < 'A' || startChar > 'Z' || ch < 'A' || ch > 'Z'|| map.containsKey(ch)){
                    continue;
                }

                map.put(ch, startChar);
                startChar++;
            }
        }

        //Now encipher
        char[] cipherText = cipherTexts.toCharArray();

        StringBuilder stringBuilder = new StringBuilder();
        for(char cipher:cipherText){
            if(map.get(cipher) == null){
                stringBuilder.append(' ');
            }else {
                stringBuilder.append(map.get(cipher));
            }
        }
        return stringBuilder.toString();
    }

    static class TestCase{
        String keyWord;
        String cipherTexts;
        TestCase(String keyWord, String cipher){
            this.keyWord = keyWord;
            this.cipherTexts = cipher;
        }
    }
}
