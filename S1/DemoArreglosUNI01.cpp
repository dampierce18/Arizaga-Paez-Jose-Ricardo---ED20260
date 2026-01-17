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

    return 0;
}