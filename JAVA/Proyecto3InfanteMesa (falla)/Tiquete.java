/*
programacion avanzada
24/04/2022
Proyecto 2
Santiago Mesa
Mateo Infante
Grupo 5
*/


package Proyecto2InfanteMesa;

public class Tiquete implements java.io.Serializable {
    private int numeroTiquete;
    private String nombre;
    private String apellido;
    private int ID;
    private int codigoVuelo;

    public void setNumeroTiquete(int numeroTiquete){
        this.numeroTiquete=numeroTiquete;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setApellido(String apellido){
        this.apellido=apellido;
    }

    public void setID(int ID){
        this.ID=ID;
    }

    public int getNumeroTiquete(){
        return numeroTiquete;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getID() {
        return ID;
    }

    public Tiquete(int numeroTiquete, String nombre, String apellido, int ID){
        this.numeroTiquete=numeroTiquete;
        this.nombre=nombre;
        this.apellido=apellido;
        this.ID=ID;
    }

    public void setCodigoVuelo(int codigoVuelo){
        this.codigoVuelo = codigoVuelo;
    }

    public int getCodigoVuelo(){
        return codigoVuelo;
    }

    public Tiquete(){

    }

}
