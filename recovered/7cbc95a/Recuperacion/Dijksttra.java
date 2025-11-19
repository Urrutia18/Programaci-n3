import java.util.*;

public class Dijkstra {

    public static int[] dijkstra(Graph graph, int inicio) {
        int n = graph.size();

        int[] dist = new int[n];
        boolean[] visitado = new boolean[n];
        int[] previo = new int[n];

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
