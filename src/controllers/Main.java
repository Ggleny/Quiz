package controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import helpers.Utilities;
import models.Pregunta;
import models.Tema;
import views.PantallaInicio;
import views.PantallaPregunta;
import views.PantallaResultado;

public class Main{
	
	public static void main(String[] args) {		
		ControllerInicio controlador = new ControllerInicio();
		controlador.mostrarInicio();
	}

}
