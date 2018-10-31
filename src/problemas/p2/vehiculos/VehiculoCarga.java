package problemas.p2.vehiculos;

public abstract class VehiculoCarga extends Vehiculo{

	// ATTRIBUTES
	private int pma;
	
	// CONSTRUCTOR
	public VehiculoCarga(String matricula, int dias, int pma) {
		super(matricula, dias);
		this.pma = pma;
	}
	
	// METHODS
	public double precioAlquiler() {
		return calculaAlquiler(super.getDias());
	}
	
	public double calculaAlquiler(int nDias) {
		return super.calculaAlquiler(nDias) + (20 * this.pma);
	}
	
	// TOSTRING
	public String toString() {
		return super.toString()+" PMA: "+this.pma;
	}
}
