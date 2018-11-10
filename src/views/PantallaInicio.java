package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.ControllerInicio;
import models.Tema;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class PantallaInicio extends JFrame {

	ControllerInicio c;
	
	public PantallaInicio(){
		
	}

	public PantallaInicio(ArrayList<Tema> temas, ControllerInicio c) {	
		this.c = c;
		PantallaInicio me = this;
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(20, 20, 20, 20));

		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblElijaUnTema = new JLabel("Elija un tema");
		panel.add(lblElijaUnTema);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		for (Tema tema : temas) {
			if(tema.getPreguntas().size()>0){
				JButton btnNewButton = new JButton(tema.getNombre());
				btnNewButton.addActionListener(c);
				panel_1.add(btnNewButton);
			}
		}
		
	}

}
