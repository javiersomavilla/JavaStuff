package practicas.p4.trabajo;

import practicas.p4.excepciones.TrabajoFinalizado;

public abstract class Reparacion extends Trabajo{
    
    // ATTRIBUTES
    private double precioMaterial;
    private double extraCoste;
    
    // CONSTRUCTOR
    public Reparacion(String descripcion) {
        super(descripcion);
        this.precioMaterial = 0;
        this.extraCoste = 1;
    }
    
    // METHODS
    public double precio(){
        return super.precio() + (precioMaterial * extraCoste);
    }
    
    public void aumentaPrecioMaterial(double precioMaterial) throws TrabajoFinalizado{
        if(super.isFinalizado()){
            throw new TrabajoFinalizado(this.getId());
        }else{
            this.precioMaterial += precioMaterial;
        }
    }

    // GETTERS && SETTERS
    public double getPrecioMaterial() {
        return precioMaterial;
    }

    public void setPrecioMaterial(double precioMaterial) throws TrabajoFinalizado {
        this.precioMaterial = precioMaterial;
    }

    public double getExtraCoste() {
        return extraCoste;
    }

    public void setExtraCoste(double extraCoste) {
        this.extraCoste = extraCoste;
    }
    
    // TOSTRING
    public String toString(){
        return super.toString()+"\tPrecio Total = "+precio()+"\tPrecio Material: "+precioMaterial;
    }
}
