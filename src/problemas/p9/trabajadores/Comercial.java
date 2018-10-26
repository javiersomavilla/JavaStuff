package problemas.p9.trabajadores;

public class Comercial  extends Empleado{

    // ATTRIBUTES
    private int contratosConseguidos;
    
    // CONSTRUCTOR
    public Comercial(String dni, String nombre, String apellido1, String apellido2, String telefono, double sueldoBase) {
        super(dni, nombre, apellido1, apellido2, telefono, sueldoBase);
        this.contratosConseguidos = 0;
    }

    // METHODS
    @Override
    public double sueldo() {
        return super.getSueldoBase() + ((0.1 * super.getSueldoBase()) * this.contratosConseguidos);
    }
    
    @Override
    public void resetearExtras() {
       setContratosConseguidos(0);
    }
    
    public void incrementaContratos(){
        this.contratosConseguidos++;
    }

    // GETTERS && SETTERS
    public int getContratosConseguidos() {
        return contratosConseguidos;
    }

    public void setContratosConseguidos(int contratosConseguidos) {
        this.contratosConseguidos = contratosConseguidos;
    }
}
