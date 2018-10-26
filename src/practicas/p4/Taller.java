package practicas.p4;

import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

import practicas.p4.excepciones.TipoNoCoincide;
import practicas.p4.excepciones.TrabajoFinalizado;
import practicas.p4.excepciones.TrabajoNoEncontrado;
import practicas.p4.trabajo.Reparacion;
import practicas.p4.trabajo.Trabajo;

public class Taller {
    
    // ATTRIBUTES
    private LinkedList<Trabajo> trabajos;

    public Taller() {
        this.trabajos = new LinkedList<>();
    }
    
    // METHODS    
    public Trabajo encuentraTrabajo(int id){
        Trabajo t = null;
        
        boolean encontrado = false;
        for(int i=0; i<trabajos.size() && !encontrado; i++){
            if(trabajos.get(i).getId() == id){
                encontrado = true;
                t = trabajos.get(i);
            }
        }
        return t;
    }
    
    public void registraTrabajo(Trabajo t){
        trabajos.add(t);
    }
    
    public void aumentaHoras(int id, int horas) throws TrabajoNoEncontrado{
        Trabajo t = encuentraTrabajo(id);
        if(t != null){
            t.aumentaHoras(horas);
        }else{
            throw new TrabajoNoEncontrado(id);
        }
    }
    
    public void aumentaCostePiezas(int id, double coste) throws TrabajoNoEncontrado, TrabajoFinalizado, TipoNoCoincide{
        Trabajo t = encuentraTrabajo(id);
        if(t != null){
            if(t instanceof Reparacion){
                ((Reparacion)t).aumentaPrecioMaterial(coste);
            }else{
                throw new TipoNoCoincide("Reparacion",id);
            }
            
        }else{
            throw new TrabajoNoEncontrado(id);
        }
    }
    
    public void finalizaTrabajo(int id) throws TrabajoNoEncontrado{
        Trabajo t = encuentraTrabajo(id);
        if(t != null){
            t.setFinalizado(true);
        }else{
            throw new TrabajoNoEncontrado(id);
        }
    }
    
    public String muestraTrabajo(int id) throws TrabajoNoEncontrado{
        Trabajo t = encuentraTrabajo(id);
        if(t != null){
            return t.toString();
        }else{
            throw new TrabajoNoEncontrado(id);
        }
    }
    
    public int consultarPlazo(int id) throws TrabajoNoEncontrado{
        Trabajo t = encuentraTrabajo(id);
        if(t != null){
            long diffInMillies = new Date().getTime() - t.getInicio().getTime();
            int diffInDays = (int) TimeUnit.DAYS.convert(diffInMillies,TimeUnit.MILLISECONDS);
            return t.getPlazo()-diffInDays;
        }else{
            throw new TrabajoNoEncontrado(id);
        }
    }

    // GETTERS && SETTERS
    public LinkedList<Trabajo> getTrabajos() {
        return trabajos;
    }

    public void setTrabajos(LinkedList<Trabajo> trabajos) {
        this.trabajos = trabajos;
    }
    
    // TOSTRING
    public String toString(){
        String strTrabajos = "";
        
        for(Trabajo t: trabajos){
            strTrabajos += t.toString()+"\n\n";
        }
        
        return strTrabajos;
    }
}
