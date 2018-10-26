package practicas.p4.trabajo;

public class ReparacionChapaYPintura extends Reparacion{

    // CONSTRUCTOR
    public ReparacionChapaYPintura(String descripcion) {
        super(descripcion);
        super.setExtraCoste(1.3);
        super.setPlazo(21);
    }
    
    // TOSTRING
    public String toString(){
        return "REPARACION [CHAPA Y PINTURA]\t"+super.toString();
    }
}
