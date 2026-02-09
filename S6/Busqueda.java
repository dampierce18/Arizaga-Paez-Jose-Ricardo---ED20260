package S6;

public class Busqueda {
    public static void main(String[] args) {
        // Arreglo ordenado para las búsquedas optimizadas
        int[] arr = {10, 23, 35, 40, 55, 67, 71, 80, 89, 95};
        int objetivo = 67;

        mostrar(arr);

        System.out.println("\n--- BUSQUEDA SECUENCIAL ---");
        int pos = buscaLineal(arr, objetivo);
        System.out.println("Elemento " + objetivo + " encontrado en indice: " + pos);

        System.out.println("\n--- BUSQUEDA BINARIA ---");
        pos = buscaBinaria(arr, objetivo);
        System.out.println("Elemento " + objetivo + " encontrado en indice: " + pos);

        System.out.println("\n--- BUSQUEDA INTERPOLACION ---");
        pos = buscaInterpolacion(arr, objetivo);
        System.out.println("Elemento " + objetivo + " encontrado en indice: " + pos);

        System.out.println("\n--- BUSQUEDA POR SALTO (JUMP) ---");
        pos = buscaSalto(arr, objetivo);
        System.out.println("Elemento " + objetivo + " encontrado en indice: " + pos);
    }

    // 1. Busqueda Secuencial (Lineal)
    public static int buscaLineal(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == x) return i;
        return -1;
    }

    // 2. Busqueda Binaria (Requiere ordenado)
    public static int buscaBinaria(int[] arr, int x) {
        int inicio = 0, fin = arr.length - 1;
        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            if (arr[medio] == x) return medio;
            if (arr[medio] > x) fin = medio - 1;
            else inicio = medio + 1;
        }
        return -1;
    }

    // 3. Busqueda Interpolacion (Mejora binaria si distribución es uniforme)
    public static int buscaInterpolacion(int[] arr, int x) {
        int bajo = 0, alto = arr.length - 1;
        
        while (bajo <= alto && x >= arr[bajo] && x <= arr[alto]) {
            if (bajo == alto) {
                if (arr[bajo] == x) return bajo;
                return -1;
            }

            // Fórmula de interpolación (corregida con casting a double para precisión)
            // pos = lo + ((x - arr[lo]) * (hi - lo) / (arr[hi] - arr[lo]))
            int pos = bajo + (int) (((double)(alto - bajo) / (arr[alto] - arr[bajo])) * (x - arr[bajo]));

            if (arr[pos] == x) return pos;
            if (arr[pos] < x) bajo = pos + 1;
            else alto = pos - 1;
        }
        return -1;
    }

    // 4. Busqueda por Salto (Jump Search)
    public static int buscaSalto(int[] arr, int x) {
        int n = arr.length;
        int salto = (int) Math.sqrt(n); // Tamaño del bloque
        int prev = 0;

        // Saltar bloques mientras el valor sea menor al objetivo
        while (arr[Math.min(salto, n) - 1] < x) {
            prev = salto;
            salto += (int) Math.sqrt(n);
            if (prev >= n) return -1;
        }

        // Búsqueda lineal dentro del bloque identificado
        while (arr[prev] < x) {
            prev++;
            if (prev == Math.min(salto, n)) return -1;
        }

        if (arr[prev] == x) return prev;
        return -1;
    }

    public static void mostrar(int[] arr) {
        System.out.print("Arreglo: ");
        for (int v : arr) System.out.print(v + " ");
        System.out.println();
    }
}