package controllers;

import java.util.Map;

import views.PantallaPregunta;
import views.PantallaRespuesta;

public class ControllerRespuesta {

	private PantallaRespuesta viewRestpuesta;

	public ControllerRespuesta(Map results) {
		this.viewRestpuesta = new PantallaRespuesta(results, this);
		viewRestpuesta.pack();
		viewRestpuesta.setLocationRelativeTo(null);
		viewRestpuesta.setVisible(true);
	}

}
