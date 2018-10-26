package problemas.p9.trabajadores;

public class Limpiador extends Empleado{

    // ATTRIBUTES
    private int horasExtra;
    
    // CONSTRUCTOR
    public Limpiador(String dni, String nombre, String apellido1, String apellido2, String telefono, double sueldoBase) {
        super(dni, nombre, apellido1, apellido2, telefono, sueldoBase);
        this.horasExtra = 0;
    }

    // METHODS
    @Override
    public double sueldo() {
        return super.getSueldoBase() + ((0.05 * super.getSueldoBase()) * this.horasExtra);
    }
    
    @Override
    public void resetearExtras() {
       setHorasExtra(0);
    }
    
    public void incrementaHoras(int horasExtra){
        this.horasExtra += horasExtra;
    }

    // GETTERS && SETTERS
    public int getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    }
}
