package S4;
import java.time.LocalDate;

public class DemoS4_02 {
    public static void main(String[] args) {
        LEDCircular lista = new LEDCircular();
        
        System.out.println("PRUEBA LISTA DOBLE CIRCULAR");
        
        lista.insertaInicio(new Persona("Ana", LocalDate.now()));
        lista.insertaFinal(new Persona("Beto", LocalDate.now()));
        lista.insertaFinal(new Persona("Carla", LocalDate.now()));
        System.out.println("Inicial: " + lista);
        
        lista.insertaPorPosicion(new Persona("Xavier", LocalDate.now()), 1);
        System.out.println("Insertar pos 1: " + lista);

        lista.eliminarInicio(); 
        System.out.println("Eliminar Inicio: " + lista);
        
        lista.eliminarFinal(); 
        System.out.println("Eliminar Final: " + lista);
        
        lista.eliminarPorPosicion(1);
        System.out.println("Eliminar pos 1: " + lista);
    }
}