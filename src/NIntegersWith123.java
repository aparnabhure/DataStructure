import java.util.LinkedList;
import java.util.Queue;

public class NIntegersWith123 {
    public static void main(String[] args) {
        print(solve(15));
    }

    static void print(int[] result){
        for(int i:result){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    static int[] solve(int A) {
        if(A==1) return new int[]{1};
        if(A==2) return new int[]{1,2};
        if(A==3) return new int[]{1,2,3};

        int[] ans = new int[A];

        Queue<Integer> queue = new LinkedList<>();
        int i =0;
        for(; i<3; i++){
            ans[i] = i+1;
            queue.add(ans[i]);
        }
        int count = 3;
        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = Integer.parseInt(x+"1");
            ans[i] = y;
            queue.add(ans[i]);
            count++;
            i++;
            if(count == A) return ans;

            y = Integer.parseInt(x+"2");
            ans[i] = y;
            queue.add(ans[i]);
            count++;
            i++;
            if(count == A) return ans;

            y = Integer.parseInt(x+"3");
            ans[i] = y;
            queue.add(ans[i]);
            count++;
            i++;
            if(count == A) return ans;
        }

        return ans;
    }
}
