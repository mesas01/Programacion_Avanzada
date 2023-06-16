/*
programacion avanzada
04/05/2022
Taller 3 Lab 2
Santiago Mesa
Mateo Infante
Grupo 5
*/
package geometriainfantemesa;


public class Circulo extends Figura {
        
    @Override
    public float area(float dato) {
         float area=0;
         area=dato*dato*3.1416f;
         return area;
    }
    
    public float getArea(){
        float area;
        area=area(super.getRadio());
        return area;
    }
}
