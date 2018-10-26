package problemas.p9.exceptions;

public class ErrorCategoria extends Exception{
    public ErrorCategoria(String dni, String tipo){
        super("El empleado con dni = "+dni+" no es de tipo "+tipo);
    }
}
