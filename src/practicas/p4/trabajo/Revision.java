package practicas.p4.trabajo;

public class Revision extends Trabajo{
    
    // ATTRIBUTES
    private static final int FIJO = 20;
    
    // CONSTRUCTOR
    public Revision(String descripcion) {
        super(descripcion);  
        super.setPlazo(7);
    }
    
    public double precio(){
        return super.precio()+FIJO;
    }
    
    // TOSTRING
    public String toString(){
        return "REVISION\t\t\t"+super.toString()+"\tPrecio Total = "+precio();
    }
}
