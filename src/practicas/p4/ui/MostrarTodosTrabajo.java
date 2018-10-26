package practicas.p4.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import practicas.p4.Main;

public class MostrarTodosTrabajo {

    private static JFrame f=new JFrame("Lista de Trabajos"); 
  
    private static JTextArea tListaTrabajos=new JTextArea(21,20);  
    private static JButton bSalir=new JButton("Volver al Menu");
    
    private static JPanel panelSuperior = new JPanel();
    private static JPanel panelInferior = new JPanel();
    
    public static void createMostrarTodosTrabajo(){
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showMostrarTodosTrabajoFrame();
        addListenersToButtons();
        addElementsToFrame();   
        tListaTrabajos.setText(Main.taller.toString().replaceAll("\t+","\t").replaceAll("\t", "\n"));
    }
    
    private static void addListenersToButtons(){
        addListenerVolverMenu();
    }
    
    private static void addElementsToFrame(){
        construyePanelSuperior();
        construyePanelInferior();
        f.add(panelSuperior,BorderLayout.NORTH);
        f.add(panelInferior,BorderLayout.SOUTH);
    }
    
    private static void construyePanelSuperior(){
        panelSuperior.setLayout(new GridLayout(1,1));
        
        JScrollPane scroll = new JScrollPane(tListaTrabajos);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        panelSuperior.add(scroll);
        tListaTrabajos.setEditable(false);
        tListaTrabajos.setLineWrap(true);
    }

    private static void construyePanelInferior(){
        panelInferior.setLayout(new GridLayout(1,1));
        panelInferior.add(bSalir);
    }
    
    private static void showMostrarTodosTrabajoFrame(){
        f.setSize(300,390);  
        f.setResizable(false);
        f.setLayout(new BorderLayout());  
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    
    private static void hideMostrarTodosTrabajoFrame(){
        f.setVisible(false);
        tListaTrabajos.setText("");
    }
        
    private static void addListenerVolverMenu(){
        bSalir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                hideMostrarTodosTrabajoFrame();
                Menu.showMenuFrame();
            }
        });
    }
}
