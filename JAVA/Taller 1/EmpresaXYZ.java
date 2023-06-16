package Taller10InfanteYMesa;

import java.util.Scanner;

public class EmpresaXYZ {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Bienvenido a la empresa XYZ");
        System.out.println("\nMenu:\n" );
        System.out.println("1. Calcular valor del interes.\n2. Salir");
        System.out.println("\nIngrese la opcion deseada: ");
        int opcion = entrada.nextInt();

        switch (opcion){
            case 1: {
                System.out.print("\nPor favor ingrese su nombre: ");
                String nombres = entrada.next();
                System.out.println("\nPor favor ingrese su apellido: ");
                String apellidos = entrada.next();
                System.out.println("\nPor favor ingrese el valor de su prestamo: ");
                float prestamo = entrada.nextFloat();
                System.out.println("\nPor favor ingrese el total de meses de su prestamo: ");
                int meses = entrada.nextInt();
                System.out.println("\nPor favor ingrese el valor del interes: ");
                float interes = entrada.nextFloat();
                Prestamos usuario = new Prestamos(prestamo, meses, interes);
                usuario.calcular(prestamo, interes, meses);
                System.out.println("El total de los interes es de" + usuario.getTotal_intereses());
                break;
            }
            case 2:
                break;
        }
    }
}