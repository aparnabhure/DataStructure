import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class KosarajuAlgo {
    public static void main(String[] args) {

        //Fill the graph
        Graph g = new Graph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        //Find Strongly Connected Components
       findSCC(g);


    }

    private static void findSCC(Graph g){
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visitedVertex = new HashSet<>();

        // Graph is 0->2,3 1->0, 2->1, 3->4
        //Step 1. Use empty stack, pick one element and do DFS
        fillStack(g, 0, stack, visitedVertex);
        // Generate stack as 02134
        //Step2: Reverse or transpose the graph
        g = reverseGraph(g);
        // Now the graph is 2->0, 3->0, 0->1, 1->2, 4->3
        //Reset the visited set
        visitedVertex.clear();
        //Step 3: Pop elements from the stack and do DFS to print the SCC
        while (!stack.empty()){
            int vertex = stack.pop();
            //Do DFS
            printSCC(g, vertex, visitedVertex);
            System.out.println();
        }
    }

    private static void fillStack(Graph g, int vertex, Stack<Integer> stack, Set<Integer> visitedVertex){
        if(visitedVertex.contains(vertex)){
            return;
        }
        //Mark it as visited
        visitedVertex.add(vertex);
        LinkedList<Integer> edges = g.connectedVertex[vertex];
        for(Integer edge: edges){
            fillStack(g, edge, stack, visitedVertex);
        }
        stack.push(vertex);
    }

    private static Graph reverseGraph(Graph g){
        int totalVertex = g.vertex;
        Graph rg = new Graph(totalVertex);
        for(int i=0; i<totalVertex; i++){
            LinkedList<Integer> edges = g.connectedVertex[i];
            for(Integer edge: edges){
                rg.connectedVertex[edge].add(i);
            }
        }
        return rg;
    }

    private static void printSCC(Graph g, int vertex, Set<Integer> visitedVertex){
        if(visitedVertex.contains(vertex)){
            return;
        }
        //Do DFS
        visitedVertex.add(vertex);
        System.out.print(vertex + " ");
        LinkedList<Integer> edges = g.connectedVertex[vertex];
        for(Integer edge: edges){
            printSCC(g, edge, visitedVertex);
        }
    }

}
