package practicas.p4.trabajo;

public class ReparacionMecanica extends Reparacion{

    // CONSTRUCTOR
    public ReparacionMecanica(String descripcion) {
        super(descripcion);
        super.setExtraCoste(1.1);
        super.setPlazo(14);
    }
    
    // TOSTRING
    public String toString(){
        return "REPARACION [MECANICA]\t\t"+super.toString();
    }

}
