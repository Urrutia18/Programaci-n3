public class Seleccion {
    public static void main(String[] args) {
        int[] numeros = {5, 3, 8, 1, 2};

        for (int i = 0; i < numeros.length - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < numeros.length; j++) {
                if (numeros[j] < numeros[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }
            int temp = numeros[i];
            numeros[i] = numeros[indiceMinimo];
            numeros[indiceMinimo] = temp;
        }

        System.out.print("Selección: ");
        for (int n : numeros)
            System.out.print(n + " ");
    }
}
