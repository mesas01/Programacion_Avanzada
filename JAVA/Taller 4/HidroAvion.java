/*
programacion avanzada
01/05/2022
Taller 3 Lab 1
Santiago Mesa
Mateo Infante
Grupo 5
*/
package taller3lab1infantemesa;

public class HidroAvion implements ObjetoAcuatico, ObjetoVolador {
    private int fechaCreacion;
    private float alturaMaxima;
    private float velocidadMaxima;

    public void navegar(String avion, float millas) {
        System.out.println("El objeto "+avion+", esta navegando a "+millas+" millas por hora.");
    }

    public void volar(String avion, float millas) {
        System.out.println("El objeto "+avion+", esta volando a "+millas+" millas por hora.");
    }

    public void aterrizar(String avion) {
        System.out.println("El objeto "+avion+", esta aterrizando.");
    }

    public void despegar(String avion) {
        System.out.println("El objeto "+avion+", esta despegando.");
    }

    public int getFechaCreacion() {
        return fechaCreacion;
    }

    public float getAlturaMaxima() {
        return alturaMaxima;
    }

    public float getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setFechaCreacion(int fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setAlturaMaxima(float alturaMaxima) {
        this.alturaMaxima = alturaMaxima;
    }

    public void setVelocidadMaxima(float velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public HidroAvion(final int fechaCreacion, final float alturaMaxima, final float velocidadMaxima) {
        this.fechaCreacion = fechaCreacion;
        this.alturaMaxima = alturaMaxima;
        this.velocidadMaxima = velocidadMaxima;
    }
}
