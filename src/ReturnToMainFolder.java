import java.util.Stack;

public class ReturnToMainFolder {
    public static void main(String[] args) {
        System.out.println(minOperations(new String[]{"d1/","d2/","./","d3/","../","d31/"}));
    }

    private static int minOperations(String[] logs){
        if(logs == null || logs.length <=0){
            return 0;
        }

        if(logs.length == 1){
            return (logs[0].equals("../") || logs[0].equals("./") ? 0 :1);
        }

        int folderDepth  = 0;
        Stack<String> folders = new Stack<>();

        for(int i=0; i<logs.length; i++){

            if(logs[i].equalsIgnoreCase("./")){
                //Donothing
            }else if(!logs[i].equals("../")){
                folders.push(logs[i]);
            }else if(folders.size() >0){
                folders.pop();
            }


        }

        return folders.size();
    }
}
