import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExamenColaMapa {

    // Clase interna para manejar una cola circular de enteros
    static class ColaCircularEnteros {
        private int[] datos;
        private int cabeza;
        private int cola;
        private int tam;

        public ColaCircularEnteros(int capacidad) {
            datos = new int[capacidad];
            cabeza = 0;
            cola = 0;
            tam = 0;
        }

        public boolean estaVacia() { 
            return tam == 0; 
        }

        public boolean estaLlena() { 
            return tam == datos.length; 
        }

        // Encolar un nuevo elemento
        public void encolar(int x) {
            if (estaLlena()) throw new IllegalStateException("Cola llena");
            datos[cola] = x;
            cola = (cola + 1) % datos.length;
            tam++;
        }

        // Desencolar y retornar el elemento más antiguo
        public int desencolar() {
            if (estaVacia()) throw new IllegalStateException("Cola vacía");
            int v = datos[cabeza];
            cabeza = (cabeza + 1) % datos.length;
            tam--;
            return v;
        }
    }

    /**
     * (50 pts)
     * Calcula el balance de paréntesis encolando +1 para '(' y -1 para ')'.
     */
    public static int balanceConCola(String s) {
        ColaCircularEnteros cola = new ColaCircularEnteros(s.length());

        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') cola.encolar(1);
            else if (c == ')') cola.encolar(-1);
        }


        int suma = 0;
        while (!cola.estaVacia()) {
            suma += cola.desencolar();
        }

        return suma; 
    }

    /**
     * (50 pts)
     * Registra el número de intentos por nombre en un mapa.
     */
    public static int registrarIntento(Map<String, Integer> intentos, String nombre) {
        int actual = 0;

        if (intentos.containsKey(nombre)) {
            actual = intentos.get(nombre) + 1;
        } else {
            actual = 1; 
        }

        intentos.put(nombre, actual); 
        return actual;
    }

     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese una cadena con paréntesis:");
        String cadena = sc.nextLine();
        System.out.println("Balance cola: " + balanceConCola(cadena));

        Map<String, Integer> intentos = new HashMap<>();
        System.out.println("Intentos (Ana): " + registrarIntento(intentos, "Ana"));
        System.out.println("Intentos (Ana): " + registrarIntento(intentos, "Ana"));


        sc.close();
    }
}
