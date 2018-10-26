package practicas.p4;

import practicas.p4.excepciones.TipoNoCoincide;
import practicas.p4.excepciones.TrabajoFinalizado;
import practicas.p4.excepciones.TrabajoNoEncontrado;
import practicas.p4.trabajo.ReparacionChapaYPintura;
import practicas.p4.trabajo.ReparacionMecanica;
import practicas.p4.trabajo.Revision;
import practicas.p4.ui.Menu;

public class Main {
    
    public static Taller taller = new Taller();

    public static void main(String[] args) {
        
        rellenaTaller();        // metemos 9 trabajos, 3 de cada tipo
        aumentaHorasTaller();   // les aumentamos las horas a todos
        finalizaTrabajos();     // finalizamos el trabajo 2 y 3
        aumentaCostePiezas();   // aumentamos el coste de piezas de todos
        mostrarTrabajo();       // mostramos el trabajo 8
        
        // GUI
        Menu.createMenu(); // arrancamos la GUI con la info seteada anteriormente.
    }
    
    private static void rellenaTaller(){
        ReparacionChapaYPintura rcp1 = new ReparacionChapaYPintura("rcp 1");
        ReparacionChapaYPintura rcp2 = new ReparacionChapaYPintura("rcp 2");
        ReparacionChapaYPintura rcp3 = new ReparacionChapaYPintura("rcp 3");
        
        ReparacionMecanica rm4 = new ReparacionMecanica("rm 4");
        ReparacionMecanica rm5 = new ReparacionMecanica("rm 5");
        ReparacionMecanica rm6 = new ReparacionMecanica("rm 6");
        
        Revision r7 = new Revision("r 7");
        Revision r8 = new Revision("r 8");
        Revision r9 = new Revision("r 9");
        
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Registramos los 9 trabajos...");
        System.out.println("---------------------------------------------------------------------");
        
        taller.registraTrabajo(rcp1);   // id = 1
        taller.registraTrabajo(rcp2);   // id = 2
        taller.registraTrabajo(rcp3);   // id = 3
        taller.registraTrabajo(rm4);    // id = 4
        taller.registraTrabajo(rm5);    // id = 5
        taller.registraTrabajo(rm6);    // id = 6
        taller.registraTrabajo(r7);     // id = 7
        taller.registraTrabajo(r8);     // id = 8
        taller.registraTrabajo(r9);     // id = 9
        pintaTaller();
    }
    
    private static void aumentaHorasTaller(){
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Aumentamos las horas de todos los trabajos: ");
        System.out.println("---------------------------------------------------------------------");
        
        try {
            taller.aumentaHoras(1, 1);
            taller.aumentaHoras(2, 2);
            taller.aumentaHoras(3, 3);
            taller.aumentaHoras(4, 4);
            taller.aumentaHoras(5, 5);
            taller.aumentaHoras(6, 6);
            taller.aumentaHoras(7, 7);
            taller.aumentaHoras(8, 8);
            taller.aumentaHoras(9, 9);
            taller.aumentaHoras(10, 10);
        } catch (TrabajoNoEncontrado e) {            
            System.out.println("[ERROR] --> "+e.getMessage());
        }
        
        pintaTaller();
    }
    
    private static void finalizaTrabajos(){
        System.out.println("---------------------------------------------------------------------");    
        System.out.println("Finalizamos el trabajo 2 y 3");
        System.out.println("---------------------------------------------------------------------");
        
        try {
            taller.finalizaTrabajo(2);
            taller.finalizaTrabajo(3);
        } catch (TrabajoNoEncontrado e) {
            System.out.println("[ERROR] --> "+e.getMessage());
        }
        
        pintaTaller();
    }
    
    private static void aumentaCostePiezas(){
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Aumentamos el coste de las piezas: ");
        System.out.println("---------------------------------------------------------------------");
        
        try {
            taller.aumentaCostePiezas(1, 10);
            taller.aumentaCostePiezas(4, 40);
            taller.aumentaCostePiezas(5, 50);
            taller.aumentaCostePiezas(6, 60);
        } catch (TrabajoNoEncontrado e) {
            System.out.println("[ERROR] --> "+e.getMessage());
        } catch (TrabajoFinalizado e) {
            System.out.println("[ERROR] --> "+e.getMessage());
        } catch (TipoNoCoincide e) {
            System.out.println("[ERROR] --> "+e.getMessage());
        }
        
        try{
            taller.aumentaCostePiezas(7, 70);
        } catch (Exception e) {
            System.out.println("[ERROR] --> "+e.getMessage());
        }
        try{
            taller.aumentaCostePiezas(8, 80);
        } catch (Exception e) {
            System.out.println("[ERROR] --> "+e.getMessage());
        }
        try{
            taller.aumentaCostePiezas(9, 90);
        } catch (Exception e) {
            System.out.println("[ERROR] --> "+e.getMessage());
        }
        try{
            taller.aumentaCostePiezas(10, 100);
        } catch (Exception e) {
            System.out.println("[ERROR] --> "+e.getMessage());
        }
        try{
            taller.aumentaCostePiezas(2, 20);
        } catch (Exception e) {
            System.out.println("[ERROR] --> "+e.getMessage());
        }
        try{
            taller.aumentaCostePiezas(3, 30);
        } catch (Exception e) {
            System.out.println("[ERROR] --> "+e.getMessage());
        }
        pintaTaller();
    }
    
    private static void mostrarTrabajo(){
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Mostramos el trabajo 8: ");
        System.out.println("---------------------------------------------------------------------");
        
        try {
            System.out.println(taller.muestraTrabajo(8));
        } catch (TrabajoNoEncontrado e) {
            System.out.println("[ERROR] --> "+e.getMessage());
        }
    }
    
    private static void pintaTaller(){
        System.out.println("\nTIPO\t\t\t\tID\tDESCRIPCION\tSTATUS\t\tHORAS TOTALES\t\tPRECIO TOTAL\t\tPRECIO MATERIAL\n----------------------------------------------------------------------------------------------------------------------------------------------\n"+taller.toString());
    }
}
