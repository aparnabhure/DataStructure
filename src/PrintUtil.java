import java.util.ArrayList;

public class PrintUtil {
    static void print(int[] result){
        for(int i: result){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    static void print(String[] result){
        for(String i: result){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    static void print(int[][] result){
        int n = result.length;
        int m = result[0].length;
        for(int i =0; i<n; i++){
            for(int j =0; j<m; j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void print(ArrayList<Integer> result){
        for(int i: result){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
