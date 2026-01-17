/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package demoarreglobi01;

/**
 *
 * @author HP
 */
public class DemoArregloBI01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[][] matriz= {
            {"Hugo","Paco","Luis","Jesus","Maria"},
            {"Jose","Martha","Ena","Bertha","Lula"},
            {"Putin","Ana","Luisa","Jesusa","Mario"},
            {"Xi","Fi","Fu","Li","Ju"},
            {"Rena","Paca","Leo","Javier","Bruno"}
        };
        imprimir(matriz);
        System.out.println("\nCONTORNO");
        int n=matriz.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==0||i==n-1||j==0||j==n-1) System.out.print(matriz[i][j]+"\t");
                else System.out.print("   \t");
            }
            System.out.println();
        }
    }
    public static void imprimir(String[][] m){
        for(String[] fila: m){
            for(String nombre: fila){
                System.out.print(nombre+"\t");
            }
            System.out.println();
        }
    }
    
}
