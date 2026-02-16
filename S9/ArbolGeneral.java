package S9;
import java.util.*;
public class ArbolGeneral {
    Nodo raiz;
    public ArbolGeneral(String valorRaiz) {
        this.raiz=new Nodo(valorRaiz);
    }
    public void insertar(Nodo nodoPadre, String valorHijo){
        Nodo hijo=new Nodo(valorHijo);
        nodoPadre.agregarHijo(hijo);
    }
    public void eliminar(Nodo nodoPadre,Nodo nodoHijo){
        nodoPadre.hijos.remove(nodoHijo);
    }
    public void recorridoAmplitud(){
        Queue<Nodo> cola=new LinkedList<>();
        cola.add(raiz);
        while(!cola.isEmpty()){
            Nodo actual=cola.poll();
            System.out.println(actual.valor);
            cola.addAll(actual.hijos);
        }
    }

    // TAREA 9_2
    public void recorridoProfundidad(){
        System.out.println("--- Inicio Recorrido Profundidad ---");
        dfsRecursivo(raiz);
        System.out.println("\n--- Fin Recorrido Profundidad ---");
    }

    private void dfsRecursivo(Nodo nodo){
        if(nodo == null) return;

        System.out.print(nodo.valor + " "); 
        
        if (nodo.hijos != null) {
            for(Nodo hijo : nodo.hijos){
                dfsRecursivo(hijo);
            }
        }
    }
}
