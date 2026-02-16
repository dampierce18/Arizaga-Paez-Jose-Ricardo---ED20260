package S9;
import java.util.LinkedList;
import java.util.Queue;

public class ArbolDinamico {
    Nodo raiz;

    public ArbolDinamico(String valorRaiz) {
        this.raiz = new Nodo(valorRaiz);
    }

    public void recorridoAncho() {
        if (raiz == null) return;

        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);

        System.out.print("Recorrido Ancho: ");
        while (!cola.isEmpty()) {
            Nodo actual = cola.poll(); 
            System.out.print(actual.valor + " ");

            cola.addAll(actual.hijos);
        }
        System.out.println();
    }

    public void recorridoProfundidad() {
        System.out.print("Recorrido Profundidad: ");
        recorridoProfundidadRecursivo(raiz);
        System.out.println();
    }

    private void recorridoProfundidadRecursivo(Nodo nodo) {
        if (nodo == null) return;

        System.out.print(nodo.valor + " ");

        for (Nodo hijo : nodo.hijos) {
            recorridoProfundidadRecursivo(hijo);
        }
    }
}