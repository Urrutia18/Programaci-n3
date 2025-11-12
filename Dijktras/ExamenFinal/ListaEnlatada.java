public class Matrizlista{
    public Statim void main (String[] args){
        int[][] Matriz={
            {0, 3, 0, 4}
            {1, 0, 4, 0}
            {0, 2, 0, 5}
            {7, 0, 8, 0}
        }

         ArrayList<ArrayList<Integer>>listaAdyacencia=new ArrayList<>();
           for (int i = 0; i < Matriz.length; i++) {
           ArrayList<Integer fila = new ArrayList<>();
           for (int j = 0; j < Matriz[i].length; j++) { 
            if(matriz[i][j] != 0){
                fila.add(matriz[i][j]);
                }
           }
           listaAdyacencia.add(filas)
        }
        System.out.println("lista de Adyacencia");
        for(int i=0; i<listaAdyacencia.size(); i++){
            System.out.println("nodo "+ i +"->" +listaAdyacencia.get(i));
            }
           int menor = Integer.MAX_VALUE;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] != 0 && matriz[i][j] < menor) {
                    menor = matriz[i][j];
                }
            }
        }
        System.out.println("\nEl menor valor en la matriz es: " + menor);

    
        System.out.println("\nRecorrido BFS desde el nodo 0:");
        bfs(listaAdyacencia, 0);

    
        System.out.println("\nRecorrido DFS desde el nodo 0:");
        boolean[] visitado = new boolean[listaAdyacencia.size()];
        dfs(listaAdyacencia, 0, visitado);
    }


    public static void bfs(ArrayList<ArrayList<Integer>> lista, int inicio) {
        boolean[] visitado = new boolean[lista.size()];
        Queue<Integer> cola = new LinkedList<>();

        visitado[inicio] = true;
        cola.add(inicio);

        while (!cola.isEmpty()) {
            int nodo = cola.poll();
            System.out.print(nodo + " ");

            for (int vecino : lista.get(nodo)) {
                if (!visitado[vecino]) {
                    visitado[vecino] = true;
                    cola.add(vecino);
                }
            }
        }
    }