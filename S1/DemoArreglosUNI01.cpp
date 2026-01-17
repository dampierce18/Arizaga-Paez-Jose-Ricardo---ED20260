#include <iostream>
#include <string>
#include <stdexcept>
#include "ArregloUnidimensional.cpp" 

using namespace std;

/**
 * Ejemplo de uso de arreglo unidimensional con nombres propios
 * inserta, elimina, valida indices y estados críticos
 */
int main() {
    ArregloUnidimensional arr;

    // Llenamos el arreglo
    arr.insertar(0, "Hugo"); 
    arr.insertar(1, "Paco");
    arr.insertar(1, "Luis");
    arr.insertar(2, "Ana"); 
    arr.insertar(3, "Javier");
    arr.insertar(4, "Maria");
    arr.insertar(5, "Ena"); 
    arr.insertar(6, "Martha");
    arr.insertar(7, "Bertha");
    arr.insertar(8, "Gaby"); 

    cout << "Arreglo Lleno" << endl;
    arr.imprimir();

    // Intentar insertar un undécimo elemento -> genera excepción
    try {
        arr.insertar(9, "Donald Trompas");
    } catch (const exception& e) {
        // Capturamos la excepción (equivalente a IllegalStateException/runtime_error)
        cout << "\n " << e.what() << endl;
    }

    // Eliminar
    string eliminado = arr.eliminar(0);
    cout << "\nEliminado: " << eliminado << endl;
    arr.imprimir();

    arr.eliminar(4);
    cout << "Despues de eliminar indice 4" << endl;
    arr.imprimir();

    // PROBANDO METODOS DE LA TAREA S1_2
    // 2. Búsqueda Lineal
    cout << "\n--- BUSQUEDA LINEAL ---" << endl;
    string buscado = "Luis";
    int pos = arr.buscar(buscado);
    cout << "Buscando a '" << buscado << "': " << (pos != -1 ? "Encontrado en indice " + to_string(pos) : "No encontrado") << endl;

    // 3. Inversión
    cout << "\n--- INVERSION DEL ARREGLO ---" << endl;
    arr.invertir();
    arr.imprimir();
    
    // Regresamos a la normalidad invirtiendo de nuevo (opcional, para probar ordenamiento después)
    arr.invertir(); 

    // 4. Ordenamiento
    cout << "\n--- ORDENAMIENTO (ALFABETICO) ---" << endl;
    arr.ordenar();
    arr.imprimir();

    // 5. Búsqueda Binaria (Solo funciona si está ordenado)
    cout << "\n--- BUSQUEDA BINARIA ---" << endl;
    buscado = "Maria";
    pos = arr.busquedaBinaria(buscado);
    cout << "Buscando a '" << buscado << "' (Binaria): " << (pos != -1 ? "Encontrado en indice " + to_string(pos) : "No encontrado") << endl;

    // 6. Inserción Ordenada
    cout << "\n--- INSERCION ORDENADA (Insertando 'Dario') ---" << endl;
    arr.insertarOrdenado("Dario"); 
    arr.imprimir();

    return 0;
}