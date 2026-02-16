package S9;
import java.util.ArrayList; 

public class Nodo {
    String valor;
    ArrayList<Nodo> hijos; 

    public Nodo(String valor) {
        this.valor = valor;
        this.hijos = new ArrayList<>(); 
    }

    public void agregarHijo(Nodo hijo) {
        this.hijos.add(hijo);
    }
}