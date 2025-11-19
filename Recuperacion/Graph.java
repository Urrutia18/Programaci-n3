import java.util.ArrayList;
import java.util.List;

public class Graph {

    private List<List<Edge>> adjList;

    public Graph(int nodos) {
        adjList = new ArrayList<>();
        for (int i = 0; i < nodos; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int origen, int destino, int peso) {
        adjList.get(origen).add(new Edge(destino, peso));
        adjList.get(destino).add(new Edge(origen, peso)); // Si el grafo es no dirigido
    }

    public List<Edge> getAdjList(int nodo) {
        return adjList.get(nodo);
    }

    public int size() {
        return adjList.size();
    }
}

