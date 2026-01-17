#include <iostream>
#include <string>
#include <vector>

using namespace std;

// Prototipo de la función
void imprimir(const vector<vector<string>>& m);

int main() {
    // Inicialización de la matriz usando vector de vectores
    vector<vector<string>> matriz = {
        {"Hugo", "Paco", "Luis", "Jesus", "Maria"},
        {"Jose", "Martha", "Ena", "Bertha", "Lula"},
        {"Putin", "Ana", "Luisa", "Jesusa", "Mario"},
        {"Xi", "Fi", "Fu", "Li", "Ju"},
        {"Rena", "Paca", "Leo", "Javier", "Bruno"}
    };

    imprimir(matriz);

    cout << "\nCONTORNO" << endl;
    
    int n = matriz.size(); // Tamaño de las filas
    
    // Asumimos matriz cuadrada como en el original
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            // Lógica para detectar los bordes
            if (i == 0 || i == n - 1 || j == 0 || j == n - 1) {
                cout << matriz[i][j] << "\t";
            } else {
                cout << " \t"; // Espacio para mantener la alineación
            }
        }
        cout << endl;
    }

    return 0;
}

// Función auxiliar para imprimir la matriz completa
void imprimir(const vector<vector<string>>& m) {
    // Equivalente al "for-each" de Java
    for (const auto& fila : m) {
        for (const auto& nombre : fila) {
            cout << nombre << "\t";
        }
        cout << endl;
    }
}