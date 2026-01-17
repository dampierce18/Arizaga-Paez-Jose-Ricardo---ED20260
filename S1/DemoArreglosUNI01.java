/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package demoarreglosuni01;

/**
 *
 * @author HP
 */
public class DemoArreglosUNI01 {

    /**
     * Ejemplo de uso de arreglo unidimensional con nombres propios
     *  inserta,  elimina, valida indices y estados críticos
     */
    public static void main(String[] args) {
        ArregloUnidimensional arr=new ArregloUnidimensional();
        arr.insertar(0, "Hugo"); arr.insertar(1, "Paco");arr.insertar(1, "Luis");
        arr.insertar(2, "Ana"); arr.insertar(3, "Javier");arr.insertar(4, "Maria");
        arr.insertar(5, "Ena"); arr.insertar(6, "Martha");arr.insertar(7, "Bertha");
        arr.insertar(8, "Gaby"); //llenamos el arreglo
        System.out.println("Arreglo Lleno");
        arr.imprimir();
        //insertar UNdécimo -> excepcion
        try{
            arr.insertar(9, "Donald Trompas");
        }catch(IllegalStateException e){
            System.out.println("\n "+e.getMessage());
        }
        //Eliminar
        String eliminado=arr.eliminar(0);
        System.out.println("\nEliminado: "+eliminado);
        arr.imprimir();
        arr.eliminar(4);
        System.out.println("Despues de eliminar indice 4");
        arr.imprimir();
    }
    
}
