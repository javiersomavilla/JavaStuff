package practicas.p4.excepciones;

public class TipoNoCoincide extends Exception{
    public TipoNoCoincide(String tipoBuscado, int id){
        super("El trabajo con id = "+id+" no es del tipo "+tipoBuscado);
    }
}
