package problemas.p2.exceptions;

public class VehiculoYaExistente extends Exception{
	public VehiculoYaExistente(String matricula) {
		super("[ERROR] El vehiculo con matricula "+matricula+" ya existe.");
	}
}
