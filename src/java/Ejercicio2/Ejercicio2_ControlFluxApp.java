package java.Ejercicio2;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class Ejercicio2_ControlFluxApp {

	public static void main(String[] args) {
		/*1
Crea una aplicaci�n que calcule la nota media de los
alumnos pertenecientes al curso de programaci�n Una vez
calculada la nota media se guardara esta informaci�n en un
diccionario de datos que almacene la nota media de cada
alumno Todos estos datos se han de proporcionar por
pantalla
EJERCICIOS*/
		startProgram();
	}

	public static void startProgram() {
		int totalNotes = 0;
		String alumnesNotes = "", response;
		Hashtable <String, String> alumnes = new Hashtable <String, String>();
		
		response = JOptionPane.showInputDialog("Desea cargar notas, indique (SI) o (NO) :  ");
		
		do {
			response = JOptionPane.showInputDialog("Desea cargar notas, indique (SI) o (NO) :  ");
			
			String countNotes = JOptionPane.showInputDialog("Indique cantidad notas : ");
			totalNotes = Integer.parseInt(countNotes);
			String nameAlumne = JOptionPane.showInputDialog("Indique alumno : ");
			
			calculateAverage(totalNotes);
			
			alumnesNotes = String.valueOf(calculateAverage(totalNotes));
			//createColection(nameAlumne, alumnesNotes);
			alumnes.put(nameAlumne, alumnesNotes);
		}while(response.equalsIgnoreCase("si".toLowerCase()));
	
		
	}
	
	public static double calculateAverage(int totalNotes) {
		int totalNote = 0, notes, calculateAverage;
		
		for(int i = 0; i < totalNotes; i++) {
			String noteAlumne = JOptionPane.showInputDialog("Indique nota : ");
			notes = Integer.parseInt(noteAlumne);
			totalNote += notes;
		}
		calculateAverage = totalNote / totalNotes;	
		
		return calculateAverage;
	}
	
	public static void printColection(Hashtable <String, String> alumnes) {
		
		Enumeration <String> elements = alumnes.elements(); // ASIGNAMOS A LA VARIABLE ENUMERATION EL VALOR DE "alumnes.elements" PARA RECORRER VALORES
		Enumeration <String> keys = alumnes.keys();
		
		while(elements.hasMoreElements() && keys.hasMoreElements()) { 
			System.out.println("El promedio de notas el alumno " + keys.nextElement() + " es igual a = " + elements.nextElement());
		}
	}
	
	
}