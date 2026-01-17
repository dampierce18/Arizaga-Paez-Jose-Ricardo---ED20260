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

    // MÉTODOS DE LA TAREA S1_2

    /**
     * 1. Búsqueda por valor (Lineal)
     * Recorre el arreglo buscando el nombre.
     * @return índice del nombre o -1 si no existe.
     */
    int buscar(string nombre) {
        for (int i = 0; i < tamano; i++) {
            if (elementos[i] == nombre) {
                return i;
            }
        }
        return -1; // No encontrado
    }

    /**
     * 2. Ordenamiento (Burbuja - Natural/Alfabético)
     * Ordena los nombres de A a Z.
     */
    void ordenar() {
        for (int i = 0; i < tamano - 1; i++) {
            for (int j = 0; j < tamano - i - 1; j++) {
                // El operador > en string compara alfabéticamente
                if (elementos[j] > elementos[j + 1]) {
                    string temp = elementos[j];
                    elementos[j] = elementos[j + 1];
                    elementos[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 3. Inversión del arreglo
     * Invierte el orden de los elementos actuales.
     */
    void invertir() {
        for (int i = 0; i < tamano / 2; i++) {
            string temp = elementos[i];
            int indiceContrario = tamano - 1 - i;
            elementos[i] = elementos[indiceContrario];
            elementos[indiceContrario] = temp;
        }
    }

    /**
     * 4. Búsqueda Binaria
     * IMPORTANTE: El arreglo DEBE estar ordenado previamente.
     * Divide el arreglo en mitades para buscar más rápido.
     */
    int busquedaBinaria(string nombre) {
        int izquierda = 0;
        int derecha = tamano - 1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;

            if (elementos[medio] == nombre)
                return medio; // Encontrado

            if (elementos[medio] < nombre)
                izquierda = medio + 1; // Buscar en la mitad derecha
            else
                derecha = medio - 1; // Buscar en la mitad izquierda
        }
        return -1; // No encontrado
    }

    /**
     * 5. Inserción en arreglo ordenado
     * Inserta un elemento manteniendo el orden alfabético.
     * Asume que el arreglo ya está ordenado.
     */
    void insertarOrdenado(string nombre) {
        if (tamano == CAPACIDAD_MAXIMA) throw runtime_error("Arreglo Lleno");
        if (nombre.empty()) return;

        int i = tamano - 1;
        // Mueve los elementos mayores hacia la derecha para hacer hueco
        while (i >= 0 && elementos[i] > nombre) {
            elementos[i + 1] = elementos[i];
            i--;
        }
        
        // Inserta en la posición correcta
        elementos[i + 1] = nombre;
        tamano++;
    }
};
