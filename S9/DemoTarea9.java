package S9;

public class DemoTarea9 {
    public static void main(String[] args) {
        
        ArbolDinamico arbol = new ArbolDinamico("RAIZ");
        Nodo nodoA = new Nodo("A");
        Nodo nodoB = new Nodo("B");
        Nodo nodoC = new Nodo("C");
        
        arbol.raiz.agregarHijo(nodoA);
        arbol.raiz.agregarHijo(nodoB);
        arbol.raiz.agregarHijo(nodoC);
        
        nodoA.agregarHijo(new Nodo("D"));
        nodoA.agregarHijo(new Nodo("E"));
        nodoB.agregarHijo(new Nodo("F"));

        arbol.recorridoAncho();       
        arbol.recorridoProfundidad(); 
    }
}