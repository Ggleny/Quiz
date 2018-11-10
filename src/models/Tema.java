package models;

import java.util.ArrayList;
import java.util.List;

import helpers.Utilities;

public class Tema {
	private String nombre;
	private String descripcion;
	private ArrayList <Pregunta> preguntas;	
	
	public Tema(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.preguntas = new ArrayList<>();
	}
	
	public void AgregarPregunta(Pregunta pregunta){
		preguntas.add(pregunta);		
	}

	public ArrayList<Pregunta> getPreguntas(){
		return preguntas;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public static ArrayList<Tema> getTemas(){
		ArrayList<Tema> temas = new ArrayList<>();
		List<Object> tpreg = Utilities.LeerArchivoCSV("C:\\Users\\Marce\\Desktop\\yan facu\\preguntas.csv");
		/*Cargo Temas*/
		List<Object> taux = Utilities.LeerArchivoCSV("C:\\Users\\Marce\\Desktop\\yan facu\\temas.csv");
		Tema tsave;
		
		for (Object object : taux) {
			String nombreTema = ((ArrayList<String>)object).get(0);
			tsave = new Tema(nombreTema,((ArrayList<String>)object).get(1));
			for (Object preg : tpreg) {
				ArrayList<String> p = ((ArrayList<String>)preg);
				String temaDePregunta = p.get(0);
				//System.out.println("NOMBRE TEMA:"+nombreTema+" = "+temaDePregunta);
				if(nombreTema.equals(temaDePregunta)){
					
					tsave.AgregarPregunta( new Pregunta(p.get(1), Boolean.valueOf(p.get(2)), Integer.valueOf(p.get(3))) );
				}
			}
			temas.add(tsave);
		}
		return temas;
	}
}