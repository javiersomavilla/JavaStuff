package practicas.p4.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import practicas.p4.Main;
import practicas.p4.excepciones.TrabajoNoEncontrado;

public class MostrarTrabajo {

    private static JFrame f=new JFrame("Alta Trabajo"); 
    
    private static JLabel lId = new JLabel("Introduce el id del trabajo que buscas:");  
    private static JTextField tId = new JTextField("");
    
    private static JButton bShow=new JButton("Mostrar");
    
    private static JLabel lDescripcion = new JLabel("Descripcion del trabajo:");  
    private static JTextArea tDescripcion=new JTextArea("");  
    private static JButton bSalir=new JButton("Volver al Menu");
    
    private static JPanel panelSuperior = new JPanel();
    private static JPanel panelCentral = new JPanel();
    private static JPanel panelInferior = new JPanel();
    
    public static void createMostrarTrabajo(){
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showMostrarTrabajoFrame();
        addListenersToButtons();
        addElementsToFrame();        
    }
    
    private static void addListenersToButtons(){
        addListenerShow();
        addListenerVolverMenu();
    }
    
    private static void addElementsToFrame(){
        construyePanelSuperior();
        construyePanelCentral();
        construyePanelInferior();
        f.add(panelSuperior,BorderLayout.NORTH);
        f.add(panelCentral,BorderLayout.CENTER);
        f.add(panelInferior,BorderLayout.SOUTH);
    }
    
    private static void construyePanelSuperior(){
        panelSuperior.setLayout(new GridLayout(4,1));
        panelSuperior.add(lId);
        panelSuperior.add(tId);
        panelSuperior.add(bShow);
        panelSuperior.add(lDescripcion);
    }
    
    private static void construyePanelCentral(){
        panelCentral.setLayout(new GridLayout(1,1));
        panelCentral.add(tDescripcion);
        tDescripcion.setEditable(false);
        tDescripcion.setLineWrap(true);
//        tDescripcion.setSize(400, 300);        
    }

    private static void construyePanelInferior(){
        panelInferior.setLayout(new GridLayout(1,1));
        panelInferior.add(bSalir);
    }
    
    private static void showMostrarTrabajoFrame(){
        f.setSize(300,350);  
        f.setResizable(false);
        f.setLayout(new BorderLayout());  
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    
    private static void hideMostrarTrabajoFrame(){
        f.setVisible(false);
        tDescripcion.setText("");
    }
    
    private static void addListenerShow(){
        bShow.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int id;
                try{
                    id = Integer.parseInt(tId.getText());   
                    try {
                        String desc = Main.taller.muestraTrabajo(id).replaceAll("\t+","\t").replaceAll("\t", "\n");
                        tDescripcion.setText(desc);
                    } catch (TrabajoNoEncontrado e1) {
                        JOptionPane.showMessageDialog(new JFrame(), e1.getMessage(), "Dialog", JOptionPane.ERROR_MESSAGE);
                    }
                }catch(Exception E){
                    JOptionPane.showMessageDialog(new JFrame(), "El id debe ser de tipo entero", "Dialog", JOptionPane.ERROR_MESSAGE);
                }                
            }
        });
    }
    
    private static void addListenerVolverMenu(){
        bSalir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                hideMostrarTrabajoFrame();
                Menu.showMenuFrame();
            }
        });
    }
}
