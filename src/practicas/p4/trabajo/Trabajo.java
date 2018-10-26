package practicas.p4.trabajo;

import java.util.Date;

import practicas.p4.excepciones.TrabajoFinalizado;

public class Trabajo {
    
    // ATTRIBUTES
    private static int proximoId = 1;
    private static final int FIJO = 30;
    private int id;
    private String descripcion;
    private int horas;
    private boolean finalizado;
    private int plazo;
    private Date inicio;
    
    // CONSTRUCTOR
    public Trabajo(String descripcion) {
        this.id = proximoId;
        proximoId++;
        this.descripcion = descripcion;
        this.finalizado = false;
        this.horas = 0;
        this.plazo = -1;
        this.inicio = new Date();
    }
    
    // METHODS
    public double precio(){
        return horas * FIJO;    
    }
    
    public void aumentaHoras(int horas){
        this.horas+=horas;
    }
    
    public String getFormatedInicio(){
        return inicio.getDate()+"/"+(inicio.getMonth()+1)+"/"+inicio.getYear();
    }
    
    // GETTERS && SETTERES
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getHoras() {
        return horas;
    }
    public void setHoras(int horas) throws TrabajoFinalizado {
        if(finalizado){
            throw new TrabajoFinalizado(this.id);
        }else{
            this.horas = horas;
        }
    }
    public boolean isFinalizado() {
        return finalizado;
    }
    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }
    
    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    // TOSTRING
    public String toString(){
        return "ID: "+id+"\tDesc: "+descripcion+"\tFinalizado: "+(finalizado ? "Si" : "No")+"\tHoras totales: "+horas+"\tPlazo: "+plazo+"\tInicio: "+getFormatedInicio();
    }
}
