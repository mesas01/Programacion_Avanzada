/*
programacion avanzada
04/05/2022
Taller 3 Lab 2
Santiago Mesa
Mateo Infante
Grupo 5
*/
package geometriainfantemesa;


public abstract class Figura {
    private float radio;
    private float lado;

    public float getRadio() {
        return radio;
    }

    public float getLado() {
        return lado;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }

    public void setLado(float lado) {
        this.lado = lado;
    }
    
    public abstract float area(float dato);
}
