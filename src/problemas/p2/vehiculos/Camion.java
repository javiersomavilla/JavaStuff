package problemas.p2.vehiculos;

public class Camion extends VehiculoCarga{

	// CONSTRUCTOR
	public Camion(String matricula, int dias, int pma) {
		super(matricula, dias, pma);
	}
	
	// METHODS
	public double precioAlquiler() {
		return calculaAlquiler(super.getDias());
	}
	
	public double calculaAlquiler(int nDias) {
		return super.calculaAlquiler(nDias) + 40;
	}
	
	// TOSTRING
	public String toString() {
		return "[CAMION]\t"+super.toString()+"\t\tPRECIO ALQUILER: "+precioAlquiler();
	}
}
