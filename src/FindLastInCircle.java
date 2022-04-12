import java.util.ArrayList;
import java.util.List;

public class FindLastInCircle {

    public static void main(String[] args) {

        List<Integer> array = new ArrayList<>();
        for(int i=1; i<=5;i++){
            array.add(i);
        }

        System.out.println(findLast(0, array));
    }

    static int findLast(int index, List<Integer> array){
        if(array.size() == 1){
            return array.get(0);
        }

        ++index;
        array.remove(index);
        if(index == (array.size()-1)){
            index = -1;
        }else if(index == array.size()){
            index = 0;
        }
        return findLast(index, array);
    }

    static int findLast(List<Integer> array){
        int start = 0;
        while(array.size()>1){
            start++;
            array.remove(start);
            if(start == array.size()-1){
                start = -1;
            }else if(start == array.size()){
                start = 0;
            }
        }

        return array.get(0);
    }
}
