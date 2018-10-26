package problemas.p9.trabajadores;

import java.util.LinkedList;

public class Encargado  extends Empleado{

    // ATTRIBUTES
    private LinkedList<Comercial> comercialesACargo;
    
    // CONSTRUCTOR
    public Encargado(String dni, String nombre, String apellido1, String apellido2, String telefono, double sueldoBase) {
        super(dni, nombre, apellido1, apellido2, telefono, sueldoBase);
        this.comercialesACargo = new LinkedList<>();
    }

    // METHODS
    @Override
    public double sueldo() {
        return super.getSueldoBase() + ((0.05 * super.getSueldoBase()) * numContratosComercialesACargo());
    }
    
    @Override
    public void resetearExtras() {
       setComercialesACargo(new LinkedList<>());
    }
    
    public int numContratosComercialesACargo(){
        int numContratos = 0;
        
        for(int i=0; i<this.comercialesACargo.size(); i++){
            numContratos += this.comercialesACargo.get(i).getContratosConseguidos();
        }
        
        return numContratos;
    }
    
    public void addComercialACargo(Comercial c){
        this.comercialesACargo.add(c);
    }
    
    // GETTERS && SETTERS
    public LinkedList<Comercial> getComercialesACargo() {
        return comercialesACargo;
    }

    public void setComercialesACargo(LinkedList<Comercial> comercialesACargo) {
        this.comercialesACargo = comercialesACargo;
    }
}
