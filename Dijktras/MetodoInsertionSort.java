public class Insercion {
    public static void main(String[] args) {
        int[] numeros = {5, 3, 8, 1, 2};

        for (int i = 1; i < numeros.length; i++) {
            int actual = numeros[i];
            int j = i - 1;
            while (j >= 0 && numeros[j] > actual) {
                numeros[j + 1] = numeros[j];
                j--;
            }
            numeros[j + 1] = actual;
        }

        System.out.print("Inserción: ");
        for (int n : numeros)
            System.out.print(n + " ");
    }
}
