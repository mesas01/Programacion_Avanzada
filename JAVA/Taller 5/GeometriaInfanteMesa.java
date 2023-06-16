/*
programacion avanzada
04/05/2022
Taller 3 Lab 2
Santiago Mesa
Mateo Infante
Grupo 5
*/
package geometriainfantemesa;

import java.util.InputMismatchException;
import java.util.Scanner;


public class GeometriaInfanteMesa {

    public static void main(String[] args) {
        System.out.print("Bienvenido al sistema para calcular areas");
        System.out.println("\nSe calculará el area de un cuadrado");
        Scanner s = new Scanner(System.in);
        Cuadrado ejemplo = new Cuadrado();
        System.out.print("Ingrese el tamaño del lado: ");
        float ejemploLado=0;
        try {
                ejemploLado =s.nextFloat();
            }
            catch(InputMismatchException e){
                System.out.println("Por favor ingresar un valor tipo flotante");
                s.next();
            }
            catch(Exception e){
                System.out.println("Por favor ingrese un valor tipo flotante");
            }
        ejemplo.setLado(ejemploLado);
        float ejemploArea =0;
        ejemploArea = ejemplo.getArea();
        System.out.print("El area del cuadrado es igual a : "+ejemploArea);
        System.out.println("\nSe calculará el area de un circulo");
        Circulo ejemploC = new Circulo();
        System.out.print("Ingrese el tamaño del radio: ");
        float ejemploRadio=0;
        try {
                ejemploRadio =s.nextFloat();
            }
            catch(InputMismatchException e){
                System.out.println("Por favor ingresar un valor tipo flotante");
                s.next();
            }
            catch(Exception e){
                System.out.println("Por favor ingrese un valor tipo flotante");
            }
        ejemploC.setRadio(ejemploRadio);
        float ejemploAreaC =0;
        ejemploAreaC = ejemploC.getArea();
        System.out.print("El area del circulo es igual a : "+ejemploAreaC);
    }
    
}
