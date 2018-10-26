package problemas.p9.trabajadores;

import java.util.Date;

public abstract class Empleado {
    // ATTRIBUTES
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String telefono;
    private double sueldoBase;
    private Date fechaContrato;
    
    // CONSTRUCTOR
    public Empleado(String dni, String nombre, String apellido1, String apellido2, String telefono,
            double sueldoBase) {
        super();
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefono = telefono;
        this.sueldoBase = sueldoBase;
        this.fechaContrato = new Date();
    }
    
    // METHODS
    public abstract double sueldo();
    public abstract void resetearExtras();
    
    private String getFormatedFechaContrato(){
        return fechaContrato.getDate()+"/"+(fechaContrato.getMonth()+1)+"/"+fechaContrato.getYear();
    }
    
    // GETTERS && SETTERS
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }
    
    public Date getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(Date fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    // TOSTRING
    public String toString(){
        return "DNI: " + dni + "\tNombre: " + nombre + "\tApellidos: " + apellido1 +" "+ apellido2 + "\tTelefono: " + telefono + "\tSueldo: " + sueldo() + "\t\tFecha contratacion: "+getFormatedFechaContrato()+"\n";
    }
}

