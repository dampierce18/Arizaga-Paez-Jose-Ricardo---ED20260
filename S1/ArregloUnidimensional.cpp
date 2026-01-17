#include <iostream>
#include <string>
#include <stdexcept> 
#include <vector>

using namespace std;

class ArregloUnidimensional {
private:
    static const int CAPACIDAD_MAXIMA = 10;
    string elementos[CAPACIDAD_MAXIMA]; 
    int tamano;

public:
    ArregloUnidimensional() {
        this->tamano = 0;
    }

    /**
     * Inserta un nombre en una posición específica
     * @param indice posición donde insertar (0 <= indice <= tamano)
     * @param nombre nombre propio a insertar
     * @throws runtime_error si el arreglo está lleno
     * @throws out_of_range si el índice no es válido
     */
    void insertar(int indice, string nombre) {
        if (tamano == CAPACIDAD_MAXIMA) {
            throw runtime_error("Arreglo Lleno");
        }
        if (indice < 0 || indice > tamano) {
            throw out_of_range("Indice fuera de rango: " + to_string(indice));
        }
        if (nombre.empty()) return;

        // Desplazamiento de elementos a la derecha
        for (int i = tamano; i > indice; i--) {
            elementos[i] = elementos[i - 1];
        }

        elementos[indice] = nombre; 
        tamano++;
    }

    /**
     * Elimina un nombre en una posición específica
     * @param indice posición del elemento a eliminar (0 <= indice < tamano)
     * @return nombre eliminado
     * @throws out_of_range si el índice no es válido
     */
    string eliminar(int indice) {
        if (indice < 0 || indice >= tamano) { // Nota: en eliminar es '>= tamano'
            throw out_of_range("Indice fuera de rango: " + to_string(indice));
        }

        string nombreEliminado = elementos[indice];

        // Desplazamiento de elementos a la izquierda
        for (int i = indice; i < tamano - 1; i++) {
            elementos[i] = elementos[i + 1];
        }

        // Limpiamos el último elemento
        elementos[tamano - 1].clear();
        
        tamano--;
        return nombreEliminado;
    }

    /**
     * Obtiene el nombre de una posicion dada
     * @param indice posición del elemento
     * @return nombre almacenado
     * @throws out_of_range si el índice no es válido
     */
    string obtener(int indice) {
        if (indice < 0 || indice >= tamano) {
            throw out_of_range("Indice fuera de rango: " + to_string(indice));
        }
        return elementos[indice];
    }

    /**
     * Devuelve el número actual de elementos
     * @return tamaño lógico
     */
    int getTamano() {
        return tamano;
    }

    /**
     * Verifica si el arreglo está lleno
     * @return true si alcanzó la capacidad máxima
     */
    bool estaLleno() {
        return tamano == CAPACIDAD_MAXIMA;
    }

    /**
     * Imprime el estado actual del arreglo
     */
    void imprimir() {
        if (tamano == 0) {
            cout << "[] (arreglo vacio)" << endl;
            return;
        }

        cout << "[";
        for (int i = 0; i < tamano; i++) {
            cout << elementos[i];
            if (i < tamano - 1) cout << ", ";
        }
        cout << "]" << endl;
    }
};

// Función main para probar la clase 
int main() {
    try {
        ArregloUnidimensional arreglo;
        
        arreglo.insertar(0, "Hugo");
        arreglo.insertar(1, "Paco");
        arreglo.insertar(2, "Luis");
        
        cout << "Estado inicial: ";
        arreglo.imprimir();

        cout << "Eliminando indice 1 (" << arreglo.eliminar(1) << ")..." << endl;
        arreglo.imprimir();

        cout << "Insertando Donald en indice 0..." << endl;
        arreglo.insertar(0, "Donald");
        arreglo.imprimir();

    } catch (const exception& e) {
        cerr << "Error: " << e.what() << endl;
    }

    return 0;
}