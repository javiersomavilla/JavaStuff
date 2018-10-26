package practicas.p4.excepciones;

public class TrabajoNoEncontrado extends Exception{
    public TrabajoNoEncontrado(int id) {
        super("No se ha encontrado ningun trabajo con el id = "+id);
    }
}
