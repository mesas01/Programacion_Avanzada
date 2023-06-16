/*
programacion avanzada
02/04/2022
Lab sesion 11
Santiago Mesa
Mateo Infante
Grupo 5
*/

package taller11infantemesa;


import java.util.Scanner;


public class DividirPalabras  {
    
    public DividirPalabras(){
        
    }
    
    public static void division (){

        String fraseEntrada;
        Scanner leer = new Scanner(System.in);
        leer.useDelimiter("\n");
        System.out.print("Ingrese la frase deseada: ");
        fraseEntrada = leer.next();


        int tamanoPalabra = 0;
        String [] arr = fraseEntrada.split(" ");
        for (String str: arr) {

            System.out.println(str + ": "+str.length());
        }
    }
}


