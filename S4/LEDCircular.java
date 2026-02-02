package S4;

public class LEDCircular {
    private NodoDoble head;
    private NodoDoble tail;
    private int size;

    public LEDCircular() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() { return size == 0; }
    public int getSize() { return size; }

    public void insertaInicio(Persona p) {
        NodoDoble nuevo = new NodoDoble(p);
        if (isEmpty()) {
            head = tail = nuevo;
            head.next = head;
            head.prev = head; 
        } else {
            nuevo.next = head;
            nuevo.prev = tail;
            head.prev = nuevo;
            tail.next = nuevo;
            head = nuevo; 
        }
        size++;
    }

    public void insertaFinal(Persona p) {
        NodoDoble nuevo = new NodoDoble(p);
        if (isEmpty()) {
            head = tail = nuevo;
            head.next = head;
            head.prev = head;
        } else {
            nuevo.next = head;
            nuevo.prev = tail;
            tail.next = nuevo; 
            head.prev = nuevo; 
            tail = nuevo;      
        }
        size++;
    }

    public void insertaPorPosicion(Persona p, int indice) {
        if (indice < 0 || indice > size) throw new IndexOutOfBoundsException("Indice invalido");
        
        if (indice == 0) { insertaInicio(p); return; }
        if (indice == size) { insertaFinal(p); return; }

        NodoDoble nuevo = new NodoDoble(p);
        NodoDoble actual = head;
        for (int i = 0; i < indice; i++) {
            actual = actual.next;
        }
        NodoDoble anterior = actual.prev;

        nuevo.next = actual;
        nuevo.prev = anterior;
        
        anterior.next = nuevo;
        actual.prev = nuevo;
        
        size++;
    }

    public void eliminarInicio() {
        if (isEmpty()) return;

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next; 
            head.prev = tail; 
            tail.next = head; 
        }
        size--;
    }

    public void eliminarFinal() {
        if (isEmpty()) return;

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev; 
            tail.next = head; 
            head.prev = tail; 
        }
        size--;
    }

    public void eliminarPorPosicion(int indice) {
        if (indice < 0 || indice >= size) throw new IndexOutOfBoundsException("Indice invalido");

        if (indice == 0) { eliminarInicio(); return; }
        if (indice == size - 1) { eliminarFinal(); return; }

        NodoDoble eliminar = head;
        for (int i = 0; i < indice; i++) {
            eliminar = eliminar.next;
        }
        
        NodoDoble anterior = eliminar.prev;
        NodoDoble siguiente = eliminar.next;

        anterior.next = siguiente;
        siguiente.prev = anterior;
        
        size--;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder();
        NodoDoble actual = head;
        sb.append("[H] ");
        for (int i = 0; i < size; i++) {
            sb.append(actual.dato.getNombre());
            if (i < size - 1) sb.append(" <-> ");
            actual = actual.next;
        }
        sb.append(" [T]");
        sb.append(" (T.next=" + tail.next.dato.getNombre() + ")");
        return sb.toString();
    }
}