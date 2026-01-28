package S4;
import java.time.LocalDate;
public class ED260DEMOLISTAENLAZAsinJFC {
    public static void main(String[] args) {
        LESCircular lista=new LESCircular();
        lista.insertaInicio(new Persona("Javier",LocalDate.of(1969,5,24)));
        lista.insertaFinal(new Persona("hUgo",LocalDate.of(1969,1,1)));
        lista.insertaFinal(new Persona("Paco",LocalDate.of(1969,2,2)));
        lista.insertaFinal(new Persona("lUis",LocalDate.of(1969,3,3)));
        System.out.println(lista);
        lista.insertaXposicion(new Persona("Maria",LocalDate.of(1222,2,22)), 2);
        System.out.println(lista);
    }
}
