/*
programacion avanzada
09/04/2022
Taller 2 Lab 3
Santiago Mesa
Mateo Infante
Grupo 5
No enviaron las evidencias de ejecucion
Nota : 2.0

El programa solo recibe el primer contacto, esta mal manejada la variable ultimoContacto


*/
package taller2lab3infantemesa;


import java.util.InputMismatchException;
import java.util.Scanner;


public class MainPunto2 {

   
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Persona[] agenda=new Persona[100];
        for(int i=0; i<agenda.length; i++){
            agenda[i]=new Persona();
        }
        String nombreInicial;
        nombreInicial = "fin";
        agenda[0].setNombre(nombreInicial);
        int opcion=0;
        while(opcion!=3){
            System.out.println("\nBienvenido al menu tu de agenda");
            System.out.println("\nMenu:\n" );
            System.out.println("1. Agregar contacto\n");
            System.out.println("2. Mostrar todos los contactos \n \n3. Salir\n");
            System.out.println("\nIngrese la opcion deseada: ");
            try {
                opcion = entrada.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("Por favor ingresar una opcion existente");
                break;
            }
            catch(Exception e){
                System.out.println("Por favor ingrese una opcion existente");
                break;
            }
            switch (opcion){
            case 1 ->  {
                agregarContacto(agenda);
                break;
                }
            case 2 -> {
                mostrarAgenda(agenda);
                break;
                }
            case 3 -> {
                break;
                }
            default->{
                System.out.println("Por favor ingrese una opcion ofrecida");
                }
            }
        }
            
    }
    
    public static Persona[] agregarContacto(Persona[] agenda){
        int ultimoContacto=0;
        for(int i=0; i<agenda.length; i++){
            if("fin".equals(agenda[i].getNombre())==true){
                ultimoContacto=i;
                break;
            } else if(i==99){
                return agenda;
            }
        }
        String nombreAgregar;
        String telefonoAgregar;
        String correoAgregar;
        Scanner textoAgregar = new Scanner(System.in);
        System.out.println("\nSe procedera a pedir datos del contacto a agregar");
        System.out.println("\nIngrese el nombre del contacto: ");
        try{
            nombreAgregar= textoAgregar.nextLine();
            System.out.println("\nIngrese el telefono del contacto: ");
            telefonoAgregar= textoAgregar.nextLine();
            System.out.println("\nIngrese el correo del contacto: ");
            correoAgregar= textoAgregar.nextLine();
            agenda[ultimoContacto].setNombre(nombreAgregar);
            agenda[ultimoContacto].setTelefono(telefonoAgregar);
            agenda[ultimoContacto].setCorreo(correoAgregar);
        }
        catch(Exception e){
            System.out.println("\nOcurrio un error al guadar el contacto");
            System.out.println("\nIntente guardar otra vez el contacto");
            agenda[ultimoContacto].setNombre("fin");
        }
        return agenda;
    }
    
    public static void mostrarAgenda(Persona[] agenda){
        int nroContacto=0;
        for(int i=0; i<agenda.length; i++){
            if("fin".equals(agenda[i].getNombre())==true){
                System.out.println("\nSe acabo la agenda") ;
                break;
            } else{
                nroContacto=i+1;
                System.out.println("\nContacto: "+nroContacto);
                System.out.println("\nNombre: "+agenda[i].getNombre());
                System.out.println("\nTelefono: "+agenda[i].getTelefono());
                System.out.println("\nCorreo: "+agenda[i].getCorreo());
            }
            return; 
        }
    }
}


        
   
