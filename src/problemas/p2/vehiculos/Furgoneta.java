package problemas.p2.vehiculos;

public class Furgoneta extends VehiculoCarga{

	// CONSTRUCTOR
	public Furgoneta(String matricula, int dias, int pma) {
		super(matricula, dias, pma);
	}
	
	// TOSTRING
	public String toString() {
		return "[FURGONETA]\t"+super.toString()+"\t\tPRECIO ALQUILER: "+super.precioAlquiler();
	}
}
