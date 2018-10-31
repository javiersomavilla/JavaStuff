package problemas.p1.exceptions;

public class AlumnoNoEncontrado extends Exception{
	public AlumnoNoEncontrado(String dni) {
		super("[ERROR] el alumno con dni "+dni+" no ha sido encontrado.");
	}
}
