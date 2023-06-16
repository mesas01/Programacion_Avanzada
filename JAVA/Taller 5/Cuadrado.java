/*
programacion avanzada
04/05/2022
Taller 3 Lab 2
Santiago Mesa
Mateo Infante
Grupo 5
*/
package geometriainfantemesa;


public class Cuadrado extends Figura {

    @Override
    public float area(float dato) {
         float area=0;
         area=dato*dato;
         return area;
    }
    
    public float getArea(){
        float area;
        area=area(super.getLado());
        return area;
    }
}
