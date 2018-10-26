package practicas.p4.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import practicas.p4.Main;

public class FinalizaTrabajo {
    private static JFrame f=new JFrame("Aumenta Coste Trabajo"); 
    
    private static JButton bSalir=new JButton("Volver al Menu");
    private static JButton bFinalizar=new JButton("Finalizar");
    
    private static JLabel lId = new JLabel("Introduce el id del trabajo que buscas:");  
    private static JTextField tId = new JTextField("");
    
    private static JPanel panelSuperior = new JPanel();
    private static JPanel panelInferior = new JPanel();
    
    public static void createFinalizaTrabajo(){
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showFinalizaTrabajoFrame();
        addListenersToButtons();
        addElementsToFrame();
       
    }
    
    private static void addListenersToButtons(){
        addListenerFinalizar();
        addListenerVolverMenu();
    }
    
    private static void addElementsToFrame(){
        contruyePanelSuperior();
        contruyePanelInferior();
        f.add(panelSuperior,BorderLayout.NORTH);
        f.add(panelInferior,BorderLayout.SOUTH);
    }

    private static void contruyePanelSuperior(){
        panelSuperior.setLayout(new GridLayout(2,1));
        panelSuperior.add(lId);
        panelSuperior.add(tId);
    }
    
    private static void contruyePanelInferior(){
        panelInferior.setLayout(new FlowLayout());
        panelInferior.add(bFinalizar);
        panelInferior.add(bSalir);
    }
    
    private static void showFinalizaTrabajoFrame(){
        f.setSize(300,100);  
        f.setResizable(false);
        f.setLayout(new BorderLayout());  
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    
    private static void hideFinalizaTrabajoFrame(){
        f.setVisible(false);
    }
    
    private static void addListenerFinalizar(){
        bFinalizar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                String idStr = tId.getText().trim();
                
                if(!idStr.equalsIgnoreCase("")){
                    int id;
                    try{
                        id = Integer.parseInt(idStr);
                        Main.taller.finalizaTrabajo(id);
                        bSalir.doClick();
                    }catch(Exception e1){
                        JOptionPane.showMessageDialog(new JFrame(), "Introduce in id válido.", "Dialog", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(new JFrame(), "Introduce in id válido.", "Dialog", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    
    private static void addListenerVolverMenu(){
        bSalir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                hideFinalizaTrabajoFrame();
                Menu.showMenuFrame();
            }
        });
    }
}
