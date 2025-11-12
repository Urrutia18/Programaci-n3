public class Burbuja {
    public static void main(String[] args) {
        int[] numeros = {5, 3, 8, 1, 2};
        
        for (int i = 0; i < numeros.length - 1; i++) {
            for (int j = 0; j < numeros.length - 1 - i; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    int temp = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temp;
                }
            }
        }

        System.out.print("Burbuja: ");
        for (int n : numeros)
            System.out.print(n + " ");
    }
}
