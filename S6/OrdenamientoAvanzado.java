package S6;

import java.util.Arrays;

public class OrdenamientoAvanzado {
    
    public static void main(String[] args) {
        int[] datos = {170, 45, 75, 90, 802, 24, 2, 66};
        
        System.out.println("--- PRUEBAS DE ORDENAMIENTO AVANZADO ---");
        System.out.println("Original: " + Arrays.toString(datos));

        // 1. QUICK SORT
        int[] arr1 = datos.clone();
        quickSort(arr1, 0, arr1.length - 1);
        System.out.println("QuickSort: " + Arrays.toString(arr1));

        // 2. HEAP SORT
        int[] arr2 = datos.clone();
        heapSort(arr2);
        System.out.println("HeapSort:  " + Arrays.toString(arr2));

        // 3. COUNTING SORT (Para demo usamos un rango pequeño de 0 a 9)
        int[] datosPeque = {4, 2, 2, 8, 3, 3, 1};
        System.out.println("\nDatos Counting: " + Arrays.toString(datosPeque));
        countingSort(datosPeque);
        System.out.println("CountingSort:   " + Arrays.toString(datosPeque));

        // 4. RADIX SORT
        int[] arr3 = datos.clone();
        radixSort(arr3);
        System.out.println("\nRadixSort: " + Arrays.toString(arr3));
    }

    // ==========================================
    // 1. QUICK SORT (Divide y Vencerás)
    // ==========================================
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);  // Antes del pivote
            quickSort(arr, pi + 1, high); // Después del pivote
        }
    }
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap
                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }
        // Swap pivote a su lugar final
        int temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
        return i + 1;
    }

    // ==========================================
    // 2. HEAP SORT (Montículo)
    // ==========================================
    public static void heapSort(int[] arr) {
        int n = arr.length;
        // Construir heap (reorganizar array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        // Extraer elementos uno a uno
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0]; arr[0] = arr[i]; arr[i] = temp; // Mover raíz al final
            heapify(arr, i, 0); // Llamar heapify en el heap reducido
        }
    }
    private static void heapify(int[] arr, int n, int i) {
        int largest = i; 
        int l = 2 * i + 1; 
        int r = 2 * i + 2; 

        if (l < n && arr[l] > arr[largest]) largest = l;
        if (r < n && arr[r] > arr[largest]) largest = r;

        if (largest != i) {
            int swap = arr[i]; arr[i] = arr[largest]; arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

    // ==========================================
    // 3. COUNTING SORT (Por conteo)
    // ==========================================
    public static void countingSort(int[] arr) {
        int n = arr.length;
        int max = Arrays.stream(arr).max().getAsInt(); // Hallar el mayor
        int[] count = new int[max + 1];
        int[] output = new int[n];

        // Contar ocurrencias
        for (int i = 0; i < n; i++) count[arr[i]]++;
        // Acumular conteo
        for (int i = 1; i <= max; i++) count[i] += count[i - 1];
        // Construir output
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }
        // Copiar al original
        System.arraycopy(output, 0, arr, 0, n);
    }

    // ==========================================
    // 4. RADIX SORT (Por dígitos)
    // ==========================================
    public static void radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        // Aplicar counting sort para cada digito (1s, 10s, 100s...)
        for (int exp = 1; max / exp > 0; exp *= 10)
            countingSortRadix(arr, exp);
    }
    private static void countingSortRadix(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) count[(arr[i] / exp) % 10]++;
        for (int i = 1; i < 10; i++) count[i] += count[i - 1];
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        System.arraycopy(output, 0, arr, 0, n);
    }
}