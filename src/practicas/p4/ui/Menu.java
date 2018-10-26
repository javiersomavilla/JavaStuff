package practicas.p4.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;   

public class Menu {
    
    private static JFrame f=new JFrame("Menu");  
    
    private static JButton bRegistraTrabajo=new JButton("Añadir Trabajo");  
    private static JButton bAumentaHoras=new JButton("Aumenta horas Trabajo");
    private static JButton bFinalizaTrabajo=new JButton("Finaliza Trabajo");
    private static JButton bAumentaCoste=new JButton("Aumentar coste Trabajo");
    private static JButton bConsultaPlazoTrabajo=new JButton("Consultar Plazo Trabajo");
    private static JButton bMuestraTrabajo=new JButton("Mostrar Trabajo");
    private static JButton bMuestraTodos=new JButton("Mostrat lista trabajos.");
    private static JButton bSalir=new JButton("Salir");
    
    public static JFrame createMenu(){
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addListenersToButtons();
        addButtonsToFrame();
        createMenuFrame();
        
        return f;
    }
    
    private static void addListenersToButtons(){
        addListenerRegistraTrabajo();
        addListenerAumentaHorasTrabajo();
        addListenerFinalizaTrabajo();
        addListenerAumentarCosteTrabajo();
        addListenerMostrarTrabajo();
        addListenerConsultarPlazoTrabajo();
        addListenerMostrarTodosTrabajos();
        addListenerSalir();
    }
    
    private static void addButtonsToFrame(){
        f.add(bRegistraTrabajo);
        f.add(bAumentaHoras);
        f.add(bFinalizaTrabajo);
        f.add(bAumentaCoste);
        f.add(bConsultaPlazoTrabajo);
        f.add(bMuestraTrabajo);
        f.add(bMuestraTodos);
        f.add(bSalir);
    }
    
    private static void createMenuFrame(){
        f.setSize(300,400);  
        f.setResizable(false);
        f.setLayout(new GridLayout(8,1));  
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    
    public static void showMenuFrame(){
        f.setVisible(true);
    }
    
    public static void hideMenuFrame(){
        f.setVisible(false);
    }
    
    private static void addListenerRegistraTrabajo(){
        bRegistraTrabajo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                hideMenuFrame();
                AltaTrabajo.createAltaTrabajo();
            }
        });
    }
    
    private static void addListenerAumentaHorasTrabajo(){
        bAumentaHoras.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                hideMenuFrame();
                AumentaHorasTrabajo.createAumentaHorasTrabajo();
            }
        });
    }

    private static void addListenerFinalizaTrabajo(){
        bFinalizaTrabajo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                hideMenuFrame();
                FinalizaTrabajo.createFinalizaTrabajo();
            }
        });
    }

    private static void addListenerAumentarCosteTrabajo(){
        bAumentaCoste.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hideMenuFrame();
                AumentaCostePiezasTrabajo.createAumentaCostePiezasTrabajo();
            }
      });
    }
    
    private static void addListenerMostrarTrabajo(){
        bMuestraTrabajo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                hideMenuFrame();
                MostrarTrabajo.createMostrarTrabajo();
            }
        });
    }
    
    private static void addListenerConsultarPlazoTrabajo(){
        bConsultaPlazoTrabajo.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              hideMenuFrame();
              ConsultarPlazoTrabajo.createConsultarPlazoTrabajo();
          }
        });
    }    
    
    private static void addListenerMostrarTodosTrabajos(){
        bMuestraTodos.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              hideMenuFrame();
              MostrarTodosTrabajo.createMostrarTodosTrabajo();
          }
        });
    }
    
    
    private static void addListenerSalir(){
        bSalir.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              System.exit(0);
          }
        });
    }
}
