#include <iostream>
#include <vector>
#include <string>
#include "MatrizDinamica.cpp" 

using namespace std;

int main() {
    MatrizDinamica gestor;

    cout << "=== ESTADO INICIAL ===";
    gestor.imprimirPorFilas();

    // 1. Insertar Fila
    // Creamos una fila nueva (debe tener 3 elementos porque la matriz original es de 3 columnas)
    vector<string> nuevaFila = {"FIL1", "FIL1", "FIL1"};
    gestor.insertarFila(1, nuevaFila); // Insertar en índice 1
    gestor.imprimirPorFilas();

    // 2. Insertar Columna
    gestor.insertarColumna(0, "COL0"); // Insertar al inicio
    gestor.imprimirPorFilas();

    // 3. Buscar Valor
    cout << "\n=== BUSQUEDA ===" << endl;
    gestor.buscarValor("Martha");
    gestor.buscarValor("Goku"); // No existe

    // 4. Eliminar Fila y Columna
    cout << "\n=== ELIMINACION ===" << endl;
    gestor.eliminarFila(0); // Eliminamos la primera fila
    gestor.eliminarColumna(2); // Eliminamos una columna intermedia
    gestor.imprimirPorFilas();

    // 5. Recorrido Inverso (Por columnas)
    gestor.imprimirPorColumnas();

    return 0;
}