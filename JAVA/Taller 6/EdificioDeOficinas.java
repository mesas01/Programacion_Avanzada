/*
programacion avanzada
11/05/2022
Taller 3 Lab 3
Santiago Mesa
Mateo Infante
Grupo 5
*/
package taller3lab3infantemesa;

public class EdificioDeOficinas implements Edificio {

    private int numOficinas;
    private int superficie;
    
    public EdificioDeOficinas(int numOficinas, int superficie){
        this.numOficinas=numOficinas;
        this.superficie=superficie;
    }

    public EdificioDeOficinas() {
        
    }

    public void setNumOficinas(int numOficinas) {
        this.numOficinas = numOficinas;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public int getNumOficinas() {
        return numOficinas;
    }
    
    @Override
    public int getSuperficieEdificio() {
        return this.superficie;
    }
    
    @Override
    public String toString(){
        System.out.println("Numero de oficinas: "+numOficinas);
        System.out.println("Superficie: "+superficie);
        return "Edificio de Oficinas";
    }
}
