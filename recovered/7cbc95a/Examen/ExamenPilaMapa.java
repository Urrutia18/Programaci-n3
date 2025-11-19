import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExamenPilaMapa {

    // Clase interna para manejar una pila de enteros
    static class PilaEnteros {
        private int[] datos;
        private int tope; 

        public PilaEnteros(int capacidad) {
            datos = new int[capacidad];
            tope = -1;
        }

        public boolean estaVacia() { 
            return tope == -1; 
        }

        public boolean estaLlena() { 
            return tope + 1 == datos.length; 
        }

        // Apilar un elemento en la pila
        public void apilar(int x) {
            if (estaLlena()) throw new IllegalStateException("Pila llena");
            tope++;
            datos[tope] = x;
        }

        // Desapilar y retornar el elemento superior
        public int desapilar() {
            if (estaVacia()) throw new IllegalStateException("Pila vacía");
            int v = datos[tope];
            tope--;
            return v;
        }
    }

    /**
     * (50 pts)
     * Verifica si los paréntesis de una cadena están balanceados.
     */
    public static boolean esBalanceado(String s) {
        PilaEnteros pila = new PilaEnteros(s.length());

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                pila.apilar(1);
            } else if (c == ')') {
                if (pila.estaVacia()) {
                    return false; 
                }
                pila.desapilar(); 
            }
        }

        
        return pila.estaVacia();
    }

    /**
     * (50 pts)
     * Actualiza la calificación si el ID existe y el nuevo valor está entre 0 y 100.
     */
    public static boolean actualizarCalificacion(Map<Integer, Integer> califPorId, int id, int nuevo) {
        if (nuevo < 0 || nuevo > 100) return false; 
        if (!califPorId.containsKey(id)) return false; 
        califPorId.put(id, nuevo); 
        return true;
    }

      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese una cadena con paréntesis:");
        String cadena = sc.nextLine();
        System.out.println("Balanceado: " + esBalanceado(cadena));

        Map<Integer, Integer> mapa = new HashMap<>();
        mapa.put(101, 70);

        System.out.println("Actualizado: " + actualizarCalificacion(mapa, 101, 95));

        sc.close();
    }
}
