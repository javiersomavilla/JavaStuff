package problemas.p9;

import java.util.LinkedList;

import problemas.p9.exceptions.ErrorCategoria;
import problemas.p9.exceptions.TrabajadorNoEncontrado;
import problemas.p9.exceptions.TrabajadorYaExistente;
import problemas.p9.trabajadores.Administrativo;
import problemas.p9.trabajadores.Comercial;
import problemas.p9.trabajadores.Empleado;
import problemas.p9.trabajadores.Encargado;
import problemas.p9.trabajadores.Limpiador;
import problemas.p9.trabajadores.TipoEmpleado;

public class Empresa {
    
    // ATTRIBUTES
    private LinkedList<Empleado> empleados;
    
    // CONSTRUCTOR
    public Empresa(){
        this.empleados = new LinkedList<>();
    }
    
    // METHODS    
    public void contrataEmpleado(TipoEmpleado tipo, String dni, String nombre, String apellido1, String apellido2, String telefono, double sueldoBase) throws TrabajadorYaExistente{
        int index = buscaEmpleado(dni);
        if(index == -1){
            Empleado e = null;
            switch(tipo){
                case  LIMPIADOR:
                    e = new Limpiador(dni, nombre, apellido1, apellido2, telefono, sueldoBase);
                    break;
                case COMERCIAL:
                    e = new Comercial(dni, nombre, apellido1, apellido2, telefono, sueldoBase);
                    break;
                case ADMINISTRATIVO:
                    e = new Administrativo(dni, nombre, apellido1, apellido2, telefono, sueldoBase);
                    break;
                case ENCARGADO:
                    e = new Encargado(dni, nombre, apellido1, apellido2, telefono, sueldoBase);
                    break;
            }
            this.empleados.add(e);
        }else{
            throw new TrabajadorYaExistente(dni);
        }        
    }
    
    public Empleado despideEmpleado(String dni) throws TrabajadorNoEncontrado{
        Empleado e = null;
        
        int index = buscaEmpleado(dni);
        if(index != -1){
            this.empleados.remove(index);
        }else{
            throw new TrabajadorNoEncontrado("El trabajador con dni "+dni+" no puede despedirse, no trabaja en esta empresa");
        }
        
        return e;
    }
    
    public void comienzaMes(){
        for(Empleado e: empleados){
            e.resetearExtras();
        }
    }
    
    public void addHorasLimpiador(String dniLimpiador, int horas) throws TrabajadorNoEncontrado, ErrorCategoria{
        int index = buscaEmpleado(dniLimpiador);
        if(index != -1){
            Empleado e = this.empleados.get(index);
            if(e instanceof Limpiador){
                ((Limpiador)e).incrementaHoras(horas);
            }else{
                throw new ErrorCategoria(dniLimpiador, "limpiador");
            }
        }else{
            throw new TrabajadorNoEncontrado("El trabajador con dni "+dniLimpiador+" no puede despedirse, no trabaja en esta empresa");
        }
    }
    
    public void addContratoAComercial(String dniComercial) throws TrabajadorNoEncontrado, ErrorCategoria{
        int index = buscaEmpleado(dniComercial);
        if(index != -1){
            Empleado e = this.empleados.get(index);
            if(e instanceof Comercial){
                ((Comercial)e).incrementaContratos();
            }else{
                throw new ErrorCategoria(dniComercial, "comercial");
            }
        }else{
            throw new TrabajadorNoEncontrado("El trabajador con dni "+dniComercial+" no puede despedirse, no trabaja en esta empresa");
        }
    }
    
    public void asignaComercialAEncargado(String dniComercial, String dniEncargado) throws TrabajadorNoEncontrado, ErrorCategoria{
        int indexComercial = buscaEmpleado(dniComercial);
        int indexEncargado = buscaEmpleado(dniEncargado);
        
        if(indexComercial != -1){
            if(indexEncargado != -1){
                Empleado comercial = this.empleados.get(indexComercial);
                Empleado encargado = this.empleados.get(indexEncargado);
                
                if(comercial instanceof Comercial){
                    if(encargado instanceof Encargado){
                        ((Encargado)encargado).addComercialACargo((Comercial)comercial);
                    }else{
                        throw new ErrorCategoria(dniEncargado, "encargado");    
                    }
                }else{
                    throw new ErrorCategoria(dniComercial, "comercial");
                }
            }else{
                throw new TrabajadorNoEncontrado("El trabajador con dni "+dniEncargado+" no puede despedirse, no trabaja en esta empresa");
            }
        }else{
            throw new TrabajadorNoEncontrado("El trabajador con dni "+dniComercial+" no puede despedirse, no trabaja en esta empresa");
        }
    }
    
    private int buscaEmpleado(String dni){
        int index = -1;
        
        boolean encontrado = false;
        for(int i=0; i<this.empleados.size() && !encontrado; i++){
            if(this.empleados.get(i).getDni().equalsIgnoreCase(dni)){
                encontrado = true;
                index = i;
            }
        }
        
        return index;
    }
    
    // GETTERS && SETTERS
    public LinkedList<Empleado> getEmpleados(){
        return this.empleados;
    }
    
    public void setEmpleados(LinkedList<Empleado> empleados){
        this.empleados = empleados;
    }
    
    // TOSTRING
    public String toString(){
        String str = "";
        
        for(int i=0; i<this.empleados.size(); i++){
            str+=this.empleados.get(i).toString();
        }
        
        return str;
    }
}
