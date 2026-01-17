#include <iostream>
#include <vector>
#include <string>
#include <iomanip> // Para formatear la impresión

using namespace std;

class MatrizDinamica {
private:
    // Usamos vector de vectores en lugar de string[][]
    vector<vector<string>> matriz;

public:
    // Constructor: Inicializa con datos de prueba (como en el ejemplo original)
    MatrizDinamica() {
        matriz = {
            {"Hugo", "Paco", "Luis"},
            {"Ana", "Martha", "Ena"},
            {"Xi", "Fi", "Fu"}
        };
    }

    // 1. INSERTAR FILA O COLUMNA
    
    // Inserta una fila completa en una posición dada
    void insertarFila(int indice, vector<string> nuevaFila) {
        if (indice < 0 || indice > matriz.size()) {
            cout << "Error: Indice de fila fuera de rango." << endl;
            return;
        }
        // Validamos que la nueva fila tenga el mismo ancho que la matriz
        if (!matriz.empty() && nuevaFila.size() != matriz[0].size()) {
            cout << "Error: La fila nueva debe tener " << matriz[0].size() << " columnas." << endl;
            return;
        }
        
        // .insert() mueve todo automáticamente
        matriz.insert(matriz.begin() + indice, nuevaFila);
        cout << ">> Fila insertada en indice " << indice << endl;
    }

    // Inserta una columna en una posición dada con un valor por defecto
    void insertarColumna(int indice, string valorDefecto) {
        if (matriz.empty()) return;
        if (indice < 0 || indice > matriz[0].size()) {
            cout << "Error: Indice de columna fuera de rango." << endl;
            return;
        }

        // Recorremos cada fila e inyectamos el valor en la posición deseada
        for (int i = 0; i < matriz.size(); i++) {
            matriz[i].insert(matriz[i].begin() + indice, valorDefecto);
        }
        cout << ">> Columna insertada en indice " << indice << endl;
    }

    // 2. ELIMINAR FILA O COLUMNA

    void eliminarFila(int indice) {
        if (indice < 0 || indice >= matriz.size()) {
            cout << "Error: Indice invalido." << endl;
            return;
        }
        matriz.erase(matriz.begin() + indice);
        cout << ">> Fila " << indice << " eliminada." << endl;
    }

    void eliminarColumna(int indice) {
        if (matriz.empty()) return;
        if (indice < 0 || indice >= matriz[0].size()) {
            cout << "Error: Indice invalido." << endl;
            return;
        }
        // Eliminamos el elemento 'indice' de cada fila
        for (int i = 0; i < matriz.size(); i++) {
            matriz[i].erase(matriz[i].begin() + indice);
        }
        cout << ">> Columna " << indice << " eliminada." << endl;
    }

    // 3. BUSCAR VALOR (Devuelve coordenadas)
    
    void buscarValor(string nombre) {
        bool encontrado = false;
        for (int i = 0; i < matriz.size(); i++) {
            for (int j = 0; j < matriz[i].size(); j++) {
                if (matriz[i][j] == nombre) {
                    cout << "Encontrado '" << nombre << "' en Fila: " << i << ", Columna: " << j << endl;
                    encontrado = true;
                }
            }
        }
        if (!encontrado) cout << "El valor '" << nombre << "' no existe en la matriz." << endl;
    }

    // 4. RECORRIDOS (Por filas y por columnas)

    void imprimirPorFilas() {
        cout << "\n--- Recorrido por FILAS ---" << endl;
        for (const auto& fila : matriz) {
            for (const auto& elemento : fila) {
                cout << setw(10) << elemento; // setw da espaciado uniforme
            }
            cout << endl;
        }
    }

    void imprimirPorColumnas() {
        if (matriz.empty()) return;
        cout << "\n--- Recorrido por COLUMNAS ---" << endl;
        int filas = matriz.size();
        int cols = matriz[0].size();

        for (int j = 0; j < cols; j++) { // Primero iteramos columnas
            cout << "Col " << j << ": ";
            for (int i = 0; i < filas; i++) { // Luego filas
                cout << matriz[i][j] << " | ";
            }
            cout << endl;
        }
    }
};