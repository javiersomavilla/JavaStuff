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

public class ConsultarPlazoTrabajo {
    private static JFrame f=new JFrame("Aumenta Coste Trabajo"); 
    
    private static JButton bSalir=new JButton("Volver al Menu");
    private static JButton bConsultar=new JButton("Consultar");
    
    private static JLabel lId = new JLabel("Introduce el id del trabajo que a consultar:");  
    private static JTextField tId = new JTextField("");
    
    private static JPanel panelSuperior = new JPanel();
    private static JPanel panelInferior = new JPanel();
    
    public static void createConsultarPlazoTrabajo(){
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showConsultarPlazoTrabajoFrame();
        addListenersToButtons();
        addElementsToFrame();
    }
    
    private static void addListenersToButtons(){
        addListenerConsultar();
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
        panelInferior.add(bConsultar);
        panelInferior.add(bSalir);
    }
    
    private static void showConsultarPlazoTrabajoFrame(){
        f.setSize(300,100);  
        f.setResizable(false);
        f.setLayout(new BorderLayout());  
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    
    private static void hideConsultarPlazoTrabajoFrame(){
        f.setVisible(false);
    }
    
    private static void addListenerConsultar(){
        bConsultar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                String idStr = tId.getText().trim();
                
                if(!idStr.equalsIgnoreCase("")){
                    int id;
                    try{
                        id = Integer.parseInt(idStr);
                        int plazo = Main.taller.consultarPlazo(id);
                        if(plazo < 0){
                            JOptionPane.showMessageDialog(new JFrame(), "Este trabajo debería estar ya terminado", "Dialog", JOptionPane.ERROR_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(new JFrame(), "Quedan "+plazo+" dia(s) para finalizar el trabajo", "Dialog", JOptionPane.INFORMATION_MESSAGE);
                        }
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
                hideConsultarPlazoTrabajoFrame();
                Menu.showMenuFrame();
            }
        });
    }
}
