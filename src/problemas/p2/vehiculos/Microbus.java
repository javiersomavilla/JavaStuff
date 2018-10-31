package problemas.p2.vehiculos;

public class Microbus extends VehiculoTransporte{

	// CONSTRUCTOR
	public Microbus(String matricula, int dias, int numPlazas) {
		super(matricula, dias, numPlazas);
	}
	
	// METHODS
	public double precioAlquiler() {
		return calculaAlquiler(super.getDias());
	}
	
	public double calculaAlquiler(int nDias) {
		return super.calculaAlquiler(nDias) + (2 * super.getNumPlazas());
	}
	
	// TOSTRING
	public String toString() {
		return "[MICROBUS]\t"+super.toString()+"\tPRECIO ALQUILER: "+precioAlquiler();
	}
}
