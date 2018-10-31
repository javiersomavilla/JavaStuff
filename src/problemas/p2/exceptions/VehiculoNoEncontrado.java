package problemas.p2.exceptions;

public class VehiculoNoEncontrado extends Exception{
	public VehiculoNoEncontrado(String matricula) {
		super("[ERROR] El vehiculo con matricula "+matricula+" no existe en el sistema.");
	}
}
