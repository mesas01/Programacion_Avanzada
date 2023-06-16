/*
Punto 1:
No marcaron el codigo fuente (-1 punto)
No enviaron evidencias de ejecucion (-1 punto)
Nota : 1.6

- Las operaciones no reciben decimales
- El factorial no muestra la respuesta y al final pregunta por un numero


*/
package ClasesYObjetos;
import java.util.Scanner;
import java.util.InputMismatchException;

public class MainPunto1 {
    public static void main(String[] args){
        Scanner leer = new Scanner(System.in);
        int opcion = 0;

        //crear objeto de la clase operacion
        Operacion op = new Operacion();
        System.out.println("Que operacion desea realizar?");
        System.out.println("""
                1. Sumar
                2. Restar
                3. Multiplicar
                4. Dividir
                5. Factorial
                6. Potencia
                7. Salir""");

        boolean error;
        do {
            error = false;
            try {
                System.out.print("Opcion: ");
                opcion = leer.nextInt();
            }
            catch (InputMismatchException ex){
                System.out.println("Debe ingresar obligatoriamente un numero entero."+ex.toString());
                error = true;
                leer.next();
            }
        }while (error);

        switch (opcion) {
            case 1 -> {
                op.leerNumeros();
                op.sumar();
            }
            case 2 -> {
                op.leerNumeros();
                op.restar();
            }
            case 3 -> {
                op.leerNumeros();
                op.multiplicar();
            }
            case 4 -> {
                op.leerNumeros();
                op.dividir();
            }
            case 5 -> {
                op.factorial();
            }
            case 6 -> {
                System.out.println("Numero 1 = base Numero 2 = Potencia");
                op.leerNumeros();
                op.potencia();
            }
            case 7 -> {
                System.out.println("Ud. decidio salir, hasta pronto...");
                System.exit(0);
            }
            default -> {
                System.out.println("la opcion ingresada no es valida intente de nuevo...");
                System.exit(0);
            }
        }
    }
}
