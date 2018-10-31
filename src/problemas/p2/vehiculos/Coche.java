package problemas.p2.vehiculos;

public class Coche extends VehiculoTransporte{
	
	// CONSTRUCTOR
	public Coche(String matricula, int dias, int numPlazas) {
		super(matricula, dias, numPlazas);
	}
	
	// TOSTRING
	public String toString() {
		return "[COCHE]\t\t"+super.toString()+"\tPRECIO ALQUILER: "+super.precioAlquiler();
	}
}
