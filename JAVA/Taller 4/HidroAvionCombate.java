/*
programacion avanzada
01/05/2022
Taller 3 Lab 1
Santiago Mesa
Mateo Infante
Grupo 5
*/
package taller3lab1infantemesa;


public class HidroAvionCombate extends HidroAvion implements ObjetoDeCombate {

    public void atacar(String avion) {
        System.out.println("El objeto "+avion+", esta despegando.");
    }

    public HidroAvionCombate(final int fechaCreacion, final float alturaMaxima, final float velocidadMaxima) {
        super(fechaCreacion, alturaMaxima, velocidadMaxima);
    }
}