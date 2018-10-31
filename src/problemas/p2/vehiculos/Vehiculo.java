package problemas.p2.vehiculos;

public abstract class Vehiculo {
	
	// ATTRIBUTES
	private final static int BASE_POR_DIA = 50;	
	private String matricula;
	private int dias;
	
	// CONSTRUCTOR
	public Vehiculo(String matricula, int dias) {
		this.matricula = matricula;
		this.dias = dias;
	}

	// METHODS
	public double precioAlquiler() {		
		return calculaAlquiler(this.dias);
	}
	
	public double calculaAlquiler(int nDias) {
		return nDias * BASE_POR_DIA;
	}
	
	// GETTERS && SETTERS
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}
	
	// TOSTRING
	public String toString() {
		return "MATRICULA: "+this.matricula+"\tDIAS: "+this.dias;
	}
}
