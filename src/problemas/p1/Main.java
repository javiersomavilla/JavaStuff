package problemas.p1;

import problemas.p1.exceptions.AlumnoNoEncontrado;
import problemas.p1.exceptions.AlumnoYaExistente;
import problemas.p1.exceptions.CursoCompleto;

public class Main {

	public static void main(String[] args) {
		// Creamos el curso
		Curso curso = new Curso();
		
		// Creamos los alumnos
		Alumno a1 = new Alumno("nom1", "dir1", "tel1", "dni1");
		Alumno a2 = new Alumno("nom2", "dir2", "tel2", "dni2");
		Alumno a3 = new Alumno("nom3", "dir3", "tel3", "dni3");
		Alumno a4 = new Alumno("nom4", "dir4", "tel4", "dni4");
		Alumno a5 = new Alumno("nom5", "dir5", "tel5", "dni5");
		Alumno a6 = new Alumno("nom6", "dir6", "tel6", "dni6");
		Alumno a7 = new Alumno("nom7", "dir7", "tel7", "dni7");
		Alumno a8 = new Alumno("nom8", "dir8", "tel8", "dni8");
		Alumno a9 = new Alumno("nom9", "dir9", "tel9", "dni9");
		
		// Añadimos los alumnos
		try {
			curso.matricularAlumno(a1);
			curso.matricularAlumno(a2);
			curso.matricularAlumno(a3);
			curso.matricularAlumno(a4);
			curso.matricularAlumno(a5);
			curso.matricularAlumno(a6);
			curso.matricularAlumno(a7);
			curso.matricularAlumno(a8);
			curso.matricularAlumno(a9);
		} catch (AlumnoYaExistente | CursoCompleto e) {
			System.out.println(e.getMessage());
		}
		
		// Añadimos un alumno que ya existe
		try {
			curso.matricularAlumno(a3);
		} catch (AlumnoYaExistente | CursoCompleto e) {
			System.out.println(e.getMessage()+"\n");
		}
		
		// Buscamos a un alumno que no existe
		try {
			curso.buscaAlumnoPorDni("asdf");
		} catch (AlumnoNoEncontrado e) {
			System.out.println(e.getMessage()+"\n");
		}
		
		// Mostramos el curso
		System.out.println(curso.verDatosCurso());
	}

}
