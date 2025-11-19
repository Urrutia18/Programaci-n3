import java.util.*;

class Edge {
    int destino;
    int peso;

    public Edge(int destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }
}

class Graph {

    private List<List<Edge>> adjList;

    public Graph(int nodos) {
        adjList = new ArrayList<>();
        for (int i = 0; i < nodos; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int origen, int destino, int peso) {
        adjList.get(origen).add(new Edge(destino, peso));
        adjList.get(destino).add(new Edge(origen, peso)); // No dirigido
    }

    public List<Edge> getAdjList(int nodo) {
        return adjList.get(nodo);
    }

    public int size() {
        return adjList.size();
    }
}

class Dijkstra {

    public static int[] dijkstra(Graph graph, int inicio, int[] previo) {
        int n = graph.size();

        int[] dist = new int[n];
        boolean[] visitado = new boolean[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(previo, -1);

        dist[inicio] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{inicio, 0});

        while (!pq.isEmpty()) {
            int[] actual = pq.poll();
            int nodo = actual[0];

            if (visitado[nodo]) continue;
            visitado[nodo] = true;

            for (Edge edge : graph.getAdjList(nodo)) {
                int vecino = edge.destino;
                int peso = edge.peso;

                if (dist[nodo] + peso < dist[vecino]) {
                    dist[vecino] = dist[nodo] + peso;
                    previo[vecino] = nodo;
                    pq.add(new int[]{vecino, dist[vecino]});
                }
            }
        }

        return dist;
    }

    public static List<Integer> obtenerRuta(int destino, int[] previo) {
        List<Integer> ruta = new ArrayList<>();
        while (destino != -1) {
            ruta.add(destino);
            destino = previo[destino];
        }
        Collections.reverse(ruta);
        return ruta;
    }
}

class QuickSort {

    public static void quickSort(int[] arr, int inicio, int fin) {
        if (inicio < fin) {
            int pivoteIndex = particion(arr, inicio, fin);
            quickSort(arr, inicio, pivoteIndex - 1);
            quickSort(arr, pivoteIndex + 1, fin);
        }
    }

    private static int particion(int[] arr, int inicio, int fin) {
        int pivote = arr[fin];
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (arr[j] <= pivote) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[fin];
        arr[fin] = temp;

        return i + 1;
    }
}

public class Main {

    public static void main(String[] args) {

        // ----- ÍNDICE DE CIUDADES -----
        // 0 Cali
        // 1 Popayán
        // 2 Pasto
        // 3 Neiva
        // 4 Ibagué
        // 5 Armenia
        // 6 Pereira
        // 7 Manizales
        // 8 Medellín
        // 9 Montería
        // 10 Sincelejo
        // 11 Cartagena
        // 12 Barranquilla
        // 13 Santa Marta
        // 14 Bogotá
        // 15 Villavicencio
        // 16 Tunja
        // 17 Bucaramanga
        // 18 Cúcuta

        Graph graph = new Graph(19);

        // ----- LISTA DE ADYACENCIA -----
        graph.addEdge(0, 1, 135);
        graph.addEdge(1, 2, 285);
        graph.addEdge(0, 5, 242);
        graph.addEdge(5, 6, 50);
        graph.addEdge(6, 7, 42);
        graph.addEdge(7, 8, 49);
        graph.addEdge(8, 9, 332);
        graph.addEdge(9, 10, 132);
        graph.addEdge(10, 11, 127);
        graph.addEdge(10, 12, 111);
        graph.addEdge(12, 13, 106);
        graph.addEdge(3, 4, 243);
        graph.addEdge(0, 3, 402);
        graph.addEdge(4, 14, 142);
        graph.addEdge(14, 6, 273);
        graph.addEdge(14, 16, 130);
        graph.addEdge(14, 15, 245);
        graph.addEdge(16, 17, 179);
        graph.addEdge(17, 18, 105);
        graph.addEdge(12, 11, 105);
        graph.addEdge(6, 8, 249);
        graph.addEdge(7, 4, 285);

        int inicio = 0;     // Cali
        int destino = 11;   // Cartagena

        int[] previo = new int[19];
        int[] distancias = Dijkstra.dijkstra(graph, inicio, previo);

        List<Integer> ruta = Dijkstra.obtenerRuta(destino, previo);

        System.out.println("----- RUTA MÁS CORTA: Cali → Cartagena -----");
        for (int ciudad : ruta) {
            System.out.print(ciudad + " ");
        }

        System.out.println("\nDistancia total: " + distancias[destino] + " km");

        System.out.println("\n----- DISTANCIAS ORDENADAS (QuickSort) -----");
        int[] distCopy = distancias.clone();
        QuickSort.quickSort(distCopy, 0, distCopy.length - 1);

        for (int d : distCopy) {
            if (d != Integer.MAX_VALUE) {
                System.out.print(d + " ");
            }
        }

        System.out.println();
    }
}
