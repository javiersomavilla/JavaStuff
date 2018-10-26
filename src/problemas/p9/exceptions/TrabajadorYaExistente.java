package problemas.p9.exceptions;

public class TrabajadorYaExistente extends Exception{
    public TrabajadorYaExistente(String dni){
        super("El trabajador con dni = "+dni+" ya esta contratado en esta empresa.");
    }
}
