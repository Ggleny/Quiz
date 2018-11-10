package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

import models.Pregunta;
import models.Tema;
import views.PantallaPregunta;
import views.PantallaResultado;

public class ControllerPregunta implements ActionListener{
	ArrayList<Pregunta> preguntas;
	PantallaPregunta pPregunta;
	PantallaResultado pResultado;
	
	public ControllerPregunta (ArrayList<Pregunta> preguntas){
		this.preguntas = preguntas;
		this.mostrarPregunta();
	}
	
	public void mostrarPregunta(){
		this.pPregunta = new PantallaPregunta(preguntas, this);
		pPregunta.pack();
		pPregunta.setLocationRelativeTo(null);
		pPregunta.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		pPregunta.setVisible(false);
		Map aux = pPregunta.getResult();
		ControllerRespuesta controlador = new ControllerRespuesta(aux);
		
	}
}
