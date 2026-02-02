package S4;

public class NodoDoble {
    Persona dato;
    NodoDoble next;
    NodoDoble prev;     

    public NodoDoble(Persona p) {
        this.dato = p;
        this.next = null;
        this.prev = null;
    }
}