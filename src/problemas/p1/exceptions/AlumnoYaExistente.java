package problemas.p1.exceptions;

public class AlumnoYaExistente extends Exception{
	public AlumnoYaExistente(String dni) {
		super("[ERROR] El alumno con dni "+dni+" ya está dado de alta.");
	}
}
