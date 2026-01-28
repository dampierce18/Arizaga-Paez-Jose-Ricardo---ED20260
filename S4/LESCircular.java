package S4;
public class LESCircular {
    private Nodo head, tail;
    private int size;
    public boolean isEmpty(){
        return size==0;
    }
    public int getSize() {
        return size;
    }
    public void insertaFinal(Persona x){
        Nodo nuevo=new Nodo(x);
        if(head==null) { head=nuevo; tail=nuevo; }
        else{
            nuevo.next=head;
            tail.next=nuevo;
            tail=nuevo;
        }
        size++;
    }
    public void insertaInicio(Persona x){
        Nodo nuevo=new Nodo(x);
        if(head==null) { head=nuevo; tail=nuevo; }
        else {
            nuevo.next=head; 
            head=nuevo;
        }
        size++;
    }
    private void validarIndiceInsercion(int indice){
         if(indice<0||indice>this.getSize()) 
             throw new IndexOutOfBoundsException("indice"
                     + " insercion INValIDO "+indice);
    }
    //retornar el nodo anterior a un indice dato
    private Nodo nodoAnterior(int index){
        Nodo actual=head;
        for(int i=0;i<index-1;i++) actual=actual.next;
        return actual;
    }

    //posiciones validas: 0..size
    public boolean insertaXposicion(Persona x, int indice){
        validarIndiceInsercion(indice);
        if(indice==0) {insertaInicio(x);  return true;  }
        if(indice==size) {insertaFinal(x);  return true;  }
        Nodo nuevo=new Nodo(x);
        Nodo anterior=nodoAnterior( indice);
        nuevo.next=anterior.next;
        anterior.next=nuevo;
        size++;
        return true;
    }

    // TAREA S3_1: MÉTODOS DE ELIMINACIÓN

    public void eliminarInicio() {
        if (isEmpty()) return;

        if (head == tail) { 
            head = null;
            tail = null;
        } else {
            head = head.next; 
            tail.next = head; 
        }
        size--;
    }

    public void eliminarFinal() {
        if (isEmpty()) return;

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Nodo actual = head;
            while (actual.next != tail) {
                actual = actual.next;
            }
            tail = actual;
            tail.next = head; 
        }
        size--;
    }

    public void eliminarPorPosicion(int indice) {
        if (indice < 0 || indice >= size) 
            throw new IndexOutOfBoundsException("Indice fuera de rango para eliminar");

        if (indice == 0) {
            eliminarInicio();
        } else if (indice == size - 1) {
            eliminarFinal();
        } else {
            Nodo anterior = nodoAnterior(indice);
            Nodo aEliminar = anterior.next;
            anterior.next = aEliminar.next; 
            size--;
        }
    }

    @Override
    public String toString() {
        if(this.isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder();
        Nodo actual=head;
        for(int i=0;i<this.getSize();i++){
            sb.append(actual.dato.toString());
            if(i<this.getSize()-1) sb.append("\n->");
            actual=actual.next;
        }
        sb.append("");
        return sb.toString();
    }
}
