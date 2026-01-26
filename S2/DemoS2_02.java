// Tarea Sem02_02
package S2;

public class DemoS2_02 {
    public static void main(String[] args) {
        ListaEnlazadaTail lista = new ListaEnlazadaTail();

        System.out.println("LISTA INICIAL");
        lista.insertaFinal(50.0);
        lista.insertaFinal(10.0);
        lista.insertaFinal(40.0);
        lista.insertaFinal(20.0);
        lista.insertaFinal(30.0);
        lista.mostrar();

        System.out.println("\nPRUEBAS DE ELIMINACION ");
        System.out.println("Eliminando inicio (50.0)...");
        lista.eliminarInicio();
        
        System.out.println("Eliminando final (30.0)...");
        lista.eliminarFinal();
        
        System.out.println("Eliminando posicion 1 (40.0)...");
        lista.eliminarXposicion(1); 
        lista.mostrar();

        System.out.println("\nPRUEBAS DE BUSQUEDA ");
        Double valorBuscado = 20.0;
        int pos = lista.buscarPorValor(valorBuscado);
        System.out.println("Buscando valor " + valorBuscado + ": " + (pos != -1 ? "Encontrado en pos " + pos : "No existe"));

        int posBusqueda = 0;
        System.out.println("Buscando en posicion " + posBusqueda + ": " + lista.buscarPorPosicion(posBusqueda));

        System.out.println("\nPRUEBA DE ORDENAMIENTO ");
        lista.insertaInicio(99.0);
        lista.insertaFinal(5.0);
        System.out.print("Antes de ordenar: ");
        lista.mostrar();

        lista.ordenar();
        System.out.print("Despues de ordenar: ");
        lista.mostrar();
    }
}