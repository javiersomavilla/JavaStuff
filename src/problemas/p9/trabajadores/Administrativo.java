package problemas.p9.trabajadores;

import java.util.LinkedList;

public class Administrativo  extends Empleado{

    // CONSTRUCTOR
    public Administrativo(String dni, String nombre, String apellido1, String apellido2, String telefono, double sueldoBase) {
        super(dni, nombre, apellido1, apellido2, telefono, sueldoBase);
    }

    // METHODS
    @Override
    public double sueldo() {
        return super.getSueldoBase();
    }
    @Override
    public void resetearExtras() {}
}
