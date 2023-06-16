package Proyecto2InfanteMesa;


public class Aeronave implements java.io.Serializable {
    private int codigoAV;
    private String marca;

    public void setCodigoAV(int codigoAV){
        this.codigoAV=codigoAV;
    }

    public void setMarca(String marca){
        this.marca=marca;
    }

    public int getCodigoAV(){
        return this.codigoAV;
    }

    public String getMarca(){
        return this.marca;
    }

    public Aeronave(int codigoAV, String marca){
        this.codigoAV=codigoAV;
        this.marca=marca;
    }

    public Aeronave(){

    }


}