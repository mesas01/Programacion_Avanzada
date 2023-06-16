/*
programacion avanzada
11/05/2022
Taller 3 Lab 3
Santiago Mesa
Mateo Infante
Grupo 5
*/
package taller3lab3infantemesa;


public class Polideportivo implements InstalaciónDeportiva, Edificio {

    private String nombre;
    private int tipoDeInstalacion;
    private int superficie;
    
    public Polideportivo(String nombre, int tipoDeInstalacion, int superficie){
        this.nombre=nombre;
        this.tipoDeInstalacion=tipoDeInstalacion;
        this.superficie=superficie;
    }

    public Polideportivo() {
        
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoDeInstalacion(int tipoDeInstalacion) {
        this.tipoDeInstalacion = tipoDeInstalacion;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    @Override
    public int getTipoDeInstalacion() {
        return this.tipoDeInstalacion;
    }

    @Override
    public int getSuperficieEdificio() {
        return this.superficie;
    }
    
    @Override
    public String toString(){
        System.out.println("\nNombre del Polideportivo: "+nombre);
        System.out.println("\nTipo de Instalación: "+tipoDeInstalacion);
        System.out.println("\nSuperficie: "+superficie);
        return "Polideportivo";
    }
    
}
