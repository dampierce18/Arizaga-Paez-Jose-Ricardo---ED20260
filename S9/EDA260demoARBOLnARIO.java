package S9;

public class EDA260demoARBOLnARIO {
    public static void main(String[] args) {
        ArbolGeneral arbol = new ArbolGeneral("Raiz");
        
        Nodo nivel1_1 = new Nodo("Nivel_1_1");
        Nodo nivel1_2 = new Nodo("Nivel_1_2");
        Nodo nivel1_3 = new Nodo("Nivel_1_3");
        
        arbol.raiz.agregarHijo(nivel1_1);
        arbol.raiz.agregarHijo(nivel1_2);
        arbol.raiz.agregarHijo(nivel1_3);
        
        Nodo nivel2_1 = new Nodo("Nivel_2_1");
        Nodo nivel2_2 = new Nodo("Nivel_2_2");
        Nodo nivel2_3 = new Nodo("Nivel_2_3");
        
        nivel1_1.agregarHijo(nivel2_1);
        nivel1_1.agregarHijo(nivel2_2);
        nivel1_1.agregarHijo(nivel2_3);
        
        System.out.println("--- Recorrido en Amplitud ---");
        arbol.recorridoAmplitud(); 
        System.out.println("\n--- Recorrido en Profundidad (Tarea 9_2) ---");
        arbol.recorridoProfundidad(); 
    }
}