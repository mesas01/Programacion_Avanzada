/*
programacion avanzada
11/05/2022
Taller 3 Lab 3
Santiago Mesa
Mateo Infante
Grupo 5
*/
package taller3lab3infantemesa;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Taller3Lab3InfanteMesa {


    public static void main(String[] args) {
        System.out.print("Bienvenido al menú de creación de edificios");
        System.out.println("\nSe procedera a crear arreglo de Polideportivos");
        Scanner s = new Scanner (System.in);
        String nombreAux = null;
        int tipoAux = 0;
        int superficieAux = 0;
        System.out.print("\nIngrese el nombre del polideportivo: ");
        try{
                nombreAux = s.nextLine();
            }
            catch(InputMismatchException e){
                System.out.println("Por favor ingresar un entero");
                s.next();
            }
            catch(Exception e){
                System.out.println("Por favor ingrese un entero");
            }
        System.out.print("\nIngrese el tipo de instalacion: ");
        try{
                tipoAux = s.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("Por favor ingresar un entero");
                s.next();
            }
            catch(Exception e){
                System.out.println("Por favor ingrese un entero");
            }
        System.out.print("\nIngrese la superficie: ");
        try{
                superficieAux = s.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("Por favor ingresar un entero");
                s.next();
            }
            catch(Exception e){
                System.out.println("Por favor ingrese un entero");
            }
        System.out.println("\n");
        Polideportivo instalacionAux = new Polideportivo(nombreAux, tipoAux, superficieAux);
        ArrayList <Polideportivo> listaPolideportivos = new ArrayList<Polideportivo>();
        listaPolideportivos.add(instalacionAux);
        Polideportivo instalacionAux1 = new Polideportivo();
        nombreAux = "Coliseo";
        tipoAux = 4;
        superficieAux = 250;
        instalacionAux1.setNombre(nombreAux);
        instalacionAux1.setSuperficie(superficieAux);
        instalacionAux1.setTipoDeInstalacion(tipoAux);
        listaPolideportivos.add(instalacionAux1);
        Polideportivo instalacionAux2 = new Polideportivo();
        nombreAux = "Estadio";
        tipoAux = 7;
        superficieAux = 1200;
        instalacionAux2.setNombre(nombreAux);
        instalacionAux2.setSuperficie(superficieAux);
        instalacionAux2.setTipoDeInstalacion(tipoAux);
        listaPolideportivos.add(instalacionAux2);
        System.out.println("\nLista de Polideportivos\n");
        int f=1;
        for(Polideportivo p1:listaPolideportivos){
            System.out.println("\nPolideportivo #"+f);
            p1.toString();
            f++;
            
        }
        System.out.println("\nSe procedera a crear arreglo de Oficinas");
        int numOficinasAux = 0;
        System.out.print("\nIngrese el numero de oficinas: ");
        try{
            numOficinasAux = s.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("Por favor ingresar un entero");
                s.next();
            }
            catch(Exception e){
                System.out.println("Por favor ingrese un entero");
            }
        System.out.print("\nIngrese la superficie: ");
        try{
            superficieAux = s.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("Por favor ingresar un entero");
                s.next();
            }
            catch(Exception e){
                System.out.println("Por favor ingrese un entero");
            }
        System.out.println("\n");
        EdificioDeOficinas oficinaAux = new EdificioDeOficinas(numOficinasAux, superficieAux);
        ArrayList <EdificioDeOficinas> listaEdificios = new ArrayList<EdificioDeOficinas>();
        listaEdificios.add(oficinaAux);
        EdificioDeOficinas oficinaAux1 = new EdificioDeOficinas();
        numOficinasAux = 400;
        superficieAux = 1500;
        oficinaAux1.setNumOficinas(numOficinasAux);
        oficinaAux1.setSuperficie(superficieAux);
        listaEdificios.add(oficinaAux1);
        EdificioDeOficinas oficinaAux2 = new EdificioDeOficinas();
        numOficinasAux = 700;
        superficieAux = 2400;
        oficinaAux2.setNumOficinas(numOficinasAux);
        oficinaAux2.setSuperficie(superficieAux);
        listaEdificios.add(oficinaAux2);
        System.out.println("\nLista de Edificios de oficinas\n");
        int k=1;
        for(EdificioDeOficinas ed:listaEdificios){
            System.out.println("\nEdificio #"+k);
            ed.toString();
            k++;
        }

            
    }
}
    

