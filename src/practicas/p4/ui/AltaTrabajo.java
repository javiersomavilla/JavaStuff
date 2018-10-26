package practicas.p4.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import practicas.p4.Main;
import practicas.p4.trabajo.ReparacionChapaYPintura;
import practicas.p4.trabajo.ReparacionMecanica;
import practicas.p4.trabajo.Revision;
import practicas.p4.trabajo.Trabajo;

public class AltaTrabajo {
    private static JFrame f=new JFrame("Alta Trabajo"); 
    
    private static JButton bSalir=new JButton("Volver al Menu");
    private static JButton bRegistrarTrabajo=new JButton("Añadir");
    
    private static JLabel lDescripcion = new JLabel("Introduce la descripción del trabajo:\n");
    private static JTextField tDescripcion = new JTextField("");  
    
    private static JLabel lTipo = new JLabel("Selecciona el tipo de trabajo:\n");
    private static JComboBox cbTipo = new JComboBox(new String [] {"Reparacion Chapa y Pintura", "Reparacion Mecanica", "Revision"});
    
    private static JPanel panelSuperior = new JPanel();
    private static JPanel panelInferior = new JPanel();
    
    public static void createAltaTrabajo(){
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showAltaTrabajoFrame();
        addListenersToButtons();
        addElementsToFrame();
    }
    
    private static void addListenersToButtons(){
        addListenerRegistrarTrabajo();
        addListenerVolverMenu();
    }
    
    private static void addElementsToFrame(){
        contruyePanelSuperior();
        contruyePanelInferior();
        f.add(panelSuperior,BorderLayout.NORTH);
        f.add(panelInferior,BorderLayout.SOUTH);
    }

    private static void contruyePanelSuperior(){
        panelSuperior.setLayout(new GridLayout(4,1));
        panelSuperior.add(lDescripcion);
        panelSuperior.add(tDescripcion);
        panelSuperior.add(lTipo);
        panelSuperior.add(cbTipo);
    }
    
    private static void contruyePanelInferior(){
        panelInferior.setLayout(new FlowLayout());
        panelInferior.add(bRegistrarTrabajo);
        panelInferior.add(bSalir);
    }
    
    private static void showAltaTrabajoFrame(){
        f.setSize(300,185);  
        f.setResizable(false);
        f.setLayout(new BorderLayout());  
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    
    private static void hideAltaTrabajoFrame(){
        f.setVisible(false);
    }
    
    private static void addListenerRegistrarTrabajo(){
        bRegistrarTrabajo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String desc = tDescripcion.getText().trim();
                if(!desc.equalsIgnoreCase("")){
                    Trabajo t = null;
                    if(cbTipo.getSelectedItem().toString().equalsIgnoreCase("Reparacion Chapa y Pintura")){
                        t = new ReparacionChapaYPintura(desc);
                    }else if(cbTipo.getSelectedItem().toString().equalsIgnoreCase("Reparacion Mecanica")){
                        t = new ReparacionMecanica(desc);
                    }else{
                        t = new Revision(desc);
                    }
                    Main.taller.registraTrabajo(t);
                    bSalir.doClick();
                }else{
                    JOptionPane.showMessageDialog(new JFrame(), "Trabajo no introducido. Descripción no introducida.", "Dialog", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
    
    private static void addListenerVolverMenu(){
        bSalir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                hideAltaTrabajoFrame();
                Menu.showMenuFrame();
            }
        });
    }
}
