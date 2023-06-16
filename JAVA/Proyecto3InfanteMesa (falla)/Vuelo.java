package Proyecto2InfanteMesa;


import java.util.ArrayList;

public class Vuelo implements java.io.Serializable{
    private int codigoViaje, codigoAV ;
    private String fecha,origen,destino;
    private float valor;
    public ArrayList <Tiquete> pasajeros;

    public Vuelo() {

    }


    public int getCodigoViaje(){
        return codigoViaje;
    }

    public int getCodigoAV(){
        return codigoAV;
    }

    public String getFecha(){
        return fecha;
    }

    public String getOrigen(){
        return origen;
    }

    public String getDestino(){
        return destino;
    }

    public float getValor(){
        return valor;
    }

    public ArrayList<Tiquete> getPasajeros() {
        return pasajeros;
    }


    public Vuelo(int codigoViaje, int codigoAV, String fecha, String origen, String destino, float valor) {
        this.codigoViaje = codigoViaje;
        this.codigoAV = codigoAV;
        this.fecha = fecha;
        this.origen = origen;
        this.destino = destino;
        this.valor = valor;
        this.pasajeros = new ArrayList<>();
    }
}