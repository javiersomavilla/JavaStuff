package problemas.p2.vehiculos;

public abstract class VehiculoTransporte extends Vehiculo{
	
	// ATTRIBUTES
	private int numPlazas;
	
	// CONSTRUCTOR
	public VehiculoTransporte(String matricula, int dias, int numPlazas) {
		super(matricula, dias);
		this.numPlazas = numPlazas;
	}
	
	// METHODS
	public double precioAlquiler() {
		return calculaAlquiler(super.getDias());
	}
	
	public double calculaAlquiler(int nDias) {
		return super.calculaAlquiler(nDias) + (1.5 * this.numPlazas * super.getDias());
	}
	
	// GETTERS && SETTERS
	public int getNumPlazas() {
		return this.numPlazas;
	}
	
	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
	}
	
	// TOSTRING
	public String toString() {
		return super.toString()+" NUM. PLAZAS: "+this.numPlazas;
	}

}
