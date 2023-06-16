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


public class Persona {
    private String nombre;
    private String telefono;
    private String correo;
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public void setTelefono(String telefono){
        this.telefono=telefono;
    }
    
    public void setCorreo(String correo){
        this.correo=correo;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getTelefono(){
        return this.telefono;
    }
    
    public String getCorreo(){
        return this.correo;
    }
    
    public Persona(){
        
    }
    
    public Persona(String nombre, String telefono, String correo){
        this.nombre=nombre;
        this.telefono=telefono;
        this.correo=correo;
    }
}
