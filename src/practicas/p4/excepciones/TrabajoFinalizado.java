package practicas.p4.excepciones;

public class TrabajoFinalizado extends Exception{
    
    public TrabajoFinalizado(int id) {
        super("El trabajo con id "+id+" ya ha sido cerrado.");
    }
}
