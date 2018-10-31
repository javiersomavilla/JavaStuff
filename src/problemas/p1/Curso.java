package problemas.p1;

import java.util.LinkedList;

import problemas.p1.exceptions.AlumnoNoEncontrado;
import problemas.p1.exceptions.AlumnoYaExistente;
import problemas.p1.exceptions.CursoCompleto;

public class Curso {
	
	// ATTRIBUTES
	private static final int MAX_ALUMNOS = 40;
	private LinkedList<Alumno> alumnos;
	
	// CONSTRUCTOR
	public Curso() {
		alumnos = new LinkedList<>();
	}
	
	// METHODS
	public void matricularAlumno(Alumno nuevoAlumno) throws AlumnoYaExistente, CursoCompleto{
		if(alumnos.size() == MAX_ALUMNOS) {
			throw new CursoCompleto();
		}else{
			try {
				buscaAlumnoPorDni(nuevoAlumno.getDni());
				throw new AlumnoYaExistente(nuevoAlumno.getDni());
			}catch (AlumnoNoEncontrado e) {
				alumnos.addLast(nuevoAlumno);
			}
			
		}
	}
	
	public Alumno buscaAlumnoPorDni(String dni) throws AlumnoNoEncontrado{
		Alumno a = null;
		
		boolean encontrado = false;
		for(int i=0; i<alumnos.size() && !encontrado; i++) {
			if(alumnos.get(i).getDni().equalsIgnoreCase(dni)) {
				encontrado = true;
				a = alumnos.get(i);
			}
		}
		
		if(!encontrado) {
			throw new AlumnoNoEncontrado(dni);
		}else {
			return a;
		}
	}
	
	public String verDatosCurso() {
		String str = "";
		
		for(Alumno a: alumnos) {
			str += a.toString()+"\n\n";
		}
		
		return str;
	}
}
