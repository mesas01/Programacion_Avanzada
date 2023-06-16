package Proyecto2InfanteMesa;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Proyecto2InfanteMesa {
    private static ArrayList <Aeronave> aviones;
    private static ArrayList <Vuelo> vuelos;

    public static void main(String[] args) {
        aviones = new ArrayList<>();
        vuelos = new ArrayList<>();
        cargarAviones();
        cargarVuelos();
        cargarTiquetes();
        Scanner entrada = new Scanner(System.in);
        int opcion=0;
        while(opcion!=7){
            System.out.println("\nBienvenido al menu de la Aerolinea XYZ");
            System.out.println("\nMenu:\n" );
            System.out.println("1. Registrar aeronave\n");
            System.out.println("2. Registrar programacion de viajes\n ");
            System.out.println("3. Registrar Tiquete\n");
            System.out.println("4. Mostrar Programacion\n");
            System.out.println("5. Eliminar Tiquete\n");
            System.out.println("6. Eliminar Vuelo\n");
            System.out.println("7. Salir\n");
            System.out.print("\nIngrese la opcion deseada: ");
            try {
                opcion = entrada.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("Por favor ingresar una opcion existente");
                entrada.next();
            }
            catch(Exception e){
                System.out.println("Por favor ingrese una opcion existente");
                break;
            }
            switch (opcion){
                case 1 ->  {
                    Aeronave avionNuevo = new Aeronave();
                    pedirNuevoAvion(avionNuevo);
                    agregarAvion(avionNuevo);
                    guardarInfoAviones();
                }
                case 2 -> {
                    if (registrarProgramacion()){
                        System.out.println("El registro de programacion se realizo correctamente");
                    }else {
                        System.out.println("No se pudo registrar la programacion del vuelo, intente nuevamente...");
                    }
                    guardarInfoVuelos();
                }
                case 3 -> {
                    if (registrarTiquete()){
                        System.out.println("\nEl registro de los tiquetes se realizo correctamente");
                    }else{
                        System.out.println("\nNo se pudieron registrar los tiquetes, intente nuevamente...");
                    }
                    guardarInfoTiquetes();
                }
                case 4 -> {
                    if (mostrarProgramacion()){
                        System.out.println("\nEl registro de los tiquetes se realizo correctamente");
                    }else{
                        System.out.println("\nNo se pudieron registrar los tiquetes, intente nuevamente...");
                    }
                }
                case 5 -> {
                    elimiarTiquete();
                    guardarInfoTiquetes();
                }
                case 6 -> {
                    elimiarVuelo();
                    guardarInfoVuelos();
                }
                case 7 -> System.out.println("Ud decidió Salir, vuelva pronto...");
                default-> System.out.println("Por favor ingrese una opcion ofrecida");
            }
        }
    }

    /*pasar funcion a binario*/
    public static void cargarAviones(){
        /* Aqui se buscara el archivo donde estan los aviones y se genera un arreglo con todos los datos*/
        Path path = Paths.get("");
        String directorio = path.toAbsolutePath().toString();
        File carpeta = new File(directorio+File.separator+"datosProyecto");
        File archivoAviones = new File(carpeta+File.separator, "aviones.bin");
        if (!carpeta.exists()) {
            if (carpeta.mkdirs()) {
                System.out.println("Se creo carpeta para guardar archivos");
            } else {
                System.out.println("Error al crear carpeta " + carpeta);
            }
        }else{
            System.out.println("Carpeta para guardar archivos ya existe: "+carpeta);
        }
        if(!archivoAviones.exists()){
            try {
                archivoAviones.createNewFile();
            }
            catch(IOException e){
                System.out.println("No se logro crear el archivo");
            }
        }
        Aeronave a= null;
        try{

            //FileInputStream  archivo1 = new FileInputStream(carpeta.getAbsolutePath()+File.separator+"algo.bin");

            FileInputStream  archivo = new FileInputStream(carpeta.getAbsolutePath()+File.separator+"aviones.bin");


            ObjectInputStream obj1=new ObjectInputStream(archivo);
            try{
                a=(Aeronave)obj1.readObject();
            }
            catch (EOFException e){
                a=null;
            }
            while (a!=null){
                aviones.add(a);

                try{
                    a=(Aeronave)obj1.readObject();
                }
                catch (EOFException e){
                    a=null;
                }
            }
            obj1.close();
            archivo.close();
        } catch (FileNotFoundException e) {
            System.out.println("¡El archivo no existe!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        /*FileInputStream  archivo = null;
        try {
            archivo = new FileInputStream(carpeta.getAbsolutePath()+File.separator+"aviones.bin");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Proyecto2InfanteMesa.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObjectInputStream obj1 = null;
        try{
            obj1= new ObjectInputStream(archivo);
        } catch(Exception e){
            System.out.println("Error de archivo 1 ");
            e.printStackTrace();
        }
        Aeronave a = new Aeronave();
        try{
            a=(Aeronave)obj1.readObject();
        } catch(Exception e){
            System.out.println("Error de archivo 2");
            e.printStackTrace();
        }
        while(a!=null){
            aviones.add(a);
            try{
                a=(Aeronave)obj1.readObject();
            } catch (EOFException e){
                a = null;
            } catch (Exception e){
                System.out.println("Error de archivo 3");
                e.printStackTrace();
                break;
            }
            try{
            obj1.close();
            archivo.close();
            } catch(Exception e){
                System.out.println("Error de archivo 3.1");
        }*/



        /*Path path = Paths.get("");
        String directorio = path.toAbsolutePath().toString();
        File carpeta = new File(directorio+File.separator+"datosProyecto");
        File archivoAviones = new File(carpeta, "aviones.txt");
        if (!carpeta.exists()) {
            if (carpeta.mkdirs()) {
                System.out.println("Se creo carpeta para guardar archivos");
            } else {
                System.out.println("Error al crear carpeta " + carpeta);
            }
        }else{
            System.out.println("Carpeta para guardar archivos ya existe: "+carpeta);
        }

        if(!archivoAviones.exists()){
            try {
                archivoAviones.createNewFile();
            }
            catch(IOException e){
                System.out.println("No se logro crear el archivo");
            }
        }
        try{
            FileReader freader = new FileReader(carpeta.getAbsolutePath()+File.separator+"aviones.txt");
            BufferedReader br = new BufferedReader(freader);
            String s;
            String[] atributos;
            while((s = br.readLine()) != null) {
                atributos = s.split(",");
                int codigoAux;
                codigoAux = Integer.parseInt(atributos[0]);
                String marcaAux;
                marcaAux = atributos[1];
                Aeronave avion = new Aeronave(codigoAux, marcaAux);
                aviones.add(avion);
            }
            br.close();
            freader.close();
        }
        catch(FileNotFoundException ex){
            System.out.println("Error de archivo");
        } catch (IOException ex) {
            Logger.getLogger(Proyecto2InfanteMesa.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    public static void pedirNuevoAvion(Aeronave avionNuevo){
        boolean agregar = false;
        boolean existe = false;
        while(!agregar){
            String marcaAux;
            int codigoAux=0;
            Scanner info = new Scanner(System.in);
            System.out.println("\nA continuacion ingresara informacion del nuevo aeronave\n\n");
            System.out.print("Ingrese la marca del avion: ");
            marcaAux = info.nextLine();
            avionNuevo.setMarca(marcaAux);
            System.out.print("\nIngrese el codigo del avion: ");
            try{
                codigoAux = info.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("Por favor ingresar una opcion existente");
                info.next();
            }
            catch(Exception e){
                System.out.println("Por favor ingrese una opcion existente");
                break;
            }
            for(Aeronave avion:aviones){
                if (codigoAux == avion.getCodigoAV()) {
                    existe = true;
                    break;
                }
            }
            if(!existe){
                avionNuevo.setCodigoAV(codigoAux);
                agregar=true;
            } else {
                System.out.println("\nPor favor Ingrese un codigo de avion nuevo y no usado\n");
            }
        }
    }



    public static void agregarAvion(Aeronave avionNuevo){
        System.out.println("\nSe procedera a guardar los datos del nuevo avion\n");
        aviones.add(avionNuevo);
    }

    public static void guardarInfoAviones(){
        Path path = Paths.get("");
        String directorio = path.toAbsolutePath().toString();
        File carpeta = new File(directorio+File.separator+"datosProyecto");
        File archivoAviones = new File(carpeta, "aviones.bin");
        if(!archivoAviones.delete()){
            System.out.println(" No se pudo borrar el archivo");
        }
        FileOutputStream fos;
        ObjectOutputStream escribir;

        try {
            fos = new FileOutputStream(archivoAviones);
            escribir = new ObjectOutputStream(fos);
            for(Aeronave avion:aviones){
                escribir.writeObject(avion);
            }
            escribir.close();
            fos.close();
        } catch (Exception e) {
            System.out.println("Error de archivo, no se pudo guardar en el archivo");
        }

    }

    /*Pasar función a binario*/
    public static void cargarVuelos(){
        /* Aqui se buscara el archivo donde estan los aviones y se genera un arreglo con todos los datos*/
        Path path = Paths.get("");
        String directorio = path.toAbsolutePath().toString();
        File carpeta = new File(directorio+File.separator+"datosProyecto");
        File archivoAviones = new File(carpeta+File.separator, "vuelos.bin");
        if (!carpeta.exists()) {
            if (carpeta.mkdirs()) {
                System.out.println("Se creo carpeta para guardar archivos");
            } else {
                System.out.println("Error al crear carpeta " + carpeta);
            }
        }else{
            System.out.println("Carpeta para guardar archivos ya existe: "+carpeta);
        }
        if(!archivoAviones.exists()){
            try {
                archivoAviones.createNewFile();
            }
            catch(IOException e){
                System.out.println("No se logro crear el archivo");
            }
        }
        Vuelo v= null;
        try{

            //FileInputStream  archivo1 = new FileInputStream(carpeta.getAbsolutePath()+File.separator+"algo.bin");

            FileInputStream  archivo = new FileInputStream(carpeta.getAbsolutePath()+File.separator+"vuelos.bin");


            ObjectInputStream obj1=new ObjectInputStream(archivo);
            try{
                v=(Vuelo)obj1.readObject();
            }
            catch (EOFException e){
                v=null;
            }
            while (v!=null){
                vuelos.add(v);

                try{
                    v=(Vuelo)obj1.readObject();
                }
                catch (EOFException e){
                    v=null;
                }
            }
            obj1.close();
            archivo.close();
        } catch (FileNotFoundException e) {
            System.out.println("¡El archivo no existe!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        /*Path path = Paths.get("");
        String directorio = path.toAbsolutePath().toString();
        File carpeta = new File(directorio+File.separator+"datosProyecto");
        File archivoVuelos = new File(carpeta, "vuelos.dat");
        if (!carpeta.exists()) {
            if (carpeta.mkdirs()) {
                System.out.println("Se creo carpeta para guardar archivos");
            } else {
                System.out.println("Error al crear carpeta " + carpeta);
            }
        }else{
            System.out.println("Carpeta para guardar archivos ya existe: "+carpeta);
        }

        if(!archivoVuelos.exists()){
            try {
                archivoVuelos.createNewFile();
            }
            catch(IOException e){
                System.out.println("No se logro crear el archivo");
            }
        }
        FileInputStream  archivo = null;
        try {
            archivo = new FileInputStream(carpeta.getAbsolutePath()+File.separator+"vuelos.dat");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Proyecto2InfanteMesa.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObjectInputStream obj1 = null;
        try{
            obj1= new ObjectInputStream(archivo);
        } catch(Exception e){
            System.out.println("Error de archivo 4");
        }
        Vuelo a = new Vuelo();
        try{
            a=(Vuelo)obj1.readObject();
        } catch(Exception e){
            System.out.println("Error de archivo 5");
        }
        while(a!=null){
            vuelos.add(a);
            try{
                a=(Vuelo)obj1.readObject();
            } catch (EOFException e){
                a = null;
            } catch (Exception e){
                System.out.println("Error de archivo 6");
                break;
            }
        }*/


        /*Path path = Paths.get("");
        String directorio = path.toAbsolutePath().toString();
        File carpeta = new File(directorio+File.separator+"datosProyecto");
        File archivoVuelos = new File(carpeta, "vuelos.txt");
        if (!carpeta.exists()) {
            if (carpeta.mkdirs()) {
                System.out.println("Se creo carpeta para guardar archivos");
            } else {
                System.out.println("Error al crear carpeta " + carpeta);
            }
        }else{
            System.out.println("Carpeta para guardar archivos ya existe: "+carpeta);
        }

        if(!archivoVuelos.exists()){
            try {
                archivoVuelos.createNewFile();
            }
            catch(IOException e){
                System.out.println("No se logro crear el archivo");
            }
        }
        try{
            FileReader freader = new FileReader(carpeta.getAbsolutePath()+File.separator+"vuelos.txt");
            BufferedReader br = new BufferedReader(freader);
            String s;
            String[] atributos;
            while((s = br.readLine()) != null) {
                atributos = s.split(",");
                int codigoViajeAux;
                codigoViajeAux = Integer.parseInt(atributos[0]);
                int codigoAvionAux;
                codigoAvionAux = Integer.parseInt(atributos[1]);
                String fechaAux;
                fechaAux = atributos[2];
                String origenAux;
                origenAux = atributos[3];
                String destinoAux;
                destinoAux = atributos[4];
                float valorAux;
                valorAux = Float.parseFloat(atributos[5]);
                Vuelo vueloAux = new Vuelo(codigoViajeAux, codigoAvionAux, fechaAux, origenAux, destinoAux, valorAux);
                vuelos.add(vueloAux);
            }
            br.close();
            freader.close();
        }
        catch(FileNotFoundException ex){
            System.out.println("Error de archivo");
        } catch (IOException ex) {
            Logger.getLogger(Proyecto2InfanteMesa.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    public static void guardarInfoVuelos(){
        Path path = Paths.get("");
        String directorio = path.toAbsolutePath().toString();
        File carpeta = new File(directorio+File.separator+"datosProyecto");
        File archivoVuelos = new File(carpeta, "vuelos.bin");
        if(archivoVuelos.delete()){
            System.out.println("El archivo fue eliminado");
        } else {
            System.out.println(" No se pudo borrar el archivo");
        }
        FileOutputStream fos;
        ObjectOutputStream escribir;

        try {
            fos = new FileOutputStream(archivoVuelos);
            escribir = new ObjectOutputStream(fos);
            for(Vuelo v:vuelos){
                escribir.writeObject(v);
            }
            escribir.close();
            fos.close();
        } catch (Exception e) {
            System.out.println("Error de archivo, no se pudo guardar en el archivo");
        }
    }
    /*pasar función binario*/
    public static void cargarTiquetes(){
        /* Aqui se buscara el archivo donde estan los aviones y se genera un arreglo con todos los datos*/

        Path path = Paths.get("");
        String directorio = path.toAbsolutePath().toString();
        File carpeta = new File(directorio+File.separator+"datosProyecto");
        File archivoAviones = new File(carpeta+File.separator, "tiquetes.bin");
        if (!carpeta.exists()) {
            if (carpeta.mkdirs()) {
                System.out.println("Se creo carpeta para guardar archivos");
            } else {
                System.out.println("Error al crear carpeta " + carpeta);
            }
        }else{
            System.out.println("Carpeta para guardar archivos ya existe: "+carpeta);
        }
        if(!archivoAviones.exists()){
            try {
                archivoAviones.createNewFile();
            }
            catch(IOException e){
                System.out.println("No se logro crear el archivo");
            }
        }
        Tiquete t= null;
        try{

            //FileInputStream  archivo1 = new FileInputStream(carpeta.getAbsolutePath()+File.separator+"algo.bin");

            FileInputStream  archivo = new FileInputStream(carpeta.getAbsolutePath()+File.separator+"tiquetes.bin");


            ObjectInputStream obj1=new ObjectInputStream(archivo);
            try{
                t=(Tiquete)obj1.readObject();
            }
            catch (EOFException e){
                t=null;
            }
            while (t!=null){
                for(Vuelo v:vuelos){
                    if(v.getCodigoViaje()== t.getCodigoVuelo()){
                        v.pasajeros.add(t);
                    }

                    try{
                        t=(Tiquete)obj1.readObject();
                    }
                    catch (EOFException e){
                        t=null;
                    }
                }
            }
            obj1.close();
            archivo.close();
        } catch (FileNotFoundException e) {
            System.out.println("¡El archivo no existe!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        /*Path path = Paths.get("");
        String directorio = path.toAbsolutePath().toString();
        File carpeta = new File(directorio+File.separator+"datosProyecto");
        File archivoTiquetes = new File(carpeta, "tiquetes.bin");
        if (!carpeta.exists()) {
            if (carpeta.mkdirs()) {
                System.out.println("Se creo carpeta para guardar archivos");
            } else {
                System.out.println("Error al crear carpeta " + carpeta);
            }
        }else{
            System.out.println("Carpeta para guardar archivos ya existe: "+carpeta);
        }

        if(!archivoTiquetes.exists()){
            try {
                archivoTiquetes.createNewFile();
            }
            catch(IOException e){
                System.out.println("No se logro crear el archivo");
            }
        }
        FileInputStream  archivo = null;
        try {
            archivo = new FileInputStream(carpeta.getAbsolutePath()+File.separator+"tiquetes.bin");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Proyecto2InfanteMesa.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObjectInputStream obj1 = null;
        try{
            obj1= new ObjectInputStream(archivo);
        } catch(Exception e){
            System.out.println("Error de archivo 7");
        }
        Tiquete t = new Tiquete();
        try{
            t=(Tiquete)obj1.readObject();
        } catch(Exception e){
            System.out.println("Error de archivo 8");
        }
        while(t!=null){
            for(Vuelo v:vuelos){
                if(v.getCodigoViaje()== t.getCodigoVuelo()){
                    v.pasajeros.add(t);
                }
            }
            try{
                t=(Tiquete)obj1.readObject();
            } catch (EOFException e){
                t = null;
            } catch (Exception e){
                System.out.println("Error de archivo 9");
                break;
            }
        }*/


        /*Path path = Paths.get("");
        String directorio = path.toAbsolutePath().toString();
        File carpeta = new File(directorio+File.separator+"datosProyecto");
        File archivoTiquetes = new File(carpeta, "tiquetes.txt");
        if (!carpeta.exists()) {
            if (carpeta.mkdirs()) {
                System.out.println("Se creo carpeta para guardar archivos");
            } else {
                System.out.println("Error al crear carpeta " + carpeta);
            }
        }else{
            System.out.println("Carpeta para guardar archivos ya existe: "+carpeta);
        }

        if(!archivoTiquetes.exists()){
            try {
                archivoTiquetes.createNewFile();
            }
            catch(IOException e){
                System.out.println("No se logro crear el archivo");
            }
        }
        try{
            FileReader freader = new FileReader(carpeta.getAbsolutePath()+File.separator+"tiquetes.txt");
            BufferedReader br = new BufferedReader(freader);
            String s;
            String[] atributos;
            while((s = br.readLine()) != null) {
                atributos = s.split(",");
                int codigoVueloAux;
                codigoVueloAux = Integer.parseInt(atributos[0]);
                int numeroTiqueteAux;
                numeroTiqueteAux = Integer.parseInt(atributos[1]);
                String nombreAux;
                nombreAux = atributos[2];
                String apellidoAux;
                apellidoAux = atributos[3];
                int idAux;
                idAux = Integer.parseInt(atributos[4]);
                Tiquete tiqueteAux = new Tiquete(numeroTiqueteAux,nombreAux,apellidoAux,idAux);
                for(Vuelo vAux:vuelos){
                    if(codigoVueloAux==vAux.getCodigoViaje()){
                        vAux.pasajeros.add(tiqueteAux);
                    }
                }
            }
            br.close();
            freader.close();
        }
        catch(FileNotFoundException ex){
            System.out.println("Error de archivo");
        } catch (IOException ex) {
            Logger.getLogger(Proyecto2InfanteMesa.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    public static void guardarInfoTiquetes(){
        Path path = Paths.get("");
        String directorio = path.toAbsolutePath().toString();
        File carpeta = new File(directorio+File.separator+"datosProyecto");
        File archivoTiquetes = new File(carpeta, "tiquetes.bin");
        if(archivoTiquetes.delete()){
            System.out.println("El archivo fue eliminado");
        } else {
            System.out.println(" No se pudo borrar el archivo");
        }

        if(!archivoTiquetes.exists()){
            try {
                archivoTiquetes.createNewFile();
            }
            catch(IOException e){
                System.out.println("No se logro crear el archivo");
            }
        }
        FileOutputStream fos;
        ObjectOutputStream escribir;

        try {
            fos = new FileOutputStream(archivoTiquetes);
            escribir = new ObjectOutputStream(fos);
            for(Vuelo v:vuelos){
                for(Tiquete tiquet:v.pasajeros){
                    escribir.writeObject(tiquet);
                }
            }
            escribir.close();
            fos.close();
        } catch (Exception e) {
            System.out.println("Error de archivo, no se pudo guardar en el archivo");
        }
    }

    public static boolean registrarProgramacion(){
        Scanner entrada = new Scanner(System.in);
        int codigoAeronaveAux=0, consecutivoAux ;
        int codigoViaje;
        if(vuelos.size()!=0) {
            consecutivoAux = vuelos.get(vuelos.size()-1).getCodigoViaje();
            codigoViaje = consecutivoAux;
        } else {
            codigoViaje = 0;
        }
        String fechaAux,origenVueloAux,destinoVueloAux;
        float valorTiqueteAux=0;
        System.out.print("Ingrese el codigo de la aeronave: ");
        try{
            codigoAeronaveAux = entrada.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("Por favor ingresar una opcion existente");
            entrada.next();
        }
        catch(Exception e){
            System.out.println("Por favor ingrese una opcion existente");
        }

        if (verificarCAeronave(codigoAeronaveAux)){
            System.out.println("El codigo existe...");
        }else {
            System.out.println("El codigo no existe, intente de nuevo...");
            return false;
        }
        entrada.nextLine();
        System.out.print("\nIngrese Fecha del vuelo (Ej: 18/04/2069): ");
        fechaAux = entrada.nextLine();
        System.out.print("\nIngrese el origen del vuelo: ");
        origenVueloAux = entrada.nextLine();
        System.out.print("\nIngrese el destino del vuelo: ");
        destinoVueloAux = entrada.nextLine();
        System.out.print("\nIngrese el valor de cada tiquete: ");
        try{
            valorTiqueteAux = entrada.nextFloat();
        }
        catch(InputMismatchException e){
            System.out.println("Por favor ingresar una opcion existente");
            entrada.next();
        }
        catch(Exception e){
            System.out.println("Por favor ingrese una opcion existente");
        }
        codigoViaje += 1;

        Vuelo vuelito = new Vuelo(codigoViaje, codigoAeronaveAux,
                fechaAux, origenVueloAux, destinoVueloAux, valorTiqueteAux);
        vuelos.add(vuelito);
        System.out.println("El codigo asignado para este viaje es: "+ codigoViaje);
        return true;
    }

    public static boolean verificarCAeronave(int codigoAeronaveAux){
        for (Aeronave aeronavesita:aviones){//recorrer listas de clases
            if (aeronavesita.getCodigoAV() == codigoAeronaveAux){
                return true;
            }
        }
        return false;
    }

    public static boolean registrarTiquete(){
        Scanner entrada = new Scanner(System.in);
        int codigoConsecutivoAux=0;
        System.out.print("Ingrese el # del vuelo del Viaje: ");
        try{
            codigoConsecutivoAux = entrada.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("Por favor ingresar una opcion existente");
            entrada.next();
        }
        catch(Exception e){
            System.out.println("Por favor ingrese una opcion existente");
        }
        if (verificarConsecutivo(codigoConsecutivoAux)){
            System.out.println("El # del vuelo existe...");
        }else {
            System.out.println("El # del vuelo no existe, intente de nuevo...");
            return false;
        }
        Vuelo vuelo = buscarVuelo(codigoConsecutivoAux);
        if (vuelo != null){
            System.out.println("Codigo del viaje: "+vuelo.getCodigoViaje());
            System.out.println("Codigo de la aeronave: "+vuelo.getCodigoAV());
            System.out.println("Fecha del viaje: "+vuelo.getFecha());
            System.out.println("Origen del viaje: "+vuelo.getOrigen());
            System.out.println("Destino del viaje: "+vuelo.getDestino());
            System.out.println("Valor de cada tiquete: "+vuelo.getValor());
            ArrayList <Tiquete> tiquetes = vuelo.getPasajeros();
            if (tiquetes.size() == 0 ){
                System.out.println("Este vuelo no tiene tiquetes comprados");
            }else {
                int contador = 1;
                for (Tiquete tiquetico:tiquetes){
                    System.out.println("Viajero # "+contador+": codigo: "+tiquetico.getNumeroTiquete());
                    contador++;
                }
            }
            int comprar=0;
            System.out.print("Desa comprar en este vuelo? 1-> SI 2-> NO: ");
            try{
                comprar = entrada.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("Por favor ingresar una opcion existente");
                entrada.next();
            }
            catch(Exception e){
                System.out.println("Por favor ingrese una opcion existente");
            }
            if(comprar != 1){
                System.out.println("Ud. decidio no comprar o escogió una opcion no valida");
                System.out.println("intente de nuevo");
                return false;
            }
            int nroViajeros=0;
            System.out.print("Digite cuantos tiquetes desea comprar: ");
            try{
                nroViajeros = entrada.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("Por favor ingresar una opcion existente");
                entrada.next();
            }
            catch(Exception e){
                System.out.println("Por favor ingrese una opcion existente");
            }
            String nombreAux, apellidoAux;
            int tamanio = tiquetes.size();
            int IdAux=0;
            for (int i = 0; i < nroViajeros; i++) {
                entrada.nextLine();
                System.out.print("\nIngrese el nombre de la persona "+(i+1)+": ");
                nombreAux = entrada.nextLine();
                System.out.print("\nIngrese el apellido de la persona "+(i+1)+": ");
                apellidoAux = entrada.nextLine();
                System.out.print("\nIngrese el ID de la persona "+(i+1)+": ");
                try{
                    IdAux = entrada.nextInt();
                }
                catch(InputMismatchException e){
                    System.out.println("Por favor ingresar una opcion existente");
                    entrada.next();
                }
                catch(Exception e){
                    System.out.println("Por favor ingrese una opcion existente");
                }
                tamanio++;
                Tiquete tiqu = new Tiquete(tamanio+1000,nombreAux,apellidoAux,IdAux);
                tiqu.setCodigoVuelo(codigoConsecutivoAux);
                tiquetes.add(tiqu);
            }
            int contador = 1;
            for (Tiquete tiquetico:tiquetes){
                System.out.println("\t..:Viajero # "+contador+":.. ");
                System.out.println("Nombre: "+tiquetico.getNombre());
                System.out.println("Apellido: "+tiquetico.getApellido());
                System.out.println("ID: # "+tiquetico.getID());
                System.out.println("Codigo:  "+tiquetico.getNumeroTiquete()+"\n");
                contador++;
            }
        }
        return true;
    }

    public static boolean verificarConsecutivo(int codigoConsecutivoAux){
        for (Vuelo vuelesito:vuelos){//recorrer listas de clases
            System.out.println(" "+vuelesito.getOrigen());
            if (vuelesito.getCodigoViaje() == codigoConsecutivoAux){

                return true;
            }
        }
        return false;
    }

    public static Vuelo buscarVuelo(int codigoConsecutivoAux){
        for (Vuelo vuelesito:vuelos){//recorrer listas de clases
            if (vuelesito.getCodigoViaje() == codigoConsecutivoAux){
                return vuelesito;
            }
        }
        return null;
    }

    public static void elimiarTiquete(){
        System.out.println("Usted ha elegido borrar un tiquete");
        Scanner s = new Scanner(System.in);
        int salida = 1;
        while(salida != 0){
            int aux = 0;
            System.out.println("Ingrese el numero de vuelo donde compro el tiquete: ");
            try {
                aux = s.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("Por favor ingresar una opcion existente");
                aux = s.nextInt();
            }
            catch(Exception e){
                System.out.println("Por favor ingrese una opcion existente");
                break;
            }
            for(Vuelo v : vuelos){
                if(v.getCodigoViaje()== aux){
                    int auxiliar = 0;
                    System.out.println("Ingrese el numero de tiquete que desea borrar: ");
                    try {
                        auxiliar = s.nextInt();
                    }
                    catch(InputMismatchException e){
                        System.out.println("Por favor ingresar una opcion existente");
                        aux = s.nextInt();
                    }
                    catch(Exception e){
                        System.out.println("Por favor ingrese una opcion existente");
                        break;
                    }
                    for(Tiquete t: v.pasajeros){
                        if(t.getNumeroTiquete() == auxiliar){
                            System.out.println("Confirme si la información del tiquete que desea borrar es correcta");
                            System.out.println("Datos del vuelo: ");
                            System.out.println("Codigo del viaje: " + t.getCodigoVuelo());
                            System.out.println("Codigo del avion: " + v.getCodigoAV());
                            System.out.println("Fecha: " + v.getFecha());
                            System.out.println("Origen: " + v.getOrigen());
                            System.out.println("Destino: " + v.getDestino());
                            System.out.println("Valor: " + v.getValor());
                            System.out.println("Nombre del Viajero: " + t.getNombre());
                            System.out.println("Apellido del Viajero: " + t.getApellido());
                            System.out.println("ID del Viajero: " + t.getID());
                            System.out.println("\n Si es correcto esta información que desea borrar escriba 1 para Si, de lo contrario 2 para No: ");
                            int decision = 0;
                            try {
                                decision = s.nextInt();
                            }
                            catch(InputMismatchException e){
                                System.out.println("Por favor ingresar una opcion existente");
                                decision = s.nextInt();
                            }
                            catch(Exception e){
                                System.out.println("Por favor ingrese una opcion existente");
                                break;
                            }
                            if(decision == 1){
                                v.pasajeros.remove(t);
                                System.out.println("Se ha borrado el tiquete deseado ");
                                salida = 0;
                            } else{
                                System.out.println("Si no es su tiquete deseado eliga otro");
                            }
                        }
                    }
                }
                else{
                    System.out.println("El vuelo no existe ");
                    System.out.println("Ingrese un vuelo que existe ");
                }

            }
        }
    }





    public static void elimiarVuelo(){
        System.out.println("Usted ha elegido borrar un vuelo");
        Scanner s = new Scanner(System.in);
        int salida = 1;
        while(salida != 0){
            int aux = 0;
            System.out.println("Ingrese el número de vuelo que desea borrar: ");
            try {
                aux = s.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("Por favor ingresar una opcion existente");
                aux = s.nextInt();
            }
            catch(Exception e){
                System.out.println("Por favor ingrese una opcion existente");
                break;
            }
            for(Vuelo v : vuelos){
                if(v.getCodigoViaje()== aux){
                    if(v.pasajeros.isEmpty() == true){
                        System.out.println("El vuelo que desea borrar no tiene tiquetes ");
                        System.out.println("Datos del vuelo: ");
                        System.out.println("Codigo del viaje: " + v.getCodigoViaje());
                        System.out.println("Codigo del avion: " + v.getCodigoAV());
                        System.out.println("Fecha: " + v.getFecha());
                        System.out.println("Origen: " + v.getOrigen());
                        System.out.println("Destino: " + v.getDestino());
                        System.out.println("\n Si es correcto esta información que desea borrar escriba Si, de lo contrario No: ");
                        String decision = null;
                        decision = s.nextLine();
                        if(decision.equals("SI")== true){
                            vuelos.remove(v);
                            System.out.println("Se ha borrado el vuelo deseado ");
                            salida = 0;
                        } else{
                            System.out.println("Si no es su vuelo deseado eliga otro");
                        }

                    } else{
                        System.out.println("El vuelo cuenta con tiquetes comprados ");
                        System.out.println("Eliminelos para poder eliminar el vuelo ");
                    }
                }
            }
        }
    }


    public static boolean mostrarProgramacion(){
        Scanner entrada = new Scanner(System.in);
        int codigoConsecutivoAux=0;
        System.out.print("Ingrese el # del vuelo del Viaje: ");
        try{
            codigoConsecutivoAux = entrada.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("Por favor ingresar una opcion existente");
            entrada.next();
        }
        catch(Exception e){
            System.out.println("Por favor ingrese una opcion existente");
        }
        if (verificarConsecutivo(codigoConsecutivoAux)){
            System.out.println("El # del vuelo existe...");
        }else {
            System.out.println("El # del vuelo no existe, intente de nuevo...");
            return false;
        }
        Vuelo vuelo = buscarVuelo(codigoConsecutivoAux);
        assert vuelo != null;
        System.out.println("Codigo del viaje: "+vuelo.getCodigoViaje());
        System.out.println("Codigo de la aeronave: "+vuelo.getCodigoAV());
        System.out.println("Fecha del viaje: "+vuelo.getFecha());
        System.out.println("Origen del viaje: "+vuelo.getOrigen());
        System.out.println("Destino del viaje: "+vuelo.getDestino());
        System.out.println("Valor de cada tiquete: "+vuelo.getValor());

        ArrayList <Tiquete> tiquetes = vuelo.getPasajeros();
        int contador = 1;
        for (Tiquete tiquetico:tiquetes){
            System.out.println("\t..:Viajero # "+contador+":.. ");
            System.out.println("Nombre: "+tiquetico.getNombre());
            System.out.println("Apellido: "+tiquetico.getApellido());
            System.out.println("ID: # "+tiquetico.getID());
            System.out.println("Codigo:  "+tiquetico.getNumeroTiquete()+"\n");
            contador++;
        }
        return true;
    }
}