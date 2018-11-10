package views;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

import controllers.ControllerInicio;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaResultado extends JFrame {

	
	public PantallaResultado(){
		
	}
	
	public PantallaResultado(int numeroPreguntas, int respuestasCorrectas) {
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		PantallaResultado me = this;
		
		String saux = "Ud. a respondido correctamente " + respuestasCorrectas + " de " + numeroPreguntas + " preguntas.";
		JLabel lblNewLabel = new JLabel(saux);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel);
		 
		JButton btnNewButton = new JButton("Ok!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		getContentPane().add(btnNewButton);
		
	}

	public void setControlador(ControllerInicio controlador) {
		// TODO Auto-generated method stub
		
	}
}
