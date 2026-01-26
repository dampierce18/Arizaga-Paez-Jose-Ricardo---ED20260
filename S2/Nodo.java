// Tarea Sem02_01
package S2;

public class Nodo {
    private double dato;
    private Nodo siguiente;

    public Nodo(double dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public double getDato() {
        return dato;
    }

    public void setDato(double dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}