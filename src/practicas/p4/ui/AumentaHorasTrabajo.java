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

public class AumentaHorasTrabajo {
    private static JFrame f=new JFrame("Aumenta Horas Trabajo"); 
    
    private static JButton bSalir=new JButton("Volver al Menu");
    private static JButton bAumentaHoras=new JButton("Aumentar");
    
    private static JLabel lId = new JLabel("Introduce el id del trabajo que buscas:");  
    private static JTextField tId = new JTextField("");
    
    private static JLabel lHoras = new JLabel("Introduce las horas a incrementar:");  
    private static JTextField tHoras = new JTextField("");
    
    private static JPanel panelSuperior = new JPanel();
    private static JPanel panelInferior = new JPanel();
    
    public static void createAumentaHorasTrabajo(){
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showAumentaHorasTrabajoFrame();
        addListenersToButtons();
        addElementsToFrame();
    }
    
    private static void addListenersToButtons(){
        addListenerAumentaHoras();
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
        panelSuperior.add(lHoras);
        panelSuperior.add(tHoras);
    }
    
    private static void contruyePanelInferior(){
        panelInferior.setLayout(new FlowLayout());
        panelInferior.add(bAumentaHoras);
        panelInferior.add(bSalir);
    }
    
    private static void showAumentaHorasTrabajoFrame(){
        f.setSize(300,185);  
        f.setResizable(false);
        f.setLayout(new BorderLayout());  
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    
    private static void hideAumentaHorasTrabajoFrame(){
        f.setVisible(false);
    }
    
    private static void addListenerAumentaHoras(){
        bAumentaHoras.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                String horasStr = tHoras.getText().trim();
                String idStr = tId.getText().trim();
                
                if(!idStr.equalsIgnoreCase("")){
                    int id, horas;
                    try{
                        id = Integer.parseInt(idStr);
                        if(!horasStr.equalsIgnoreCase("")){
                            try{
                                horas = Integer.parseInt(horasStr);
                                Main.taller.aumentaHoras(id, horas);
                                bSalir.doClick();
                            }catch(Exception e2){
                                JOptionPane.showMessageDialog(new JFrame(), "Las horas deben ser un n�mero entero.", "Dialog", JOptionPane.ERROR_MESSAGE);
                            }
                        }else{
                            JOptionPane.showMessageDialog(new JFrame(), "Campo vacio, por favor introduce las horas correctamente.", "Dialog", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }catch(Exception e1){
                        JOptionPane.showMessageDialog(new JFrame(), "Introduce in id v�lido.", "Dialog", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(new JFrame(), "Introduce in id v�lido.", "Dialog", JOptionPane.ERROR_MESSAGE);
                }
                
                
            }
        });
    }
    
    private static void addListenerVolverMenu(){
        bSalir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                hideAumentaHorasTrabajoFrame();
                Menu.showMenuFrame();
            }
        });
    }
}