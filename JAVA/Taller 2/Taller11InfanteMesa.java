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


public class Taller11InfanteMesa {

    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Bienvenido a edicion de cadenas");
        System.out.println("\nMenu:\n" );
        System.out.println("1. Busqueda de subcadenas dentro de cadenas.\n");
        System.out.println("2. División de cadena por palabras \n \n3. Salir\n");
        System.out.println("\nIngrese la opcion deseada: ");
        int opcion = entrada.nextInt();

        switch (opcion){
            case 1 ->  {
                String cadena;
                String subcadena;
                entrada.useDelimiter("\n");
                System.out.println("\nIngrese la cadena principal: \n");
                cadena = entrada.next();
                System.out.println("\nIngrese la subcadena a buscar: \n");
                subcadena = entrada.next();
                BusquedaPatron patronInteres = new BusquedaPatron();
                int contadorFinal=patronInteres.contarSubcadenas(cadena, subcadena);
                System.out.println("\nCadena : "+cadena);
                System.out.println("\nPalabra : "+subcadena);
                System.out.println("\nTotal de : "+contadorFinal+" veces encontrada" );
                break;
            }

            case 2 -> {
                DividirPalabras.division();
                break;
            }
            case 3 -> {
                break;
            }
        }
    }
}

