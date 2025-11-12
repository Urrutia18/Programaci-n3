import java.util.*;

public class Dijkstra {
    static class Arista {
        int destino;
        int peso;

        Arista(int destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }

    public static void main(String[] args) {
        // Número de nodos
        int vertices = 5;

        // Grafo representado como lista de adyacencia
        List<List<Arista>> grafo = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            grafo.add(new ArrayList<>());
        }

        // Agregamos aristas (nodoOrigen, nodoDestino, peso)
        agregarArista(grafo, 0, 1, 10);
        agregarArista(grafo, 0, 2, 3);
        agregarArista(grafo, 1, 2, 1);
        agregarArista(grafo, 1, 3, 2);
        agregarArista(grafo, 2, 1, 4);
        agregarArista(grafo, 2, 3, 8);
        agregarArista(grafo, 2, 4, 2);
        agregarArista(grafo, 3, 4, 7);
        agregarArista(grafo, 4, 3, 9);

        int origen = 0;
        dijkstra(grafo, origen);
    }

    // Método para agregar aristas dirigidas
    static void agregarArista(List<List<Arista>> grafo, int origen, int destino, int peso) {
        grafo.get(origen).add(new Arista(destino, peso));
    }

    // Implementación del algoritmo de Dijkstra
    static void dijkstra(List<List<Arista>> grafo, int origen) {
        int n = grafo.size();
        int[] distancia = new int[n];
        boolean[] visitado = new boolean[n];

        // Inicializa todas las distancias como infinito
        Arrays.fill(distancia, Integer.MAX_VALUE);
        distancia[origen] = 0;

        // Cola de prioridad: almacena pares (distancia, nodo)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, origen});

        while (!pq.isEmpty()) {
            int[] actual = pq.poll();
            int distActual = actual[0];
            int nodo = actual[1];

            if (visitado[nodo]) continue;
            visitado[nodo] = true;

            // Recorre los vecinos del nodo actual
            for (Arista arista : grafo.get(nodo)) {
                int vecino = arista.destino;
                int peso = arista.peso;

                // Si se encuentra un camino más corto, actualiza
                if (distActual + peso < distancia[vecino]) {
                    distancia[vecino] = distActual + peso;
                    pq.offer(new int[]{distancia[vecino], vecino});
                }
            }
        }

        // Mostrar distancias finales
        System.out.println("Distancias mínimas desde el nodo " + origen + ":");
        for (int i = 0; i < n; i++) {
            System.out.println("→ Nodo " + i + ": " + distancia[i]);
        }
    }
}
