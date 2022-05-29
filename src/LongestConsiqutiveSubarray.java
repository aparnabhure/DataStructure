import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LongestConsiqutiveSubarray {
    /*
    Given an array A of N integers.

Find the largest continuous sequence in a array which sums to zero.
     */
    public static void main(String[] args) {
        int[] result1 = zeros(new int[]{1,2,-2,4,-4});
        print(result1);
        result1 = zeros(new int[]{1, 2, -3, 3});
        print(result1);
        result1 = zeros(new int[]{1, 2, -3, 3, -2,-1, 1});
        print(result1);
        result1 = zeros(new int[]{0,1,2});
        print(result1);
        result1 = zeros(new int[]{1,2,0});
        print(result1);
        result1 = zeros(new int[]{2,-2,0});
        print(result1);
        result1 = zeros(new int[]{-1, 1, 1, -1, -1, 1, 1, -1});
        print(result1);
        result1 = zeros(new int[]{-8, 8, -1, -16, -28, -27, 15, -14, 14, -27, -5, -6, -25, -11, 28, 29, -3, -25, 17, -25, 4, -20, 2, 1, -17, -10, -25});
        print(result1);

        System.out.println("*******************");

        ArrayList<Integer> result = lszero(Arrays.asList(1,2,-2,4,-4));
        print(result);
        result = lszero(Arrays.asList(1, 2, -3, 3));
        print(result);
        result = lszero(Arrays.asList(1, 2, -3, 3, -2,-1, 1));
        print(result);
        result = lszero(Arrays.asList(0,1,2));
        print(result);
        result = lszero(Arrays.asList(1,2,0));
        print(result);
        result = lszero(Arrays.asList(2,-2,0)); //Wrong answer
        print(result);
        result = lszero(Arrays.asList(-1, 1, 1, -1, -1, 1, 1, -1)); //Wrong answer
        print(result);
        result = lszero(Arrays.asList(-8, 8, -1, -16, -28, -27, 15, -14, 14, -27, -5, -6, -25, -11, 28, 29, -3, -25, 17, -25, 4, -20, 2, 1, -17, -10, -25)); //Wrong answer
        print(result);

    }

    static void print(int[] result){
        for(int a: result){
            System.out.print(a+" ");
        }
        System.out.println();
    }

    static void print(ArrayList<Integer> result){
        for(int a: result){
            System.out.print(a+" ");
        }
        System.out.println();
    }

    static int[] zeros(int[] A){
        int len = A.length;
        int answer = 0;

        //Building the prefix array.
        int[] pf = new int[len];
        pf[0] = A[0];
        for (int i = 1; i < len; i++)
            pf[i] = pf[i - 1] + A[i];

        //storing the prefix array to hasmap.
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);//initialize hm with 0 and -1 -> Base case.
        int l = -1; // to store the start index of the final answer.

        for (int i = 0; i < len; i++) {
            if (hm.containsKey(pf[i])) {
                int firstIndex = hm.get(pf[i]);
                int length = i - firstIndex;
                int previousAnswer = answer;
                answer = Math.max(answer, length);
                if (answer > previousAnswer) {
                    l = firstIndex+1;
                }
            }
            else
                hm.put(pf[i], i);
        }
        //if we got a sub-array sum as 0, build a result array and return it.
        if (answer > 0) {
            //build the result array
            int[] result = new int [answer];
            int i =0;
            while (i<answer){
                result[i] = A[l+i];
                i++;
            }
            return result;
        }

        else {
            //create and return an empty array.
            int[] result ={};
            return result;
        }
    }

    static ArrayList<Integer> lszero(List<Integer> A) {
        int n = A.size();
        int[] pref = new int[n];
        pref[0] = A.get(0);
        for(int i=1; i<n; i++){
            pref[i] = pref[i-1]+A.get(i);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int lastIndex = -1;
        int maxLen = 0;
        for(int i=0; i<n; i++){
            if(map.containsKey(pref[i])){
                int index = map.get(pref[i]);
                int len = i - index;
                if(len > maxLen){
                    maxLen = len;
                    lastIndex = ++index;
                }
            }else{
                map.put(pref[i],i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        //build the result array
        int i =0;
        while (i<maxLen){
            result.add(A.get(lastIndex+i));
            i++;
        }
        return result;


    }

    static class SubArray{
        int start;
        int end;
        int len;
    }

}
