import java.util.ArrayList;
import java.util.List;

public class SpaceReorder {
    public static void main(String[] args) {
        System.out.println("*"+reorder("hello  world")+"*");
       System.out.println("*"+reorder(" practice   makes   perfect")+"*");
        System.out.println("*"+reorder("  hello")+"*");
        System.out.println("*"+reorder("a b c ")+"*");


    }

    public static String reorder(String text){
        if(text== null || text.length()<=1){
            return text;
        }
        List<String> words = new ArrayList<>();
        int spaces = 0;
        StringBuffer word = new StringBuffer();
        for(int i =0; i<text.length();i++){
            if(text.charAt(i) ==' '){
                spaces++;
                if(word.length() > 0){
                    words.add(word.toString());
                    word = new StringBuffer();
                }
                continue;
            }

            word.append(text.charAt(i));
        }
        if(word.length() >0){
            words.add(word.toString());
        }

        int totalWords = words.size();
        int spacesInBetween = 1;
        if(totalWords ==1){
            spacesInBetween = spaces;
        }else{
            spacesInBetween = spaces/(totalWords-1);
        }

        StringBuffer newStr = new StringBuffer();
        int spaceCounter = 0;
        for(int i=0; i<totalWords; i++){
            newStr.append(words.get(i));
            for (int j = 1; j < spacesInBetween; j++) {
                    if(spaceCounter == spaces){
                        break;
                    }
                    spaceCounter++;
                    newStr.append(' ');
                }

        }

//        if(spaceCounter <spacesInBetween){
//            int diff = spacesInBetween-spaceCounter;
//            while (diff>0){
//                newStr.append(" ");
//                diff--;
//            }
//        }
        return newStr.toString();
    }
}
