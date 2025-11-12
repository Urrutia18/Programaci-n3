public class QuickSort {
    public static void main(String[] args) {
        int[] numeros = {5, 3, 8, 1, 2};
        quickSort(numeros, 0, numeros.length - 1);

        System.out.print("Quick Sort: ");
        for (int n : numeros)
            System.out.print(n + " ");
    }

    static void quickSort(int[] arr, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int indicePivote = particionar(arr, izquierda, derecha);
            quickSort(arr, izquierda, indicePivote - 1);
            quickSort(arr, indicePivote + 1, derecha);
        }
    }

    static int particionar(int[] arr, int izquierda, int derecha) {
        int pivote = arr[derecha];
        int i = izquierda - 1;
        for (int j = izquierda; j < derecha; j++) {
            if (arr[j] <= pivote) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[derecha];
        arr[derecha] = temp;
        return i + 1;
    }
}
