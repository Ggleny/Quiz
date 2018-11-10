package views;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controllers.ControllerPregunta;
import models.Pregunta;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JButton;
import java.awt.FlowLayout;

public class PantallaPregunta extends JFrame {
	
	int preguntasCorrectas;
	int numeroPregunta;
	ArrayList<ButtonGroup> arrayGrupos;
	private int totalPreguntas;
	private ArrayList<Pregunta> preguntas;
	
	public PantallaPregunta(ArrayList<Pregunta> preguntas, ControllerPregunta c) {
		this.preguntasCorrectas = 0;
		this.numeroPregunta = 0;
		this.totalPreguntas = preguntas.size();
		this.arrayGrupos = new ArrayList<>();
		this.preguntas = preguntas;
		getContentPane().setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		JLabel lblNewLabel_1 = new JLabel("Responda Verdadero o Falso");
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		JButton btnValidar = new JButton("Validar");
		btnValidar.addActionListener(c);
		panel_1.add(btnValidar);
		
		JPanel panel_2 = new JPanel();
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		for (Pregunta pregunta : preguntas) {
			panel_2.add( addPregunta(pregunta.getPregunta()), BorderLayout.CENTER );
		}
		panel_2.setVisible(true);
		int totalPreguntas = preguntas.size();
		getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(totalPreguntas, 1, 0, 0));
		getContentPane().setVisible(true);
	}
	
	JPanel addPregunta(String text){
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 200, 33);
		
		JLabel lblNewLabel = new JLabel(text);
		panel_3.add(lblNewLabel);
		ButtonGroup group = new ButtonGroup();
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Verdadero");
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Falso");
		group.add(rdbtnNewRadioButton_2);
		group.add(rdbtnNewRadioButton_3);
		arrayGrupos.add(group);
		panel_3.add(rdbtnNewRadioButton_2,BorderLayout.WEST);
		panel_3.add(rdbtnNewRadioButton_3,BorderLayout.WEST);
		panel_3.setVisible(true);
		return panel_3;
	}

	public Map getResult() {
		Map<String, String> resultados = new HashMap<String, String>();
		int puntajeTotal = 0;
		resultados.put("total", String.valueOf(totalPreguntas));
		int posPreg = 0;
		Pregunta pregunta;
		for (ButtonGroup buttonGroup : arrayGrupos) {
			 Enumeration<AbstractButton> allRadioButton = buttonGroup.getElements();  
			 pregunta = preguntas.get(posPreg);
	        while(allRadioButton.hasMoreElements())  
	        {  
	           JRadioButton temp=(JRadioButton)allRadioButton.nextElement();  
	           if(temp.isSelected())  
	           {  
	        	   if(Boolean.parseBoolean( temp.getText()) == pregunta.getRespuesta() ){
	        		   puntajeTotal = puntajeTotal+pregunta.getPuntaje();
	        		   preguntasCorrectas++;
	        	   }
	            System.out.println("You select : "+temp.getText());  
	           }  
	        }           
	        posPreg++;
		}
		resultados.put("total_puntaje", String.valueOf(puntajeTotal));
		resultados.put("total_correctas", String.valueOf(preguntasCorrectas));
		resultados.put("total_incorrectas", String.valueOf(totalPreguntas-preguntasCorrectas));
		return resultados;
		
	}
}
