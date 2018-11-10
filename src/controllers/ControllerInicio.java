package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import models.Pregunta;
import models.Tema;
import views.PantallaInicio;

public class ControllerInicio implements ActionListener {

	ArrayList<Tema> temas;
	PantallaInicio pInicio;
	
	public ControllerInicio (){
	}
	
	public void mostrarInicio(){
		this.temas = Tema.getTemas();
		this.pInicio = new PantallaInicio(temas, this);
		pInicio.pack();
		pInicio.setLocationRelativeTo(null);
		pInicio.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		pInicio.setVisible(false);
		ArrayList<Pregunta> aux = new ArrayList<>();
		for(Tema t: temas)
			if(t.getNombre().equals(e.getActionCommand())){
				aux = t.getPreguntas();
			}
		ControllerPregunta controlador = new ControllerPregunta(aux);
	}
	
}
