package problemas.p9;

import problemas.p9.exceptions.ErrorCategoria;
import problemas.p9.exceptions.TrabajadorNoEncontrado;
import problemas.p9.exceptions.TrabajadorYaExistente;
import problemas.p9.trabajadores.TipoEmpleado;

public class Main {
    
    private static Empresa e = new Empresa();

    public static void main(String[] args) {
        contrataEmpleados();
        despideEmpleado();
        addHorasLimpiadores();
        addContratosAComerciales();
        asignamosComercialesAEncargados();
    }
    
    private static void contrataEmpleados(){
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Registramos los 12 empleados...");
        System.out.println("---------------------------------------------------------------------");
        try{
            e.contrataEmpleado(TipoEmpleado.LIMPIADOR, "0001", "limpiador 1", "ape1 limp1", "ape2 limp2", "606254698", 10000);
            e.contrataEmpleado(TipoEmpleado.LIMPIADOR, "0002", "limpiador 2", "ape1 limp2", "ape2 limp2", "606254698", 10000);
            e.contrataEmpleado(TipoEmpleado.LIMPIADOR, "0003", "limpiador 3", "ape1 limp3", "ape2 limp3", "606254698", 10000);
    
            e.contrataEmpleado(TipoEmpleado.COMERCIAL, "0004", "comercial 4", "ape1 comer4", "ape2 comer4", "606254698", 20000);
            e.contrataEmpleado(TipoEmpleado.COMERCIAL, "0005", "comercial 5", "ape1 comer5", "ape2 comer5", "606254698", 20000);
            e.contrataEmpleado(TipoEmpleado.COMERCIAL, "0006", "comercial 6", "ape1 comer6", "ape2 comer6", "606254698", 20000);
    
            e.contrataEmpleado(TipoEmpleado.ADMINISTRATIVO, "0007", "adminis 7", "ape1 admin7", "ape2 admin7", "606254698", 30000);
            e.contrataEmpleado(TipoEmpleado.ADMINISTRATIVO, "0008", "adminis 8", "ape1 admin8", "ape2 admin8", "606254698", 30000);
            e.contrataEmpleado(TipoEmpleado.ADMINISTRATIVO, "0009", "adminis 9", "ape1 admin9", "ape2 admin9", "606254698", 30000);
    
            e.contrataEmpleado(TipoEmpleado.ENCARGADO, "0010", "encaragdo 10", "ape1 encarg10", "ape2 encarg10", "606254698", 40000);
            e.contrataEmpleado(TipoEmpleado.ENCARGADO, "0011", "encaragdo 11", "ape1 encarg11", "ape2 encarg11", "606254698", 40000);
            e.contrataEmpleado(TipoEmpleado.ENCARGADO, "0012", "encaragdo 12", "ape1 encarg12", "ape2 encarg12", "606254698", 40000);
        }catch(TrabajadorYaExistente e){
            System.out.println(e.getMessage());
        }
        pintaEmpresa();
    }
    
    private static void despideEmpleado(){
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Despedimos los empleados 3, 6, 9, 12 ...");
        System.out.println("---------------------------------------------------------------------");
        try {
            e.despideEmpleado("0003");
            e.despideEmpleado("0006");
            e.despideEmpleado("0009");
            e.despideEmpleado("0012");
        } catch (TrabajadorNoEncontrado e) {
            System.out.println(e.getMessage());
        }
        
        pintaEmpresa();
    }
    
    private static void addHorasLimpiadores(){
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Añadimos horas extra a los limpiadores ...");
        System.out.println("---------------------------------------------------------------------");
        try {
            e.addHorasLimpiador("0001", 10);
            e.addHorasLimpiador("0002", 20);
        } catch (TrabajadorNoEncontrado e1) {
            System.out.println(e1.getMessage());
        } catch (ErrorCategoria e1) {
            System.out.println(e1.getMessage());
        }
        pintaEmpresa();
    }
    
    private static void addContratosAComerciales(){
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Añadimos 2 contratos al comercial 4 y 3 al comercial 5 ...");
        System.out.println("---------------------------------------------------------------------");
        
        try {
            e.addContratoAComercial("0004");
            e.addContratoAComercial("0004");
            e.addContratoAComercial("0005");
            e.addContratoAComercial("0005");
            e.addContratoAComercial("0005");
        } catch (TrabajadorNoEncontrado e1) {
            System.out.println(e1.getMessage());
        } catch (ErrorCategoria e1) {
            System.out.println(e1.getMessage());
        }
       pintaEmpresa();
    }
    
    private static void asignamosComercialesAEncargados(){
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Añadimos comercial 4 al encargado 10 y comercial 5 al encargado 11...");
        System.out.println("---------------------------------------------------------------------");
        
        try {
            e.asignaComercialAEncargado("0004", "0010");
            e.asignaComercialAEncargado("0005", "0011");
        } catch (TrabajadorNoEncontrado e1) {
            System.out.println(e1.getMessage());
        } catch (ErrorCategoria e1) {
            System.out.println(e1.getMessage());
        }
      pintaEmpresa();
    }
    
    private static void pintaEmpresa(){
        System.out.println(e.toString());
    }

}
