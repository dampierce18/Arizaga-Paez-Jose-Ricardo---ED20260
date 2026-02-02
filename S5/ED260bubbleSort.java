package S5;

import java.util.Random;

public class ED260bubbleSort {

    public static void main(String[] args) {
        int[] datosOriginales = {5, 3, 8, 4, 2};

        System.out.println("1. BUBBLE SORT (Burbuja)");
        System.out.println("DESCRIPCION: Compara pares de elementos adyacentes y los intercambia \n" +
                           "si estan en el orden incorrecto. Este proceso se repite hasta que no \n" +
                           "se necesitan mas intercambios. Es sencillo (O(n^2)) pero lento \n" +
                           "en listas grandes.");
        System.out.println("-------------------------------------------------");
        
        int[] arr1 = datosOriginales.clone();
        System.out.print("Original: ");
        mostrar(arr1);
        BubbleSort(arr1);
        System.out.print("Ordenado: ");
        mostrar(arr1);
        System.out.println();


        System.out.println("2. SELECTION SORT (Seleccion)");
        System.out.println("DESCRIPCION: Busca repetidamente el elemento minimo de la parte no \n" +
                           "ordenada y lo intercambia con el primer elemento. Mantiene dos \n" +
                           "sublistas (ordenada y no ordenada). Su complejidad es siempre O(n^2) \n" +
                           "porque siempre recorre todo el resto de la lista.");
        System.out.println("-------------------------------------------------");
        
        int[] arr2 = datosOriginales.clone();
        System.out.print("Original: ");
        mostrar(arr2);
        selectionSort(arr2);
        System.out.print("Ordenado: ");
        mostrar(arr2);
        System.out.println();


        System.out.println("3. INSERTION SORT (Insercion)");
        System.out.println("DESCRIPCION: Construye el arreglo ordenado elemento por elemento. \n" +
                           "Toma un item de la parte no ordenada y lo inserta en su posicion \n" +
                           "correcta desplazando los mayores a la derecha. Es muy eficiente para \n" +
                           "listas pequeñas o casi ordenadas.");
        System.out.println("-------------------------------------------------");
        
        int[] arr3 = datosOriginales.clone();
        System.out.print("Original: ");
        mostrar(arr3);
        insertionSort(arr3);
        System.out.print("Ordenado: ");
        mostrar(arr3);
        System.out.println();


        System.out.println("4. BOGO SORT (Bobocha)");
        System.out.println("DESCRIPCION: Algoritmo ineficiente basado en la suerte (aleatoriedad). \n" +
                           "Genera permutaciones al azar (baraja como cartas) y verifica si \n" +
                           "quedo ordenado. Complejidad O(n*n!). Solo para fines educativos.");
        System.out.println("-------------------------------------------------");
        
        int[] arr4 = datosOriginales.clone();
        System.out.print("Original: ");
        mostrar(arr4);
        bogoSort(arr4);
        System.out.print("Ordenado: ");
        mostrar(arr4);
    }

    public static void BubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean intercambio = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int aux = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = aux;
                    intercambio = true;
                }
            }
            if (!intercambio) break;
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }
            int temp = arr[indiceMinimo];
            arr[indiceMinimo] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void bogoSort(int[] arr) {
        while (!estaOrdenado(arr)) {
            barajar(arr);
        }
    }

    private static boolean estaOrdenado(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }

    private static void barajar(int[] arr) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            int indiceAleatorio = rand.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[indiceAleatorio];
            arr[indiceAleatorio] = temp;
        }
    }

    public static void mostrar(int[] arr) {
        for (int x : arr) System.out.print(x + " ");
        System.out.println();
    }
}