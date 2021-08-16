import java.beans.Visibility;
import java.util.*;

/**
 * What is a Mother Vertex?
 * A mother vertex in a graph G = (V,E) is a vertex v such that all other vertices in G can be reached by a path from v.
 */
public class MotherNodeInGraph {
    public static void main(String[] args) {
        //Generate Graph
        Graph g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(4, 1);
        g.addEdge(5, 2);
        g.addEdge(5, 6);
        g.addEdge(6, 4);
        g.addEdge(6, 0);

        System.out.println("Using Naive DFS Algo O(V(V+E))");
        naiveFindMotherNode(g);

        System.out.println("Using Kosaraju's ALog O(V+E)");
        kosarRajuAlgoMotherNode(g);

        System.out.println("*************");

        g = new Graph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 1);
        g.addEdge(3, 4);

        System.out.println("Using Naive DFS Algo O(V(V+E))");
        naiveFindMotherNode(g);

        System.out.println("Using Kosaraju's ALog O(V+E)");
        kosarRajuAlgoMotherNode(g);
    }

    private static void kosarRajuAlgoMotherNode(Graph g){
        Set<Integer> visitedVertex = new HashSet<>();
        //Step 1: Find the last traverse node
        int motherNode = -1;
        for(int i=0; i<g.vertex; i++){
            if(!visitedVertex.contains(i)){
                findMotherNodeKosarRaju(g, i, visitedVertex);
                motherNode = i;
            }
        }

        // Step2: Check if the lastVertex is mother node or not, connect to all nodes
        visitedVertex.clear();
        findMotherNodeKosarRaju(g, motherNode, visitedVertex);
        if(visitedVertex.size() == g.vertex){
            System.out.println("Mother node is "+motherNode);
        }else{
            System.out.println("Mother node not found");
        }
    }

    private static void findMotherNodeKosarRaju(Graph g, int vertex, Set<Integer> visitedVertex){
        if(visitedVertex.contains(vertex)){
            return;
        }
        visitedVertex.add(vertex);
        LinkedList<Integer> edges = g.connectedVertex[vertex];
        for(int edge: edges){
            findMotherNodeKosarRaju(g, edge, visitedVertex);
        }
    }

    //Naive approach is DFS for each node and find if got connected to all or not
    private static void naiveFindMotherNode(Graph g){

        Map<Integer, Set<Integer>> vertexEdgeMap = new HashMap<>();
        Set<Integer> visitedVertex = new HashSet<>();
        int motherNode = -1;

        for(int i=0; i< g.vertex; i++) {
            motherNode = findMotherNode(g, i, vertexEdgeMap, visitedVertex);
            if(motherNode != -1){
                break;
            }
        }

        System.out.println("Mother node is "+ motherNode);
    }

    private static int findMotherNode(Graph g, int vertex, Map<Integer, Set<Integer>> vertexEdgeMap, Set<Integer> visitedVertex){

        if(!vertexEdgeMap.containsKey(vertex)){
            Set<Integer> d = new HashSet<>();
            d.add(vertex);
            vertexEdgeMap.put(vertex, d);
        }

        if(!visitedVertex.contains(vertex)) {
            visitedVertex.add(vertex);
            LinkedList<Integer> edges = g.connectedVertex[vertex];
            for (int edge : edges) {
                Set<Integer> e = vertexEdgeMap.get(vertex);
                e.add(edge);
                vertexEdgeMap.put(vertex, e);
                findMotherNode(g, edge, vertexEdgeMap, visitedVertex);
                e = vertexEdgeMap.get(vertex);
                e.addAll(vertexEdgeMap.get(edge));
                vertexEdgeMap.put(vertex, e);
            }
        }

        return vertexEdgeMap.get(vertex).size() == g.vertex?vertex:-1;
    }
}
