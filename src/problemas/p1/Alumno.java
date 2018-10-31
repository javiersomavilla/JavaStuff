package problemas.p1;

public class Alumno {
	
	// ATTRIBUTES
	private String nombre;
	private String direccion;
	private String telefono;
	private String dni;
	
	// CONSTRUCTOR
	public Alumno(String nombre, String direccion, String telefono, String dni) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.dni = dni;
	}

	// GETTERS && SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	// TOSTRING
	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", dni=" + dni
				+ "]";
	}
}
