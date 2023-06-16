/*
Punto 1:
No marcaron el codigo fuente (-1 punto)
No enviaron evidencias de ejecucion (-1 punto)
Nota : 1.6

- Las operaciones no reciben decimales
- El factorial no muestra la respuesta y al final pregunta por un numero


*/

package ClasesYObjetos;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;

public class Operacion {
    Scanner leer = new Scanner(System.in);

    //atributos
    int numero1, numero2;
    float suma, resta;
    float multiplicacion, division,factorial;
    double potencia;

    //metodos

    //metodo para pedir al usuario 2 digitos
    public void leerNumeros(){
        boolean error;
        do {
            error = false;
            try {
                System.out.print("Ingrese el primer numero: ");
                numero1 = leer.nextInt();
                System.out.print("\nIngrese el segundo numero: ");
                numero2 = leer.nextInt();
            }
            catch (InputMismatchException ex){
                System.out.println("Debe ingresar obligatoriamente un numero entero."+ex.toString());
                error = true;
                leer.next();
            }
        }while (error);
    }

    //metodo para sumar ambos numeros
    public void sumar(){
        suma = numero1 + numero2;
        System.out.println("la suma es: "+suma);
    }

    //metodo para restar ambos numeros
    public void restar(){
        resta = numero1 - numero2;
        System.out.println("la resta es: "+resta);
    }

    //metodo para multiplicar ambos numeros
    public void multiplicar(){
        multiplicacion = numero1 * numero2;
        System.out.println("la multiplicacion es: "+multiplicacion);
    }
    //metodo para dividir ambos numeros
    public void dividir(){
        try {
            division = (float) (numero1 / numero2);
        }
        catch (ArithmeticException ex){
            System.out.println("se esta intentando dividir por 0");
            return;
        }
        System.out.println("la division es: "+division);

    }
    //metodo para sacr factorial
    public void factorial(){
        try {
            numero1 = leer.nextInt();
        }
        catch (InputMismatchException ex){
            System.out.println("Debe ingresar obligatoriamente un numero entero."+ex.toString());
        }

        while ( numero1 != 0) {
            factorial *= numero1;
            numero1--;
        }
        System.out.print("Ingrese el numero: ");
    }
    //metodo para sacar potencia
    public void potencia(){
        potencia = Math.pow(numero1,numero2);
        System.out.println("la division es: " + potencia);
    }
}
