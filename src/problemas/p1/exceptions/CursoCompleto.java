package problemas.p1.exceptions;

public class CursoCompleto extends Exception{
	public CursoCompleto() {
		super("[ERROR] El curso ya está completo.");
	}
}
