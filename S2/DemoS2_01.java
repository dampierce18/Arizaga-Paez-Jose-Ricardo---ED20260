// Tarea Sem02_01
package S2;

public class DemoS2_01 {
    public static void main(String[] args) {
        ListaEnlazadaTail lista = new ListaEnlazadaTail();
        
        System.out.println("1. Insertando 10.0 al inicio:");
        lista.insertaInicio(10.0);
        lista.mostrar();

        System.out.println("2. Insertando 20.0 y 30.0 al final:");
        lista.insertaFinal(20.0);
        lista.insertaFinal(30.0);
        lista.mostrar();

        System.out.println("3. Insertando 15.0 en la posicion 1 (medio):");
        lista.insertaXposicion(15.0, 1);
        lista.mostrar();

        System.out.println("4. Insertando 40.0 en la posicion final (actualiza tail):");
        lista.insertaXposicion(40.0, 4);
        lista.mostrar();
    }
}