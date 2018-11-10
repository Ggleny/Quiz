package helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import models.Pregunta;
import models.Tema;

public class Utilities{
	public static List<Object> LeerArchivoCSV(String path){
		String csvFile = path;
		BufferedReader br = null;
		String line = "";
		//Se define separador ";"
		String cvsSplitBy = ";";
		List<Object> datosSend=new ArrayList<>();
		List<String> aux;
		try {
		    br = new BufferedReader(new FileReader(csvFile));
		    int i=0,j=0;
		    while ((line = br.readLine()) != null) {
		        String[] datos = line.split(cvsSplitBy);
		        aux = new ArrayList<>();
		        for(String s:datos){
		        	aux.add(s);
		        }
		        datosSend.add(aux);
		    }
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    if (br != null) {
		        try {
		            br.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		}
	    return datosSend;
	}
}