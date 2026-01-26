// Tarea Sem02_01
package S2;

public class ListaEnlazadaTail {
    private Nodo head;
    private Nodo tail; 
    private int size;

    public ListaEnlazadaTail() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void insertaInicio(Double x) {
        Nodo nuevo = new Nodo(x);
        if (head == null) {
            head = nuevo;
            tail = nuevo; 
        } else {
            nuevo.setSiguiente(head);
            head = nuevo;
        }
        size++;
    }

    public void insertaFinal(Double x) {
        Nodo nuevo = new Nodo(x);
        if (head == null) {
            head = nuevo;
            tail = nuevo;
        } else {          
            tail.setSiguiente(nuevo);
            tail = nuevo; 
        }
        size++;
    }

    public boolean insertaXposicion(Double x, int pos) {
        if (pos < 0 || pos > size) return false;
        
        if (pos == 0) {
            insertaInicio(x);
            return true;
        }
        if (pos == size) {
            insertaFinal(x);
            return true;
        }

        Nodo nuevo = new Nodo(x);
        Nodo actual = head;
        int posActual = 0;

        while (posActual < pos - 1) {
            actual = actual.getSiguiente();
            posActual++;
        }

        nuevo.setSiguiente(actual.getSiguiente());
        actual.setSiguiente(nuevo);
        size++;
        return true;
    }

    // Tarea Sem02_02: Eliminar, Buscar, Ordenar

    public void eliminarInicio() {
        if (head == null) return; 
        
        if (head == tail) { 
            head = null;
            tail = null;
        } else {
            head = head.getSiguiente();
        }
        size--;
    }

    public void eliminarFinal() {
        if (head == null) return;
        
        if (head == tail) { 
            head = null;
            tail = null;
        } else {
            Nodo actual = head;
            while (actual.getSiguiente() != tail) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(null); 
            tail = actual;        
        }
        size--;
    }

    public boolean eliminarXposicion(int pos) {
        if (pos < 0 || pos >= size) return false; 
        
        if (pos == 0) { eliminarInicio(); return true; }
        if (pos == size - 1) { eliminarFinal(); return true; }

        Nodo actual = head;
        int posActual = 0;
        while (posActual < pos - 1) {
            actual = actual.getSiguiente();
            posActual++;
        }
        Nodo eliminar = actual.getSiguiente();
        actual.setSiguiente(eliminar.getSiguiente());
        size--;
        return true;
    }

    public int buscarPorValor(Double valor) {
        Nodo actual = head;
        int pos = 0;
        while (actual != null) {
            if (actual.getDato() == valor) {
                return pos;
            }
            actual = actual.getSiguiente();
            pos++;
        }
        return -1; 
    }

    public Double buscarPorPosicion(int pos) {
        if (pos < 0 || pos >= size) return null;
        
        Nodo actual = head;
        for (int i = 0; i < pos; i++) {
            actual = actual.getSiguiente();
        }
        return actual.getDato();
    }

    public void ordenar() {
        if (head == null || head.getSiguiente() == null) return;

        boolean cambiado;
        do {
            cambiado = false;
            Nodo actual = head;
            Nodo siguiente = head.getSiguiente();

            while (siguiente != null) {
                if (actual.getDato() > siguiente.getDato()) {
                    Double temp = actual.getDato();
                    actual.setDato(siguiente.getDato());
                    siguiente.setDato(temp);
                    cambiado = true;
                }
                actual = siguiente;
                siguiente = siguiente.getSiguiente();
            }
        } while (cambiado);
    }

    public void mostrar() {
        if (head == null) {
            System.out.println("Lista vacia");
            return;
        }
        Nodo actual = head;
        System.out.print("[Head] -> ");
        while (actual != null) {
            System.out.print(actual.getDato() + " -> ");
            actual = actual.getSiguiente();
        }
        System.out.println("[Null]");
        System.out.println("Tail actual: " + tail.getDato());
        System.out.println("Tamaño: " + size);
        System.out.println("");
    }
}