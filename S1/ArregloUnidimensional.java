/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demoarreglosuni01;

/**
 *
 * @author HP
 */
public class ArregloUnidimensional {
    private String[] elementos;
    private int tamano;
    private static final int CAPACIDAD_MAXIMA=10;
   /**
    * Constructor que inicializa un arreglo vacio
    */
    public ArregloUnidimensional() {
        this.elementos=new String[CAPACIDAD_MAXIMA];
        this.tamano=0;
    }
    /**
     * inserta un nombre en una posición específica
     * @param indice posición donde insertar (0<=indice<=tamano)
     * @param nombre nombre propio a insertar(ej. "Hugo", "Paco", ..)
     * @throws IndexOutOfBoundsException si el índice no es válido
     * @throws IllegalStateException si el arreglo está lleno
     */
    public void insertar(int indice, String nombre){
        if(tamano==CAPACIDAD_MAXIMA)
            throw new IllegalStateException("Arreglo Lleno");
        if(indice<0||indice>tamano)
            throw new IndexOutOfBoundsException("indice fuera de rango: "+indice);
        if(nombre==null||nombre.trim().isEmpty()) return;
        for(int i=tamano;i>indice;i--)
            elementos[i]=elementos[i-1];
        elementos[indice]=nombre.trim();
        tamano++;
    }
    /**
     * elimina un nombre en una posición específica
     * @param indice posición del elemento a eliminar (0<=indice<tamano)
     * @throws IndexOutOfBoundsException si el índice no es válido
     * @return nombre eliminado
     */
    public String eliminar(int indice){
        if(indice<0||indice>tamano)
            throw new IndexOutOfBoundsException("indice fuera de rango: "+indice);
        String nombreEliminado=elementos[indice];
        for(int i=indice;i<tamano-1;i++) elementos[i]=elementos[i+1];
        elementos[tamano-1]=null;
        tamano--;
        return nombreEliminado;
    }
    /**
     * obtiene el nombre de una posicion dada
     * @param indice posición del elemento (0<=indice<tamano)
     * @return nombre almacenado
     * @throws IndexOutOfBoundsException si el índice no es válido
     */
    public String obtener(int indice){
        if(indice<0||indice>tamano)
            throw new IndexOutOfBoundsException("indice fuera de rango: "+indice);
        return elementos[indice];
    }
    /**
     * devuelve el número actUal de elementos
     * @return tamaño lógico  (0 a 10)
     */
    public int getTamano() {
        return tamano;
    }
    /**
     * Verifica si el el arreglo está lleno
     * @return true si alcanzó la capacidad máxima (10)
     */
    public boolean estaLleno(){
        return tamano==CAPACIDAD_MAXIMA;
    }
    /**
     * imprime el estado actual del arreglo
     * muestra solo los elementos reales (hasta "tamaño")
     */
    public void imprimir(){
        if(tamano==0){
            System.out.println("[] (arreglo vacio");
            return;
        }
        System.out.print("[");
         for(int i=0;i<tamano;i++) {
             System.out.print(elementos[i]);
             if (i<tamano-1) System.out.print(", ");
         }
         System.out.println("]");
    } 
}
