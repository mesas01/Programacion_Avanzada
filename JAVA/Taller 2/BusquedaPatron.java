/*
programacion avanzada
02/04/2022
Lab sesion 11
Santiago Mesa
Mateo Infante
Grupo 5
*/

package taller11infantemesa;

import java.util.Scanner;
import java.lang.String;

public class BusquedaPatron {
    private String cadena;
    private String subcadena;
    private int contador;
    
    public BusquedaPatron(){
   
    }
    
    public BusquedaPatron(String cadena, String subcadena){
        this.cadena=cadena;
        this.subcadena=subcadena;
    }
    
    public String getCadena(){
        return cadena;
    }
    
    public String getSubcadena(){
        return subcadena;
    }
    
    public int getContador(){
        return contador;
    }
    
    public void setCadena(String cadena){
        this.cadena=cadena;
    }
    
    public void setSubcadena(String subcadena){
        this.subcadena=subcadena;
    }
    
    public void setContador(int contador){
        this.contador=contador;
    }
    
    public int contarSubcadenas(String cadena, String subcadena){
        this.contador=0;
        String comparar;
        comparar=cadena.toLowerCase();
        int ubicacion=0;
        int aux=-1;
        int cantidad=0;
        boolean encontrado=true;
        while(encontrado==true){
            ubicacion=comparar.indexOf(subcadena, ++aux);
            aux=ubicacion;
            if(ubicacion==-1){
                encontrado=false;
            } else {
                cantidad++;        
                }
            
            }
        return cantidad;
        
    }
}
