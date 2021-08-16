import java.util.LinkedList;

public class Graph {
    //Total vertex
    int vertex;
    //List of all vertex and its connection with Edges
    LinkedList<Integer>[] connectedVertex;

    public Graph(int vertex){
        this.vertex = vertex;
        this.connectedVertex = new LinkedList[this.vertex];
        //Fill empty list
        for(int i= 0; i<vertex; i++){
            this.connectedVertex[i] = new LinkedList<>();
        }
    }

    public void addEdge(int vertex, int edge){
        connectedVertex[vertex].add(edge);
    }
}
