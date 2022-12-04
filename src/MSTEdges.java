import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MSTEdges {
    public static void main(String[] args) {
        PrintUtil.print(solve(3, new int[][]{{1, 2, 2}, {1, 3, 2}, {2, 3, 3}}));
        PrintUtil.print(solve(2, new int[][]{{1, 2, 42}}));
    }

    static int[] parent;
    static int[] solve(int A, int[][] B) {
        parent = new int[A+1];
        for(int i=1;i<=A; i++){
            parent[i]= i;
        }

        List<Pair> adjMatrics = new ArrayList<>();
        int n = B.length;
        for(int i=0;i<n; i++){
            adjMatrics.add(new Pair(B[i][0],B[i][1], B[i][2], i));
        }

        adjMatrics.sort(Comparator.comparingInt(x-> x.weight));

        int[] ans = new int[n];
        for(int i=0;i<n;){
            int j=i;
            //Check if equal weighted nodes can be part of spanning tree or MST
            for(; j<n && (adjMatrics.get(i).weight ==adjMatrics.get(j).weight); j++){
                if(findParent(adjMatrics.get(j).x) != findParent(adjMatrics.get(j).y)){
                    ans[adjMatrics.get(j).index]= 1;
                }
            }
            //Union for same weighted edges
            j=i;
            for(; j<n && (adjMatrics.get(i).weight ==adjMatrics.get(j).weight); j++){
                union(adjMatrics.get(j).x, adjMatrics.get(j).y);
            }
            i=j;
        }
        return ans;
    }

    static int findParent(int edge){
        if(parent[edge] == edge) return edge;
        parent[edge] = findParent(parent[edge]);
        return parent[edge];
    }

    static void union(int x, int y){
        int parentX = findParent(x);
        int parentY = findParent(y);
        if(parentX == parentY) return;
        parent[parentY] = parentX;
    }

    static class Pair{
        int x; int y;
        int weight;
        int index;
        public Pair(int x, int y, int weight, int index){
            this.x = x;
            this.y = y;
            this.weight = weight;
            this.index = index;
        }
    }
}
