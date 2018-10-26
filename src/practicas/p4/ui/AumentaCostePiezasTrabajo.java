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
import practicas.p4.excepciones.TipoNoCoincide;
import practicas.p4.excepciones.TrabajoFinalizado;
import practicas.p4.excepciones.TrabajoNoEncontrado;

public class AumentaCostePiezasTrabajo {
    private static JFrame f=new JFrame("Aumenta Coste Trabajo"); 
    
    private static JButton bSalir=new JButton("Volver al Menu");
    private static JButton bAumentaCoste=new JButton("Aumentar");
    
    private static JLabel lId = new JLabel("Introduce el id del trabajo que buscas:");  
    private static JTextField tId = new JTextField("");
    
    private static JLabel lCoste = new JLabel("Introduce el coste a incrementar:");  
    private static JTextField tCoste = new JTextField("");
    
    private static JPanel panelSuperior = new JPanel();
    private static JPanel panelInferior = new JPanel();
    
    public static void createAumentaCostePiezasTrabajo(){
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showAumentaCostePiezasTrabajoFrame();
        addListenersToButtons();
        addElementsToFrame();
    }
    
    private static void addListenersToButtons(){
        addListenerAumentaCostePiezas();
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
        panelSuperior.add(lId);
        panelSuperior.add(tId);
        panelSuperior.add(lCoste);
        panelSuperior.add(tCoste);
    }
    
    private static void contruyePanelInferior(){
        panelInferior.setLayout(new FlowLayout());
        panelInferior.add(bAumentaCoste);
        panelInferior.add(bSalir);
    }
    
    private static void showAumentaCostePiezasTrabajoFrame(){
        f.setSize(300,185);  
        f.setResizable(false);
        f.setLayout(new BorderLayout());  
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    
    private static void hideAumentaCostePiezasTrabajoFrame(){
        f.setVisible(false);
    }
    
    private static void addListenerAumentaCostePiezas(){
        bAumentaCoste.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                String costeStr = tCoste.getText().trim();
                String idStr = tId.getText().trim();
                
                if(!idStr.equalsIgnoreCase("")){
                    int id;
                    double coste;
                    try{
                        id = Integer.parseInt(idStr);
                        if(!costeStr.equalsIgnoreCase("")){
                            try{
                                coste = Double.parseDouble(costeStr);
                                Main.taller.aumentaCostePiezas(id, coste);
                                bSalir.doClick();
                            }catch(NumberFormatException e2){
                                JOptionPane.showMessageDialog(new JFrame(), "Las horas deben ser un número real.", "Dialog", JOptionPane.ERROR_MESSAGE);
                            }catch(TrabajoFinalizado e3){
                                JOptionPane.showMessageDialog(new JFrame(), "No se pueden aumentar las horas, el trabajo ya esta finalizado.", "Dialog", JOptionPane.ERROR_MESSAGE);
                            }catch(TrabajoNoEncontrado e4){
                                JOptionPane.showMessageDialog(new JFrame(), "El trabajo buscado no ha sido encontrado.", "Dialog", JOptionPane.ERROR_MESSAGE);
                            }catch(TipoNoCoincide e5){
                                JOptionPane.showMessageDialog(new JFrame(), "No se puede aumentar el coste, este trabajo no es una reparacion.", "Dialog", JOptionPane.ERROR_MESSAGE);
                            }
                        }else{
                            JOptionPane.showMessageDialog(new JFrame(), "Campo vacio, por favor introduce un importe correcto.", "Dialog", JOptionPane.INFORMATION_MESSAGE);
                        }
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
                hideAumentaCostePiezasTrabajoFrame();
                Menu.showMenuFrame();
            }
        });
    }
}
