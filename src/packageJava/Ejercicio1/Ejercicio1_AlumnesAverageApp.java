package packageJava.Ejercicio1;
/**@author isabel Calzadilla
 * Ejercicio 1 - UD7: CALCULAR PROMEDIO NOTAS
 * **/
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class Ejercicio1_AlumnesAverageApp {

	public static void main(String[] args) {

			/*1
	Crea una aplicación que calcule la nota media de los
	alumnos pertenecientes al curso de programación Una vez
	calculada la nota media se guardara esta información en un
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
			
			if(response.equals("si")) {//EVALUA 
				do {	
					String countNotes = JOptionPane.showInputDialog("Indique cantidad notas : ");
					totalNotes = Integer.parseInt(countNotes);
					String nameAlumne = JOptionPane.showInputDialog("Indique alumno : ");
					alumnesNotes = String.valueOf(calculateAverage(totalNotes));// CALCULA EL PROMEDIO CON EL MÉTODO Y ALMACENA EN LA VARIABLE 
					alumnes.put(nameAlumne, alumnesNotes);//ENVIAN LAS CONDICIONES DEL HASHTABLE
					response = JOptionPane.showInputDialog("Desea cargar notas, indique (SI) o (NO) :  ");
				}while(response.equals("si"));//REALIZA LA CARGA MIENTRAS SEA SI
					printColection(alumnes);
			}else {
				JOptionPane.showMessageDialog(null, "Hasta luego ...");//DE NO CUMPLIRSE CIERRA EL CICLO
			}
		}
		
		public static double calculateAverage(int totalNotes) {// MÉTODO QUE CALCULA EL PROMEDIO INTRODUCIDO EN EL TECLADO
			int totalNote = 0, notes, calculateAverage;
			
			for(int i = 0; i < totalNotes; i++) {
				String noteAlumne = JOptionPane.showInputDialog("Indique nota : ");
				notes = Integer.parseInt(noteAlumne);
				totalNote += notes;
			}
			calculateAverage = totalNote / totalNotes;	
			
			return calculateAverage;
		}
		//MÉTODO QUE IMPRIME EL HASHTABLE CON LOS VALORES AL COMPLETO
		public static void printColection(Hashtable <String, String> alumnes) {
			
			Enumeration <String> elements = alumnes.elements(); // ASIGNAMOS A LA VARIABLE ENUMERATION EL VALOR DE "alumnes.elements" PARA RECORRER VALORES
			Enumeration <String> keys = alumnes.keys();
			
			while(elements.hasMoreElements() && keys.hasMoreElements()) { //CONDICIONAL PARA IMPRIMER AMBOS SIMULTANEAMENTE
				System.out.println("El promedio de notas del alumno = " + keys.nextElement() + " es igual a = " + elements.nextElement());
				//JOptionPane.showMessageDialog(null, "El promedio de notas el alumno " + keys.nextElement() + " es igual a = " + elements.nextElement());
			}
		}
		
	}


