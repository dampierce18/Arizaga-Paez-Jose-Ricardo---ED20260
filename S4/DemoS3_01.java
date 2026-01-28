package S4;

import java.time.LocalDate;

public class DemoS3_01 {
    public static void main(String[] args) {
        LESCircular lista = new LESCircular();

        System.out.println("CARGA INICIAL");
        lista.insertaFinal(new Persona("Hugo", LocalDate.of(1990, 1, 1)));
        lista.insertaFinal(new Persona("Paco", LocalDate.of(1991, 2, 2)));
        lista.insertaFinal(new Persona("Luis", LocalDate.of(1992, 3, 3)));
        lista.insertaInicio(new Persona("Tio Rico", LocalDate.of(1950, 5, 5))); 
        System.out.println(lista);

        System.out.println("\nELIMINAR INICIO (Tio Rico)");
        lista.eliminarInicio();
        System.out.println(lista);

        System.out.println("\nELIMINAR FINAL (Luis)");
        lista.eliminarFinal();
        System.out.println(lista);

        System.out.println("\nELIMINAR POSICION 1 (Paco)");
        lista.eliminarPorPosicion(1);
        System.out.println(lista);
        
        System.out.println("\nTamaño final:" + lista.getSize());
    }
}