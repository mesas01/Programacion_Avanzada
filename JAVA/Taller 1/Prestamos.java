package Taller10InfanteYMesa;

public class Prestamos {
    private float prestamo;
    private int meses;
    private float interes;
    private float total_intereses;

    public Prestamos(float prestamo, int meses, float interes){
        this.prestamo=prestamo;
        this.meses=meses;
        this.interes=interes;
    }

    public float getMeses(){
        return meses;
    }

    public void setMeses(int meses){
        this.meses=meses;
    }

    public float getInteres(){
        return interes;
    }

    public void setInteres(float interes){
        this.interes=interes;
    }

    public float getPrestamo(){
        return prestamo;
    }

    public void setPrestamo(float prestamo){
        this.prestamo=prestamo;
    }

    public float getTotal_intereses(){
        return total_intereses;
    }

    public void calcular(float prestamo, float interes, int meses){
        total_intereses=prestamo*interes*meses;
    }

}